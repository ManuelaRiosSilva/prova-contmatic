package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.EMAIL_REGEX;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_LETRAS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_NUMEROS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.util.validacao.Space;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente extends Auditoria {

    @NotBlank(message = CPF_MENSAGEM_NULO)
    @Space(message = CPF_MENSAGEM_ESPACO)
    @Size(min = 11, max = 11, message = CPF_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = CPF_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = CPF_MENSAGEM_CARACTERE_ESPECIAL)
    @CPF(message = CPF_MENSAGEM_INVALIDO)
    private String cpf;

    @NotNull(message = NOME_MENSAGEM_NULO)
    @NotEmpty(message = NOME_MENSAGEM_VAZIO)
    @Space(message = NOME_MENSAGEM_ESPACO)
    @Size(min = 5, max = 40, message = NOME_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message =  NOME_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = NOME_MENSAGEM_CARACTERE_ESPECIAL) 
    private String nome;

    @NotNull(message = EMAIL_MENSAGEM_NULO)
    @NotEmpty(message = EMAIL_MENSAGEM_VAZIO)
    @Space(message = EMAIL_MENSAGEM_ESPACO)
    @Size(min = 18, max = 40, message = EMAIL_MENSAGEM_TAMANHO)
    @Email(regexp = EMAIL_REGEX, message = EMAIL_MENSAGEM_INVALIDO)
    private String email;

    public Cliente(String cpf) {
        super();
        this.setCpf(cpf);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(cpf);
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
