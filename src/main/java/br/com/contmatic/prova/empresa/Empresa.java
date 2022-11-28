package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.EmpresaConstante.DATA_ABERTURA_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.EmpresaConstante.DATA_ABERTURA_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_TAMANHO_MINIMO;
import static br.com.contmatic.prova.util.validacao.DataUtil.validarDataMaxima;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarEspaco;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarListaNula;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarListaTamanhoMaximo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarListaVazia;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNulo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMaximo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMinimo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarVazio;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.auditoria.Auditoria;
import br.com.contmatic.prova.endereco.Endereco;
import br.com.contmatic.prova.telefone.Telefone;
import br.com.contmatic.prova.util.validacao.CNPJUtil;

public class Empresa extends Auditoria {

	private String cnpj;

	private String nomeFantasia;

	private String razaoSocial;

	private List<Telefone> telefones;

	private List<Endereco> enderecos;
	
	private LocalDate dataAbertura;

	public Empresa(String cnpj) {
		this.setCnpj(cnpj);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		CNPJUtil.validar(cnpj);
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		validarNulo(nomeFantasia, NOME_FANTASIA_MENSAGEM_NULO);
		validarVazio(nomeFantasia, NOME_FANTASIA_MENSAGEM_VAZIO);
		validarEspaco(nomeFantasia, NOME_FANTASIA_MENSAGEM_ESPACO);
		validarTamanhoMinimo(nomeFantasia, NOME_FANTASIA_TAMANHO_MINIMO, NOME_FANTASIA_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(nomeFantasia, NOME_FANTASIA_TAMANHO_MAXIMO, NOME_FANTASIA_MENSAGEM_TAMANHO_MAXIMO);
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		validarNulo(razaoSocial, RAZAO_SOCIAL_MENSAGEM_NULO);
		validarVazio(razaoSocial, RAZAO_SOCIAL_MENSAGEM_VAZIO);
		validarEspaco(razaoSocial, RAZAO_SOCIAL_MENSAGEM_ESPACO);
		validarTamanhoMinimo(razaoSocial, RAZAO_SOCIAL_TAMANHO_MINIMO, RAZAO_SOCIAL_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(razaoSocial, RAZAO_SOCIAL_TAMANHO_MAXIMO, RAZAO_SOCIAL_MENSAGEM_TAMANHO_MAXIMO);
		this.razaoSocial = razaoSocial;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		validarListaNula(telefones, LISTA_TELEFONES_MENSAGEM_NULO);
		validarListaVazia(telefones,LISTA_TELEFONES_MENSAGEM_VAZIO);
		validarListaTamanhoMaximo(telefones, LISTA_TELEFONES_TAMANHO_MAXIMO, LISTA_TELEFONES_MENSAGEM_TAMANHO_MAXIMO);
		this.telefones = telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		validarListaNula(enderecos, LISTA_ENDERECOS_MENSAGEM_NULO);
		validarListaVazia(enderecos, LISTA_ENDERECOS_MENSAGEM_VAZIO);
		validarListaTamanhoMaximo(enderecos, LISTA_ENDERECOS_TAMANHO_MAXIMO, LISTA_ENDERECOS_MENSAGEM_TAMANHO_MAXIMO);
		this.enderecos = enderecos;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		validarNulo(dataAbertura, DATA_ABERTURA_MENSAGEM_NULO);
		validarDataMaxima(dataAbertura, DATA_ABERTURA_MAXIMA_MENSAGEM);
		this.dataAbertura = dataAbertura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cnpj);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
	 	if (getClass() != obj.getClass()) {
 			return false;
		}
		Empresa other = (Empresa) obj;
		return Objects.equals(cnpj, other.cnpj);
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Empresa [cnpj=")
		.append(cnpj)
		.append(", nomeFantasia=")
		.append(nomeFantasia)
		.append(", razaoSocial=")
		.append(razaoSocial)
		.append(", telefones=")
		.append(telefones)
		.append(", enderecos=")
		.append(enderecos)
		.append(", dataAbertura=")
		.append(dataAbertura)
		.append("]\n")
		.append(super.toString())
		.toString();
	}
}
