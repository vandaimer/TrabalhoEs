package modelo;

import modelo.persistencia.BaralhoDao;
import modelo.persistencia.CartaDao;
import modelo.persistencia.ConexaoBanco;
import modelo.persistencia.JogadorDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioDeJogoDB implements RepositorioDoJogo {

    private final List<Carta> listaDeCartaACervo;
    private final ConexaoBanco conexaoBanco;
    private final Map<String, Jogador> listaJogador = new HashMap<>();

    public RepositorioDeJogoDB() throws Exception {
        /*
         Inicia conexão com o banco
         */
        this.conexaoBanco = new ConexaoBanco("localhost", "root", "admin", "EngenhariaSoftware");
        listaDeCartaACervo = new ArrayList(60);

        /*
         Gera a lista de carta e adiciona do acervo
         */
        CartaDao cd = new CartaDao(this.conexaoBanco, "Carta");
        ResultSet cartas = cd.listAll();
        while (cartas != null && cartas.next()) {
            Carta c = new Carta(cartas.getString("NOME"), cartas.getInt("ID"));
            listaDeCartaACervo.add(c);
        }
    }

    @Override
    public List<Carta> obterCartasDoAcervo() throws ExcecaoDePersistencia {
        return this.listaDeCartaACervo;
    }

    @Override
    public boolean autenticar(Jogador j) throws ExcecaoDePersistencia {

        try {

            String nome = j.getNome();
            String senha = j.getSenha();

            JogadorDao jd = new JogadorDao(this.conexaoBanco, "Jogador");
            ResultSet jogador = jd.getJogador(nome, senha);

            while (jogador != null && jogador.next()) {
                int id = jogador.getInt("ID");
                j.setID(id);
                BaralhoDao bd = new BaralhoDao(this.conexaoBanco, "Baralho");
                ResultSet cartas = bd.getCartaByJogador(id);

                /*
                 Lista de cartas que o usuario tem, mas somente o ID de cada carta
                 Tem que pesquisar na tabela Carta, com o ID, e pegar as informações
                 */
                while (cartas != null && cartas.next()) {
                    int idCarta = cartas.getInt("ID_CARTA");
                    CartaDao cd = new CartaDao(this.conexaoBanco, "Carta");
                    ResultSet carta = cd.getCartaByID(idCarta);

                    while (carta != null && carta.next()) {
                        Carta newCarta = new Carta(carta.getString("NOME"), idCarta);
                        newCarta.setAgilidade(carta.getInt("agilidade"));
                        newCarta.setForca(carta.getInt("forca"));
                        newCarta.setDefesa(carta.getInt("defesa"));
                        newCarta.setEfeito(carta.getInt("efeito"));
                        newCarta.setAtaque(carta.getInt("ataque"));
                        j.editarBaralho(newCarta, 0);
                    }
                }
                listaJogador.put(j.toString(), new Jogador(j));
                return true;
            }
            return false;

        } catch (Exception e) {
            throw new ExcecaoDePersistencia(e);
        }
    }

    @Override
    public boolean salvar(Jogador j) throws ExcecaoDePersistencia {
        try {

            if (j == null) {
                throw new IllegalArgumentException("Jogador inválido, não foi possivel salvar.");
            }

            /*
             Como teria que ser feito um "diff" das carta adicionadas e cartas removidas, então irei deletar
             as relação entre carta e baralho do jogador, e adicionar novamente.
             */
            BaralhoDao bd = new BaralhoDao(this.conexaoBanco, "Baralho");
            int idJogador = j.getId();
            bd.deletarBaralhorJogador(idJogador);

            /*
             Agora adiciona as carta novamente.
             No pior caso, não teve diferença, a pessoa não mudou o deck
             e foi realizado as operações de deletar e excluir. FODA-SE zenti ksaoksoaksoakosako
             */
            for (Carta carta : j.obterCartasAtuais()) {
                bd.adicionarCartaBaralho(idJogador, carta.getId());
            }

            listaJogador.put(j.toString(), new Jogador(j));
            return true;

        } catch (Exception e) {
            throw new ExcecaoDePersistencia(e);
        }

    }

    @Override
    public Jogador pesquisarPorChave(String id) throws ExcecaoDePersistencia {
        try {

            Jogador j = new Jogador(listaJogador.get(id));
            JogadorDao jd = new JogadorDao(this.conexaoBanco, "Jogador");
            ResultSet jogador = jd.getJogador(j.getNome(), j.getSenha());
            jogador.next();
            j.setID(jogador.getInt("ID"));
            return j;

        } catch (Exception e) {
            throw new ExcecaoDePersistencia(e);

        }

    }
}
