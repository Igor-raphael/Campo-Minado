package br.com.project.cm.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.project.cm.exercao.ExplosaoException;

public class CampoTest {
	
	
	private Campo campo;
	
	
	
	@BeforeEach
	void iniciarCampo() {
		
		campo = new Campo(1,2);
		
	}
	

	@Test
	void testeVizinhoReal () {
		Campo vizinho = new Campo(2, 2);
		
		boolean resultado = campo.adicionarVizinhos(vizinho);
		assertTrue(resultado);
	}
	
	
	
	@Test
	void testeValorPadraoMarcado() {
		assertFalse(campo.isMarcado());
	} 
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
		
	}
	
	@Test
	void testeAdicionarVizinhos1() {
		
		Campo vizinho1 = new Campo(1,1);
		
		Campo vizinhoDoVizinho1 = new Campo(2,2);
		
		vizinho1.adicionarVizinhos(vizinhoDoVizinho1);
		
		campo.adicionarVizinhos(vizinho1);
		campo.abrir();
		
		
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho1.isAberto());
		
		
		
	}
	
	
	@Test
	void testeAdicionarVizinhos2() {
		
		Campo vizinho1 = new Campo(1,1);
		Campo vizinhoDoVizinho1 = new Campo(2,2);
		Campo vizinhoMinado = new Campo(2, 2);
		vizinhoMinado.minar();
		
		vizinho1.adicionarVizinhos(vizinhoDoVizinho1);
		vizinhoDoVizinho1.adicionarVizinhos(vizinhoMinado);
		campo.adicionarVizinhos(vizinho1);
		
		
		campo.abrir();
		
		
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho1.isAberto());
		
		
		
	}
	

}
