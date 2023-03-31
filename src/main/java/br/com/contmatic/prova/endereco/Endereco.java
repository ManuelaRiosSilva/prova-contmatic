package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_TAMANHO_MAXIMO_30;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_TAMANHO_MINIMO_3;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_TAMANHO_FIXO_8;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_TAMANHO_MAXIMO_20;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_TAMANHO_MINIMO_3;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MAXIMO_60;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MINIMO_3;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_TAMANHO_MAXIMO_4;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_TAMANHO_MINIMO_1;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_TAMANHO_FIXO_2;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_LETRAS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_NUMEROS;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.prova.util.validacao.Space;
import br.com.contmatic.prova.util.validacao.Uf;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of = {"cep", "numero"}, callSuper = false)
@RequiredArgsConstructor
@ToString
public class Endereco {

    @NonNull
    @NotNull(message = CEP_MENSAGEM_NULO)
    @NotEmpty(message = CEP_MENSAGEM_VAZIO)
    @Space(message = CEP_MENSAGEM_ESPACO)
    @Size(min = CEP_TAMANHO_FIXO_8, max = CEP_TAMANHO_FIXO_8, message = CEP_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = CEP_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = CEP_MENSAGEM_CARACTERE_ESPECIAL)
	private String cep;

    @NonNull
    @NotNull(message = NUMERO_MENSAGEM_NULO)
    @NotEmpty(message = NUMERO_MENSAGEM_VAZIO)
    @Space(message = NUMERO_MENSAGEM_ESPACO)
    @Size(min = NUMERO_TAMANHO_MINIMO_1, max = NUMERO_TAMANHO_MAXIMO_4, message = NUMERO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = NUMERO_MENSAGEM_CARACTERE_ESPECIAL)
	private String numero;

    @NotNull(message = LOGRADOURO_MENSAGEM_NULO)
    @NotEmpty(message = LOGRADOURO_MENSAGEM_VAZIO)
    @Space(message = LOGRADOURO_MENSAGEM_ESPACO)
    @Size(min = LOGRADOURO_TAMANHO_MINIMO_3, max = LOGRADOURO_TAMANHO_MAXIMO_60, message = LOGRADOURO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = LOGRADOURO_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = LOGRADOURO_MENSAGEM_CARACTERE_ESPECIAL)
	private String logradouro;

    @NotNull(message = BAIRRO_MENSAGEM_NULO)
    @NotEmpty(message = BAIRRO_MENSAGEM_VAZIO)
    @Space(message = BAIRRO_MENSAGEM_ESPACO)
    @Size(min = BAIRRO_TAMANHO_MINIMO_3, max = BAIRRO_TAMANHO_MAXIMO_30, message = BAIRRO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = BAIRRO_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = BAIRRO_MENSAGEM_CARACTERE_ESPECIAL)
	private String bairro;

    @NotNull(message = CIDADE_MENSAGEM_NULO)
    @NotEmpty(message = CIDADE_MENSAGEM_VAZIO)
    @Space(message = CIDADE_MENSAGEM_ESPACO)
    @Size(min = CIDADE_TAMANHO_MINIMO_3, max = CIDADE_TAMANHO_MAXIMO_20, message = CIDADE_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = CIDADE_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = CIDADE_MENSAGEM_CARACTERE_ESPECIAL)
	private String cidade;

    @NotNull(message = UF_MENSAGEM_NULO)
    @NotEmpty(message = UF_MENSAGEM_VAZIO)
    @Space(message = UF_MENSAGEM_ESPACO)
    @Size(min = UF_TAMANHO_FIXO_2, max = UF_TAMANHO_FIXO_2, message = UF_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = UF_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = UF_MENSAGEM_CARACTERE_ESPECIAL)
    @Uf(enumClass = EstadoType.class, message = UF_MENSAGEM_INVALIDO)
	private String uf;
    
}
