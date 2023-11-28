package farmacia.model;

public class Cosmetico extends Produto {
	
	private String fragancia;

	public Cosmetico(int id, String nome, int tipo, float preco, String fragancia) {
		super(id, nome, tipo, preco);
	}

	public String getFragancia() {
		return fragancia;
	}

	public void setFragancia(String fragancia) {
		this.fragancia = fragancia;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\nCosmético: "+fragancia);
	}

}
