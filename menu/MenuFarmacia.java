package farmacia.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import farmacia.controller.FarmaciaController;
import farmacia.model.Cosmetico;
import farmacia.model.Medicamento;

public class MenuFarmacia {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		FarmaciaController produtos = new FarmaciaController();
		
		int opcao =0, id, tipo;
		String nomeProduto, generico = "", fragancia = "";
		float preco;
		
		while (true) {
			
			System.out.println("                                                                    ");
			System.out.println("                                                                    ");
			System.out.println("Bem vindo a Drogaxil, a sua melhor solução quando o assunto é saúde!");
			System.out.println("                                                                    ");
			System.out.println("                     1 - Cadastrar produto                          ");
			System.out.println("                     2 - Listar todos os produtos                   ");
			System.out.println("                     3 - Bucar produto por ID                       ");
			System.out.println("                     4 - Atualizar produto                          ");
			System.out.println("                     5 - Deletar produto                            ");
			System.out.println("                     0 - Sair                                       ");
			System.out.println("                                                                    ");
			System.out.println("                Entre com a opção desejada                          ");
			
			try {
				opcao = leia.nextInt();
			} catch(InputMismatchException inputMismatchException) {
				System.out.println("\nDigite uma opção válida!");
				leia.nextLine();
				opcao = 0;
			}
			
			if (opcao == 0) {
				System.out.println("\nDrogaxil, a solução que você precisa está aqui.");
				leia.close();
				System.exit(0);
			}
			
			switch (opcao) {
			case 1:
				System.out.println("\nCadastrar produto");
				System.out.println("\nDigite o nome do produto: ");
				leia.skip("\\R?");
				nomeProduto = leia.nextLine();
				
				do {
					System.out.println("\nDigite o tipo de produto (1- Medicamento/2- Cosmético): ");
					tipo = leia.nextInt();
				} while(tipo == 1 && tipo == 2);
				
				System.out.println("\nDigite o preço do produto: ");
				preco = leia.nextFloat();
				
				switch (tipo) {
				case 1:
					produtos.criarProduto(new Medicamento(produtos.gerarId(), nomeProduto, tipo, preco, generico));
					break;
					
				case 2:
					produtos.criarProduto(new Cosmetico(produtos.gerarId(), nomeProduto, tipo, preco, fragancia));
					break;
				}
				break;
				
			case 2:
				System.out.println("\nListar todos os produtos");
				produtos.listarProduto();
				break;
				
			case 3:
				System.out.println("\nBuscar produto por ID");
				System.out.println("\nDigite o ID do produto: ");
				id = leia.nextInt();
				produtos.consultarProdutoID(id);
				break;
				
			case 4:
				System.out.println("\nAtualizar produto");
				System.out.println("\nDigite o ID do produto: ");
				id = leia.nextInt();
				
				var buscaProduto = produtos.buscarNaCollection(id);
				if (buscaProduto != null) {
					tipo = buscaProduto.getTipo();
					
					System.out.println("\nDigite o nome do produto: ");
					leia.skip("\\R?");
					nomeProduto = leia.nextLine();
					
					System.out.println("\nDigite o preço do produto: ");
					preco = leia.nextFloat();
					
					switch (tipo) {
					case 1: {
						produtos.atualizarProduto(new Medicamento(id, nomeProduto, tipo, preco, generico));
						break;
					}
						
					case 2: {
						produtos.atualizarProduto(new Cosmetico(id, nomeProduto, tipo, preco, fragancia));
						break;
					} default: {
						System.out.println("\nTipo de produto inválido!");
						}
					}
				} else {
					System.out.println("\nO produto não foi encontrado!");
					break;
				}
				
			case 5:
				System.out.println("\nDeletar produto");
				System.out.println("\nDigite o ID do produto: ");
				id = leia.nextInt();
				
				produtos.deletarProduto(id);
				break;
			}
		}

	}

}
