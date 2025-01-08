package br.com.project.cm.visao;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.project.cm.exercao.ExplosaoException;
import br.com.project.cm.exercao.SairException;
import br.com.project.cm.modelo.Tabuleiro;

public class TabuleiroConsole {
	
	private Tabuleiro tabuleiro;
	private Scanner entrada = new Scanner(System.in); 
	
	
	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while (continuar) {
				cicloDoJogo();
				
				System.out.println("Outra partida? (S/n) ");
				String resposta = entrada.nextLine();
				
				if ("n" .equalsIgnoreCase(resposta)) {
					continuar = false;
				}else {
					tabuleiro.reiniciar();
				}
			}
			
		} catch (SairException e) {
			System.out.println("Tchau!!!");
		
		} finally {
			entrada.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			
			while (!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				
				String digitado = capturaValorDigitado("Digite as coordenadas (x, y): ");
				
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
				               .map( e -> Integer.parseInt(e.trim())).iterator();
				
				
				digitado = capturaValorDigitado("1 - Abrir ou 2 - (Des)Marcar");
				
				if ("1" .equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				
				}else if ("2".equals(digitado)) {
					tabuleiro.alternaMarcado(xy.next(), xy.next());
				}
				
			}
			
			System.out.println("Você ganhou!!!");
			System.out.println(tabuleiro);
			
		} catch(ExplosaoException e) {
			
			System.out.println(tabuleiro);
			System.out.println("Você perdeu!");
		}
		
	}
	
	private String capturaValorDigitado(String texto) {
		System.out.println(texto);
		String digitado = entrada.nextLine();
		
		if ("sair" .equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		
		return digitado;
	}
	

}
