package br.com.contmatic.prova.telefone;

import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_CARACTERES_INVALIDOS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TERMINADO_EM_0;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_TAMANHO_FIXO_2;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_CARACTERES_INVALIDOS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VALOR_INVALIDO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_TAMANHO_FIXO_2;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_CARACTERES_INVALIDOS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_TAMANHO_MAXIMO_9;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_TAMANHO_MINIMO_8;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_PERMITIR_SOMENTE_NUMEROS;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.prova.util.validacao.Ddd;
import br.com.contmatic.prova.util.validacao.Ddi;
import br.com.contmatic.prova.util.validacao.Space;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Telefone {

    @NotNull(message = DDI_MENSAGEM_NULO)
    @NotEmpty(message = DDI_MENSAGEM_VAZIO)
    @Space(message = DDI_MENSAGEM_ESPACO)
    @Size(min = DDI_TAMANHO_FIXO_2, max = DDI_TAMANHO_FIXO_2, message = DDI_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_PERMITIR_SOMENTE_NUMEROS, message = DDI_MENSAGEM_CARACTERES_INVALIDOS)
    @Ddi(message = DDI_MENSAGEM_VALOR_INVALIDO)
    private String ddi;

    @NotNull(message = DDD_MENSAGEM_NULO)
    @NotEmpty(message = DDD_MENSAGEM_VAZIO)
    @Space(message = DDD_MENSAGEM_ESPACO)
    @Size(min = DDD_TAMANHO_FIXO_2, max = DDD_TAMANHO_FIXO_2, message = DDD_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_PERMITIR_SOMENTE_NUMEROS, message = DDD_MENSAGEM_CARACTERES_INVALIDOS)
    @Ddd(message = DDD_MENSAGEM_TERMINADO_EM_0)
    private String ddd;
   
    @NotNull(message = NUMERO_MENSAGEM_NULO)
    @NotEmpty(message = NUMERO_MENSAGEM_VAZIO)
    @Space(message = NUMERO_MENSAGEM_ESPACO)
    @Size(min = NUMERO_TAMANHO_MINIMO_8, max = NUMERO_TAMANHO_MAXIMO_9, message = NUMERO_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_PERMITIR_SOMENTE_NUMEROS, message = NUMERO_MENSAGEM_CARACTERES_INVALIDOS)
    private String numero;
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getDdi())
                .append(this.getDdd())
                .append(this.getNumero())
                .hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (!(obj instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) obj;
        return new EqualsBuilder()
                .append(this.getDdi(), other.getDdi())
                .append(this.getDdd(), other.getDdd())
                .append(this.getNumero(), other.getNumero())
                .isEquals();
    }
}
