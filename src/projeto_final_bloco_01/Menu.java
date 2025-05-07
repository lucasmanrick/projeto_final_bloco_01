package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Eletronico;
import projeto_final_bloco_01.model.Mobilia;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
	
		
		ProdutoController crudReceive = new ProdutoController();
		
		String marca,categoria,caracteristicas,finalidade,usabilidade;
		int tipo,identificador;
		double largura,altura,profundidade,peso,preco;
		
		
		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                MercadoDigital Do Lucas              ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Novo Produto               ");
			System.out.println("            2 - Ver Todos Produtos registrados       ");
			System.out.println("            3 - Buscar Produto pelo seu ID           ");
			System.out.println("            4 - Atualizar Dados de um produto        ");
			System.out.println("            5 - Retirar um Produto do Catalogo       ");
			System.out.println("            6 - Listar Produtos por Marca            ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Insira a opção desejada:                             ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nMercadoDigital Do Lucas, Onde sua Compra rende");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Cadastrando novo Produto \n\n");
				System.out.println("Digite o tipo de produto que você deseja cadastrar: \n 1 - Eletronico \n 2 - Mobilia");
				tipo = leia.nextInt();
				System.out.println("Digite a marca do produto: ");
				leia.skip("\\R");
				marca = leia.nextLine();
				System.out.println("Digite o preço do produto: ");
				preco = leia.nextDouble();
				System.out.println("Digite a categoria do produto (por exemplo: mouse, teclado ou sofá, cama)");
				leia.skip("\\R");
				categoria = leia.nextLine();
				System.out.println("Digite as caracteristicas do produto: (ex: produto na cor preta,vermelha e azul, inclui funcionalidade rgb e etc.)");
				caracteristicas = leia.nextLine();
				
				switch (tipo) {
					case 1 : 
						System.out.println("Digite a finalidade do produto (gamer, trabalho, normal)");
						finalidade = leia.nextLine();
						System.out.println("Digite a usabilidade do produto (bateria, plugavel)");
						usabilidade = leia.nextLine();
						Eletronico novoProdutoEletronico = new Eletronico(crudReceive.gerarID(),preco,marca,categoria,caracteristicas,tipo,finalidade,usabilidade);
						crudReceive.cadastrar(novoProdutoEletronico);
						break;
					case 2:
						System.out.println("Digite a largura do produto:");
						largura = leia.nextDouble();
						System.out.println("Digite a altura do produto: ");
						altura = leia.nextDouble();
						System.out.println("Digite a profundidade do produto: ");
						profundidade = leia.nextDouble();
						System.out.println("Digite o peso do produto: ");
						peso = leia.nextDouble();
						Mobilia novoProdutoMobilia= new Mobilia(crudReceive.gerarID(),preco,marca,categoria,caracteristicas,tipo,largura,altura,profundidade,peso);
						crudReceive.cadastrar(novoProdutoMobilia);
						break;
						default: 
							System.out.println("Opção invalida!");
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listando todos Produtos cadastrados \n\n");
				crudReceive.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Listando informações de um produto especifico\n\n");
				System.out.println("Digite o id do produto:");
				identificador = leia.nextInt();
				
				crudReceive.procurarPorId(identificador);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizando dados de um produto\n\n");
				System.out.println("Digite o id do produto:");
				identificador = leia.nextInt();
				
				Optional<Produto> verificandoExistencia = crudReceive.buscarProdutoNoBd(identificador);
				
				if(verificandoExistencia.isPresent()) {
					if(verificandoExistencia.get().gettipoProd() == 1) {
						System.out.println(Cores.TEXT_WHITE + "Produto encontrado, atualizando dados do Produto \n\n");
						System.out.println("Digite o tipo de produto que você deseja cadastrar: \n 1 - Eletronico \n 2 - Mobilia");
						tipo = leia.nextInt();
						System.out.println("Digite a marca do produto: ");
						leia.skip("\\R");
						marca = leia.nextLine();
						System.out.println("Digite o preço do produto: ");
						preco = leia.nextDouble();
						System.out.println("Digite a categoria do produto (por exemplo: mouse, teclado)");
						leia.skip("\\R");
						categoria = leia.nextLine();
						System.out.println("Digite as caracteristicas do produto: (ex: produto na cor preta,vermelha e azul, inclui funcionalidade rgb e etc.)");
						caracteristicas = leia.nextLine();
						System.out.println("Digite a finalidade do produto (gamer, trabalho, normal)");
						finalidade = leia.nextLine();
						System.out.println("Digite a usabilidade do produto (bateria, plugavel)");
						usabilidade = leia.nextLine();
						Eletronico novoProdutoEletronico = new Eletronico(identificador,preco,marca,categoria,caracteristicas,tipo,finalidade,usabilidade);
						crudReceive.atualizar(identificador, novoProdutoEletronico);
					}else if (verificandoExistencia.get().gettipoProd() == 2) {
						System.out.println(Cores.TEXT_WHITE + "Cadastrando novo Produto \n\n");
						System.out.println("Digite o tipo de produto que você deseja cadastrar: \n 1 - Eletronico \n 2 - Mobilia");
						tipo = leia.nextInt();
						System.out.println("Digite a marca do produto: ");
						leia.skip("\\R");
						marca = leia.nextLine();
						System.out.println("Digite o preço do produto: ");
						preco = leia.nextDouble();
						System.out.println("Digite a categoria do produto (por exemplo: mouse, teclado)");
						leia.skip("\\R");
						categoria = leia.nextLine();
						System.out.println("Digite as caracteristicas do produto: (ex: produto na cor preta,vermelha e azul, inclui funcionalidade rgb e etc.)");
						caracteristicas = leia.nextLine();
						System.out.println("Digite a largura do produto:");
						largura = leia.nextDouble();
						System.out.println("Digite a altura do produto: ");
						altura = leia.nextDouble();
						System.out.println("Digite a profundidade do produto: ");
						profundidade = leia.nextDouble();
						System.out.println("Digite o peso do produto: ");
						peso = leia.nextDouble();
						Mobilia novoProdutoMobilia= new Mobilia(crudReceive.gerarID(),preco,marca,categoria,caracteristicas,tipo,largura,altura,profundidade,peso);
						crudReceive.atualizar(identificador,novoProdutoMobilia);
					}
//					
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Removendo um produto do catalogo\n\n");
				System.out.println("Digite o id do produto:");
				identificador = leia.nextInt();
				crudReceive.deletar(identificador);
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Lucas Manrick Teodoro da Fonseca");
		System.out.println("https://github.com/lucasmanrick");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		 try {
		        System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		        
		        // Lê apenas a tecla Enter e ignora outras teclas
		        int input;
		        while ((input = System.in.read()) != '\n') {
		            // Ignora qualquer outra tecla diferente do Enter
		            if (input == -1) {
		                throw new IOException("Entrada encerrada inesperadamente");
		            }
		        }
		        
		    } catch (IOException e) {
		        System.err.println("Erro de entrada/saída: " + e.getMessage());
		    } catch (Exception e) {
		        System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
		    }
	}


}
