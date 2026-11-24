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
		char opt = validacaoSN();
		sc.nextLine();
		
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
				opt = validacaoSN();
				sc.nextLine();
				
			}
		}
			abrirMenu();	
	}
	
	public static void pendentesChamados() {
		
		boolean temPendente = false;
		for (chamado dados : listC) {
		    if (dados.getStatus() != chamado.CONCLUÍDO) {
		        temPendente = true;
		        break;
		    }
		}
		
		
		if (listC.isEmpty()) {
			System.out.print("Não há chamados pendentes. Gostaria de abrir um chamado agora? (S ou N para retornar ao menu) ");
			char opt = validacaoSN();
			if (Character.toUpperCase(opt) == 'S') {
				abrirChamado();
				
			}
			else {
				abrirMenu();
			
			}
		} else if (temPendente == false) {
			System.out.println("Não há chamados pendentes, todos já foram concluídos!");
		    abrirMenu();
		    return;
		}	
		
		else {
			for (chamado dados : listC) {
				if (dados.getStatus() == chamado.AGUARDANDO || dados.getStatus() == chamado.EM_PROGRESSO) {
				System.out.println(dados.toString());
				}
			}
			System.out.print("Gostaria de delegar um chamado para si? (S/N) ");
			char opt = validacaoSN();
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
		if (listC.isEmpty()) {
			System.out.println("Não há chamados pendentes!");
			abrirMenu();
			return;
		}
		else {
			boolean encontrado = false;
			for (chamado dados : listC) {
				if (dados.getTecnico() == null) {
				encontrado  = true;
				break;
				}
			}
			if (encontrado == true) {
				System.out.println("Chamados sem técnico atribuido:");
				for (chamado dados : listC) {
					if (dados.getTecnico() == null) {
						System.out.println(dados.toString());
					}
				}
				char valid = 'S';
				while (valid == 'S') {
					System.out.print("Digite o número do chamado que deseja atribuir para si: ");	
					int numero = sc.nextInt();
					sc.nextLine();
					boolean finder = false;
					for (chamado dados : listC) {
						if (numero == dados.getNumero() && dados.getTecnico() == null) {
						finder = true;
						}
					}
				
				
					if (finder == true) {
						for (chamado dados : listC) {
							if (dados.getNumero() == numero) { 
								valid = 'N';
								System.out.print("Digite seu nome: ");
								dados.setTecnico(sc.nextLine());
								dados.setStatus(chamado.EM_PROGRESSO);
								
								break;
							}		
						}
					} else {
						System.out.println("Número inválido ou técnico já atribuido!");
						System.out.println("Gostaria de tentar novamente? (S/N) ");
						valid = validacaoSN();
					}
				}
				abrirMenu();
			
				} else {
					System.out.println("Não há chamados aguardando atribuição!");
					abrirMenu();
				}
			
			
		}
			
	}
	
	public static void chamadosConcluidos() {
		if (listC.isEmpty()) {
			System.out.println("Não há chamados para mostrar!");
			abrirMenu();
			return;
		} else {
			
			boolean tester = false;
			for (chamado dados : listC) {
				if (dados.getStatus() == chamado.CONCLUÍDO) {
					tester = true;
					break;
				}
			}
			if (tester == true) {
				System.out.println("Chamados concluídos: ");
				for (chamado dados : listC) {
					if (dados.getStatus() == chamado.CONCLUÍDO) {
						System.out.println(dados.toString());
					}
				}
			} else {
				System.out.println("Não há chamados concluídos!");
			}
			abrirMenu();	
			}
	}
	
	public static void encerrarChamado() {
		if (listC.isEmpty()) {
			System.out.println("Não há chamados para encerrar!");
			abrirMenu();
			return;
		} else {
			boolean tester = false;
			for (chamado dados : listC) {
				if (dados.getStatus() == chamado.EM_PROGRESSO) {
					tester = true;
					break;
				}
			}
			if (tester == true) {
				for (chamado dados : listC) {
					if (dados.getStatus() == chamado.EM_PROGRESSO) {
						System.out.println(dados.toString());
					}
				}
				System.out.println("Digite o número do chamado que deseja encerrar: ");
				int opt = sc.nextInt();
				sc.nextLine();
				boolean finder = false;
				while (finder == false) {
					for (chamado dados : listC) {
						if (dados.getNumero() == opt && dados.getStatus() == chamado.EM_PROGRESSO) {
							finder = true;
						}
					}
					if (finder == true) {
						for (chamado dados : listC) {
							if (opt == dados.getNumero()) {
								dados.setStatus(chamado.CONCLUÍDO);
								System.out.println("Chamado encerrado com sucesso! ");
								System.out.println(dados.toString());
								break;
							}
						}
					} else {
						System.out.print("Número do chamado inválido, por favor digite novamente: ");
						opt = sc.nextInt();
						sc.nextLine();
					}
				}
			} else {
				System.out.println("Não há chamados para finalizar!");
			}
		  }
		abrirMenu();	
		
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
			atribuirTecnico();
			break;
		case 4:
			chamadosConcluidos();
			break;
		case 5:
			encerrarChamado();
			break;
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
		
	
		
	sc.close();	
		
		
	
		
	}
	public static char validacaoSN() {
		char valid = sc.next().charAt(0);
		while (Character.toUpperCase(valid) != 'N' && Character.toUpperCase(valid) != 'S') {
			System.out.println("Entrada inválida, por favor, digite novamente: ");
			valid = sc.next().charAt(0);
		
		
		
		}
		return Character.toUpperCase(valid);		
	}
	
}
