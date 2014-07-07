package modelo.persistencia;

import modelo.jogo.Carta;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.CartaEfeito;
import modelo.jogo.Jogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Mapeador implements MapeadorEntidadesDoJogo {
	private PreparedStatement psmt;
	private Connection connection;
	private String tabela;
	private Map<String, Jogador> listaJogador = new HashMap<>();

	@Override
	public List<CartaAbstrata> obterCartasDoAcervo(Connection conexao) {
		try {
			this.connection = conexao;
			this.tabela = "carta";
			ResultSet result = select("");
			System.out.println(result);
			List<CartaAbstrata> cartas = new LinkedList<>();
			while (result != null && result.next()) {

				int efeito = result.getInt("efeito");
				CartaAbstrata c;

				if (efeito == 1) {
					c = new CartaEfeito();
				} else {
					c = new Carta();
					
				}
				
				mapear(result, c);
				cartas.add(c);
			}
			return cartas;
		} catch (Exception e) {
			throw new ExcecaoDePersistencia(e);
		}
	}

	private void mapear(ResultSet result, CartaAbstrata c) throws SQLException {

		c.setId(result.getInt("ID"));
		c.setNome(result.getString("NOME"));
		c.setAgilidade(result.getInt("agilidade"));
		c.setForca(result.getInt("forca"));
		c.setInteligencia(result.getInt("inteligencia"));
	}

	@Override
	public boolean autenticarJogador(Connection conexao, Jogador j) {
		try {

			this.connection = conexao;
			String nome = j.getNome();
			String senha = j.getSenha();

			ResultSet jogador = this.getJogador(nome, senha);
			while (jogador != null && jogador.next()) {
				int id = jogador.getInt("ID");
				j.setID(id);

				ResultSet cartas = this.getCartaByJogador(id);

				/*
				 * Lista de cartas que o usuario tem, mas somente o ID de cada
				 * carta Tem que pesquisar na tabela Carta, com o ID, e pegar as
				 * informações
				 */

				while (cartas != null && cartas.next()) {
					int idCarta = cartas.getInt("ID_CARTA");

					ResultSet carta = this.getCartaByID(idCarta);

					while (carta != null && carta.next()) {
						Carta newCarta = new Carta(carta.getString("NOME"),
								idCarta);
						newCarta.setAgilidade(carta.getInt("agilidade"));
						newCarta.setForca(carta.getInt("forca"));

						j.editarBaralho(newCarta, 0);
					}
				}
				listaJogador.put(j.toString(), new Jogador(j));
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExcecaoDePersistencia(e);
		}
	}

	@Override
	public boolean salvarJogador(Connection conexao, Jogador j) {
		try {

			this.connection = conexao;
			if (j == null) {
				throw new IllegalArgumentException(
						"Jogador inválido, não foi possivel salvar.");
			}

			/*
			 * Como teria que ser feito um "diff" das carta adicionadas e cartas
			 * removidas, então irei deletar as relação entre carta e baralho do
			 * jogador, e adicionar novamente.
			 */

			int idJogador = j.getId();
			this.deletarBaralhorJogador(idJogador);

			/*
			 * Agora adiciona as carta novamente. No pior caso, não teve
			 * diferença, a pessoa não mudou o deck e foi realizado as operações
			 * de deletar e excluir. FODA-SE zenti ksaoksoaksoakosako
			 */
			for (CartaAbstrata carta : j.obterCartasAtuais()) {
				this.adicionarCartaBaralho(idJogador, carta.getId());
			}

			listaJogador.put(j.toString(), new Jogador(j));
			if (idJogador == 0) {
				this.inserirJogador(j.getNome(), j.getSenha());
			}
			return true;
		} catch (Exception e) {
			throw new ExcecaoDePersistencia(e);
		}
	}

	protected void query(String sql) throws Exception {
		this.psmt = this.connection.prepareStatement(sql);
	}

	public Jogador pesquisarPorChave(Connection conexao, String id)
			throws ExcecaoDePersistencia {
		try {
			this.connection = conexao;
			Jogador j = new Jogador(listaJogador.get(id));
			ResultSet jogador = this.getJogador(j.getNome(), j.getSenha());
			jogador.next();
			j.setID(jogador.getInt("ID"));
			return j;
		} catch (Exception e) {
			throw new ExcecaoDePersistencia(e);

		}

	}

	protected void insert(HashMap<String, Object> dados) throws Exception {
		String SQL = "INSERT INTO " + this.tabela + " (";
		Set<String> campos = dados.keySet();

		for (String campo : campos) {
			SQL += campo + ",";
		}
		SQL = SQL.substring(0, SQL.length() - 1) + ")";
		SQL += " VALUES (";

		for (int i = 0; i < dados.size(); i++) {
			SQL += "?,";
		}
		SQL = SQL.substring(0, SQL.length() - 1) + ")";

		this.query(SQL);

		int contador = 1;
		for (String campo : campos) {
			this.psmt.setObject(contador, dados.get(campo));
			contador++;
		}
		this.psmt.execute();
	}

	protected ResultSet select(HashMap<String, Object> where) throws Exception {
		String SQL = "SELECT * FROM " + this.tabela + " WHERE ";

		Set<String> condicoes = where.keySet();
		for (String condicao : condicoes) {
			SQL += condicao + "=? AND ";
		}
		SQL = SQL.substring(0, SQL.length() - 5);

		this.query(SQL);

		int contador = 1;
		for (String condicao : condicoes) {
			this.psmt.setObject(contador, where.get(condicao));
			contador++;
		}
		return this.psmt.executeQuery();
	}

	protected ResultSet select(String s) throws Exception {
		String SQL = "";
		if (s.equals("")) {
			SQL = "SELECT * FROM " + this.tabela;
		} else {
			SQL = "SELECT " + s + " FROM " + this.tabela;
		}

		this.query(SQL);
		return this.psmt.executeQuery();
	}

	protected void delete(HashMap<String, Object> where) throws Exception {
		String SQL = "DELETE FROM " + this.tabela + " WHERE ";
		Set<String> condicoes = where.keySet();

		for (String condicao : condicoes) {
			SQL += condicao += "=? AND ";
		}
		SQL = SQL.substring(0, SQL.length() - 5);

		this.query(SQL);

		int contador = 1;
		for (String condicao : condicoes) {
			this.psmt.setObject(contador, where.get(condicao));
			contador++;
		}
		this.psmt.execute();
	}

	protected ResultSet getJogador(String nome, String senha) throws Exception {
		this.tabela = "jogador";
		HashMap<String, Object> where = new HashMap<>();
		where.put("NOME", nome);
		where.put("SENHA", senha);
		return select(where);
	}

	/*
	 * Tabela Baralho
	 */

	protected ResultSet getCartaByJogador(int jogador) throws Exception {
		this.tabela = "baralho";
		HashMap<String, Object> where = new HashMap<>();
		Integer id = jogador;
		where.put("id_jogador", id);
		return select(where);
	}

	protected ResultSet getCartaByID(int carta) throws Exception {
		this.tabela = "carta";
		HashMap<String, Object> where = new HashMap<>();
		Integer id = carta;
		where.put("ID", id);
		return select(where);
	}

	protected void deletarBaralhorJogador(int jogador) throws Exception {
		this.tabela = "baralho";
		HashMap<String, Object> where = new HashMap<>();
		Integer id = jogador;
		where.put("id_jogador", id);
		delete(where);
	}

	protected void adicionarCartaBaralho(int jogador, int carta)
			throws Exception {
		this.tabela = "baralho";
		HashMap<String, Object> dados = new HashMap<>();
		Integer idJogador = jogador;
		Integer idCarta = carta;
		dados.put("id_jogador", jogador);
		dados.put("id_carta", carta);
		insert(dados);
	}

	protected void inserirJogador(String nome, String senha) throws Exception {
		this.tabela = "jogador";
		HashMap<String, Object> where = new HashMap<>();
		where.put("NOME", nome);
		where.put("SENHA", senha);
		insert(where);
	}
}