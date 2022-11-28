package br.com.contmatic.prova.telefone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TelefoneTest {
	
	private static Telefone telefone;
	
	@BeforeAll
	static void deve_exibir_antes_de_todos_os_testes() {
		 System.out.println("Executando os testes da classe Telefone...");
	}
	
	@BeforeEach
	public void deve_criar_antes_de_todos_os_testes() {
		 telefone = new Telefone("55","11","930468142");
	}

	@AfterAll
	static void deve_exibir_depois_de_cada_teste() {
		System.out.println("Testes de Telefone executados com sucesso!\n");
	}
	
	@AfterEach
	public void deve_limpar_depois_de_cada_teste() {
		telefone = null;
	}
	
	@Test
	@DisplayName("😀 Teste de DDI válido")
	void deve_aceitar_um_ddi_com_2_caracteres() {
		telefone.setDdi("55");
		assertEquals("55", telefone.getDdi());
	}
	
	@Test
	@DisplayName("😢 Teste de DDI com menos de 2 dígitos")
	void nao_deve_aceitar_um_ddi_com_menos_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() ->telefone.setDdi("1"), "Esperado lançar um IllegalArgumentException ao setar setDdi(\"1\")");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve conter 2 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDI com mais de 2 dígitos")
	void nao_deve_aceitar_um_ddi_com_mais_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("123"), "Esperado lançar um IllegalArgumentException ao setar setDdi(\"123\")");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve conter 2 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDI fora do Brasil")
	void nao_deve_aceitar_um_ddi_diferente_de_55() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("56"), "Esperado lançar um IllegalArgumentException ao setar setDdi(\"56\")");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve ser do Brasil."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDI nulo")
	void nao_deve_aceitar_um_ddi_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi(null), "Esperado lançar um IllegalArgumentException ao setar setDdi(null)");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDI vazio")
	void nao_deve_aceitar_um_ddi_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi(""), "Esperado lançar um IllegalArgumentException ao setar setDdi(\"\")");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDI com espaço")
	void nao_deve_aceitar_um_ddi_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("	"), "Esperado lançar um IllegalArgumentException ao setar setDdi(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDI com letras")
	void nao_deve_aceitar_um_ddi_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi("SS"), "Esperado lançar um IllegalArgumentException ao setar setDdi(\"SS\")");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve possuir somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDI com caracteres especiais")
	void nao_deve_aceitar_um_ddi_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdi ("5&"), "Esperado lançar um IllegalArgumentException ao setar setDdi (\"5&\")");
		assertTrue(thrown.getMessage().contains("O campo DDI do Telefone deve possuir somente números."));
	}
	
	@Test
	@DisplayName("😀 Teste de DDD válido")
	void deve_aceitar_um_ddd_com_2_caracteres() {
		telefone.setDdd("11");
		assertEquals("11", telefone.getDdd());
	}
	
	@Test
	@DisplayName("😢 Teste de DDD com menos de 2 dígitos")
	void nao_deve_aceitar_um_ddd_com_menos_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd("2"), "Esperado lançar um IllegalArgumentException ao setar setDdd(\"2\")");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve conter 2 dígitos."));
	}
	
	
	@Test
	@DisplayName("😢 Teste de DDD com mais de 2 dígitos")
	void nao_deve_aceitar_um_ddd_com_mais_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd("100"), "Esperado lançar um IllegalArgumentException ao setar setDdd(\"100\")");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve conter 2 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDD terminado em 0")
	void nao_deve_aceitar_um_ddd_terminado_em_0() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd("10"), "Esperado lançar um IllegalArgumentException ao setar setDdd(\"10\")");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone não pode terminar em 0."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDD nulo")
	void nao_deve_aceitar_um_ddd_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd(null), "Esperado lançar um IllegalArgumentException ao setar setDdd(null)");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDD vazio")
	void nao_deve_aceitar_um_ddd_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd(""), "Esperado lançar um IllegalArgumentException ao setar setDdd(\"\")");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDD com espaço")
	void nao_deve_aceitar_um_ddd__com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setDdd("	"), "Esperado lançar um IllegalArgumentException ao setar setDdd(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDD com letras")
	void nao_deve_aceitar_um_ddd_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() ->  telefone.setDdd("1A"), "Esperado lançar um IllegalArgumentException ao setar setDdd(\"1A\")");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve possuir somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de DDD com caracteres especiais")
	void nao_deve_aceitar_um_ddd_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() ->  telefone.setDdd("1!"), "Esperado lançar um IllegalArgumentException ao setar setDdd(\"1!\")");
		assertTrue(thrown.getMessage().contains("O campo DDD do Telefone deve possuir somente números."));
	}
	
	@Test
	@DisplayName("😀 Teste de Número de Telefone válido")
	void deve_aceitar_um_telefone_valido() {
		 telefone.setNumero("930468142");
		assertEquals("930468142", telefone.getNumero());
	}
	
	@Test
	@DisplayName("😢 Teste de Número de Telefone com menos de 8 caracteres")
	void nao_deve_aceitar_um_telefone_com_menos_de_8_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("9304681"), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"9304681\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone deve conter no mínimo 8 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número de Telefone com mais de 9 caracteres")
	void nao_deve_aceitar_um_telefone_com_mais_de_9_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("9304681420"), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"9304681420\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone deve conter no máximo 9 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número de Telefone nulo")
	void nao_deve_aceitar_um_telefone_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero(null), "Esperado lançar um IllegalArgumentException ao setar setNumero(null)");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número de Telefone vazio")
	void nao_deve_aceitar_um_telefone_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero(""), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número de Telefone com espaço")
	void nao_deve_aceitar_um_telefone_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("	"), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número de Telefone com espaço")
	void nao_deve_aceitar_um_telefone_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("930468A42"), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"930468A42\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone deve possuir somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número de Telefone com com caracteres especiais")
	void nao_deve_aceitar_um_telefone_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> telefone.setNumero("930468@42"), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"930468@42\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Telefone deve possuir somente números."));
	}
	
	@Test
	@DisplayName("😀 Teste de Objetos iguais")
	void deve_retornar_true_no_equals_quando_dois_objetos_forem_iguais() {
		Telefone telefone1 = new Telefone("55", "11", "930468142");
		Telefone telefone2 = new Telefone("55", "11", "930468142");
		assertEquals(telefone1, telefone2);
	}
	
	@Test
	@DisplayName("😀 Teste de mesmo Objeto")
	void deve_retornar_true_no_equals_quando_for_o_mesmo_objeto() {
		Telefone telefone1 = new Telefone("55", "11", "930468142");
		assertEquals(telefone1, telefone1);
	}
	
	static Stream<Arguments> dddNumeroProvider() {
        return Stream.of(
        		arguments("15", "930468142"),
                arguments("11", "810468142")
        );
    }
	
	@ParameterizedTest
	@DisplayName("😢 Teste de Objetos diferentes")
	@MethodSource("dddNumeroProvider")
	void deve_retornar_false_no_equals_quando_dois_ddd_forem_diferentes(String ddd, String numero) {
		Telefone telefone1 = new Telefone("55", "11", "930468142");
		Telefone telefone2 = new Telefone("55", ddd, numero);
		assertNotEquals(telefone1, telefone2);
	}
	
	@Test
	@DisplayName("😢 Teste de Classes diferentes")
	void deve_retornar_false_no_equals_quando_duas_classes_forem_diferentes() {
		Telefone telefone1 = new Telefone("55", "11", "930468142");
		assertNotEquals(telefone1, new Object());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto nulo")
	void deve_retornar_true_no_equals_quando_o_objeto_for_nulo() {
		Telefone telefone1 = new Telefone("55", "11", "930468142");
		Telefone telefone2 = null;
		assertNotEquals(telefone1, telefone2);
	}
	
	@Test
	@DisplayName("😀 Teste de Hashcodes iguais")
	void deve_retornar_true_quando_dois_hashcode_forem_iguais() {
		Telefone telefone1 = new Telefone("55", "11", "930468142");
		Telefone telefone2 = new Telefone("55", "11", "930468142");
		assertEquals(telefone1.hashCode(), telefone2.hashCode());
	}
	
	@Test
	@DisplayName("😢 Teste de Hashcodes diferentes")
	void deve_retornar_false_quando_dois_hashcode_forem_diferentes() { 
		Telefone telefone1 = new Telefone("55", "11", "930468142");
		Telefone telefone2 = new Telefone("55", "12", "810468142");
		assertNotEquals(telefone1.hashCode(), telefone2.hashCode());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto igual ao toString")
	void deve_retornar_true_se_o_objeto_for_igual_ao_tostring() { 
		Telefone telefone1 = new Telefone("55", "11", "930468142");
		assertTrue(telefone1.toString().contains("55"));
		assertTrue(telefone1.toString().contains("11"));
		assertTrue(telefone1.toString().contains("930468142"));
	}
}
