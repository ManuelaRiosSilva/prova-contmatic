package br.com.contmatic.prova.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	private static Cliente cliente;
	
	@BeforeAll
	static void deve_criar_antes_de_todos_os_testes() {
		 cliente = new Cliente("49523197843");
	}

	@Test
	void deve_aceitar_um_cpf_com_11_caracteres() {
		cliente.setCpf("49523197843");
		assertEquals("49523197843", cliente.getCpf());
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_menos_de_11_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("495231978"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente deve conter 11 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_mais_de_11_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("4952319784341"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente deve conter 11 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("11123197843"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente está inválido."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("4952319784A"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente só pode conter números."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("4952319784!"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente só pode conter números."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("11111111111"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente não pode ter todos os números iguais."));
	}
	
	@Test
	void deve_aceitar_um_nome_valido() {
		cliente.setNome("Manuela Rios");
		assertEquals("Manuela Rios", cliente.getNome());
	}
	
	@Test 
	void nao_deve_aceitar_um_nome_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente deve conter de 5 a 40 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_nome_com_mais_de_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("Leôncio Aurélio da Lambreta Perneta Costa"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente deve conter de 5 a 40 caracteres."));
	}
	
	@Test 
	void nao_deve_aceitar_um_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_nome_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_nome_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("M4nu314 R105"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente só pode conter letras."));
	}
	
	@Test 
	void nao_deve_aceitar_um_nome_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("M4nuel@ @lves Rios d@ Silv@"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente só pode conter letras."));
	}
	
	@Test 
	void deve_aceitar_um_email_valido() {
		cliente.setEmail("manuela.rios.silva@gmail.com");
		assertEquals("manuela.rios.silva@gmail.com", cliente.getEmail());
	}
	
	@Test 
	void nao_deve_aceitar_um_email_com_menos_de_18_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("eli.dia@gmail.com"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente deve conter de 18 a 40 caracteres."));	
	}
	
	@Test 
	void nao_deve_aceitar_um_email_com_mais_de_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("leoncio.aurelio.lambreta.perneta.costa@gmail.com"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente deve conter de 18 a 40 caracteres."));	
	}
	
	@Test 
	void nao_deve_aceitar_um_email_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente é obrigatório."));	
	}
	
	@Test 
	void nao_deve_aceitar_um_email_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente não pode estar vazio."));	
	}
	
	@Test
	void nao_deve_aceitar_um_email_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente precisa ser válido."));	
	}
}
