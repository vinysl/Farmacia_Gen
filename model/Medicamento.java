package farmacia.model;

public class Medicamento extends Produto {
	
	private String generico;

	public Medicamento(int id, String nome, int tipo, float preco, String generico) {
		super(id, nome, tipo, preco);
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\nTipo de medicamento: "+generico);
	}

}
