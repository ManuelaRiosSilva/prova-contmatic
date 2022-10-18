package br.com.contmatic.prova.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.endereco.Endereco;

class EnderecoTest {
	
	private static Endereco endereco;
	
	@BeforeAll
	static void deve_criar_antes_de_todos_os_testes() {
		 endereco = new Endereco("07500000", "4321");
	}
	
	@Test
	void deve_aceitar_um_cep_com_8_caracteres() {
		endereco.setCep("07500000");
		assertEquals("07500000", endereco.getCep());
	}
	
	@Test
	void nao_deve_aceitar_um_cep_com_menos_de_8_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("0750000"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço deve conter 8 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_cep_com_mais_de_8_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("075000000"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço deve conter 8 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_cep_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_cep_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_cep_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_cep_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("0750000O"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço deve conter somente números."));
	}
	
	@Test
	void nao_deve_aceitar_um_cep_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("0750000!"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço deve conter somente números."));
	}
	
	@Test
	void deve_aceitar_um_numero_de_1_a_4_caracteres() {
		endereco.setNumero("1234");
		assertEquals("1234", endereco.getNumero());
	}
	
	@Test
	void nao_deve_aceitar_um_numero_com_mais_de_4_caracteres() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("12345"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço deve conter de 1 a 4 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_numero_menor_que_1() { //Arrumar
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("0"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereco não pode ser menor que 1."));
	}
	
	@Test
	void nao_deve_aceitar_um_numero_maior_que_4000() { //Arrumar
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("4001"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereco não pode ser maior que 4000."));
	}
	
	@Test
	void nao_deve_aceitar_um_numero_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_numero_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_numero_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_numero_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("iooe"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço só pode conter números."));
	}

	@Test
	void nao_deve_aceitar_um_numero_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("!oo&"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço só pode conter números."));
	}
	
	@Test
	void deve_aceitar_um_logradouro_valido() {
		endereco.setLogradouro("Rua Benedito Alves Gonçalves");
		assertEquals("Rua Benedito Alves Gonçalves", endereco.getLogradouro());
	}
	
	@Test
	void nao_deve_aceitar_um_logradouro_com_menos_de_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("Av"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço deve conter de 3 a 60 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_logradouro_com_mais_de_60_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("Travessa Pomposa das Flores Cheirosas e Carinhosas da Dona Rosa"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço deve conter de 3 a 60 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_logradouro_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_logradouro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_logradouro_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_logradouro_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("Rua L3gal"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço só pode conter letras."));
	}
	
	@Test
	void nao_deve_aceitar_um_logradouro_com_caractere_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("Ru@ Leg@l"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço só pode conter letras."));
	}
	
	@Test
	void deve_aceitar_um_bairro_valido() {
		endereco.setBairro("Jardim Eldorado");
		assertEquals("Jardim Eldorado", endereco.getBairro());
	}
	
	@Test
	void nao_deve_aceitar_um_bairro_com_menos_de_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro("Ja"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço deve conter de 3 a 30 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_bairro_com_menos_de_30_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro("Bairrozinho do Amiguinho Bobinho"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço deve conter de 3 a 30 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_bairro_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_bairro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_bairro_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_bairro_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro("J@rdim Eldorado"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço só pode conter letras."));
	}
	
	@Test
	void deve_aceitar_uma_cidade_valida() {
		endereco.setCidade("Santa Isabel");
		assertEquals("Santa Isabel", endereco.getCidade());
	}
	
	@Test
	void nao_deve_aceitar_uma_cidade_com_menos_de_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("Sa"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço deve conter de 3 a 20 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_uma_cidade_com_mais_de_20_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("Santinha Isabelzinha oba"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço deve conter de 3 a 20 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_uma_cidade_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_uma_cidade_vazia() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_uma_cidade_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_uma_cidade_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("S4nta Isabel"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço deve conter somente letras."));
	}
	
	@Test
	void nao_deve_aceitar_uma_cidade_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("S@nta Isabel"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço deve conter somente letras."));
	}
	
	@Test
	void deve_aceitar_uma_uf_valida() { // NÃO PEGA AS LETRAS MAIUSCULAS
		endereco.setUf("sp");
		assertEquals("sp", endereco.getUf());
	}
	
	@Test
	void nao_deve_aceitar_uma_uf_com_menos_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("S"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço deve conter 2 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_uma_uf_com_mais_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("SPP"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço deve conter 2 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_uma_uf_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_uma_vazia() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_uma_uf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_uma_uf_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("5P"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço deve conter somente letras."));
	}
	
	@Test
	void nao_deve_aceitar_uma_uf_com_caractere_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("$P"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço deve conter somente letras."));
	}	
}
