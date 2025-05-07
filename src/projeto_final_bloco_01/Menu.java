package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

import projeto_final_bloco_01.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);

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

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listando todos Produtos cadastrados \n\n");

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Listando informações de um produto especifico\n\n");

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizando dados de um produto\n\n");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Removendo um produto do catalogo\n\n");
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
