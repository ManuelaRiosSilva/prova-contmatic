package br.com.contmatic.prova.util.validacao;

import static br.com.contmatic.prova.constantes.CPFConstante.CPF_MENSAGEM;
import static br.com.contmatic.prova.constantes.CPFConstante.CPF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.CPFConstante.CPF_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.CPFConstante.CPF_MENSAGEM_NUMEROS_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFConstante.CPF_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.CPFConstante.CPF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.TOTAL_MULTIPLICACAO_NUMEROS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.MODULO_11;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.INICIO_CONTAGEM;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.ZERO_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.UM_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.DOIS_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.TRES_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.QUATRO_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.CINCO_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.SEIS_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.SETE_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.OITO_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.NOVE_IGUAIS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.NOVE_PRIMEIROS_NUMEROS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.QUANTIDADE_NUMEROS_ATE_PRIMEIRO_DIGITO;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.QUANTIDADE_NUMEROS_ATE_SEGUNDO_DIGITO;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.DEZ_PRIMEIROS_NUMEROS;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.POSICAO_PRIMEIRO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constantes.CPFNumerosConstante.POSICAO_SEGUNDO_DIGITO_VERIFICADOR;

public final class CPFUtil {

	private CPFUtil() {
		super();
 	}

	public static void validar(String cpf, String classe) {
		validarTamanho(cpf, classe);
		validarNumerosIguais(cpf, classe);	
		verificarCalculoDigitos(cpf, classe);	
	}

	private static void verificarCalculoDigitos(String cpf, String classe) {
		int resultado = calculoPrimeiroDigito(cpf);

		int resultado2 = calculoSegundoDigito(cpf);

		if (resultado == Integer.parseInt(String.valueOf(cpf.charAt(POSICAO_PRIMEIRO_DIGITO_VERIFICADOR)))
				&& resultado2 == Integer.parseInt(String.valueOf(cpf.charAt(POSICAO_SEGUNDO_DIGITO_VERIFICADOR)))) {
			return;
		}
		throw new IllegalArgumentException(CPF_MENSAGEM + classe + CPF_MENSAGEM_INVALIDO);
	}

	private static int calculoSegundoDigito(String cpf) {
		int soma;
		int multiplicador;
		soma = TOTAL_MULTIPLICACAO_NUMEROS;
		multiplicador = QUANTIDADE_NUMEROS_ATE_SEGUNDO_DIGITO;
		for (int contador = INICIO_CONTAGEM; contador < DEZ_PRIMEIROS_NUMEROS; contador++) {
			soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * multiplicador;
			multiplicador--;
		}
		return MODULO_11 - (soma % MODULO_11);
		
	}

	private static int calculoPrimeiroDigito(String cpf) {
		int soma = TOTAL_MULTIPLICACAO_NUMEROS;
		int multiplicador = QUANTIDADE_NUMEROS_ATE_PRIMEIRO_DIGITO;
		for (int contador = INICIO_CONTAGEM; contador < NOVE_PRIMEIROS_NUMEROS; contador++) {
			soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * multiplicador;
			multiplicador--;
		}
		return MODULO_11 - (soma % MODULO_11);
		 
	}

	private static void validarNumerosIguais(String cpf, String classe) {
		if (cpf.equals(ZERO_IGUAIS) || cpf.equals(UM_IGUAIS) || cpf.equals(DOIS_IGUAIS)
				|| cpf.equals(TRES_IGUAIS) || cpf.equals(QUATRO_IGUAIS) || cpf.equals(CINCO_IGUAIS)
				|| cpf.equals(SEIS_IGUAIS) || cpf.equals(SETE_IGUAIS) || cpf.equals(OITO_IGUAIS)
				|| cpf.equals(NOVE_IGUAIS)) {
			throw new IllegalArgumentException(CPF_MENSAGEM + classe + CPF_MENSAGEM_NUMEROS_IGUAIS);
		}
	}

	private static void validarTamanho(String cpf, String classe) {
		if (cpf.length() != TAMANHO_FIXO) {
			throw new IllegalArgumentException(CPF_MENSAGEM + classe + CPF_MENSAGEM_TAMANHO);
		}
	}

	public static void validacaoVazio(String cpf, String classe) {
		if (cpf.isEmpty()) {
			throw new IllegalArgumentException(CPF_MENSAGEM + classe + CPF_MENSAGEM_VAZIO);
		}
	}

	public static void validacaoNulo(String cpf, String classe) {
		if (cpf == null) {
			throw new IllegalArgumentException(CPF_MENSAGEM + classe + CPF_MENSAGEM_NULO);
		}
	}
	
}
