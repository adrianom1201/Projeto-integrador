package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.chamado;

public class sistemaChamados {
	
	static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
	static List<chamado> listC = new ArrayList<>();
	static int option = -1; 
	static int numero = 0;
	
	public static void abrirChamado() {
		System.out.println("===========ABERTURA DE CHAMADO===========");
		System.out.print("Deseja continuar? (S/N) ");
		char opt = sc.next().charAt(0);
		sc.nextLine();
		while (Character.toUpperCase(opt) != 'S' && Character.toUpperCase(opt) != 'N') {
			System.out.print("Opção inválida, tente novamente (S/N) ");
			opt = sc.next().charAt(0);
			sc.nextLine();
		}	
		if (Character.toUpperCase(opt) == 'S') {
			while (Character.toUpperCase(opt) == 'S') {
			
				numero ++;
				System.out.println();
				System.out.print("Digite o seu nome: ");
				String solicitante = sc.nextLine();
				System.out.print("Descreva o problema: ");					
				String problema = sc.nextLine();
	
				listC.add(new chamado(solicitante, numero, problema, chamado.AGUARDANDO));
				System.out.print("Gostaria de abrir um novo chamado? (S/N) ");
				opt = sc.next().charAt(0);
				sc.nextLine();
				while (Character.toUpperCase(opt) != 'S' && Character.toUpperCase(opt) != 'N') {
					System.out.print("Opção inválida, tente novamente (S/N) ");
					opt = sc.next().charAt(0);
					sc.nextLine();
				}
			}
		}
			abrirMenu();	
	}
	
	public static void pendentesChamados() {
		if (listC.isEmpty()) {
			System.out.print("Não há chamados pendentes. Gostaria de abrir um chamado agora? (S ou N para retornar ao menu) ");
			char opt = sc.next().charAt(0);
			while (Character.toUpperCase(opt) != 'S' && Character.toUpperCase(opt) != 'N') {
				System.out.print("Opção inválida, tente novamente (S/N) ");
				opt = sc.next().charAt(0);
				sc.nextLine();
			}
			if (Character.toUpperCase(opt) == 'S') {
				abrirChamado();
				
			}
			else {
				abrirMenu();
			
			}
		}
		else {
			for (chamado dados : listC) {
				System.out.println(dados.toString());
			}
			System.out.print("Gostaria de delegar um chamado para si? (S/N) ");
			char opt = sc.next().charAt(0);
			while (Character.toUpperCase(opt) != 'S' && Character.toUpperCase(opt) != 'N') {
				System.out.print("Opção inválida, tente novamente (S/N) ");
				opt = sc.next().charAt(0);
				sc.nextLine();
			}
			if (Character.toUpperCase(opt) == 'S') {
				System.out.print("Digite o número do chamado: ");
				int numero = sc.nextInt();
				sc.nextLine();
				boolean encontrado = false;
				
				while (encontrado == false) {
					for (chamado dados : listC) {
						if (dados.getNumero() == numero) {
							encontrado = true;
							break;
						}
						
					}	
					
						if (encontrado == false) {
						
							System.out.print("Chamado não encontrado, por favor digite novamente: ");
							numero = sc.nextInt();
							sc.nextLine();
						}	
					if (encontrado == true) {
						for (chamado dados : listC) {
							if (dados.getNumero() == numero) {
					
						
								if (dados.getTecnico() == null) {
									System.out.print("Digite seu nome: ");
									dados.setTecnico(sc.nextLine());
									System.out.println("TÉCNICO ATRIBUIDO COM SUCESSO!");
									dados.setStatus(chamado.EM_PROGRESSO);
									System.out.println(dados.toString());
								break;
								}
								else {
									System.out.println("Este chamado já possui técnico atribuido!");
								break;
								}
							}
					
						}
					}
				}
				abrirMenu();
			}
			}
	}
	
	public static void atribuirTecnico() {
		
		
		
	}
	
	
	
	
	
	
	public static void abrirMenu() {
		System.out.println("===========MENÚ DE SERVICE DESK===========");
		System.out.println();
		System.out.println("1 - Abrir chamado");
		System.out.println("2 - Chamados pendentes");
		System.out.println("3 - Atribuir técnico");
		System.out.println("4 - Chamados concluídos");
		System.out.println("5 - Encerrar chamado");
		System.out.println("0 - Encerrar o acesso");
		
		System.out.println();
		
		System.out.print("Digite o número da opção desejada: ");
		option = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
		switch (option) {
		case 1: 
			abrirChamado();
			break;
		case 2:
			pendentesChamados();
			break;
		case 3:
			
		case 4:
			
		case 5:
			
		case 0:
			System.out.println("Sessão encerrada.");
		
			break;
		
		default:
			System.out.println("Entrada inválida");
			break;
		}
	}
	
	
	public static void main(String args[]) {
		
	while (option != 0) {
		
		abrirMenu();
		
	}	
		
	
		
		
		
		
	
		
	}
	
	
}
