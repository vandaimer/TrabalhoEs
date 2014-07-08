package modelo.jogo;

public class CartaEfeito extends CartaAbstrata {

	private CartaAbstrata umaCarta;

	public CartaEfeito() {
	
	}
	
	private CartaEfeito(CartaAbstrata c, String nome, int id, int inteligencia,
			int forca, int agilidade) {
		super(nome, id, inteligencia, forca, agilidade);
		tipo = "Efeito";
		umaCarta = c;
	}

	public CartaEfeito(String nome, int id, int inteligencia, int forca,
			int agilidade) {
		this(null, nome, id, inteligencia, forca, agilidade);

	}

	public CartaAbstrata decorar(CartaAbstrata c) {
		return new CartaEfeito(c, super.getNome(), super.getId(),
				super.getInteligencia(), super.getForca(), super.getAgilidade());
	}

	@Override
	public int getAgilidade() {
		if (umaCarta == null) {
			return super.getAgilidade();
		}
		return umaCarta.getAgilidade() + super.getAgilidade();
	}

	@Override
	public int getInteligencia() {
		if (umaCarta == null) {
			return super.getInteligencia();
		}
		return umaCarta.getInteligencia() + super.getInteligencia();
	}

	@Override
	public int getForca() {
		if (umaCarta == null) {
			return super.getForca();
		}
		return umaCarta.getForca() + super.getForca();

	}

	@Override
	public String getNome() {
		if (umaCarta == null) {
			return super.getNome();
		}
		return umaCarta.getNome() + "," + super.getNome();
	}



	@Override
	public String getTipo() {
		if(umaCarta==null){
			return super.getTipo();
		}
		return super.getTipo() + " " + umaCarta.getTipo();
	}

	public static void main(String[] args) {
		CartaAbstrata c1 = new Carta("m1", 1, 10, 10, 10);
		CartaEfeito ce1 = new CartaEfeito("e1", 2, 2, 2, 2);
		CartaAbstrata aux = ce1.decorar(c1);
		aux = ce1.decorar(aux);
		System.out.println(aux);
	}

	@Override
	public CartaAbstrata clonar() {
		return new CartaEfeito(umaCarta.clonar(), nome, id, inteligencia, forca, agilidade);
	}

}
