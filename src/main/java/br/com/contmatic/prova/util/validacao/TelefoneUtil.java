package br.com.contmatic.prova.util.validacao;

public final class TelefoneUtil {

	private TelefoneUtil() {
		super();
	}

	public static void validarDdi(String ddi, String mensagem) {
		if (!"55".equals(ddi)) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	public static void validarFimDdd(String ddd, String mensagem) {
		if(ddd.endsWith("0")) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}