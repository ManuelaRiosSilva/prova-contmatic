package br.com.contmatic.prova.util.validacao;

import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_REGEX;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_REGEX;

import java.util.List;

public final class ValidacaoUtil {

	private ValidacaoUtil() {
		super();
	}

	public static void validarNulo(Object texto, String mensagem) {
		if (texto == null) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarVazio(String texto, String mensagem) {
		if (texto.isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarEspaco(String texto, String mensagem) {
		if (texto.trim().isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarTamanhoFixo(String texto, int quantidade, String mensagem) {
		if (texto.length() != quantidade) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarTamanhoMinimo(String texto, int minimo, String mensagem) {
		if (texto.length() < minimo) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarTamanhoMaximo(String texto, int maximo, String mensagem) {
		if (texto.length() > maximo) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarNumeros(String texto, String mensagem) {
		if (!texto.matches("[ a-zA-Z-à-úÀ-Ú]*")) {
	 		throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarLetras(String texto, String mensagem) {
		if (!texto.matches("[0-9]*")) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarCaractereEspecial(String texto, String mensagem) { 
		if (!texto.matches("[ 0-9a-zA-Z-à-úÀ-Ú]*")) { 
			throw new IllegalArgumentException(mensagem);
		}
	}	
		
	public static void validarListaNula(List<?> lista, String mensagem) {
		if (lista == null) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarListaVazia(List<?> lista, String mensagem) {
		if (lista.isEmpty()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarListaTamanhoMaximo(List<?> lista, int maximo, String mensagem) {
		if (lista.size() > maximo) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarEmail(String email, String mensagem) {
		if (!email.matches(EMAIL_REGEX)) {
			throw new IllegalArgumentException(mensagem);                
		}
	}	
	
	public static void validarIp(String ip, String mensagem) {
		if(!ip.matches(IP_REGEX)) {
			throw new IllegalArgumentException(mensagem);
		}				
	}
}
