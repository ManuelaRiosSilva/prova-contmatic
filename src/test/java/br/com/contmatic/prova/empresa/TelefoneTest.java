package br.com.contmatic.prova.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.contmatic.prova.telefone.Telefone;

class TelefoneTest {
	
	private static Telefone telefone;
	
	@BeforeAll
	static void deve_criar_antes_de_todos_os_testes() {
		 telefone = new Telefone("55","11","930468142");
	}

	@Test
	void deve_aceitar_um_ddi_com_2_caracteres() {
		telefone.setDdi("55");
		assertEquals("55", telefone.getDdi());
	}
	
	@Test
	void nao_deve_aceitar_um_ddi_com_menos_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() ->telefone.setDdi("1"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve conter 2 caracteres."));
	}
	
	
	@Test
	void nao_deve_aceitar_um_ddi_com_mais_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("123"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve conter 2 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddi_diferente_de_55() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("56"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve ser do Brasil."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddi_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddi_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddi_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddi_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("SS"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve conter só números."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddi_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi ("5&"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve conter só números."));
	}
	
	@Test
	void deve_aceitar_um_ddd_com_2_caracteres() {
		telefone.setDdd("11");
		assertEquals("11", telefone.getDdd());
	}
	
	void nao_deve_aceitar_um_ddd_com_menos_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd("2"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve conter 2 caracteres."));
	}
	
	
	@Test
	void nao_deve_aceitar_um_ddd_com_mais_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd("100"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve conter 2 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddd_menor_que_11() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd("10"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve estar entre 11 e 99."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddd_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddd_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddd__com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddd_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() ->  telefone.setDdd("1A"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve conter só números."));
	}
	
	@Test
	void nao_deve_aceitar_um_ddd_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() ->  telefone.setDdd("1!"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve conter só números."));
	}
	
	@Test
	void deve_aceitar_um_telefone_valido() {
		 telefone.setNumero("930468142");
		assertEquals("930468142", telefone.getNumero());
	}
	
	@Test
	void nao_deve_aceitar_um_telefone_com_menos_de_8_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("9304681"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone deve conter de 8 a 9 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_telefone_com_mais_de_9_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("9304681420"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone deve conter de 8 a 9 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_telefone_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_telefone_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone não pode estar vazio."));
	}
	
	
	@Test
	void nao_deve_aceitar_um_telefone_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_telefone_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("930468A42"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone deve conter só números."));
	}
	
	void nao_deve_aceitar_um_telefone_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("930468@42"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone deve conter só números."));
	}
}
