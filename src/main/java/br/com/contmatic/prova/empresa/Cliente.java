package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_DA_CLASSE;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_TAMANHO_MINIMO;
import static br.com.contmatic.prova.util.validacao.CPFUtil.validacaoNulo;
import static br.com.contmatic.prova.util.validacao.CPFUtil.validacaoVazio;
import static br.com.contmatic.prova.util.validacao.CPFUtil.validar;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarCaractereEspecial;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarEmail;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarEspaco;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarLetras;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNulo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNumeros;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMaximo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMinimo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarVazio;

import java.util.Objects;

import br.com.contmatic.prova.auditoria.Auditoria;

public class Cliente extends Auditoria{

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
		validarCaractereEspecial(nome, NOME_MENSAGEM_CARACTERE_ESPECIAL);
		validarNumeros(nome, NOME_MENSAGEM_NUMEROS);
		this.nome = nome;		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		validarNulo(email, EMAIL_MENSAGEM_NULO);
		validarVazio(email, EMAIL_MENSAGEM_VAZIO);
		validarEspaco(email, EMAIL_MENSAGEM_ESPACO);
		validarEmail(email, EMAIL_MENSAGEM_INVALIDO);
		validarTamanhoMinimo(email, EMAIL_TAMANHO_MINIMO, EMAIL_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(email, EMAIL_TAMANHO_MAXIMO, EMAIL_MENSAGEM_TAMANHO_MAXIMO);
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
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
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Cliente [cpf=")
		.append(cpf)
		.append(", nome=")
		.append(nome)
		.append(", email=")
		.append(email)
		.append("]\n")
		.append(super.toString())
		.toString();
	}
}
