package br.com.contmatic.prova.auditoria;

import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADOR_POR_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_ATUALIZACAO_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_ATUALIZACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_CRIACAO_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_CRIACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.IP_REGEX;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_CARACTERES_ESPECIAIS;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.REGEX_VALIDAR_NUMEROS;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import br.com.contmatic.prova.util.validacao.Space;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Auditoria {

    @NotNull(message = CRIADOR_POR_MENSAGEM_NULO)
    @NotEmpty(message = CRIADO_POR_MENSAGEM_VAZIO)
    @Space(message = CRIADO_POR_MENSAGEM_ESPACO)
    @Size(min = CRIADO_POR_TAMANHO_MINIMO, max = CRIADO_POR_TAMANHO_MAXIMO, message = CRIADO_POR_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = CRIADO_POR_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = CRIADO_POR_MENSAGEM_CARACTERE_ESPECIAL)
	private String criadoPor;

    @NotNull(message = ATUALIZADO_POR_MENSAGEM_NULO)
    @NotEmpty(message = ATUALIZADO_POR_MENSAGEM_VAZIO)
    @Space(message = ATUALIZADO_POR_MENSAGEM_ESPACO)
    @Size(min = ATUALIZADO_POR_TAMANHO_MINIMO, max = ATUALIZADO_POR_TAMANHO_MAXIMO, message = ATUALIZADO_POR_MENSAGEM_TAMANHO)
    @Pattern(regexp = REGEX_VALIDAR_NUMEROS, message = ATUALIZADO_POR_MENSAGEM_NUMEROS)
    @Pattern(regexp = REGEX_VALIDAR_CARACTERES_ESPECIAIS, message = ATUALIZADO_POR_MENSAGEM_CARACTERE_ESPECIAL)
    private String atualizadoPor;

    @NotNull(message = DATA_CRIACAO_MENSAGEM_NULO)
    @Past(message = DATA_CRIACAO_MAXIMA_MENSAGEM)
	private DateTime dataCriacao;

    @NotNull(message = DATA_ATUALIZACAO_MENSAGEM_NULO)
    @Past(message = DATA_ATUALIZACAO_MAXIMA_MENSAGEM) 
	private DateTime ultimaAtualizacao;

    @NotNull(message = IP_CRIACAO_MENSAGEM_NULO)
    @NotEmpty(message = IP_CRIACAO_MENSAGEM_VAZIO)
    @Space(message = IP_CRIACAO_MENSAGEM_ESPACO)
    @Size(min = IP_CRIACAO_TAMANHO_MINIMO, max = IP_CRIACAO_TAMANHO_MAXIMO, message = IP_CRIACAO_MENSAGEM_TAMANHO)
    @Pattern(regexp = IP_REGEX, message = IP_CRIACAO_MENSAGEM_INVALIDO)
	private String ipCriacao;

    @NotNull(message = IP_ATUALIZACAO_MENSAGEM_NULO)
    @NotEmpty(message = IP_ATUALIZACAO_MENSAGEM_VAZIO)
    @Space(message = IP_ATUALIZACAO_MENSAGEM_ESPACO)
    @Size(min = IP_ATUALIZACAO_TAMANHO_MINIMO, max = IP_ATUALIZACAO_TAMANHO_MAXIMO, message = IP_ATUALIZACAO_MENSAGEM_TAMANHO)
    @Pattern(regexp = IP_REGEX, message = IP_ATUALIZACAO_MENSAGEM_INVALIDO)
	private String ipUltimaAtualizacao;

    
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
