package br.com.project.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.project.cm.exercao.ExplosaoException;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	
	private boolean aberto;
	private boolean minado;
	private boolean marcado;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	
	
	//METODOS
	 Campo (int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		
	}
	
	boolean adicionarVizinhos(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		
		if (deltaGeral == 1 && !diagonal) {
			
			vizinhos.add(vizinho);
			return true;
			
		} else if (deltaGeral == 2 && diagonal) {
			
			vizinhos.add(vizinho);
			return true;
		
		}else {
			return false;
		}
		
	}
	
	
	
	void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	
	
	boolean abrir() {
		
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new ExplosaoException();
			}
			// ou seja enquanto nao tive minas por perto ele continuara a abrir.
			if(vizinhacaSeguraca()) {
				vizinhos.forEach(v -> v.abrir());
			}
			
			return true;
			
		}else {
		
			return false;
			}
	}
	
	
	
	
	boolean vizinhacaSeguraca() {
		return vizinhos.stream().noneMatch(V -> V.minado);
	}
	
	
	void minar() {
		minado = true;
	}
	
	
	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		
		return desvendado || protegido;
	}
	
	
	
	long minasNasVizinhacas () {
		return vizinhos.stream().filter(V -> V.minado).count();
	}
	
	
	
	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	

	public String toString() {
		if(marcado) {
			return "X";
		
		} else if (aberto && minado) {
			return "*";
		
		} else if (aberto && minasNasVizinhacas() > 0) {
			return Long.toString(minasNasVizinhacas());
		
		}else if (aberto) {
			return " ";
		
		} else {
			return "?";
		}
		
		
		
	}
	
	
	
	//GETTER E SETTERS
	public boolean isMarcado() {
		return marcado;
	}
	
	void setAberto(boolean aberto) {
	     this.aberto = aberto;
	}
	
	public boolean isAberto() {
		return aberto;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public boolean isFechado() {
		return !isAberto();
	}
	
	public boolean isMinado() {
		return minado;
	}
	
	
	
}
