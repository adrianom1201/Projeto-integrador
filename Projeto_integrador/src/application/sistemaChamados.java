package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Chamado;

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
				System.out.print("Digite o seu nome");
				String solicitante = sc.nextLine();
				System.out.print("Descreva o problema: ");					String problema = sc.nextLine();
	
				listC.add(new chamado(solicitante, numero, problema, chamado.AGUARDAND0));
				System.out.println("Gostaria de abrir um novo chamado? (S/N) ");
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
			System.out.println("Não há chamados pendentes. Gostaria de abrir um chamado agora? (S/N) ");
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
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	public static void abrirMenu() {
		System.out.println("===========MENÚ DE SERVICE DESK===========");
		System.out.println();
		System.out.println("1 - Abrir chamado");
		System.out.println("2 - Chamados pendentes");
		System.out.println("3 - Chamados concluídos");
		System.out.println("0 - Encerrar o acesso");
		
		System.out.print("Digite o número da opção desejada: ");
		option = sc.nextInt();
		sc.nextLine();
		switch (option) {
		case 1: 
			abrirChamado();
			break;
		case 2:
			
		case 3:
			
		case 0:
		System.out.println("Sessão encerrada.");
		
		break;
		}
	}
	
	
	public static void main(String args[]) {
		
	while (option != 0) {
		
		abrirMenu();
		
	}	
		
		
		
		
		
		
		
		
		
	}
	
	
}
