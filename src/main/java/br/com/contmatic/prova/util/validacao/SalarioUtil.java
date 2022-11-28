package br.com.contmatic.prova.util.validacao;

import static br.com.contmatic.prova.constantes.FuncionarioConstante.SALARIO_MAXIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SALARIO_MINIMO;

import java.math.BigDecimal;
import java.util.Objects;

public final class SalarioUtil {

	private SalarioUtil() {
		super();
	}

	/**
	 * LEMBRAR DE TROCAR O VALOR DO SALARIO MININO QUANDO TIVER AJUSTE
	 * @param salario
	 * @param mensagem
	 */
	public static void validarSalarioMinimo(BigDecimal salario, String mensagem ){
		BigDecimal salarioMinimo = new BigDecimal(SALARIO_MINIMO);
		int resultado = salarioMinimo.compareTo(salario);
		
		if(!Objects.equals(resultado, -1)){
			throw new IllegalArgumentException(mensagem);			
		}		
	}	
	
	public static void validarSalarioMaximo(BigDecimal salario, String mensagem ){
		BigDecimal salarioMaximo = new BigDecimal(SALARIO_MAXIMO);
		int resultado = salarioMaximo.compareTo(salario);
		
		if(!Objects.equals(resultado, 1)){
			throw new IllegalArgumentException(mensagem);			
		}		
	}	
}
