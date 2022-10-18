package br.com.contmatic.prova.util.validacao;

public class CNPJUtil {

	private CNPJUtil() {

	}

	public static boolean validar(String cnpj) {

		ValidacaoUtil.validarNulo(cnpj, "O campo CNPJ da Empresa é obrigatório.");

		ValidacaoUtil.validarVazio(cnpj, "O campo CNPJ da Empresa não pode estar vazio.");

		ValidacaoUtil.validarEspaco(cnpj, "O campo CNPJ da Empresa precisa ser válido.");

		validarTamanho(cnpj);

		if (cnpj.length() == 14) {

			ValidacaoUtil.validarLetras(cnpj, "O campo CNPJ da Empresa só pode conter números.");
			ValidacaoUtil.validarCaractereEspecial(cnpj, "O campo CNPJ da Empresa só pode conter números.");
			validarNumerosIguais(cnpj);

			String inverterCnpj = new StringBuilder(cnpj).reverse().toString();

			int soma = 0;
			int multiplicador = 1;
			for (int contador = 2; contador < 14; contador++) {
				multiplicador++;
				if (multiplicador > 9) {
					multiplicador = 2;
				}
				soma += Integer.parseInt(String.valueOf(inverterCnpj.charAt(contador))) * multiplicador;
			}
			int resultado = 11 - (soma % 11);

			soma = 0;
			multiplicador = 1;
			for (int contador = 1; contador < 14; contador++) {
				multiplicador++;
				if (multiplicador > 9) {
					multiplicador = 2;
				}
				soma += Integer.parseInt(String.valueOf(inverterCnpj.charAt(contador))) * multiplicador;
			}
			int resultado2 = 11 - (soma % 11);

			if (resultado == Integer.parseInt(String.valueOf(cnpj.charAt(12)))
					&& resultado2 == Integer.parseInt(String.valueOf(cnpj.charAt(13)))) {
				return true;
			}
		}
		throw new IllegalArgumentException("O campo CNPJ da Empresa está inválido.");
	}

	private static void validarNumerosIguais(String cnpj) {
		if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
				|| cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555")
				|| cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888")
				|| cnpj.equals("99999999999999")) {
			throw new IllegalArgumentException("O campo CNPJ da Empresa não pode ter todos os números iguais.");
		}
	}

	private static void validarTamanho(String cnpj) {
		if (cnpj.length() < 14) {
			throw new IllegalArgumentException("O campo CNPJ da Empresa deve conter 14 caracteres.");
		}

		if (cnpj.length() > 14) {
			throw new IllegalArgumentException("O campo CNPJ da Empresa deve conter 14 caracteres.");
		}
	}
}
