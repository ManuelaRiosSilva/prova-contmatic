package br.com.contmatic.empresa;

import java.util.Objects;

public class Funcionario {
	private String matricula;
	
	public String getMatricula() {
		return matricula;
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


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	private String cpf;
	
	
	
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	private String nome;
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	private String cargo;
	
	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	


	private String setor;
	
	public String getSetor() {
		return setor;
	}


	public void setSetor(String setor) {
		this.setor = setor;
	}
	
}
