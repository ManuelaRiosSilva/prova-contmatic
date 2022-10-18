package br.com.contmatic.prova.empresa;

import java.util.Objects;

import br.com.contmatic.prova.util.validacao.CPFUtil;
import br.com.contmatic.prova.util.validacao.ValidacaoUtil;

public class Cliente {

	private String cpf;

	private String nome;

	private String email;

	public Cliente(String cpf) {
		super();
		this.setCpf(cpf);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		CPFUtil.validar(cpf);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		ValidacaoUtil.validarNulo(nome, "O campo Nome do Cliente é obrigatório.");
		ValidacaoUtil.validarVazio(nome, "O campo Nome do Cliente não pode estar vazio.");
		if (nome.length() >= 5 && nome.length() <= 40) {
			ValidacaoUtil.validarEspaco(nome, "O campo Nome do Cliente precisa ser válido.");
			ValidacaoUtil.validarCaractereEspecial(nome, "O campo Nome do Cliente só pode conter letras.");
			ValidacaoUtil.validarNumeros(nome, "O campo Nome do Cliente só pode conter letras.");
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("O campo Nome do Cliente deve conter de 5 a 40 caracteres.");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		ValidacaoUtil.validarNulo(email, "O campo Email do Cliente é obrigatório.");
		ValidacaoUtil.validarVazio(email, "O campo Email do Cliente não pode estar vazio.");
		ValidacaoUtil.validarEspaco(email, "O campo Email do Cliente precisa ser válido.");
		if (email.length() >= 18 && email.length() <= 40) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("O campo Email do Cliente deve conter de 18 a 40 caracteres.");
		}
	}

	@Override
	public String toString() {
		return "Cliente [cpf=" + cpf + ", nome=" + nome + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}
}
