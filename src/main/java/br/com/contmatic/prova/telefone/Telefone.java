package br.com.contmatic.prova.telefone;

import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TERMINADO_EM_0;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VALOR_INVALIDO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.util.validacao.TelefoneUtil.validarDdi;
import static br.com.contmatic.prova.util.validacao.TelefoneUtil.validarFimDdd;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarCaractereEspecial;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarEspaco;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarLetras;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNulo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoFixo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMaximo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMinimo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarVazio;

import java.util.Objects;

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
		validarNulo(ddi, DDI_MENSAGEM_NULO);
		validarVazio(ddi, DDI_MENSAGEM_VAZIO);
		validarEspaco(ddi, DDI_MENSAGEM_ESPACO);
		validarTamanhoFixo(ddi, DDI_TAMANHO_FIXO, DDI_MENSAGEM_TAMANHO);
		validarLetras(ddi, DDI_MENSAGEM_LETRAS);
		validarCaractereEspecial(ddi, DDI_MENSAGEM_CARACTERE_ESPECIAL);
		validarDdi(ddi, DDI_MENSAGEM_VALOR_INVALIDO);
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		validarNulo(ddd, DDD_MENSAGEM_NULO);
		validarVazio(ddd, DDD_MENSAGEM_VAZIO);
		validarEspaco(ddd, DDD_MENSAGEM_ESPACO);
		validarTamanhoFixo(ddd, DDD_TAMANHO_FIXO, DDD_MENSAGEM_TAMANHO);
		validarFimDdd(ddd, DDD_MENSAGEM_TERMINADO_EM_0);
		validarLetras(ddd, DDD_MENSAGEM_LETRAS);
		validarCaractereEspecial(ddd, DDD_MENSAGEM_CARACTERE_ESPECIAL);
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		validarNulo(numero, NUMERO_MENSAGEM_NULO);
		validarVazio(numero, NUMERO_MENSAGEM_VAZIO);
		validarEspaco(numero, NUMERO_MENSAGEM_ESPACO);
		validarTamanhoMinimo(numero, NUMERO_TAMANHO_MINIMO, NUMERO_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(numero, NUMERO_TAMANHO_MAXIMO, NUMERO_MENSAGEM_TAMANHO_MAXIMO);
		validarLetras(numero, NUMERO_MENSAGEM_LETRAS);
		validarCaractereEspecial(numero, NUMERO_MENSAGEM_CARACTERE_ESPECIAL);

		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, numero);
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
		return Objects.equals(ddd, other.ddd) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Telefone [ddi=")
		.append(ddi)
		.append(", ddd=")
		.append(ddd)
		.append(", numero=")
		.append(numero)
		.append("]")
		.toString();
	}
}
