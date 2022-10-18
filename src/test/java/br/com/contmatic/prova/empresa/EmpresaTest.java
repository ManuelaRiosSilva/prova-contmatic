package br.com.contmatic.prova.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class EmpresaTest {

	private static Empresa empresa;

	@BeforeAll
	static void deve_criar_antes_de_todos_os_testes() {
		empresa = new Empresa("05823382000177");
	}

	@Test
	void deve_aceitar_um_cnpj_com_14_caracteres() {
		empresa.setCnpj("05823382000177");
		assertEquals("05823382000177", empresa.getCnpj());
	}

	@Test
	void nao_deve_aceitar_um_cnpj_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("11113382000177"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa está inválido."));
	}

	@Test
	void nao_deve_aceitar_um_cnpj_com_menos_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("9431860000014"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa deve conter 14 caracteres."));
	}

	@Test
	void nao_deve_aceitar_um_cnpj_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("943186000001461"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa deve conter 14 caracteres."));
	}

	@Test
	void nao_deve_aceitar_um_cnpj_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("9431860000014@"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa só pode conter números."));
	}

	@Test
	void nao_deve_aceitar_um_cnpj_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("A4318600000141"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa só pode conter números."));
	}

	@Test
	void nao_deve_aceitar_um_cnpj_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(null),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa é obrigatório."));
	}

	@Test
	void nao_deve_aceitar_um_cnpj_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(""),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa não pode estar vazio."));
	}

	@Test
	void nao_deve_aceitar_um_cnpj_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj("	"),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa precisa ser válido."));
	}

	@Test
	void nao_deve_aceitar_um_cnpj_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("11111111111111"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa não pode ter todos os números iguais."));
	}

	@Test
	void deve_aceitar_um_nome_valido() {
		empresa.setNomeFantasia("Renner");
		assertEquals("Renner", empresa.getNomeFantasia());
	}

	@Test
	void nao_deve_aceitar_um_nome_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setNomeFantasia("Renn"),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome da Empresa deve conter de 5 a 35 caracteres."));
	}

	@Test
	void nao_deve_aceitar_um_nome_com_mais_de_35_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia("Loja super maneira e legal comprem aqui por favor tem desconto"),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome da Empresa deve conter de 5 a 35 caracteres."));
	}

	@Test
	void nao_deve_aceitar_um_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setNomeFantasia(null),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome da Empresa é obrigatório."));
	}

	@Test
	void nao_deve_aceitar_um_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setNomeFantasia(""),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome da Empresa não pode estar vazio."));
	}

	@Test
	void nao_deve_aceitar_um_nome_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setNomeFantasia("	"),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome da Empresa precisa ser válido."));
	}

	@Test
	void nao_deve_aceitar_um_nome_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setNomeFantasia("R&nner"),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome da Empresa só pode conter letras."));
	}

	@Test
	void deve_aceitar_uma_razao_social_valida() {
		empresa.setRazaoSocial("Renner S.A");
		assertEquals("Renner S.A", empresa.getRazaoSocial());
	}

	@Test
	void nao_deve_aceitar_uma_razao_social_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial("S.A"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Razão Social da Empresa deve conter de 5 a 50 caracteres."));
	}

	@Test
	void nao_deve_aceitar_uma_razao_social_com_mais_de_50_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial("Loja super maneira e legal comprem aqui por favor tem desconto"),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Razão Social da Empresa deve conter de 5 a 50 caracteres."));
	}

	@Test
	void nao_deve_aceitar_uma_razao_social_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Razão Social da Empresa é obrigatório."));
	}

	@Test
	void nao_deve_aceitar_uma_razao_social_vazia() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setRazaoSocial(""),
				"Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Razão Social da Empresa não pode estar vazio."));
	}

	@Test
	void nao_deve_aceitar_uma_razao_social_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Razão Social da Empresa precisa ser válido."));
	}
}
