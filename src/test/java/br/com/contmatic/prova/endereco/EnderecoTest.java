package br.com.contmatic.prova.endereco;

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
public class EnderecoTest {
	
	private static Endereco endereco;
	
	@BeforeAll
	static void deve_exibir_antes_de_todos_os_testes() {
		System.out.println("Executando os testes da classe Endereço...");
	}
	
	@BeforeEach
	public void deve_criar_antes_de_todos_os_testes() {
		 endereco = new Endereco("07500000", "4321");
	}
	
	@AfterAll
	static void deve_exibir_depois_de_todos_os_testes() {
		System.out.println("Testes de Endereço executados com sucesso!\n");
	}
	
	@AfterEach
	public void deve_limpar_depois_de_todos_os_testes() {
		endereco = null;
	}
	
	@Test
	@DisplayName("😀 Teste de CEP válido")
	void deve_aceitar_um_cep_com_8_caracteres() {
		endereco.setCep("07500000");
		assertEquals("07500000", endereco.getCep());
	}
	
	@Test
	@DisplayName("😢 Teste de CEP com menos de 8 caracteres")
	void nao_deve_aceitar_um_cep_com_menos_de_8_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("0750000"), "Esperado lançar um IllegalArgumentException ao setar setCep(\"0750000\")");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço deve conter 8 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de CEP com mais de 8 caracteres")
	void nao_deve_aceitar_um_cep_com_mais_de_8_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("075000000"), "Esperado lançar um IllegalArgumentException ao setar setCep(\"075000000\")");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço deve conter 8 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de CEP nulo")
	void nao_deve_aceitar_um_cep_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep(null), "Esperado lançar um IllegalArgumentException ao setar setCep(null)");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de CEP vazio")
	void nao_deve_aceitar_um_cep_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep(""), "Esperado lançar um IllegalArgumentException ao setar setCep(\"\")");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de CEP com espaço")
	void nao_deve_aceitar_um_cep_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("	"), "Esperado lançar um IllegalArgumentException ao setar setCep(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de CEP com letras")
	void nao_deve_aceitar_um_cep_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("0750000O"), "Esperado lançar um IllegalArgumentException ao setar setCep(\"0750000O\")");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço deve possuir somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de CEP com caracteres especiais")
	void nao_deve_aceitar_um_cep_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCep("0750000!"), "Esperado lançar um IllegalArgumentException ao setar setCep(\"0750000!\")");
		assertTrue(thrown.getMessage().contains("O campo CEP do Endereço deve possuir somente números."));
	}
	
	@Test
	@DisplayName("😀 Teste de Número válido")
	void deve_aceitar_um_numero_de_1_a_4_caracteres() {
		endereco.setNumero("1234");
		assertEquals("1234", endereco.getNumero());
	}
	
	@Test
	@DisplayName("😢 Teste de Número com mais de 4 caracteres")
	void nao_deve_aceitar_um_numero_com_mais_de_4_caracteres() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("12345"), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"12345\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço deve possuir no máximo 4 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número nulo")
	void nao_deve_aceitar_um_numero_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero(null), "Esperado lançar um IllegalArgumentException ao setar setNumero(null)");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número vazio")
	void nao_deve_aceitar_um_numero_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero(""), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número com espaço")
	void nao_deve_aceitar_um_numero_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("	"), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Número com caractere especial")
	void nao_deve_aceitar_um_numero_com_caractere_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setNumero("12&4"), "Esperado lançar um IllegalArgumentException ao setar setNumero(\"12&4\"");
		assertTrue(thrown.getMessage().contains("O campo Número do Endereço deve conter somente números."));
	}
	
	@Test
	@DisplayName("😀 Teste de Logradouro válido")
	void deve_aceitar_um_logradouro_valido() {
		endereco.setLogradouro("Rua Benedito Alves Gonçalves");
		assertEquals("Rua Benedito Alves Gonçalves", endereco.getLogradouro());
	}
	
	@Test
	@DisplayName("😢 Teste de Logradouro com menos de 3 caracteres")
	void nao_deve_aceitar_um_logradouro_com_menos_de_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("Av"), "Esperado lançar um IllegalArgumentException ao setar setLogradouro(\"Av\")");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço deve possuir no mínimo 3 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Logradouro com mais de 60 caracteres")
	void nao_deve_aceitar_um_logradouro_com_mais_de_60_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("Travessa Pomposa das Flores Cheirosas e Carinhosas da Dona Rosa"), "Esperado lançar um IllegalArgumentException ao setar setLogradouro(\"Travessa Pomposa das Flores Cheirosas e Carinhosas da Dona Rosa\")");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço deve possuir no máximo 60 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Logradouro nulo")
	void nao_deve_aceitar_um_logradouro_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro(null), "Esperado lançar um IllegalArgumentException ao setar setLogradouro(null)");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Logradouro vazio")
	void nao_deve_aceitar_um_logradouro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro(""), "Esperado lançar um IllegalArgumentException ao setar setLogradouro(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Logradouro com espaço")
	void nao_deve_aceitar_um_logradouro_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("	"), "Esperado lançar um IllegalArgumentException ao setar setLogradouro(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço precisa ser válido."));
	}

	@Test
	@DisplayName("😢 Teste de Logradouro com caractere especial")
	void nao_deve_aceitar_um_logradouro_com_caractere_especial() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setLogradouro("Ru@ das Flores"), "Esperado lançar um IllegalArgumentException ao setar setLogradouro(\"Ru@ das Flores\")");
		assertTrue(thrown.getMessage().contains("O campo Logradouro do Endereço deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😀 Teste de Bairro válido")
	void deve_aceitar_um_bairro_valido() {
		endereco.setBairro("Jardim Eldorado");
		assertEquals("Jardim Eldorado", endereco.getBairro());
	}
	
	@Test
	@DisplayName("😢 Teste de Bairro com menos de 3 caracteres")
	void nao_deve_aceitar_um_bairro_com_menos_de_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro("Ja"), "Esperado lançar um IllegalArgumentException ao setar setBairro(\"Ja\")");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço deve possuir no mínimo 3 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Bairro com mais de 30 caracteres")
	void nao_deve_aceitar_um_bairro_com_mais_de_30_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro("Bairrozinho do Amiguinho Bobinho"), "Esperado lançar um IllegalArgumentException ao setar setBairro(\"Bairrozinho do Amiguinho Bobinho\")");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço deve possuir no máximo 30 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Bairro nulo")
	void nao_deve_aceitar_um_bairro_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro(null), "Esperado lançar um IllegalArgumentException ao setar setBairro(null)");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Bairro vazio")
	void nao_deve_aceitar_um_bairro_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro(""), "Esperado lançar um IllegalArgumentException ao setar setBairro(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Bairro com espaço")
	void nao_deve_aceitar_um_bairro_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro("	"), "Esperado lançar um IllegalArgumentException ao setar setBairro(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Bairro com caracteres especiais")
	void nao_deve_aceitar_um_bairro_com_caracteres_especiais() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setBairro("J@rdim Eldorado"), "Esperado lançar um IllegalArgumentException ao setar setBairro(\"J@rdim Eldorado\")");
		assertTrue(thrown.getMessage().contains("O campo Bairro do Endereço deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😀 Teste de Cidade válida")
	void deve_aceitar_uma_cidade_valida() {
		endereco.setCidade("Santa Isabel");
		assertEquals("Santa Isabel", endereco.getCidade());
	}
	
	@Test
	@DisplayName("😢 Teste de Cidade com menos de 3 caracteres")
	void nao_deve_aceitar_uma_cidade_com_menos_de_3_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("Sa"), "Esperado lançar um IllegalArgumentException ao setar setCidade(\"Sa\")");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço deve possuir no mínimo 3 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cidade com mais de 20 caracteres")
	void nao_deve_aceitar_uma_cidade_com_mais_de_20_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("Santinha Isabelzinha oba"), "Esperado lançar um IllegalArgumentException ao setar setCidade(\"Santinha Isabelzinha oba\")");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço deve possuir no máximo 20 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cidade nulo")
	void nao_deve_aceitar_uma_cidade_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade(null), "Esperado lançar um IllegalArgumentException ao setar setCidade(null)");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cidade vazio")
	void nao_deve_aceitar_uma_cidade_vazia() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade(""), "Esperado lançar um IllegalArgumentException ao setar setCidade(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cidade com espaço")
	void nao_deve_aceitar_uma_cidade_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("	"), "Esperado lançar um IllegalArgumentException ao setar setCidade(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cidade com números")
	void nao_deve_aceitar_uma_cidade_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("S4nta Isabel"), "Esperado lançar um IllegalArgumentException ao setar setCidade(\"S4nta Isabel\")");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cidade com caracteres especiais")
	void nao_deve_aceitar_uma_cidade_com_caracteres_especiais() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setCidade("S@nta Isabel"), "Esperado lançar um IllegalArgumentException ao setar setCidade(\"S@nta Isabel\")");
		assertTrue(thrown.getMessage().contains("O campo Cidade do Endereço deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😀 Teste de UF válida")
	void deve_aceitar_uma_uf_valida() { 
		endereco.setUf("SP");
		assertEquals("SP", endereco.getUf());
	}
	
	@Test
	@DisplayName("😢 Teste de UF com menos de 2 caracteres")
	void nao_deve_aceitar_uma_uf_com_menos_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("S"), "Esperado lançar um IllegalArgumentException ao setar setUf(\"S\")");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço deve conter 2 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de UF com mais de 2 caracteres")
	void nao_deve_aceitar_uma_uf_com_mais_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("SPP"), "Esperado lançar um IllegalArgumentException ao setar setUf(\"SPP\")");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço deve conter 2 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de UF nula")
	void nao_deve_aceitar_uma_uf_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf(null), "Esperado lançar um IllegalArgumentException ao setar setUf(null)");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de UF vazia")
	void nao_deve_aceitar_uma_vazia() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf(""), "Esperado lançar um IllegalArgumentException ao setar setUf(\"\")");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de UF com espaço")
	void nao_deve_aceitar_uma_uf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("	"), "Esperado lançar um IllegalArgumentException ao setar setUf(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de UF com números")
	void nao_deve_aceitar_uma_uf_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("5P"), "Esperado lançar um IllegalArgumentException ao setar setUf(\"5P\")");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço deve possuir somente letras."));
	}
	
	@Test
	@DisplayName("😢 Teste de UF com caracteres especiais")
	void nao_deve_aceitar_uma_uf_com_caractere_especial() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> endereco.setUf("$P"), "Esperado lançar um IllegalArgumentException ao setar setUf(\"$P\")");
		assertTrue(thrown.getMessage().contains("O campo UF do Endereço deve possuir somente letras."));
	}	
	
	@Test
	@DisplayName("😀 Teste de Objetos iguais")
	void deve_retornar_true_no_equals_quando_dois_objetos_forem_iguais() {
		final String cep = "07500000";
		final String numero = "1234";
		Endereco endereco1 = new Endereco(cep, numero);
		Endereco endereco2 = new Endereco(cep, numero);
		assertEquals(endereco1, endereco2);
	}
	
	@Test
	@DisplayName("😀 Teste de mesmo Objeto")
	void deve_retornar_true_no_equals_quando_for_o_mesmo_objeto() {
		final String cep = "07500000";
		final String numero = "1234";
		Endereco endereco1 = new Endereco(cep, numero);
		assertEquals(endereco1, endereco1);
	}

	static Stream<Arguments> cepNumeroProvider() {
        return Stream.of(
        		arguments("07500000", "1234"),
                arguments("07176600", "1204")
        );
    }
	
	@ParameterizedTest
	@DisplayName("😢 Teste de Objetos diferentes")
	@MethodSource("cepNumeroProvider")
	void deve_retornar_false_no_equals_quando_dois_objetos_forem_diferentes(String cep, String numero) {
		Endereco endereco1 = new Endereco("07500000", "1204");
		Endereco endereco2 = new Endereco(cep, numero);
		assertNotEquals(endereco1, endereco2);
	}
	
	@Test
	@DisplayName("😢 Teste de Classes diferentes")
	void deve_retornar_false_no_equals_quando_duas_classes_forem_diferentes() {
		final String cep = "07500000";
		final String numero = "1234";
		Endereco endereco1 = new Endereco(cep, numero);
		assertNotEquals(endereco1, new Object());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto nulo")
	void deve_retornar_true_no_equals_quando_o_objeto_for_nulo() {
		final String cep = "07500000";
		final String numero = "1234";
		Endereco endereco1 = new Endereco(cep, numero);
		Endereco endereco2 = null;
		assertNotEquals(endereco1, endereco2);
	}
	
	@Test
	@DisplayName("😀 Teste de Hashcodes iguais")
	void deve_retornar_true_quando_dois_hashcode_forem_iguais() {
		final String cep = "07500000";
		final String numero = "1234";
		Endereco endereco1 = new Endereco(cep, numero);
		Endereco endereco2 = new Endereco(cep, numero);
		assertEquals(endereco1.hashCode(), endereco2.hashCode());
	}
	
	@Test
	@DisplayName("😢 Teste de Hashcodes diferentes")
	void deve_retornar_false_quando_dois_hashcode_forem_diferentes() { 
		final String cep = "07500000";
		final String cep2 = "07176600";
		final String numero = "1234";
		Endereco endereco1 = new Endereco(cep, numero);
		Endereco endereco2 = new Endereco(cep2, numero);
		assertNotEquals(endereco1.hashCode(), endereco2.hashCode());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto igual ao toString")
	void deve_retornar_true_se_o_objeto_for_igual_ao_tostring() { 
		final String cep = "07500000";
		final String numero = "1234";
		final String logradouro = "Rua das Flores";
		final String bairro = "Jardim Eldorado";
		final String cidade = "Santa Isabel";
		final String uf = "SP";
		Endereco endereco1 = new Endereco(cep, numero);
		endereco1.setCep(cep);
		endereco1.setNumero(numero);
		endereco1.setLogradouro(logradouro);
		endereco1.setBairro(bairro);
		endereco1.setCidade(cidade);
		endereco1.setUf(uf);	
		assertTrue(endereco1.toString().contains(cep));
		assertTrue(endereco1.toString().contains(numero));
		assertTrue(endereco1.toString().contains(logradouro));
		assertTrue(endereco1.toString().contains(bairro));
		assertTrue(endereco1.toString().contains(cidade));
		assertTrue(endereco1.toString().contains(uf));
	}
}
