package br.com.contmatic.empresa;

import java.util.Objects;

public class Telefone {
	
	
	private Integer ddd;
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(ddd);
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
		return Objects.equals(ddd, other.ddd);
	}




	private Integer ddi;
	
	public Integer getDdi() {
		return ddi;
	}
	public void setDdi(Integer ddi) {
		this.ddi = ddi;
	}
	
	
	
	private Integer numero;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}



















