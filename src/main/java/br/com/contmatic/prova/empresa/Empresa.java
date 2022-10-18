package br.com.contmatic.prova.empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.com.contmatic.prova.endereco.Endereco;
import br.com.contmatic.prova.telefone.Telefone;
import br.com.contmatic.prova.util.validacao.CNPJUtil;
import br.com.contmatic.prova.util.validacao.ValidacaoUtil;

public class Empresa {

	private String cnpj;

	private String nomeFantasia;

	private String razaoSocial;

	private List<Telefone> telefones;

	private List<Endereco> enderecos;
	
	private LocalDate dataAbertura;

	public Empresa(String cnpj) {
		super();
		this.setCnpj(cnpj);
	}

	public void addTelefone(Telefone telefone) {
		if (telefones == null) {
			telefones = new ArrayList<>();
		}
		telefones.add(telefone);
	}

	public void addEndereco(Endereco endereco) {
		if (enderecos == null) {
			enderecos = new ArrayList<>();
		}
		enderecos.add(endereco);
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
		ValidacaoUtil.validarNulo(nomeFantasia, "O campo Nome da Empresa é obrigatório.");
		ValidacaoUtil.validarVazio(nomeFantasia, "O campo Nome da Empresa não pode estar vazio.");
		ValidacaoUtil.validarEspaco(nomeFantasia, "O campo Nome da Empresa precisa ser válido.");
		if (nomeFantasia.length() >= 5 && nomeFantasia.length() <= 35) {
			ValidacaoUtil.validarCaractereEspecial(nomeFantasia, "O campo Nome da Empresa só pode conter letras.");
			this.nomeFantasia = nomeFantasia;
		} else {
			throw new IllegalArgumentException("O campo Nome da Empresa deve conter de 5 a 35 caracteres.");
		}
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		ValidacaoUtil.validarNulo(razaoSocial, "O campo Razão Social da Empresa é obrigatório.");
		ValidacaoUtil.validarVazio(razaoSocial, "O campo Razão Social da Empresa não pode estar vazio.");
		ValidacaoUtil.validarEspaco(razaoSocial, "O campo Razão Social da Empresa precisa ser válido.");
		if (razaoSocial.length() >= 5 && razaoSocial.length() <= 50) {
			this.razaoSocial = razaoSocial;
		} else {
			throw new IllegalArgumentException("O campo Razão Social da Empresa deve conter de 5 a 50 caracteres.");
		}
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		if (!telefones.isEmpty() && telefones.size() <= 5) {
			this.telefones = telefones;
		} else {
			throw new IllegalArgumentException("É preciso ter pelo menos 1 telefone cadastrado e não é possível adicionar mais que 5 telefones.");
		}
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
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

}
