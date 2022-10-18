package br.com.contmatic.prova.util.validacao;

public class ValidacaoUtil {
	
	private ValidacaoUtil() {

	}

	public static void validarNulo(String texto, String mensagem) {
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
		if (texto.matches("[\t]*")) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarNumeros(String texto, String mensagem) {
		if (!texto.matches("[^0-9]*")) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarCaractereEspecial(String texto, String mensagem) { //AJUSTAR ESSA VALIDAÇÃO!!! PRECISA ACEITAR ESPAÇOS TAMBÉM
		if (texto.matches("[^a-zA-Z0-9]*")) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public static void validarLetras(String texto, String mensagem) {
		if (!texto.matches("[0-9]*")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
