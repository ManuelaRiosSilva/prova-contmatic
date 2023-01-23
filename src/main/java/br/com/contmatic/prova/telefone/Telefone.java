package br.com.contmatic.prova.telefone;

import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TERMINADO_EM_0;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VALOR_INVALIDO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_LETRAS;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.MULTI_LINE_STYLE;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.contmatic.prova.util.validacao.Ddd;
import br.com.contmatic.prova.util.validacao.Ddi;
import br.com.contmatic.prova.util.validacao.Space;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Telefone {

    @NotNull(message = DDI_MENSAGEM_NULO)
    @NotEmpty(message = DDI_MENSAGEM_VAZIO)
    @Space(message = DDI_MENSAGEM_ESPACO)
    @Size(min = 2, max = 2, message = DDI_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = DDI_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = DDI_MENSAGEM_CARACTERE_ESPECIAL)
    @Ddi(message = DDI_MENSAGEM_VALOR_INVALIDO)
    private String ddi;

    @NotNull(message = DDD_MENSAGEM_NULO)
    @NotEmpty(message = DDD_MENSAGEM_VAZIO)
    @Space(message = DDD_MENSAGEM_ESPACO)
    @Size(min = 2, max = 2, message = DDD_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = DDD_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = DDD_MENSAGEM_CARACTERE_ESPECIAL)
    @Ddd(message = DDD_MENSAGEM_TERMINADO_EM_0)
    private String ddd;
   
    @NotNull(message = NUMERO_MENSAGEM_NULO)
    @NotEmpty(message = NUMERO_MENSAGEM_VAZIO)
    @Space(message = NUMERO_MENSAGEM_ESPACO)
    @Size(min = 8, max = 9, message = NUMERO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_LETRAS, message = NUMERO_MENSAGEM_LETRAS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = NUMERO_MENSAGEM_CARACTERE_ESPECIAL)
    private String numero;

    public Telefone(String ddi, String ddd, String numero) {
        super();
        this.setDdi(ddi);
        this.setDdd(ddd);
        this.setNumero(numero);
    }

	@Override
	public int hashCode() {
	    return reflectionHashCode(ddd, numero);
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
