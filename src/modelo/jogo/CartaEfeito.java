package modelo.jogo;

public class CartaEfeito extends Carta{
	
	
	private Carta umaCarta;

	public CartaEfeito(Carta c, String nome, int id, int inteligencia, int forca, int agilidade) {
		super(nome,id,inteligencia,forca,agilidade);
		umaCarta = c;
	}

	
	
	
	@Override
	public int getAgilidade() {
		return umaCarta.getAgilidade() +super.getAgilidade();
	}
	
	@Override
	public int getInteligencia() {
		return umaCarta.getInteligencia()+super.getInteligencia();
	}
	
	@Override
	public int getForca() {
		return umaCarta.getForca()+super.getForca();
	}
	
	@Override
	public String getNome() {
		return umaCarta.getNome()+","+super.getNome();
	}
	
public static void main(String[] args) {
	Carta cm=new Carta("montro", 1, 1, 2, 3);
	CartaEfeito ce=new CartaEfeito(cm,"efeito_1",2, 1,1, 1);
	CartaEfeito ce2=new CartaEfeito(ce,"efeito_2",2, 1,1, 1);
	
	System.out.println(ce2);
	
}
}
