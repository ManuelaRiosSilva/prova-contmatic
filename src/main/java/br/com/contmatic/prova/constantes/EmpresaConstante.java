package br.com.contmatic.prova.constantes;

public final class EmpresaConstante {
	
    public static final int CNPJ_TAMANHO_FIXO_14 = 14;
    
	public static final int NOME_FANTASIA_TAMANHO_MINIMO_5 = 5;
	
	public static final int NOME_FANTASIA_TAMANHO_MAXIMO_35 = 35;
	
	public static final int RAZAO_SOCIAL_TAMANHO_MINIMO_5 = 5;
	
	public static final int RAZAO_SOCIAL_TAMANHO_MAXIMO_50 = 50;
	
	public static final int LISTA_ENDERECOS_TAMANHO_MINIMO_1 = 1;
	
	public static final int LISTA_ENDERECOS_TAMANHO_MAXIMO_5 = 5;
	
	public static final int LISTA_TELEFONES_TAMANHO_MINIMO_1 = 1;
	
	public static final int LISTA_TELEFONES_TAMANHO_MAXIMO_5 = 5;
	
	public static final String CNPJ_MENSAGEM_TAMANHO = "O campo CNPJ da Empresa deve conter 14 dígitos.";
	
	public static final String CNPJ_MENSAGEM_NULO = "O campo CNPJ da Empresa é obrigatório.";
	
	public static final String CNPJ_MENSAGEM_VAZIO = "O campo CNPJ da Empresa não pode estar vazio.";
	
	public static final String CNPJ_MENSAGEM_ESPACO = "O campo CNPJ da Empresa precisa ser válido.";
	
	public static final String CNPJ_MENSAGEM_LETRAS = "O campo CNPJ da Empresa deve conter somente números.";
	
	public static final String CNPJ_MENSAGEM_CARACTERE_ESPECIAL = "O campo CNPJ da Empresa deve conter somente números.";
	
	public static final String CNPJ_MENSAGEM_INVALIDO = "O campo CNPJ da Empresa está inválido.";
	
	public static final String CNPJ_MENSAGEM_NUMEROS_IGUAIS = "O campo CNPJ da Empresa não pode ter todos os números iguais.";
	
	public static final String NOME_FANTASIA_MENSAGEM_NULO = "O campo Nome Fantasia da Empresa é obrigatório.";
	
	public static final String NOME_FANTASIA_MENSAGEM_VAZIO = "O campo Nome Fantasia da Empresa não pode estar vazio.";
	
	public static final String NOME_FANTASIA_MENSAGEM_ESPACO = "O campo Nome Fantasia da Empresa precisa ser válido.";
	
	public static final String NOME_FANTASIA_MENSAGEM_TAMANHO = "O campo Nome Fantasia da Empresa deve possuir no mínimo 5 e no máximo 35 caracteres.";
	
	public static final String RAZAO_SOCIAL_MENSAGEM_NULO = "O campo Razão Social da Empresa é obrigatório.";
	
	public static final String RAZAO_SOCIAL_MENSAGEM_VAZIO = "O campo Razão Social da Empresa não pode estar vazio.";
	
	public static final String RAZAO_SOCIAL_MENSAGEM_ESPACO = "O campo Razão Social da Empresa precisa ser válido.";
	
	public static final String RAZAO_SOCIAL_MENSAGEM_TAMANHO = "O campo Razão Social da Empresa deve possuir no mínimo 5 e no máximo 50 caracteres.";
	
	public static final String LISTA_TELEFONES_MENSAGEM_NULO = "O campo lista de Telefones deve conter pelo menos 1 registro.";
	
	public static final String LISTA_TELEFONES_MENSAGEM_VAZIO = "O campo lista de Telefones deve conter pelo menos 1 registro.";
	
	public static final String LISTA_TELEFONES_MENSAGEM_TAMANHO = "O campo lista de Telefones não pode ter mais que 5 registros.";
	
	public static final String LISTA_ENDERECOS_MENSAGEM_NULO = "O campo lista de Endereços deve conter pelo menos 1 registro."; 
	
	public static final String LISTA_ENDERECOS_MENSAGEM_VAZIO = "O campo lista de Endereços deve conter pelo menos 1 registro.";
	
	public static final String LISTA_ENDERECOS_MENSAGEM_TAMANHO = "O campo lista de Endereços não pode ter mais que 5 registros.";
	
	public static final String DATA_ABERTURA_MENSAGEM_NULO = "O campo Data de Abertura da Empresa é obrigatório.";
	
	public static final String DATA_ABERTURA_MAXIMA_MENSAGEM = "A Data de Abertura da Empresa não pode ser maior que a data atual.";
	
	private EmpresaConstante() {
		super();
	}
	
}
