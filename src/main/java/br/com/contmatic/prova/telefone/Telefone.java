package br.com.contmatic.prova.telefone;

import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TERMINADO_EM_0;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_TAMANHO_FIXO_2;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VALOR_INVALIDO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_TAMANHO_FIXO_2;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_TAMANHO_MAXIMO_9;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_TAMANHO_MINIMO_8;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_LETRAS;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.prova.util.validacao.Ddd;
import br.com.contmatic.prova.util.validacao.Ddi;
import br.com.contmatic.prova.util.validacao.Space;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@EqualsAndHashCode(of = {"ddi", "ddd", "numero"}, callSuper = false)
@RequiredArgsConstructor
@ToString
public class Telefone {

    @NonNull
    @NotNull(message = DDI_MENSAGEM_NULO)
    @NotEmpty(message = DDI_MENSAGEM_VAZIO)
    @Space(message = DDI_MENSAGEM_ESPACO)
    @Size(min = DDI_TAMANHO_FIXO_2, max = DDI_TAMANHO_FIXO_2, message = DDI_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = DDI_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = DDI_MENSAGEM_CARACTERE_ESPECIAL)
    @Ddi(message = DDI_MENSAGEM_VALOR_INVALIDO)
    private String ddi;

    @NonNull
    @NotNull(message = DDD_MENSAGEM_NULO)
    @NotEmpty(message = DDD_MENSAGEM_VAZIO)
    @Space(message = DDD_MENSAGEM_ESPACO)
    @Size(min = DDD_TAMANHO_FIXO_2, max = DDD_TAMANHO_FIXO_2, message = DDD_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = DDD_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = DDD_MENSAGEM_CARACTERE_ESPECIAL)
    @Ddd(message = DDD_MENSAGEM_TERMINADO_EM_0)
    private String ddd;
   
    @NonNull
    @NotNull(message = NUMERO_MENSAGEM_NULO)
    @NotEmpty(message = NUMERO_MENSAGEM_VAZIO)
    @Space(message = NUMERO_MENSAGEM_ESPACO)
    @Size(min = NUMERO_TAMANHO_MINIMO_8, max = NUMERO_TAMANHO_MAXIMO_9, message = NUMERO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = NUMERO_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = NUMERO_MENSAGEM_CARACTERE_ESPECIAL)
    private String numero;

}
