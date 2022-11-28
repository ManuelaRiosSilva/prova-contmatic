package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.FuncionarioConstante.ATIVO_FUNCIONARIO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.DATA_NASCIMENTO_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.DATA_NASCIMENTO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.DATA_NASCIMENTO_MINIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_DA_CLASSE;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SALARIO_MAXIMO_MENSAGEM;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SALARIO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SALARIO_MINIMO_MENSAGEM;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_TAMANHO_MINIMO;
import static br.com.contmatic.prova.util.validacao.CPFUtil.validacaoNulo;
import static br.com.contmatic.prova.util.validacao.CPFUtil.validacaoVazio;
import static br.com.contmatic.prova.util.validacao.CPFUtil.validar;
import static br.com.contmatic.prova.util.validacao.DataUtil.validarDataNascimentoMaxima;
import static br.com.contmatic.prova.util.validacao.DataUtil.validarDataNascimentoMinima;
import static br.com.contmatic.prova.util.validacao.SalarioUtil.validarSalarioMaximo;
import static br.com.contmatic.prova.util.validacao.SalarioUtil.validarSalarioMinimo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarCaractereEspecial;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarEspaco;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarLetras;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNulo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNumeros;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoFixo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMaximo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMinimo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarVazio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import br.com.contmatic.prova.auditoria.Auditoria;

public class Funcionario extends Auditoria{

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
		validarNulo(matricula, MATRICULA_MENSAGEM_NULO);
		validarVazio(matricula, MATRICULA_MENSAGEM_VAZIO);
		validarEspaco(matricula, MATRICULA_MENSAGEM_ESPACO);
		validarTamanhoFixo(matricula, MATRICULA_TAMANHO_FIXO, MATRICULA_MENSAGEM_TAMANHO);
		validarLetras(matricula, MATRICULA_MENSAGEM_LETRAS);
		validarCaractereEspecial(matricula, MATRICULA_MENSAGEM_CARACTERE_ESPECIAL);
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		validacaoNulo(cpf, NOME_DA_CLASSE);
		validacaoVazio(cpf, NOME_DA_CLASSE);
		validarEspaco(cpf, CPF_MENSAGEM_ESPACO);
		validarLetras(cpf, CPF_MENSAGEM_LETRAS);
		validarCaractereEspecial(cpf, CPF_MENSAGEM_CARACTERE_ESPECIAL);
		validar(cpf, NOME_DA_CLASSE);
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarNulo(nome, NOME_MENSAGEM_NULO);
		validarVazio(nome, NOME_MENSAGEM_VAZIO);
		validarEspaco(nome, NOME_MENSAGEM_ESPACO);
		validarTamanhoMinimo(nome, NOME_TAMANHO_MINIMO, NOME_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(nome, NOME_TAMANHO_MAXIMO, NOME_MENSAGEM_TAMANHO_MAXIMO);
		validarNumeros(nome, NOME_MENSAGEM_NUMEROS);
		validarCaractereEspecial(nome, NOME_MENSAGEM_CARACTERE_ESPECIAL);
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		validarNulo(cargo, CARGO_MENSAGEM_NULO);
		validarVazio(cargo, CARGO_MENSAGEM_VAZIO);
		validarEspaco(cargo, CARGO_MENSAGEM_ESPACO);
		validarTamanhoMinimo(cargo, CARGO_TAMANHO_MINIMO, CARGO_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(cargo, CARGO_TAMANHO_MAXIMO, CARGO_MENSAGEM_TAMANHO_MAXIMO);
		validarNumeros(cargo, CARGO_MENSAGEM_NUMEROS);
		validarCaractereEspecial(cargo, CARGO_MENSAGEM_CARACTERE_ESPECIAL);
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		validarNulo(setor, SETOR_MENSAGEM_NULO);
		validarVazio(setor, SETOR_MENSAGEM_VAZIO);
		validarEspaco(setor, SETOR_MENSAGEM_ESPACO);
		validarTamanhoMinimo(setor, SETOR_TAMANHO_MINIMO, SETOR_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(setor, SETOR_TAMANHO_MAXIMO, SETOR_MENSAGEM_TAMANHO_MAXIMO);
		validarNumeros(setor, SETOR_MENSAGEM_NUMEROS);
		validarCaractereEspecial(setor, SETOR_MENSAGEM_CARACTERE_ESPECIAL);
		this.setor = setor;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		validarNulo(dataNascimento, DATA_NASCIMENTO_MENSAGEM_NULO);
		validarDataNascimentoMinima(dataNascimento, DATA_NASCIMENTO_MINIMA_MENSAGEM);
		validarDataNascimentoMaxima(dataNascimento, DATA_NASCIMENTO_MAXIMA_MENSAGEM);
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		validarNulo(salario, SALARIO_MENSAGEM_NULO);
		validarSalarioMinimo(salario, SALARIO_MINIMO_MENSAGEM);
		validarSalarioMaximo(salario, SALARIO_MAXIMO_MENSAGEM);
		this.salario = salario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		validarNulo(ativo, ATIVO_FUNCIONARIO_MENSAGEM_NULO);
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Funcionario [matricula=")
		.append(matricula)
		.append(", cpf=")
		.append(cpf)
		.append(", nome=")
		.append(nome)
		.append(", cargo=")
		.append(cargo)
		.append(", setor=")
		.append(setor)
		.append(", dataNascimento=")
		.append(dataNascimento)
		.append(", salario=")
		.append(salario)
		.append(", ativo=")
		.append(ativo)
		.append("]")
		.append(super.toString())
		.toString();
	}
}
