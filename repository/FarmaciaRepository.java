package farmacia.repository;

import farmacia.model.Produto;

public interface FarmaciaRepository {
	
	public void criarProduto(Produto produto);
	public void listarProduto();
	public void consultarProdutoID(int id);
	public void atualizarProduto(Produto produto);
	public void deletarProduto(int id);

}
