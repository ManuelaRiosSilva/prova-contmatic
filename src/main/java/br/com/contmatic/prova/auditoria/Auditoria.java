package br.com.contmatic.prova.auditoria;

import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADOR_POR_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_ATUALIZACAO_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_ATUALIZACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_ATUALIZACAO_MINIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_CRIACAO_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_CRIACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.util.validacao.DataUtil.validarDataAtualizacaoMinima;
import static br.com.contmatic.prova.util.validacao.DataUtil.validarDataMaxima;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarCaractereEspecial;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarEspaco;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarIp;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNulo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNumeros;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMaximo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMinimo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarVazio;

import java.time.LocalDateTime;

public abstract class Auditoria {

	private String criadoPor;

	private String atualizadoPor;

	private LocalDateTime dataCriacao;

	private LocalDateTime ultimaAtualizacao;

	private String ipCriacao;

	private String ipUltimaAtualizacao;

	public String getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		validarNulo(criadoPor, CRIADOR_POR_MENSAGEM_NULO);
		validarVazio(criadoPor, CRIADO_POR_MENSAGEM_VAZIO);
		validarEspaco(criadoPor, CRIADO_POR_MENSAGEM_ESPACO);
		validarTamanhoMinimo(criadoPor, CRIADO_POR_TAMANHO_MINIMO, CRIADO_POR_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(criadoPor, CRIADO_POR_TAMANHO_MAXIMO, CRIADO_POR_MENSAGEM_TAMANHO_MAXIMO);
		validarNumeros(criadoPor, CRIADO_POR_MENSAGEM_NUMEROS);
		validarCaractereEspecial(criadoPor, CRIADO_POR_MENSAGEM_CARACTERE_ESPECIAL);
		this.criadoPor = criadoPor;
	}

	public String getAtualizadoPor() {
		return atualizadoPor;
	}

	public void setAtualizadoPor(String atualizadoPor) {
		validarNulo(atualizadoPor, ATUALIZADO_POR_MENSAGEM_NULO);
		validarVazio(atualizadoPor, ATUALIZADO_POR_MENSAGEM_VAZIO);
		validarEspaco(atualizadoPor, ATUALIZADO_POR_MENSAGEM_ESPACO);
		validarTamanhoMinimo(atualizadoPor, ATUALIZADO_POR_TAMANHO_MINIMO, ATUALIZADO_POR_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(atualizadoPor, ATUALIZADO_POR_TAMANHO_MAXIMO, ATUALIZADO_POR_MENSAGEM_TAMANHO_MAXIMO);
		validarNumeros(atualizadoPor, ATUALIZADO_POR_MENSAGEM_NUMEROS);
		validarCaractereEspecial(atualizadoPor, ATUALIZADO_POR_MENSAGEM_CARACTERE_ESPECIAL);
		this.atualizadoPor = atualizadoPor;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		validarNulo(dataCriacao, DATA_CRIACAO_MENSAGEM_NULO);
		validarDataMaxima(dataCriacao, DATA_CRIACAO_MAXIMA_MENSAGEM);
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) {
		validarNulo(ultimaAtualizacao, DATA_ATUALIZACAO_MENSAGEM_NULO);
		validarDataMaxima(ultimaAtualizacao, DATA_ATUALIZACAO_MAXIMA_MENSAGEM);
		validarDataAtualizacaoMinima(ultimaAtualizacao, getDataCriacao(), DATA_ATUALIZACAO_MINIMA_MENSAGEM);
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public String getIpCriacao() {
		return ipCriacao;
	}

	public void setIpCriacao(String ipCriacao) {
		validarNulo(ipCriacao, IP_CRIACAO_MENSAGEM_NULO);
		validarVazio(ipCriacao, IP_CRIACAO_MENSAGEM_VAZIO);
		validarEspaco(ipCriacao, IP_CRIACAO_MENSAGEM_ESPACO);
		validarTamanhoMinimo(ipCriacao, IP_CRIACAO_TAMANHO_MINIMO, IP_CRIACAO_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(ipCriacao, IP_CRIACAO_TAMANHO_MAXIMO, IP_CRIACAO_MENSAGEM_TAMANHO_MAXIMO);
		validarIp(ipCriacao, IP_CRIACAO_MENSAGEM_INVALIDO);
		this.ipCriacao = ipCriacao;
	}

	public String getIpUltimaAtualizacao() {
		return ipUltimaAtualizacao;
	}

	public void setIpUltimaAtualizacao(String ipUltimaAtualizacao) {
		validarNulo(ipUltimaAtualizacao, IP_ATUALIZACAO_MENSAGEM_NULO);
		validarVazio(ipUltimaAtualizacao, IP_ATUALIZACAO_MENSAGEM_VAZIO);
		validarEspaco(ipUltimaAtualizacao, IP_ATUALIZACAO_MENSAGEM_ESPACO);
		validarTamanhoMinimo(ipUltimaAtualizacao, IP_ATUALIZACAO_TAMANHO_MINIMO, IP_ATUALIZACAO_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(ipUltimaAtualizacao, IP_ATUALIZACAO_TAMANHO_MAXIMO, IP_ATUALIZACAO_MENSAGEM_TAMANHO_MAXIMO);
		validarIp(ipUltimaAtualizacao, IP_ATUALIZACAO_MENSAGEM_INVALIDO);
		this.ipUltimaAtualizacao = ipUltimaAtualizacao;
	}

	@Override
	public String toString() {
		return new StringBuilder() 
		.append("Auditoria [criadoPor=")
		.append(criadoPor)
		.append(", atualizadoPor=")
		.append(atualizadoPor)
		.append(", dataCriacao=")
		.append(dataCriacao)
		.append(", ultimaAtualizacao=")
		.append(ultimaAtualizacao)
		.append(", ipCriacao=")
		.append(ipCriacao)
		.append(", ipUltimaAtualizacao=")
		.append(ipUltimaAtualizacao)
		.append("]")
		.toString();
	}

}
