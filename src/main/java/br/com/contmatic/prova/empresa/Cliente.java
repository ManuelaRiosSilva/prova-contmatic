package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_LETRAS;
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
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_TAMANHO_MAXIMO_40;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_TAMANHO_MINIMO_5;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.EMAIL_REGEX;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_LETRAS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_NUMEROS;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.util.validacao.Space;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = {"cpf"}, callSuper = false)
@RequiredArgsConstructor
@ToString
public class Cliente extends Auditoria {

    @NonNull
    @NotBlank(message = CPF_MENSAGEM_NULO)
    @Space(message = CPF_MENSAGEM_ESPACO)
    @Size(min = CPF_TAMANHO_FIXO_11, max = CPF_TAMANHO_FIXO_11, message = CPF_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = CPF_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = CPF_MENSAGEM_CARACTERE_ESPECIAL)
    @CPF(message = CPF_MENSAGEM_INVALIDO)
    private String cpf;

    @NotNull(message = NOME_MENSAGEM_NULO)
    @NotEmpty(message = NOME_MENSAGEM_VAZIO)
    @Space(message = NOME_MENSAGEM_ESPACO)
    @Size(min = NOME_TAMANHO_MINIMO_5, max = NOME_TAMANHO_MAXIMO_40, message = NOME_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = NOME_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = NOME_MENSAGEM_CARACTERE_ESPECIAL)
    private String nome;

    @NotNull(message = EMAIL_MENSAGEM_NULO)
    @NotEmpty(message = EMAIL_MENSAGEM_VAZIO)
    @Space(message = EMAIL_MENSAGEM_ESPACO)
    @Size(min = EMAIL_TAMANHO_MINIMO_18, max = EMAIL_TAMANHO_MAXIMO_40, message = EMAIL_MENSAGEM_TAMANHO)
    @Email(regexp = EMAIL_REGEX, message = EMAIL_MENSAGEM_INVALIDO)
    private String email;

}
