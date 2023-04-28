package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_CARACTERES_INVALIDOS;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_TAMANHO_FIXO_11;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_TAMANHO_MAXIMO_40;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_TAMANHO_MINIMO_18;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_CARACTERES_INVALIDOS;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_TAMANHO_MAXIMO_40;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_TAMANHO_MINIMO_5;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.EMAIL_REGEX;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_PERMITIR_SOMENTE_LETRAS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_PERMITIR_SOMENTE_NUMEROS;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.util.validacao.Space;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cliente extends Auditoria {

    @NotBlank(message = CPF_MENSAGEM_NULO)
    @Space(message = CPF_MENSAGEM_ESPACO)
    @Size(min = CPF_TAMANHO_FIXO_11, max = CPF_TAMANHO_FIXO_11, message = CPF_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_PERMITIR_SOMENTE_NUMEROS, message = CPF_MENSAGEM_CARACTERES_INVALIDOS)
    @CPF(message = CPF_MENSAGEM_INVALIDO)
    private String cpf;

    @NotNull(message = NOME_MENSAGEM_NULO)
    @NotEmpty(message = NOME_MENSAGEM_VAZIO)
    @Space(message = NOME_MENSAGEM_ESPACO)
    @Size(min = NOME_TAMANHO_MINIMO_5, max = NOME_TAMANHO_MAXIMO_40, message = NOME_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_PERMITIR_SOMENTE_LETRAS, message = NOME_MENSAGEM_CARACTERES_INVALIDOS)
    private String nome;

    @NotNull(message = EMAIL_MENSAGEM_NULO)
    @NotEmpty(message = EMAIL_MENSAGEM_VAZIO)
    @Space(message = EMAIL_MENSAGEM_ESPACO)
    @Size(min = EMAIL_TAMANHO_MINIMO_18, max = EMAIL_TAMANHO_MAXIMO_40, message = EMAIL_MENSAGEM_TAMANHO)
    @Email(regexp = EMAIL_REGEX, message = EMAIL_MENSAGEM_INVALIDO)
    private String email;

    public Cliente(String cpf) {
        super();
        this.setCpf(cpf);
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getCpf()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) obj;
        return new EqualsBuilder().append(this.getCpf(), other.getCpf()).isEquals();
    }
}
