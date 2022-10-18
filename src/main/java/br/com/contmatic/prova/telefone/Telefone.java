package br.com.contmatic.prova.telefone;

import java.util.Objects;

import br.com.contmatic.prova.util.validacao.ValidacaoUtil;

public class Telefone {

	private String ddi;

	private String ddd;

	private String numero;

	public Telefone(String ddi, String ddd, String numero) {
		super();
		this.setDdi(ddi);
		this.setDdd(ddd);
		this.setNumero(numero);
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		ValidacaoUtil.validarNulo(ddi, "O campo DDI do Telefone é obrigatório.");
		ValidacaoUtil.validarVazio(ddi, "O campo DDI do Telefone não pode estar vazio.");
		ValidacaoUtil.validarEspaco(ddi, "O campo DDI do Telefone precisa ser válido.");
		if (ddi.length() == 2) {
			ValidacaoUtil.validarLetras(ddi, "O campo DDI do Telefone deve conter só números.");
			ValidacaoUtil.validarCaractereEspecial(ddi, "O campo DDI do Telefone deve conter só números.");
			this.ddi = ddi;
		} else {
			throw new IllegalArgumentException("O campo DDI do Telefone deve conter 2 caracteres.");
		}
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		ValidacaoUtil.validarNulo(ddd, "O campo DDD do Telefone é obrigatório.");
		ValidacaoUtil.validarVazio(ddd, "O campo DDD do Telefone não pode estar vazio.");
		ValidacaoUtil.validarEspaco(ddd, "O campo DDD do Telefone precisa ser válido.");
		if (ddd.length() == 2) {
			ValidacaoUtil.validarLetras(ddd, "O campo DDD do Telefone deve conter só números.");
			ValidacaoUtil.validarCaractereEspecial(ddd, "O campo DDD do Telefone deve conter só números.");
			this.ddd = ddd;
		} else {
			throw new IllegalArgumentException("O campo DDD do Telefone deve conter 2 caracteres.");
		}
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		ValidacaoUtil.validarNulo(numero, "O campo Número do Telefone é obrigatório.");
		ValidacaoUtil.validarVazio(numero, "O campo Número do Telefone não pode estar vazio.");
		ValidacaoUtil.validarEspaco(numero, "O campo Número do Telefone precisa ser válido.");
		if (numero.length() >= 8 && numero.length() <= 9) {
			ValidacaoUtil.validarLetras(numero, "O campo Número do Telefone deve conter só números.");
			ValidacaoUtil.validarCaractereEspecial(numero, "O campo Número do Telefone deve conter só números.");
			this.numero = numero;
		} else {
			throw new IllegalArgumentException("O campo Número do Telefone deve conter de 8 a 9 caracteres.");
		}
	}
	
	@Override
	public String toString() {
		return "Telefone [ddi=" + ddi + ", ddd=" + ddd + ", numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, ddi, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(ddi, other.ddi) && Objects.equals(numero, other.numero);
	}
	
}
