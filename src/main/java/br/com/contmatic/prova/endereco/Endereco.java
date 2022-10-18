package br.com.contmatic.prova.endereco;

import java.util.Objects;

import br.com.contmatic.prova.util.validacao.ValidacaoUtil;

public class Endereco {

	private String cep;

	private String numero;

	private String logradouro;

	private String bairro;

	private String cidade;

	private String uf;

	public Endereco(String cep, String numero) {
		super();
		this.setCep(cep);
		this.setNumero(numero);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		ValidacaoUtil.validarNulo(cep, "O campo CEP do Endereço é obrigatório.");
		ValidacaoUtil.validarVazio(cep, "O campo CEP do Endereço não pode estar vazio.");
		ValidacaoUtil.validarEspaco(cep, "O campo CEP do Endereço precisa ser válido.");
		if (cep.length() == 8) {
			ValidacaoUtil.validarLetras(cep, "O campo CEP do Endereço deve conter somente números.");
			ValidacaoUtil.validarCaractereEspecial(cep, "O campo CEP do Endereço deve conter somente números.");
			this.cep = cep;
		} else {
			throw new IllegalArgumentException("O campo CEP do Endereço deve conter 8 caracteres.");
		}
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		ValidacaoUtil.validarNulo(numero, "O campo Número do Endereço é obrigatório.");
		ValidacaoUtil.validarVazio(numero, "O campo Número do Endereço não pode estar vazio.");
		ValidacaoUtil.validarEspaco(numero, "O campo Número do Endereço precisa ser válido.");
		if (numero.length() >= 1 && numero.length() <= 4) {
			ValidacaoUtil.validarLetras(numero, "O campo Número do Endereço só pode conter números.");
			ValidacaoUtil.validarCaractereEspecial(numero, "O campo Número do Endereço só pode conter números.");
			this.numero = numero;
		} else {
			throw new IllegalArgumentException("O campo Número do Endereço deve conter de 1 a 4 caracteres.");
		}
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		ValidacaoUtil.validarNulo(logradouro, "O campo Logradouro do Endereço é obrigatório.");
		ValidacaoUtil.validarVazio(logradouro, "O campo Logradouro do Endereço não pode estar vazio.");
		ValidacaoUtil.validarEspaco(logradouro, "O campo Logradouro do Endereço precisa ser válido.");
		if (logradouro.length() >= 3 && logradouro.length() <= 60) {
			ValidacaoUtil.validarNumeros(logradouro, "O campo Logradouro do Endereço só pode conter letras.");
			ValidacaoUtil.validarCaractereEspecial(logradouro, "O campo Logradouro do Endereço não pode ter caracteres especiais.");
			this.logradouro = logradouro;
		} else {
			throw new IllegalArgumentException("O campo Logradouro do Endereço deve conter de 3 a 60 caracteres.");
		}
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		ValidacaoUtil.validarNulo(bairro, "O campo Bairro do Endereço é obrigatório.");
		ValidacaoUtil.validarVazio(bairro, "O campo Bairro do Endereço não pode estar vazio.");
		ValidacaoUtil.validarEspaco(bairro, "O campo Bairro do Endereço precisa ser válido.");
		if (bairro.length() >= 3 && bairro.length() <= 30) {
			ValidacaoUtil.validarCaractereEspecial(bairro, "O campo Bairro do Endereço só pode conter letras.");
			this.bairro = bairro;
		} else {
			throw new IllegalArgumentException("O campo Bairro do Endereço deve conter de 3 a 30 caracteres.");
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		ValidacaoUtil.validarNulo(cidade, "O campo Cidade do Endereço é obrigatório.");
		ValidacaoUtil.validarVazio(cidade, "O campo Cidade do Endereço não pode estar vazio.");
		ValidacaoUtil.validarEspaco(cidade, "O campo Cidade do Endereço precisa ser válido.");
		if (cidade.length() >= 3 && cidade.length() <= 20) {
			ValidacaoUtil.validarCaractereEspecial(cidade, "O campo Cidade do Endereço deve conter somente letras.");
			ValidacaoUtil.validarNumeros(cidade, "O campo Cidade do Endereço deve conter somente letras.");
			
			this.cidade = cidade;
		} else {
			throw new IllegalArgumentException("O campo Cidade do Endereço deve conter de 3 a 20 caracteres.");
		}
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		ValidacaoUtil.validarNulo(uf, "O campo UF do Endereço é obrigatório.");
		ValidacaoUtil.validarVazio(uf, "O campo UF do Endereço não pode estar vazio.");
		ValidacaoUtil.validarEspaco(uf, "O campo UF do Endereço precisa ser válido.");
		if (uf.length() == 2) {
			ValidacaoUtil.validarNumeros(uf, "O campo UF do Endereço deve conter somente letras.");
			ValidacaoUtil.validarCaractereEspecial(uf, "O campo UF do Endereço deve conter somente letras.");
			this.uf = uf;
		} else {
			throw new IllegalArgumentException("O campo UF do Endereço deve conter 2 caracteres.");
		}
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", numero=" + numero + ", logradouro=" + logradouro + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", uf=" + uf + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
	}
}
