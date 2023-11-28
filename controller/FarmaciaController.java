package farmacia.controller;

import java.util.ArrayList;

import farmacia.model.Produto;
import farmacia.repository.FarmaciaRepository;

public class FarmaciaController implements FarmaciaRepository {
	
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;
	
	@Override
	public void criarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto "+produto.getNome()+" foi criado com sucesso!");
	}
	
	@Override
	public void listarProduto() {
		for (var produto : listaProdutos) {
			produto.visualizar();
		}
	}
	
	@Override
	public void consultarProdutoID(int id) {
		var produto = buscarNaCollection(id);
		
		if (produto != null) {
			produto.visualizar();
		} else {
			System.out.println("\nO produto "+produto+" não foi encontrado!");
		}
	}
	
	@Override
	public void atualizarProduto(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getId());
		
		if (buscaProduto != null) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nO produto de ID: "+produto.getId()+" foi atualizado com sucesso!");
		} else {
			System.out.println("\nO produto de ID: "+produto.getId()+" não foi encontrado!");
		}
	}
	
	@Override
	public void deletarProduto(int id) {
		var produto = buscarNaCollection(id);
		
		if (produto != null) {
			if (listaProdutos.remove(produto) == true) {
				System.out.println("\nO produto com ID "+id+" foi deletado com sucesso!");
			}
		} else {
			System.out.println("\nO produto com ID "+id+" não foi encontrado!");
		}
	}
	
	public int gerarId() {
		return ++ id;
	}
	
	public Produto buscarNaCollection(int id) {
		for (var produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

}
