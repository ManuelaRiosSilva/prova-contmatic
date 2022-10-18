package br.com.contmatic.prova.empresa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.com.contmatic.prova.util.validacao.ValidacaoUtil;

public class Funcionario {

	private String matricula;

	private String cpf;

	private String nome;

	private String cargo;

	private String setor;
	
	private LocalDate dataNascimento;
	
	private BigDecimal salario;
	
	private Boolean ativo;

	public Funcionario(String matricula) {
		super();
		this.setMatricula(matricula);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		ValidacaoUtil.validarNulo(matricula, "O campo Matrícula do Funcionário é obrigatório.");
		ValidacaoUtil.validarVazio(matricula, "O campo Matrícula do Funcionário não pode estar vazio.");
		ValidacaoUtil.validarEspaco(matricula, "O campo Matrícula do Funcionário precisa ser válido.");
		if (matricula.length() == 5) {
			ValidacaoUtil.validarLetras(matricula, "O campo Matrícula do Funcionário deve conter somente números.");
			ValidacaoUtil.validarCaractereEspecial(matricula, "O campo Matrícula do Funcionário deve conter somente números.");
			this.matricula = matricula;
		} else {
			throw new IllegalArgumentException("O campo matrícula do Funcionário deve conter 5 caracteres.");
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		ValidacaoUtil.validarNulo(cpf, "O campo CPF do Funcionário é obrigatório.");
		ValidacaoUtil.validarVazio(cpf, "O campo CPF do Funcionário não pode estar vazio.");
		ValidacaoUtil.validarEspaco(cpf, "o campo CPF do Funcionário precisa ser válido.");
		if (cpf.length() == 11) {
			ValidacaoUtil.validarLetras(cpf, "O campo CPF do Funcionário deve conter somente números.");
			ValidacaoUtil.validarCaractereEspecial(cpf, "O campo CPF do Funcionário deve conter somente números.");
			this.cpf = cpf;
		} else {
			throw new IllegalArgumentException("O campo CPF do Funcionário deve conter 11 caracteres.");
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		ValidacaoUtil.validarNulo(nome, "O campo Nome do Funcionário é obrigatório.");
		ValidacaoUtil.validarVazio(nome, "O campo Nome do Funcionário não pode estar vazio.");
		ValidacaoUtil.validarEspaco(nome, "O campo Nome do Funcionário precisa ser válido.");
		if (nome.length() >= 5 && nome.length() <= 40) {
			ValidacaoUtil.validarNumeros(nome, "o campo Nome do Funcionário deve conter somente letras.");
			ValidacaoUtil.validarCaractereEspecial(nome, "o campo Nome do Funcionário deve conter somente letras.");
			this.nome = nome;
		} else {
			throw new IllegalArgumentException("O campo Nome do Funcionário deve conter de 5 a 40 caracteres.");
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		ValidacaoUtil.validarNulo(cargo, "O campo Cargo do Funcionário é obrigatório.");
		ValidacaoUtil.validarVazio(cargo, "O campo Cargo do Funcionário não pode estar vazio.");
		ValidacaoUtil.validarEspaco(cargo, "O campo Cargo do Funcionário precisa ser válido.");
		if (cargo.length() >= 5 && cargo.length() <= 15) {
			ValidacaoUtil.validarNumeros(cargo, "O campo Cargo do Funcionário deve conter somente letras.");
			ValidacaoUtil.validarCaractereEspecial(cargo, "O campo Cargo do Funcionário deve conter somente letras.");
			this.cargo = cargo;
		} else {
			throw new IllegalArgumentException("O campo Cargo do Funcionário deve conter de 5 a 15 caracteres.");
		}
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		ValidacaoUtil.validarNulo(setor, "O campo Setor do Funcionário é obrigatório.");
		ValidacaoUtil.validarVazio(setor, "O campo Setor do Funcionário não pode estar vazio.");
		ValidacaoUtil.validarEspaco(setor, "O campo Setor do Funcionário precisa ser válido.");
		if (setor.length() >= 2 && setor.length() <= 20) {
			ValidacaoUtil.validarNumeros(setor, "O campo Setor do Funcionário deve conter somente letras.");
			ValidacaoUtil.validarCaractereEspecial(setor, "O campo Setor do Funcionário deve conter somente letras.");
			this.setor = setor;
		} else {
			throw new IllegalArgumentException("O campo Setor do Funcionário deve conter de 2 a 20 caracteres.");
		}
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", cpf=" + cpf + ", nome=" + nome + ", cargo=" + cargo
				+ ", setor=" + setor + ", dataNascimento=" + dataNascimento + ", salario=" + salario + ", ativo="
				+ ativo + "]";
	}
	
}
