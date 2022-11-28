package br.com.contmatic.prova.empresa;

import static java.time.LocalDateTime.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import br.com.contmatic.prova.endereco.Endereco;
import br.com.contmatic.prova.telefone.Telefone;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class EmpresaTest {

	private static Empresa empresa;

	@BeforeAll
	static void deve_exibir_antes_de_todos_os_testes() {
		System.out.println("Executando os testes da classe Empresa...");
	}
	
	@BeforeEach
	public void deve_criar_antes_de_todos_os_testes() {
		empresa = new Empresa("05823382000177");
		empresa.setCriadoPor("Manu");
		empresa.setDataCriacao(LocalDateTime.of(2022, 11, 18, 11, 26));
		empresa.setIpCriacao("127.0.0.1");
	}
	
	@AfterAll
	static void deve_exibir_depois_de_todos_os_testes() {
		System.out.println("Testes de Empresa executados com sucesso!\n");
	}
	
	@AfterEach
	public void deve_limpar_depois_de_todos_os_testes() {
		empresa = null;
	}

	@Test
	@DisplayName("😀 Teste de CNPJ válido")
	void deve_aceitar_um_cnpj_com_14_caracteres() {
		empresa.setCnpj("05823382000177");
		assertEquals("05823382000177", empresa.getCnpj());
	}

	@Test
	@DisplayName("😢 Teste de CNPJ com cálculo inválido")
	void nao_deve_aceitar_um_cnpj_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("11113382000177"), "Esperado lançar um IllegalArgumentException ao setar setCnpj(\"11113382000177\")");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa está inválido."));
	}

	@Test
	@DisplayName("😢 Teste de CNPJ com menos de 14 dígitos")
	void nao_deve_aceitar_um_cnpj_com_menos_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("9431860000014"), "Esperado lançar um IllegalArgumentException ao setar setCnpj(\"9431860000014\"");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa deve conter 14 dígitos."));
	}

	@Test
	@DisplayName("😢 Teste de CNPJ com mais de 14 dígitos")
	void nao_deve_aceitar_um_cnpj_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("943186000001461"), "Esperado lançar um IllegalArgumentException ao setar setCnpj(\"943186000001461\")");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa deve conter 14 dígitos."));
	}

	@Test
	@DisplayName("😢 Teste de CNPJ com caracteres especiais")
	void nao_deve_aceitar_um_cnpj_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("9431860000014@"), "Esperado lançar um IllegalArgumentException ao setar setCnpj(\"9431860000014@\")");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa deve conter somente números."));
	}

	@Test
	@DisplayName("😢 Teste de CNPJ com letras")
	void nao_deve_aceitar_um_cnpj_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("A4318600000141"), "Esperado lançar um IllegalArgumentException ao setar setCnpj(\"A4318600000141\")");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa deve conter somente números."));
	}

	@Test
	@DisplayName("😢 Teste de CNPJ nulo")
	void nao_deve_aceitar_um_cnpj_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(null),
				"Esperado lançar um IllegalArgumentException ao setar setCnpj(null)");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa é obrigatório."));
	}

	@Test
	@DisplayName("😢 Teste de CNPJ vazio")
	void nao_deve_aceitar_um_cnpj_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj(""),
				"Esperado lançar um IllegalArgumentException ao setar setCnpj(\"\")");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa não pode estar vazio."));
	}

	@Test
	@DisplayName("😢 Teste de CNPJ espaço")
	void nao_deve_aceitar_um_cnpj_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setCnpj("	"),
				"Esperado lançar um IllegalArgumentException ao setar setCnpj(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa precisa ser válido."));
	}

	@Test
	@DisplayName("😢 Teste de CNPJ com números iguais")
	void nao_deve_aceitar_um_cnpj_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCnpj("11111111111111"), "Esperado lançar um IllegalArgumentException ao setar setCnpj(\"11111111111111\")");
		assertTrue(thrown.getMessage().contains("O campo CNPJ da Empresa não pode ter todos os números iguais."));
	}

	@Test
	@DisplayName("😀 Teste de Nome Fantasia válido")
	void deve_aceitar_um_nome_fantasia_valido() {
		empresa.setNomeFantasia("Renner");
		assertEquals("Renner", empresa.getNomeFantasia());
	}

	@Test
	@DisplayName("😢 Teste de Nome Fantasia com menos de 5 caracteres")
	void nao_deve_aceitar_um_nome_fantasia_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia("Renn"), "Esperado lançar um IllegalArgumentException ao setar setNomeFantasia(\"Renn\")");
		assertTrue(
				thrown.getMessage().contains("O campo Nome Fantasia da Empresa deve possuir no mínimo 5 caracteres."));
	}

	@Test
	@DisplayName("😢 Teste de Nome Fantasia com mais de 35 caracteres")
	void nao_deve_aceitar_um_nome_fantasia_com_mais_de_35_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia("Loja super maneira e legal comprem aqui por favor tem desconto"),
				"Esperado lançar um IllegalArgumentException ao setar setNomeFantasia(\"Loja super maneira e legal comprem aqui por favor tem desconto\")");
		assertTrue(
				thrown.getMessage().contains("O campo Nome Fantasia da Empresa deve possuir no máximo 35 caracteres."));
	}

	@Test
	@DisplayName("😢 Teste de Nome Fantasia nulo")
	void nao_deve_aceitar_um_nome_fantasia_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia(null), "Esperado lançar um IllegalArgumentException ao setar setNomeFantasia(null)");
		assertTrue(thrown.getMessage().contains("O campo Nome Fantasia da Empresa é obrigatório."));
	}

	@Test
	@DisplayName("😢 Teste de Nome Fantasia vazio")
	void nao_deve_aceitar_um_nome_fantasia_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia(""), "Esperado lançar um IllegalArgumentException ao setar setNomeFantasia(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Nome Fantasia da Empresa não pode estar vazio."));
	}

	@Test
	@DisplayName("😢 Teste de Nome Fantasia com espaço")
	void nao_deve_aceitar_um_nome_fantasia_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setNomeFantasia("	"), "Esperado lançar um IllegalArgumentException ao setar setNomeFantasia(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Nome Fantasia da Empresa precisa ser válido."));
	}

	@Test
	@DisplayName("😀 Teste de Razão Social válida")
	void deve_aceitar_uma_razao_social_valida() {
		empresa.setRazaoSocial("Renner S.A");
		assertEquals("Renner S.A", empresa.getRazaoSocial());
	}

	@Test
	@DisplayName("😢 Teste de Razão Social com menos de 5 caracteres")
	void nao_deve_aceitar_uma_razao_social_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial("S.A"), "Esperado lançar um IllegalArgumentException ao setar setRazaoSocial(\"S.A\")");
		assertTrue(
				thrown.getMessage().contains("O campo Razão Social da Empresa deve possuir no mínimo 5 caracteres."));
	}

	@Test
	@DisplayName("😢 Teste de Razão Social com mais de 50 caracteres")
	void nao_deve_aceitar_uma_razao_social_com_mais_de_50_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial("Loja super maneira e legal comprem aqui por favor tem desconto"),
				"Esperado lançar um IllegalArgumentException ao setar setRazaoSocial(\"Loja super maneira e legal comprem aqui por favor tem desconto\")");
		assertTrue(
				thrown.getMessage().contains("O campo Razão Social da Empresa deve possuir no máximo 50 caracteres."));
	}

	@Test
	@DisplayName("😢 Teste de Razão Social nula")
	void nao_deve_aceitar_uma_razao_social_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial(null), "Esperado lançar um IllegalArgumentException ao setar setRazaoSocial(null)");
		assertTrue(thrown.getMessage().contains("O campo Razão Social da Empresa é obrigatório."));
	}

	@Test
	@DisplayName("😢 Teste de Razão Social vazia")
	void nao_deve_aceitar_uma_razao_social_vazia() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setRazaoSocial(""),
				"Esperado lançar um IllegalArgumentException ao setar setRazaoSocial(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Razão Social da Empresa não pode estar vazio."));
	}

	@Test
	@DisplayName("😢 Teste de Razão Social com espaço")
	void nao_deve_aceitar_uma_razao_social_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setRazaoSocial("	"), "Esperado lançar um IllegalArgumentException ao setar setRazaoSocial(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Razão Social da Empresa precisa ser válido."));
	}

	@Test
	@DisplayName("😀 Teste de Lista de Telefones válidos")
	void deve_aceitar_lista_com_telefones_validos() {
		List<Telefone> telefones = new ArrayList<>();
		Telefone tel1 = new Telefone("55", "11", "930468142");
		telefones.add(tel1);
		Telefone tel2 = new Telefone("55", "15", "930128042");
		telefones.add(tel2);
		empresa.setTelefones(telefones);

		assertNotNull(empresa.getTelefones());
		assertEquals(2, empresa.getTelefones().size());
	}

	@Test
	@DisplayName("😢 Teste de Lista de Telefones nula")
	void nao_deve_aceitar_lista_de_telefones_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setTelefones(null),
				"Esperado lançar um IllegalArgumentException ao setar setTelefones(null)");
		assertTrue(thrown.getMessage().contains("O campo lista de Telefones deve conter pelo menos 1 registro."));
	}

	@Test
	@DisplayName("😢 Teste de Lista de Telefones vazia")
	void nao_deve_aceitar_lista_de_telefones_vazia() {
		List<Telefone> telefones = new ArrayList<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setTelefones(telefones), "Esperado lançar um IllegalArgumentException ao setar setTelefones(telefones)");
		assertTrue(thrown.getMessage().contains("O campo lista de Telefones deve conter pelo menos 1 registro."));
	}

	@Test
	@DisplayName("😢 Teste de Lista de Telefones com mais de 5 registros")
	void nao_deve_aceitar_lista_de_telefones_com_mais_de_5_registros() {
		List<Telefone> telefones = new ArrayList<>();
		Telefone tel1 = new Telefone("55", "11", "930128041");
		telefones.add(tel1);
		Telefone tel2 = new Telefone("55", "12", "930128042");
		telefones.add(tel2);
		Telefone tel3 = new Telefone("55", "13", "930128043");
		telefones.add(tel3);
		Telefone tel4 = new Telefone("55", "14", "930128044");
		telefones.add(tel4);
		Telefone tel5 = new Telefone("55", "15", "930128045");
		telefones.add(tel5);
		Telefone tel6 = new Telefone("55", "16", "930128046");
		telefones.add(tel6);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setTelefones(telefones), "Esperado lançar um IllegalArgumentException ao setar setTelefones(telefones)");
		assertTrue(thrown.getMessage().contains("O campo lista de Telefones não pode ter mais que 5 registros."));
	}

	@Test
	@DisplayName("😀 Teste de Lista de Endereços válidos")
	void deve_aceitar_lista_com_enderecos_validos() {
		List<Endereco> enderecos = new ArrayList<>();
		Endereco end1 = new Endereco("07500000", "4231");
		enderecos.add(end1);
		Endereco end2 = new Endereco("94859340", "1234");
		enderecos.add(end2);
		empresa.setEnderecos(enderecos);

		assertNotNull(empresa.getEnderecos());
		assertEquals(2, empresa.getEnderecos().size());
	}

	@Test
	@DisplayName("😢 Teste de Lista de Endereços nula")
	void nao_deve_aceitar_lista_de_enderecos_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setEnderecos(null),
				"Esperado lançar um IllegalArgumentException ao setar setEnderecos(null)");
		assertTrue(thrown.getMessage().contains("O campo lista de Endereços deve conter pelo menos 1 registro."));
	}

	@Test
	@DisplayName("😢 Teste de Lista de Endereços vazia")
	void nao_deve_aceitar_lista_de_enderecos_vazia() {
		List<Endereco> enderecos = new ArrayList<>();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setEnderecos(enderecos), "Esperado lançar um IllegalArgumentException ao setar setEnderecos(enderecos)");
		assertTrue(thrown.getMessage().contains("O campo lista de Endereços deve conter pelo menos 1 registro."));
	}

	@Test
	@DisplayName("😢 Teste de Lista de Endereços com mais de 5 registros")
	void nao_deve_aceitar_lista_de_enderecos_com_mais_de_5_registros() {
		List<Endereco> enderecos = new ArrayList<>();
		Endereco end1 = new Endereco("07176600", "5");
		enderecos.add(end1);
		Endereco end2 = new Endereco("69900000", "231");
		enderecos.add(end2);
		Endereco end3 = new Endereco("22753240", "1304");
		enderecos.add(end3);
		Endereco end4 = new Endereco("68900000", "25");
		enderecos.add(end4);
		Endereco end5 = new Endereco("15076610", "18");
		enderecos.add(end5);
		Endereco end6 = new Endereco("76995000", "952");
		enderecos.add(end6);

		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setEnderecos(enderecos), "Esperado lançar um IllegalArgumentException ao setar setEnderecos(enderecos)");
		assertTrue(thrown.getMessage().contains("O campo lista de Endereços não pode ter mais que 5 registros."));
	}
	
	@Test
	@DisplayName("😀 Teste de Data de Abertura válida")
	void deve_aceitar_uma_data_de_abertura_valida() {
		empresa.setDataAbertura(LocalDate.of(2022, 11, 20));
		assertEquals(LocalDate.of(2022, 11, 20), empresa.getDataAbertura());
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Abertura nula")
	void nao_deve_aceitar_uma_data_de_abertura_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setDataAbertura(null),
				"Esperado lançar um IllegalArgumentException ao setar setDataAbertura(null)");	
		assertTrue(thrown.getMessage().contains("O campo Data de Abertura da Empresa é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Abertura maior que a data atual")
	void nao_deve_aceitar_uma_data_de_abertura_maior_que_a_data_atual() {
		LocalDate dataMaxima = LocalDate.parse("2023-01-01");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setDataAbertura(dataMaxima),
				"Esperado lançar um IllegalArgumentException ao setar setDataAbertura(dataMaxima)");	
		assertTrue(thrown.getMessage().contains("A Data de Abertura da Empresa não pode ser maior que a data atual."));
	}
	
	@Test
	@DisplayName("😀 Teste de Objetos iguais")
	void deve_retornar_true_no_equals_quando_dois_objetos_forem_iguais() {
		Empresa empresa1 = new Empresa("05823382000177");
		assertEquals(empresa1, empresa1);
	}

	@Test
	@DisplayName("😢 Teste de Objetos diferentes")
	void deve_retornar_false_no_equals_quando_dois_objetos_forem_diferentes() { 
		Empresa empresa1 = new Empresa("05823382000177");
		Empresa empresa2 = new Empresa("58731662000111");
		assertNotEquals(empresa1, empresa2);
	}
	
	@Test
	@DisplayName("😢 Teste de Classes diferentes")
	void deve_retornar_false_no_equals_quando_duas_classes_forem_diferentes() {
		Empresa empresa1 = new Empresa("05823382000177");
		assertNotEquals(empresa1, new Object());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto nulo")
	void deve_retornar_true_no_equals_quando_o_objeto_for_nulo() {
		Empresa empresa1 = new Empresa("05823382000177");
		Empresa empresa2 = null;
		assertNotEquals(empresa1, empresa2);
	}
	
	@Test
	@DisplayName("😀 Teste de Hashcodes iguais")
	void deve_retornar_true_quando_dois_hashcode_forem_iguais() {
		Empresa empresa1 = new Empresa("05823382000177");
		Empresa empresa2 = new Empresa("05823382000177");
		assertEquals(empresa1.hashCode(), empresa2.hashCode());
	}
	
	@Test
	@DisplayName("😢 Teste de Hashcodes diferentes")
	void deve_retornar_false_quando_dois_hashcode_forem_diferentes() { 
		Empresa empresa1 = new Empresa("05823382000177");
		Empresa empresa2 = new Empresa("58731662000111");
		assertNotEquals(empresa1.hashCode(), empresa2.hashCode());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto igual ao toString")
	void deve_retornar_true_se_o_objeto_for_igual_ao_toString() { 
		final String cnpj = "05823382000177";
		final String nomeFantasia = "Renner";
		final String razaoSocial = "Renner S.A";
		final LocalDate dataAbertura = LocalDate.now();
		Empresa empresa1 = new Empresa(cnpj);
		empresa1.setNomeFantasia(nomeFantasia);
		empresa1.setRazaoSocial(razaoSocial);
		empresa1.setDataAbertura(dataAbertura);
		assertTrue(empresa1.toString().contains(cnpj));
		assertTrue(empresa1.toString().contains(nomeFantasia));
		assertTrue(empresa1.toString().contains(dataAbertura.toString()));
	}

	//AUDITORIA
	
	@Test
	@DisplayName("😀 Teste de Criado Por válido")
	void deve_aceitar_um_criado_por_valido() {
		empresa.setCriadoPor("Manu");
		assertEquals("Manu", empresa.getCriadoPor());
	}
	
	@Test
	@DisplayName("😢 Teste de Criado Por nulo")
	void nao_deve_aceitar_um_criador_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCriadoPor(null), "Esperado lançar um IllegalArgumentException ao setar setCriadoPor(null)");
		assertTrue(thrown.getMessage().contains("O campo Criado Por é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Criado Por vazio")
	void nao_deve_aceitar_um_criador_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCriadoPor(""), "Esperado lançar um IllegalArgumentException ao setar setCriadoPor(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Criado Por não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Criado Por com espaço")
	void nao_deve_aceitar_um_criador_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCriadoPor("	"), "Esperado lançar um IllegalArgumentException ao setar setCriadoPor(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Criado Por precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Criado Por com menos de 5 caracteres")
	void nao_deve_aceitar_um_criador_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCriadoPor("Ma"), "Esperado lançar um IllegalArgumentException ao setar setCriadoPor(\"Ma\")");
		assertTrue(thrown.getMessage().contains("O campo Criado Por deve possuir no mínimo 3 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Criado Por com mais de 40 caracteres")
	void nao_deve_aceitar_um_criador_com_mais_de_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCriadoPor("Manuela Manuela Manuela Manuela Manuela Manuela"), "Esperado lançar um IllegalArgumentException ao setar setCriadoPor(\"Manuela Manuela Manuela Manuela Manuela Manuela\")");
		assertTrue(thrown.getMessage().contains("O campo Criado Por deve possuir no máximo 40 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Criado Por com números")
	void nao_deve_aceitar_um_criador_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCriadoPor("M4nuela"), "Esperado lançar um IllegalArgumentException ao setar setCriadoPor(\"M4nuela\")");
		assertTrue(thrown.getMessage().contains("O campo Criado Por deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😢 Teste de Criado Por com caractere especial")
	void nao_deve_aceitar_um_criador_com_caractere_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setCriadoPor("M@nuela"), "Esperado lançar um IllegalArgumentException ao setar setCriadoPor(\"M@nuela\")");
		assertTrue(thrown.getMessage().contains("O campo Criado Por deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😀 Teste de Atualizado Por válido")
	void deve_aceitar_um_atualizado_por_valido() {
		empresa.setAtualizadoPor("Manu");
		assertEquals("Manu", empresa.getAtualizadoPor());
	}
	
	@Test
	@DisplayName("😢 Teste de Atualizado Por nulo")
	void nao_deve_aceitar_um_atualizador_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setAtualizadoPor(null), "Esperado lançar um IllegalArgumentException ao setar setAtualizadoPor(null)");
		assertTrue(thrown.getMessage().contains("O campo Atualizado Por deve ser preenchido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Atualizado Por vazio")
	void nao_deve_aceitar_um_atualizador_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setAtualizadoPor(""), "Esperado lançar um IllegalArgumentException ao setar setAtualizadoPor(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Atualizado Por não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Atualizado Por com espaço")
	void nao_deve_aceitar_um_atualizador_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setAtualizadoPor("	"), "Esperado lançar um IllegalArgumentException ao setar setAtualizadoPor(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Atualizado Por precisa ser válido."));
	}
	
	@Disabled("Desabilitado por ser um teste duplicado")
	@Test
	@DisplayName("😢 Teste de Atualizado Por com espaço")
	void nao_deve_aceitar_um_atualizador_com_sem_nada() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setAtualizadoPor("	"), "Esperado lançar um IllegalArgumentException ao setar setAtualizadoPor(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Atualizado Por precisa ser válido."));
	}
	
	@Test
	@Timeout(3)
	@DisplayName("😢 Teste de Atualizado Por com menos de 5 caracteres")
	void nao_deve_aceitar_um_atualizador_com_menos_de_5_caracteres() throws InterruptedException {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setAtualizadoPor("Ma"), "Esperado lançar um IllegalArgumentException ao setar setAtualizadoPor(\"Ma\")");
		assertTrue(thrown.getMessage().contains("O campo Atualizado Por deve possuir no mínimo 3 caracteres."));
		TimeUnit.SECONDS.sleep(1);
	}
	
	@Test
	@DisplayName("😢 Teste de Atualizado Por com mais de 40 caracteres")
	void nao_deve_aceitar_um_atualizador_com_mais_de_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setAtualizadoPor("Manuela Manuela Manuela Manuela Manuela Manuela"), "Esperado lançar um IllegalArgumentException ao setar setAtualizadoPor(\"Manuela Manuela Manuela Manuela Manuela Manuela\")");
		assertTrue(thrown.getMessage().contains("O campo Atualizado Por deve possuir no máximo 40 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Atualizado Por com números")
	void nao_deve_aceitar_um_atualizador_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setAtualizadoPor("M4nuela"), "Esperado lançar um IllegalArgumentException ao setar setAtualizadoPor(\"M4nuela\")");
		assertTrue(thrown.getMessage().contains("O campo Atualizado Por deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😢 Teste de Atualizado Por com caractere especial")
	void nao_deve_aceitar_um_atualizador_com_caractere_especial() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setAtualizadoPor("M@nuela"), "Esperado lançar um IllegalArgumentException ao setar setAtualizadoPor(\"M@nuela\")");
		assertTrue(thrown.getMessage().contains("O campo Atualizado Por deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😀 Teste de Data de Criação válida")
	void deve_aceitar_uma_data_de_criacao_valida() {
		LocalDateTime dataCriacao = of(2022, 11, 18, 11, 26);
		empresa.setDataCriacao(dataCriacao);
		assertEquals(dataCriacao, empresa.getDataCriacao()); 
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Criação nula")
	void nao_deve_aceitar_uma_data_de_criacao_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setDataCriacao(null), "Esperado lançar um IllegalArgumentException ao setar setDataCriacao(null)");
		assertTrue(thrown.getMessage().contains("O campo Data de Criação é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Criação maior que a data atual")
	void nao_deve_aceitar_uma_data_de_criacao_maior_que_a_data_atual() {
		LocalDateTime dataMaxima = LocalDateTime.parse("2023-01-01T00:01:00");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> empresa.setDataCriacao(dataMaxima),
				"Esperado lançar um IllegalArgumentException ao setar setDataCriacao(dataMaxima)");	
		assertTrue(thrown.getMessage().contains("O campo Data de Criação deve ser menor que a data atual."));
	}
	
	@Test
	@DisplayName("😀 Teste de Data de Atualização válida")
	void deve_aceitar_uma_data_de_atualizacao_valida() {
		empresa.setUltimaAtualizacao(of(2022, 11, 19, 15, 30));
		assertEquals(of(2022, 11, 19, 15, 30), empresa.getUltimaAtualizacao());
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Atualização nula")
	void nao_deve_aceitar_uma_data_de_atualizacao_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setUltimaAtualizacao(null), "Esperado lançar um IllegalArgumentException ao setar setUltimaAtualizacao(null)");
		assertTrue(thrown.getMessage().contains("O campo Data de Atualização deve ser preenchido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Atualização maior que a data atual")
	void nao_deve_aceitar_uma_data_de_atualizacao_depois_da_data_atual() {
		LocalDateTime dataAtt = LocalDateTime.parse("2023-01-01T00:01:00");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setUltimaAtualizacao(dataAtt), "Esperado lançar um IllegalArgumentException ao setar setUltimaAtualizacao(dataAtt)");
		assertTrue(thrown.getMessage().contains("O campo Data de Atualização deve ser menor que a data atual."));
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Atualização menor que a Data de Criação")
	void nao_deve_aceitar_uma_data_de_atualizacao_menor_que_a_data_de_criacao() {
		LocalDateTime dataAtt = LocalDateTime.parse("2021-01-01T00:01:00");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setUltimaAtualizacao(dataAtt), "Esperado lançar um IllegalArgumentException ao setar setUltimaAtualizacao(dataAtt)");
		assertTrue(thrown.getMessage().contains("O campo Data de Atualização deve ser maior que a data de criação."));
	}
	
	@Test
	@DisplayName("😀 Teste de IP de Criação válido")
	void deve_aceitar_um_ip_de_criacao_valido() {
		empresa.setIpCriacao("127.0.0.1");
		assertEquals("127.0.0.1", empresa.getIpCriacao());
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Criação nulo")
	void nao_deve_aceitar_um_ip_de_criacao_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpCriacao(null), "Esperado lançar um IllegalArgumentException ao setar setIpCriacao(null)");
		assertTrue(thrown.getMessage().contains("O campo IP da Criação é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Criação vazio")
	void nao_deve_aceitar_um_ip_de_criacao_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpCriacao(""), "Esperado lançar um IllegalArgumentException ao setar setIpCriacao(\"\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Criação não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Criação com espaço")
	void nao_deve_aceitar_um_ip_de_criacao_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpCriacao("	"), "Esperado lançar um IllegalArgumentException ao setar setIpCriacao(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Criação precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Criação com menos de 7 caracteres")
	void nao_deve_aceitar_um_ip_de_criacao_com_menos_de_7_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpCriacao("127.0."), "Esperado lançar um IllegalArgumentException ao setar setIpCriacao(\"127.0.\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Criação deve possuir no mínimo 7 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Criação com mais de 14 caracteres")
	void nao_deve_aceitar_um_ip_de_criacao_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpCriacao("101.102.103.104"), "Esperado lançar um IllegalArgumentException ao setar setIpCriacao(\"101.102.103.104\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Criação deve possuir no máximo 14 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Criação inválido")
	void nao_deve_aceitar_um_ip_de_criacao_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpCriacao("127.0.00"), "Esperado lançar um IllegalArgumentException ao setar setIpCriacao(\"127.0.00\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Criação está inválido."));
	}
	
	@Test
	@DisplayName("😀 Teste de IP de Atualização válido")
	void deve_aceitar_um_ip_de_atualizacao_valido() {
		empresa.setIpUltimaAtualizacao("127.0.0.1");
		assertEquals("127.0.0.1", empresa.getIpUltimaAtualizacao());
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Atualização nulo")
	void nao_deve_aceitar_um_ip_de_atualizacao_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpUltimaAtualizacao(null), "Esperado lançar um IllegalArgumentException ao setar setIpUltimaAtualizacao(null)");
		assertTrue(thrown.getMessage().contains("O campo IP da Atualização deve ser preenchido."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Atualização vazio")
	void nao_deve_aceitar_um_ip_de_atualizacao_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpUltimaAtualizacao(""), "Esperado lançar um IllegalArgumentException ao setar setIpUltimaAtualizacao(\"\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Atualização não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Atualização com espaço")
	void nao_deve_aceitar_um_ip_de_atualizacao_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpUltimaAtualizacao("	"), "Esperado lançar um IllegalArgumentException ao setar setIpUltimaAtualizacao(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Atualização precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Atualização com menos de 7 caracteres")
	void nao_deve_aceitar_um_ip_de_atualizacao_com_menos_de_7_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpUltimaAtualizacao("127.0."), "Esperado lançar um IllegalArgumentException ao setar setIpUltimaAtualizacao(\"127.0.\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Atualização deve possuir no mínimo 7 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Atualização com mais de 14 caracteres")
	void nao_deve_aceitar_um_ip_de_atualizacao_com_mais_de_14_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpUltimaAtualizacao("101.102.103.104"), "Esperado lançar um IllegalArgumentException ao setar setIpUltimaAtualizacao(\"101.102.103.104\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Atualização deve possuir no máximo 14 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de IP de Atualização inválido")
	void nao_deve_aceitar_um_ip_de_atualizacao_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> empresa.setIpUltimaAtualizacao("127.0.00"), "Esperado lançar um IllegalArgumentException ao setar setIpUltimaAtualizacaosetIpUltimaAtualizacao(\"127.0.00\")");
		assertTrue(thrown.getMessage().contains("O campo IP da Atualização está inválido."));
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto igual ao toString - Auditoria")
	void deve_retornar_true_se_o_objeto_for_igual_ao_tostring_auditoria() { 
		final String criadoPor = "Manu";
		final String atualizadoPor = "Leonardo";
		final LocalDateTime dataCriacao = LocalDateTime.now();
		final LocalDateTime ultimaAtualizacao = LocalDateTime.now();
		final String ipCriacao = "127.0.0.1";
		final String ipUltimaAtualizacao = "127.0.0.1";	
		Empresa empresa1 = new Empresa("05823382000177");
		empresa1.setCriadoPor(criadoPor);
		empresa1.setAtualizadoPor(atualizadoPor);
		empresa1.setDataCriacao(dataCriacao);
		empresa1.setUltimaAtualizacao(ultimaAtualizacao);
		empresa1.setIpCriacao(ipCriacao);
		empresa1.setIpUltimaAtualizacao(ipUltimaAtualizacao);		
		assertTrue(empresa1.toString().contains(criadoPor));
		assertTrue(empresa1.toString().contains(atualizadoPor));
		assertTrue(empresa1.toString().contains(dataCriacao.toString()));
		assertTrue(empresa1.toString().contains(ultimaAtualizacao.toString()));
		assertTrue(empresa1.toString().contains(ipCriacao));
		assertTrue(empresa1.toString().contains(ipUltimaAtualizacao));
	}
}
