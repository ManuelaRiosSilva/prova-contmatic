package br.com.contmatic.prova.constantes;

public final class ClienteConstante {
    
    public static final int CPF_TAMANHO_FIXO_11 = 11;
	
	public static final int NOME_TAMANHO_MINIMO_5 = 5;
	
	public static final int NOME_TAMANHO_MAXIMO_40 = 40;
	
	public static final int EMAIL_TAMANHO_MINIMO_18 = 18;
	
	public static final int EMAIL_TAMANHO_MAXIMO_40 = 40;
	
	public static final String NOME_DA_CLASSE = "Cliente";

	public static final String CPF_MENSAGEM_NULO = "O campo CPF do Cliente é obrigatório.";
	
	public static final String CPF_MENSAGEM_VAZIO = "O campo CPF do Cliente não pode estar vazio.";
	
	public static final String CPF_MENSAGEM_TAMANHO = "O campo CPF do Cliente deve possuir 11 dígitos.";
	
	public static final String CPF_MENSAGEM_LETRAS = "O campo CPF do Cliente deve conter somente números.";
	
	public static final String CPF_MENSAGEM_CARACTERE_ESPECIAL = "O campo CPF do Cliente deve conter somente números.";
	
	public static final String CPF_MENSAGEM_INVALIDO = "O campo CPF do Cliente está inválido.";
	
	public static final String CPF_MENSAGEM_ESPACO = "O campo CPF do Cliente precisa ser válido.";
	
	public static final String NOME_MENSAGEM_NULO = "O campo Nome do Cliente é obrigatório.";
	
	public static final String NOME_MENSAGEM_VAZIO = "O campo Nome do Cliente não pode estar vazio.";
	
	public static final String NOME_MENSAGEM_ESPACO = "O campo Nome do Cliente precisa ser válido.";
	
	public static final String NOME_MENSAGEM_TAMANHO= "O campo Nome do Cliente deve possuir no mínimo 5 e no máximo 40 caracteres.";
	
	public static final String NOME_MENSAGEM_NUMEROS = "O campo Nome do Cliente deve conter somente letras.";
	
	public static final String NOME_MENSAGEM_CARACTERE_ESPECIAL = "O campo Nome do Cliente deve conter somente letras.";
	
	public static final String EMAIL_MENSAGEM_NULO = "O campo Email do Cliente é obrigatório.";
	
	public static final String EMAIL_MENSAGEM_ESPACO = "O campo Email do Cliente precisa ser válido.";

	public static final String EMAIL_MENSAGEM_VAZIO = "O campo Email do Cliente não pode estar vazio.";
	
	public static final String EMAIL_MENSAGEM_TAMANHO = "O campo Email do Cliente deve possuir no mínimo 18 e no máximo 40 caracteres.";
		
	public static final String EMAIL_MENSAGEM_INVALIDO = "O campo Email do Cliente está inválido.";
	
	private ClienteConstante() {
		super();
	}
	
}
