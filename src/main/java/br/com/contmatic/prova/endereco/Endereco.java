package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_TAMANHO_FIXO;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_LETRAS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_NUMEROS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.prova.util.validacao.Space;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    @NotNull(message = CEP_MENSAGEM_NULO)
    @NotEmpty(message = CEP_MENSAGEM_VAZIO)
    @Space(message = CEP_MENSAGEM_ESPACO)
    @Size(min = CEP_TAMANHO_FIXO, max = CEP_TAMANHO_FIXO, message = CEP_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = CEP_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = CEP_MENSAGEM_CARACTERE_ESPECIAL)
	private String cep;

    @NotNull(message = NUMERO_MENSAGEM_NULO)
    @NotEmpty(message = NUMERO_MENSAGEM_VAZIO)
    @Space(message = NUMERO_MENSAGEM_ESPACO)
    @Size(min = NUMERO_TAMANHO_MINIMO, max = NUMERO_TAMANHO_MAXIMO, message = NUMERO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = NUMERO_MENSAGEM_CARACTERE_ESPECIAL)
	private String numero;

    @NotNull(message = LOGRADOURO_MENSAGEM_NULO)
    @NotEmpty(message = LOGRADOURO_MENSAGEM_VAZIO)
    @Space(message = LOGRADOURO_MENSAGEM_ESPACO)
    @Size(min = LOGRADOURO_TAMANHO_MINIMO, max = LOGRADOURO_TAMANHO_MAXIMO, message = LOGRADOURO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = LOGRADOURO_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = LOGRADOURO_MENSAGEM_CARACTERE_ESPECIAL)
	private String logradouro;

    @NotNull(message = BAIRRO_MENSAGEM_NULO)
    @NotEmpty(message = BAIRRO_MENSAGEM_VAZIO)
    @Space(message = BAIRRO_MENSAGEM_ESPACO)
    @Size(min = BAIRRO_TAMANHO_MINIMO, max = BAIRRO_TAMANHO_MAXIMO, message = BAIRRO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = BAIRRO_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = BAIRRO_MENSAGEM_CARACTERE_ESPECIAL)
	private String bairro;

    @NotNull(message = CIDADE_MENSAGEM_NULO)
    @NotEmpty(message = CIDADE_MENSAGEM_VAZIO)
    @Space(message = CIDADE_MENSAGEM_ESPACO)
    @Size(min = CIDADE_TAMANHO_MINIMO, max = CIDADE_TAMANHO_MAXIMO, message = CIDADE_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = CIDADE_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = CIDADE_MENSAGEM_CARACTERE_ESPECIAL)
	private String cidade;

    @NotNull(message = UF_MENSAGEM_NULO)
    @NotEmpty(message = UF_MENSAGEM_VAZIO)
    @Space(message = UF_MENSAGEM_ESPACO)
    @Size(min = UF_TAMANHO_FIXO, max = UF_TAMANHO_FIXO, message = UF_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = UF_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = UF_MENSAGEM_CARACTERE_ESPECIAL)
	private String uf;

	public Endereco(String cep, String numero) {
		super();
		this.setCep(cep);
		this.setNumero(numero);
	}

	@Override
	public int hashCode() {
	    return reflectionHashCode(cep, numero);
	}

	@Override
	public boolean equals(Object obj) {
	    return reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
	    return reflectionToString(this, MULTI_LINE_STYLE);
	}
}
