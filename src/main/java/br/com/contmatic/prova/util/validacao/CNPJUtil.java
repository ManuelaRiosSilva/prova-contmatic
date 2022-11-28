package br.com.contmatic.prova.util.validacao;

import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.CINCO_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.DOIS_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.FIM_DO_PESO;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.INICIO_CONTAGEM;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.INICIO_DO_PESO;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.MODULO_11;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.NOVE_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.OITO_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.POSICAO_PRIMEIRO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.POSICAO_SEGUNDO_DIGITO_VERIFICADOR;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.QUANTIDADE_DIGITOS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.QUATRO_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.SEIS_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.SETE_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.TOTAL_MULTIPLICACAO_NUMEROS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.TRES_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.UM_IGUAIS;
import static br.com.contmatic.prova.constantes.CNPJNumerosConstante.ZERO_IGUAIS;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_NUMEROS_IGUAIS;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNulo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarVazio;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarEspaco;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarCaractereEspecial;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarLetras;

public final class CNPJUtil {

	private CNPJUtil() {
		super();
	}

	public static void validar(String cnpj) {

		validarNulo(cnpj, CNPJ_MENSAGEM_NULO);
		validarVazio(cnpj, CNPJ_MENSAGEM_VAZIO);
		validarEspaco(cnpj, CNPJ_MENSAGEM_ESPACO);
		validarTamanho(cnpj);
		validarLetras(cnpj, CNPJ_MENSAGEM_LETRAS);
		validarCaractereEspecial(cnpj, CNPJ_MENSAGEM_CARACTERE_ESPECIAL);
		validarNumerosIguais(cnpj);
		
		String inverterCnpj = new StringBuilder(cnpj).reverse().toString();
		int resultado = calculoPrimeiroDigito(inverterCnpj);
		int resultado2 = calculoSegundoDigito(inverterCnpj);
		validarCalculoDigitos(cnpj, resultado, resultado2);
	}

	private static void validarCalculoDigitos(String cnpj, int resultado, int resultado2) {
		if (resultado == Integer.parseInt(String.valueOf(cnpj.charAt(POSICAO_PRIMEIRO_DIGITO_VERIFICADOR)))
				&& resultado2 == Integer.parseInt(String.valueOf(cnpj.charAt(POSICAO_SEGUNDO_DIGITO_VERIFICADOR)))) {
			return;
		}

		throw new IllegalArgumentException(CNPJ_MENSAGEM_INVALIDO);
	}

	private static int calculoSegundoDigito(String inverterCnpj) {
		int soma;
		int multiplicador;
		soma = TOTAL_MULTIPLICACAO_NUMEROS;
		multiplicador = INICIO_CONTAGEM;
		for (int contador = INICIO_CONTAGEM; contador < QUANTIDADE_DIGITOS; contador++) {
			multiplicador++;
			if (multiplicador > FIM_DO_PESO) {
				multiplicador = INICIO_DO_PESO;
			}
			soma += Integer.parseInt(String.valueOf(inverterCnpj.charAt(contador))) * multiplicador;
		}
		return MODULO_11 - (soma % MODULO_11);
	}

	private static int calculoPrimeiroDigito(String inverterCnpj) {
		int soma = TOTAL_MULTIPLICACAO_NUMEROS;
		int multiplicador = INICIO_CONTAGEM;
		for (int contador = INICIO_DO_PESO; contador < QUANTIDADE_DIGITOS; contador++) {
			multiplicador++;
			if (multiplicador > FIM_DO_PESO) {
				multiplicador = INICIO_DO_PESO;
			}
			soma += Integer.parseInt(String.valueOf(inverterCnpj.charAt(contador))) * multiplicador;
		}
		return MODULO_11 - (soma % MODULO_11);
	}

	private static void validarNumerosIguais(String cnpj) {
		if (cnpj.equals(ZERO_IGUAIS) || cnpj.equals(UM_IGUAIS) || cnpj.equals(DOIS_IGUAIS) || cnpj.equals(TRES_IGUAIS)
				|| cnpj.equals(QUATRO_IGUAIS) || cnpj.equals(CINCO_IGUAIS) || cnpj.equals(SEIS_IGUAIS)
				|| cnpj.equals(SETE_IGUAIS) || cnpj.equals(OITO_IGUAIS) || cnpj.equals(NOVE_IGUAIS)) {
			throw new IllegalArgumentException(CNPJ_MENSAGEM_NUMEROS_IGUAIS);
		}
	}

	private static void validarTamanho(String cnpj) {
		if (cnpj.length() != TAMANHO_FIXO) {
			throw new IllegalArgumentException(CNPJ_MENSAGEM_TAMANHO);
		}
	}
}
