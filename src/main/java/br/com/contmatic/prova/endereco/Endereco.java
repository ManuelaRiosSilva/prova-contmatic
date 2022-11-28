package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarCaractereEspecial;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarEspaco;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarLetras;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNulo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarNumeros;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarVazio;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoFixo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMinimo;
import static br.com.contmatic.prova.util.validacao.ValidacaoUtil.validarTamanhoMaximo;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_TAMANHO_MINIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_TAMANHO_MAXIMO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_TAMANHO_FIXO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_CARACTERE_ESPECIAL;
import java.util.Objects;

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
		validarNulo(cep, CEP_MENSAGEM_NULO);
		validarVazio(cep, CEP_MENSAGEM_VAZIO);
		validarEspaco(cep, CEP_MENSAGEM_ESPACO);
		validarTamanhoFixo(cep, CEP_TAMANHO_FIXO, CEP_MENSAGEM_TAMANHO);
		validarLetras(cep, CEP_MENSAGEM_LETRAS);
		validarCaractereEspecial(cep, CEP_MENSAGEM_CARACTERE_ESPECIAL);
		this.cep = cep;
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
		validarCaractereEspecial(numero, NUMERO_MENSAGEM_CARACTERE_ESPECIAL);
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		validarNulo(logradouro, LOGRADOURO_MENSAGEM_NULO);
		validarVazio(logradouro, LOGRADOURO_MENSAGEM_VAZIO);
		validarEspaco(logradouro, LOGRADOURO_MENSAGEM_ESPACO);
		validarTamanhoMinimo(logradouro, LOGRADOURO_TAMANHO_MINIMO, LOGRADOURO_MENSAGEM_TAMANHO_MINIMO);
		validarNumeros(logradouro, LOGRADOURO_MENSAGEM_NUMEROS);
		validarTamanhoMaximo(logradouro, LOGRADOURO_TAMANHO_MAXIMO, LOGRADOURO_MENSAGEM_TAMANHO_MAXIMO);
		validarCaractereEspecial(logradouro, LOGRADOURO_MENSAGEM_CARACTERE_ESPECIAL);
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		validarNulo(bairro, BAIRRO_MENSAGEM_NULO);
		validarVazio(bairro, BAIRRO_MENSAGEM_VAZIO);
		validarEspaco(bairro, BAIRRO_MENSAGEM_ESPACO);
		validarTamanhoMinimo(bairro, BAIRRO_TAMANHO_MINIMO, BAIRRO_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(bairro, BAIRRO_TAMANHO_MAXIMO, BAIRRO_MENSAGEM_TAMANHO_MAXIMO);
		validarNumeros(bairro, BAIRRO_MENSAGEM_NUMEROS);
		validarCaractereEspecial(bairro, BAIRRO_MENSAGEM_CARACTERE_ESPECIAL);
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		validarNulo(cidade, CIDADE_MENSAGEM_NULO);
		validarVazio(cidade, CIDADE_MENSAGEM_VAZIO);
		validarEspaco(cidade, CIDADE_MENSAGEM_ESPACO);
		validarTamanhoMinimo(cidade, CIDADE_TAMANHO_MINIMO, CIDADE_MENSAGEM_TAMANHO_MINIMO);
		validarTamanhoMaximo(cidade, CIDADE_TAMANHO_MAXIMO, CIDADE_MENSAGEM_TAMANHO_MAXIMO);
		validarCaractereEspecial(cidade, CIDADE_MENSAGEM_CARACTERE_ESPECIAL);
		validarNumeros(cidade, CIDADE_MENSAGEM_NUMEROS);
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		validarNulo(uf, UF_MENSAGEM_NULO);
		validarVazio(uf, UF_MENSAGEM_VAZIO);
		validarEspaco(uf, UF_MENSAGEM_ESPACO);
		validarTamanhoFixo(uf, UF_TAMANHO_FIXO, UF_MENSAGEM_TAMANHO);
		validarNumeros(uf, UF_MENSAGEM_NUMEROS);
		validarCaractereEspecial(uf, UF_MENSAGEM_CARACTERE_ESPECIAL);
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, numero);
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
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero); 
	}

	@Override
	public String toString() {
		return new StringBuilder()
		.append("Endereco [cep=")
		.append(cep)
		.append(", numero=")
		.append(numero)
		.append(", logradouro=")
		.append(logradouro)
		.append(", bairro=")
		.append(bairro)
		.append(", cidade=")
		.append(cidade)
		.append(", uf=")
		.append(uf)
		.append("]")
		.toString();
	}
}
