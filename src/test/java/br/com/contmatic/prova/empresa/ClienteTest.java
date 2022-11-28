package br.com.contmatic.prova.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ClienteTest {
	
	private static Cliente cliente;
	
	@BeforeAll
	static void deve_exibir_antes_de_todos_os_testes() {
		System.out.println("Executando os testes da classe Cliente...");
	 }
	
	@BeforeEach
	public void deve_criar_antes_de_cada_teste() {
		cliente = new Cliente("49523197843");
	}
	
	@AfterEach
	public void deve_limpar_depois_de_cada_teste() {
		cliente = null;		
	}
	
	@AfterAll
	static void deve_exibir_depois_de_todos_os_testes() {
		System.out.println("Testes de Cliente executados com sucesso!\n");
	}

	@Test
	@DisplayName("😀 Teste de CPF válido")
	void deve_aceitar_um_cpf_com_11_caracteres() {
		cliente.setCpf("49523197843");
		assertEquals("49523197843", cliente.getCpf());
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com menos de 11 dígitos")
	void nao_deve_aceitar_um_cpf_com_menos_de_11_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
	 			() -> cliente.setCpf("495231978"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"495231978\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente deve conter 11 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com mais de 11 dígitos")
	void nao_deve_aceitar_um_cpf_com_mais_de_11_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("4952319784341"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"4952319784341\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente deve conter 11 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com cálculo inválido")
	void nao_deve_aceitar_um_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("11123197843"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"11123197843\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente está inválido."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF nulo")
	void nao_deve_aceitar_um_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf(null), "Esperado lançar um IllegalArgumentException ao setar setCpf(null)");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF vazio")
	void nao_deve_aceitar_um_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf(""), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com espaço")
	void nao_deve_aceitar_um_cpf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("	"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com letras")
	void nao_deve_aceitar_um_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("4952319784A"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"4952319784A\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente deve conter somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com caracteres especiais")
	void nao_deve_aceitar_um_cpf_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("4952319784!"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"4952319784!\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente deve conter somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com números iguais")
	void nao_deve_aceitar_um_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setCpf("11111111111"), "Esperando lançar um IllegalArgumentException ao setar setCpf(\"11111111111\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Cliente não pode ter todos os números iguais."));
	}
	
	@Test
	@DisplayName("😀 Teste de Nome válido")
	void deve_aceitar_um_nome_valido() {
		cliente.setNome("João Amâncio");
		assertEquals("João Amâncio", cliente.getNome());
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome com menos de 5 caracteres")
	void nao_deve_aceitar_um_nome_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("João"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"João\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente deve possuir no mínimo 5 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com mais de 40 caracteres")
	void nao_deve_aceitar_um_nome_com_mais_de_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("Leôncio Aurélio da Lambreta Perneta Costa"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"Leôncio Aurélio da Lambreta Perneta Costa\") ");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente deve possuir no máximo 40 caracteres."));
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome nulo")
	void nao_deve_aceitar_um_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome(null), "Esperado lançar um IllegalArgumentException ao setar setNome(null)");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome vazio")
	void nao_deve_aceitar_um_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome(""), "Esperado lançar um IllegalArgumentException ao setar setNome(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com espaço")
	void nao_deve_aceitar_um_nome_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("	"), "Esperado lançar um IllegalArgumentException ao setar setNome(\" \")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com números")
	void nao_deve_aceitar_um_nome_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("M4nu314 R105"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"M4nu314 R105\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente deve conter somente letras."));
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome com caracteres especiais")
	void nao_deve_aceitar_um_nome_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setNome("M@nuela"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"M@nuela\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Cliente deve conter somente letras."));
	}
	
	@Test 
	@DisplayName("😀 Teste de E-mail válido")
	void deve_aceitar_um_email_valido() {
		cliente.setEmail("manuela.rios.silva@gmail.com");
		assertEquals("manuela.rios.silva@gmail.com", cliente.getEmail());
	}
	
	@Test 
	@DisplayName("😢 Teste de Email com menos de 18 caracteres")
	void nao_deve_aceitar_um_email_com_menos_de_18_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("eli.dia@gmail.com"), "Esperado lançar um IllegalArgumentException ao setar setEmail(\"eli.dia@gmail.com\")");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente deve possuir no mínimo 18 caracteres."));	
	}
	
	@Test 
	@DisplayName("😢 Teste de Email com mais de 40 caracteres")
	void nao_deve_aceitar_um_email_com_mais_de_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail("leoncio.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com"), "Esperado lançar um IllegalArgumentException ao setar setEmail(\"leoncio.aurelio.lambreta.perneta.costa@gmail.com\")");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente deve possuir no máximo 40 caracteres."));	
	}
	
	@Test 
	@DisplayName("😢 Teste de Email nulo")
	void nao_deve_aceitar_um_email_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail(null), "Esperado lançar um IllegalArgumentException ao setar setEmail(null)");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente é obrigatório."));	
	}
	
	@Test 
	@DisplayName("😢 Teste de Email vazio")
	void nao_deve_aceitar_um_email_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> cliente.setEmail(""), "Esperado lançar um IllegalArgumentException ao setar setEmail(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente não pode estar vazio."));	
	}
	
	@Test
	@DisplayName("😢 Teste de Email com espaço")
	void nao_deve_aceitar_um_email_com_espaco() {
	 	IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
	 			() -> cliente.setEmail("	"), "Esperado lançar um IllegalArgumentException ao setar setEmail(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente precisa ser válido."));	
	}
	
	@Test
	@DisplayName("😢 Teste de Email inválido")
	void nao_deve_aceitar_um_email_invalido(){
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
	 			() -> cliente.setEmail("manuelariosgmailcom"), "Esperado lançar um IllegalArgumentException ao setar setEmail(\"manuelariosgmailcom\")");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente está inválido."));	
	}
	
	@Test
	@DisplayName("😢 Teste de Email com dois @")
	void nao_deve_aceitar_um_email_com_dois_arrobas(){
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
	 			() -> cliente.setEmail("manuela.rios@@gmailcom"), "Esperado lançar um IllegalArgumentException ao setar setEmail(\"manuelariosgmailcom\")");
		assertTrue(thrown.getMessage().contains("O campo Email do Cliente está inválido."));	
	}
	
	@Test
	@DisplayName("😀 Teste de Objetos iguais")
	void deve_retornar_true_no_equals_quando_dois_objetos_forem_iguais() {
		Cliente cliente1 = new Cliente("49523197843");
		assertEquals(cliente1, cliente1);
	}

	@Test
	@DisplayName("😢 Teste de Objetos diferentes")
	void deve_retornar_false_no_equals_quando_dois_objetos_forem_diferentes() { 
		Cliente cliente1 = new Cliente("49523197843");
		Cliente cliente2 = new Cliente("87147963091");
		assertNotEquals(cliente1, cliente2);
	}
	
	@Test
	@DisplayName("😢 Teste de Classes diferentes")
	void deve_retornar_false_no_equals_quando_duas_classes_forem_diferentes() {
		Cliente cliente1 = new Cliente("49523197843");
		assertNotEquals(cliente1, new Object());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto nulo")
	void deve_retornar_true_no_equals_quando_o_objeto_for_nulo() {
		Cliente cliente1 = new Cliente("49523197843");
		Cliente cliente2 = null;
		assertNotEquals(cliente1, cliente2);
	}
	
	@Test
	@DisplayName("😀 Teste de Hashcodes iguais")
	void deve_retornar_true_quando_dois_hashcode_forem_iguais() {
		Cliente cliente1 = new Cliente("49523197843");
		Cliente cliente2 = new Cliente("49523197843");
		assertEquals(cliente1.hashCode(), cliente2.hashCode());
	}
	
	@Test
	@DisplayName("😢 Teste de Hashcodes diferentes")
	void deve_retornar_false_quando_dois_hashcode_forem_diferentes() { 
		Cliente cliente1 = new Cliente("49523197843");
		Cliente cliente2 = new Cliente("87147963091");
		assertNotEquals(cliente1.hashCode(), cliente2.hashCode());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto igual ao toString")
	void deve_retornar_true_se_o_objeto_for_igual_ao_tostring() { 
		final String cpf = "49523197843";
		final String nome = "José Silva";
		final String email = "jose.silva@gmail.com";
		Cliente cliente1 = new Cliente(cpf);
		cliente1.setCpf(cpf);
		cliente1.setNome(nome);
		cliente1.setEmail(email);
		assertTrue(cliente1.toString().contains(cpf));
		assertTrue(cliente1.toString().contains(nome));
		assertTrue(cliente1.toString().contains(email));
	}
}
