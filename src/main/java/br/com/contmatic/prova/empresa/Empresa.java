package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.DATA_ABERTURA_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.EmpresaConstante.DATA_ABERTURA_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MINIMO;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.br.CNPJ;
import org.joda.time.DateTime;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.endereco.Endereco;
import br.com.contmatic.prova.telefone.Telefone;
import br.com.contmatic.prova.util.validacao.Space;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Empresa extends Auditoria {
    
    @NotBlank(message = CNPJ_MENSAGEM_NULO)
    @Size(min = CNPJ_TAMANHO_FIXO, max = CNPJ_TAMANHO_FIXO, message = CNPJ_MENSAGEM_TAMANHO)
    @Space(message = CNPJ_MENSAGEM_ESPACO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = CNPJ_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = CNPJ_MENSAGEM_CARACTERE_ESPECIAL)
    @CNPJ(message = CNPJ_MENSAGEM_INVALIDO)
    private String cnpj;

    @NotNull(message = NOME_FANTASIA_MENSAGEM_NULO)
    @NotEmpty(message = NOME_FANTASIA_MENSAGEM_VAZIO)
    @Space(message = NOME_FANTASIA_MENSAGEM_ESPACO)
    @Size(min = NOME_FANTASIA_TAMANHO_MINIMO, max = NOME_FANTASIA_TAMANHO_MAXIMO, message = NOME_FANTASIA_MENSAGEM_TAMANHO)
    private String nomeFantasia;

    @NotNull(message = RAZAO_SOCIAL_MENSAGEM_NULO)
    @NotEmpty(message = RAZAO_SOCIAL_MENSAGEM_VAZIO)
    @Space(message = RAZAO_SOCIAL_MENSAGEM_ESPACO)
    @Size(min = RAZAO_SOCIAL_TAMANHO_MINIMO, max = RAZAO_SOCIAL_TAMANHO_MAXIMO, message = RAZAO_SOCIAL_MENSAGEM_TAMANHO) 
	private String razaoSocial;

    @NotNull(message = LISTA_TELEFONES_MENSAGEM_NULO)
    @NotEmpty(message = LISTA_TELEFONES_MENSAGEM_VAZIO)
    @Size(min = LISTA_TELEFONES_TAMANHO_MINIMO, max = LISTA_TELEFONES_TAMANHO_MAXIMO, message = LISTA_TELEFONES_MENSAGEM_TAMANHO)
	private Set<Telefone> telefones;

    @NotNull(message = LISTA_ENDERECOS_MENSAGEM_NULO)
    @NotEmpty(message = LISTA_ENDERECOS_MENSAGEM_VAZIO)
    @Size(min = LISTA_ENDERECOS_TAMANHO_MINIMO, max = LISTA_ENDERECOS_TAMANHO_MAXIMO, message = LISTA_ENDERECOS_MENSAGEM_TAMANHO)
	private Set<Endereco> enderecos;
 
    @NotNull(message = DATA_ABERTURA_MENSAGEM_NULO)
    @Past (message = DATA_ABERTURA_MAXIMA_MENSAGEM)
	private DateTime dataAbertura;

	public Empresa(String cnpj) {
		this.setCnpj(cnpj);
	}

    @Override
	public int hashCode() {
	    return reflectionHashCode(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
	    return reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
	    return new ToStringBuilder(this).appendSuper(super.toString()).toString();
	}
}
