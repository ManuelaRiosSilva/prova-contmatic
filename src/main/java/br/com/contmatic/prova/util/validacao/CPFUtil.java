package br.com.contmatic.prova.util.validacao;

public class CPFUtil {

	private CPFUtil() {

	}

	public static boolean validar(String cpf) {

		if (cpf == null) {
			throw new IllegalArgumentException("O campo CPF do Cliente é obrigatório.");
		}

		if (cpf.equals("")) {
			throw new IllegalArgumentException("O campo CPF do Cliente não pode estar vazio.");
		}

		if (cpf.length() < 11) {
			throw new IllegalArgumentException("O campo CPF do Cliente deve conter 11 caracteres.");
		}

		if (cpf.length() > 11) {
			throw new IllegalArgumentException("O campo CPF do Cliente deve conter 11 caracteres.");
		}
		
		if(cpf.equals("00000000000")||cpf.equals("11111111111")||cpf.equals("22222222222") 
		||cpf.equals("33333333333") || cpf.equals("44444444444") ||cpf.equals("55555555555") 
		||cpf.equals("66666666666") || cpf.equals("77777777777") ||cpf.equals("88888888888") 
		||cpf.equals("99999999999")){
			throw new IllegalArgumentException("O campo CPF do Cliente não pode ter todos os números iguais.");
		}

		validacaoCPF(cpf);

		if (cpf.length() == 11) {
			int soma = 0;
			int multiplicador = 10;
			for (int contador = 0; contador < 9; contador++) {
				soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * multiplicador;
				multiplicador--;
			}
			int resultado = 11 - (soma % 11);

			soma = 0;
			multiplicador = 11;
			for (int contador = 0; contador < 10; contador++) {
				soma += Integer.parseInt(String.valueOf(cpf.charAt(contador))) * multiplicador;
				multiplicador--;
			}
			int resultado2 = 11 - (soma % 11);

			if (resultado == Integer.parseInt(String.valueOf(cpf.charAt(9)))
					&& resultado2 == Integer.parseInt(String.valueOf(cpf.charAt(10)))) {
				return true;
			}
		}
		throw new IllegalArgumentException("O campo CPF do Cliente está inválido.");
	}

	public static void validacaoCPF(String cpf) {
		try {
			if (!cpf.matches("[0-9]*")) {
				throw new IllegalArgumentException("O campo CPF do Cliente só pode conter números.");
			}

		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("O campo CPF do Cliente não pode conter máscara.");
		}
	}
}