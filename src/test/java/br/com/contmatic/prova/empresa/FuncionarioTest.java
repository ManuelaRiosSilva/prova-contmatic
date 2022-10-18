package br.com.contmatic.prova.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FuncionarioTest {
	
	private static Funcionario funcionario;
	
	@BeforeAll
	static void deve_criar_antes_de_todos_os_testes() {
		 funcionario = new Funcionario("12345");
	}

	@Test
	void deve_aceitar_uma_matricula_com_5_caracteres() {
		funcionario.setMatricula("12345");
		assertEquals("12345", funcionario.getMatricula());
	}

	@Test
	void nao_deve_aceitar_uma_matricula_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("1234"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário deve conter 5 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_uma_matricula_com_mais_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("123456"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário deve conter 5 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_uma_matricula_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_uma_matricula_vazia() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_uma_matricula_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_uma_matricula_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("123A"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário só pode conter números."));
	}
	
	@Test
	void nao_deve_aceitar_uma_matricula_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("123@"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário só pode conter números."));
	}
	
	@Test
	void deve_aceitar_um_cpf_com_11_caracteres() {
		funcionario.setCpf("13508322009");
		assertEquals("13508322009", funcionario.getCpf());
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_menos_de_11_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("495231978"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário deve conter 11 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_mais_de_11_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("4952319784341"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário deve conter 11 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("11123197843"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário está inválido."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("4952319784A"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário só pode conter números."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("4952319784!"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário só pode conter números."));
	}
	
	@Test
	void nao_deve_aceitar_um_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("11111111111"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário não pode ter todos os números iguais."));
	}
	
	@Test
	void deve_aceitar_um_nome_valido() {
		funcionario.setNome("Manuela Alves Rios da Silva");
		assertEquals("Manuela Alves Rios da Silva", funcionario.getNome());
	}
	
	@Test 
	void nao_deve_aceitar_um_nome_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("João"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário deve conter de 5 a 40 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_nome_com_mais_de_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("Leôncio Aurélio da Lambreta Perneta Costa"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário deve conter de 5 a 40 caracteres."));
	}
	
	@Test 
	void nao_deve_aceitar_um_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_nome_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_nome_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário só pode conter letras."));
	}
	
	@Test 
	void nao_deve_aceitar_um_nome_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("M@nu31@ @1v35 R105 d@ 5i1v@"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário só pode conter letras."));
	}
	
	void deve_aceitar_um_cargo_valido() {
		funcionario.setCargo("Estagiário");
		assertEquals("Estagiário", funcionario.getCargo());
	}
	
	@Test
	void nao_deve_aceitar_um_cargo_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("Chef"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve conter de 5 a 15."));
	}
	
	@Test
	void nao_deve_aceitar_um_cargo_com_mais_de_15_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("Funcionáriozinho"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve conter de 5 a 15."));
	}
	
	@Test
	void nao_deve_aceitar_um_cargo_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_cargo_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_cargo_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_cargo_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("Chef3"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve conter só letras."));
	}
	
	@Test
	void nao_deve_aceitar_um_cargo_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("Chef&"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve conter só letras."));
	}
	
	@Test
	void deve_aceitar_um_setor_valido() {
		funcionario.setSetor("Tecnologia");
		assertEquals("Tecnologia", funcionario.getSetor());
	}
	
	@Test
	void nao_deve_aceitar_um_setor_com_menos_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("R"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário deve conter de 2 a 20 caracteres."));
	}
	
	@Test
	void nao_deve_aceitar_um_setor_com_mais_de_20_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("Funcionáriozinho"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário deve conter de 5 a 15."));
	}
	
	@Test
	void nao_deve_aceitar_um_setor_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor(null), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário é obrigatório."));
	}
	
	@Test
	void nao_deve_aceitar_um_setor_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor(""), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário não pode estar vazio."));
	}
	
	@Test
	void nao_deve_aceitar_um_setor_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("	"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário precisa ser válido."));
	}
	
	@Test
	void nao_deve_aceitar_um_setor_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("Chef3"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário deve conter só letras."));
	}
	
	@Test
	void nao_deve_aceitar_um_setor_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("Chef&"), "Expected doThing() to throw, but it didn't");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve conter só letras."));
	}
}
