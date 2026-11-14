package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Chamado;

public class sistemaChamados {
	
	static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
	static List<Chamado> listC = new ArrayList<>();
	static int option = -1; 
	
	public static void abrirChamado() {
		System.out.print("Digite o seu nome");
		String solicitante = sc.nextLine();
		
	}
	
	public static void abrirMenu() {
		System.out.println("===========MENÚ DE SERVICE DESK===========");
		System.out.println("1 - Abrir chamado");
		System.out.println("2 - Chamados pendentes");
		System.out.println("3 - Chamados concluídos");
		System.out.println("0 - Encerrar o acesso");
		
		System.out.print("Digite o número da opção desejada: ");
		option = sc.nextInt();
		sc.nextLine();
		switch (option) {
		case 1: 
			
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
