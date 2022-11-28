package br.com.contmatic.prova.empresa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class FuncionarioTest {
	
	private static Funcionario funcionario;
	
	@BeforeAll
	static void deve_exibir_antes_de_todos_os_testes() {
		 System.out.println("Executando os testes da classe Funcionário...");
	}
	
	@BeforeEach
	public void deve_criar_antes_de_todos_os_testes() {
		 funcionario = new Funcionario("12345");
	} 

	@AfterAll
	static void deve_exibir_depois_de_todos_os_testes() {
		System.out.println("Testes de Funcionário executados com sucesso!\n");
	}
	
	@AfterEach
	public void deve_limpar_depois_de_cada_teste() {
		funcionario = null;
	}
	
	@Test
	@DisplayName("😀 Teste de Matrícula válida")
	void deve_aceitar_uma_matricula_com_5_caracteres() {
		funcionario.setMatricula("12345");
		assertEquals("12345", funcionario.getMatricula());
	}

	@Test
	@DisplayName("😢 Teste de Matrícula com menos de 5 caracteres")
	void nao_deve_aceitar_uma_matricula_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("1234"), "Esperado lançar um IllegalArgumentException ao setar setMatricula(\"1234\")");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário deve conter 5 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com mais de 5 caracteres")
	void nao_deve_aceitar_uma_matricula_com_mais_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("123456"), "Esperado lançar um IllegalArgumentException ao setar setMatricula(\"123456\")");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário deve conter 5 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula nula")
	void nao_deve_aceitar_uma_matricula_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula(null), "Esperado lançar um IllegalArgumentException ao setar setMatricula(null)");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula vazia")
	void nao_deve_aceitar_uma_matricula_vazia() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula(""), "Esperado lançar um IllegalArgumentException ao setar setMatricula(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com espaço")
	void nao_deve_aceitar_uma_matricula_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("	"), "Esperado lançar um IllegalArgumentException ao setar setMatricula(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com letras")
	void nao_deve_aceitar_uma_matricula_com_letras() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("1234A"), "Esperado lançar um IllegalArgumentException ao setar setMatricula(\"1234A\")");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário deve conter somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com caracteres especiais")
	void nao_deve_aceitar_uma_matricula_com_caracteres_especiais() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setMatricula("1234@"), "Esperado lançar um IllegalArgumentException ao setar setMatricula(\"1234@\")");
		assertTrue(thrown.getMessage().contains("O campo Matrícula do Funcionário deve conter somente números."));
	}
	
	@Test
	@DisplayName("😀 Teste de CPF válido")
	void deve_aceitar_um_cpf_com_11_caracteres() {
		funcionario.setCpf("49523197843");
		assertEquals("49523197843", funcionario.getCpf());
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com menos de 11 caracteres")
	void nao_deve_aceitar_um_cpf_com_menos_de_11_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("495231978"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"495231978\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário deve conter 11 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com mais de 11 caracteres")
	void nao_deve_aceitar_um_cpf_com_mais_de_11_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("4952319784341"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"4952319784341\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário deve conter 11 dígitos."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com cálculo inválido")
	void nao_deve_aceitar_um_cpf_invalido() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("11123197843"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"11123197843\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário está inválido."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF nulo")
	void nao_deve_aceitar_um_cpf_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf(null), "Esperado lançar um IllegalArgumentException ao setar setCpf(null)");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF vazio")
	void nao_deve_aceitar_um_cpf_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf(""), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com espaço")
	void nao_deve_aceitar_um_cpf_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("	"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com letras")
	void nao_deve_aceitar_um_cpf_com_letras() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("4952319784A"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"4952319784A\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário deve conter somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com caracteres especiais")
	void nao_deve_aceitar_um_cpf_com_caracteres_especiais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("4952319784!"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"4952319784!\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário deve conter somente números."));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com números iguais")
	void nao_deve_aceitar_um_cpf_com_numeros_iguais() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCpf("11111111111"), "Esperado lançar um IllegalArgumentException ao setar setCpf(\"11111111111\")");
		assertTrue(thrown.getMessage().contains("O campo CPF do Funcionário não pode ter todos os números iguais."));
	}
	
	@Test
	@DisplayName("😀 Teste de Nome válido")
	void deve_aceitar_um_nome_valido() {
		funcionario.setNome("Manuela Alves Rios da Silva");
		assertEquals("Manuela Alves Rios da Silva", funcionario.getNome());
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome com menos de 5 caracteres")
	void nao_deve_aceitar_um_nome_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("João"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"João\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário deve possuir no mínimo 5 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com mais de 40 caracteres")
	void nao_deve_aceitar_um_nome_com_mais_de_40_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("Leôncio Aurélio da Lambreta Perneta Costa"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"Leôncio Aurélio da Lambreta Perneta Costa\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário deve possuir no máximo 40 caracteres."));
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome nulo")
	void nao_deve_aceitar_um_nome_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome(null), "Esperado lançar um IllegalArgumentException ao setar setNome(null)");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome vazio")
	void nao_deve_aceitar_um_nome_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome(""), "Esperado lançar um IllegalArgumentException ao setar setNome(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com espaço")
	void nao_deve_aceitar_um_nome_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("	"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com números")
	void nao_deve_aceitar_um_nome_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("M4nuela"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"M4nuela\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário deve conter somente letras."));
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome com caracteres especiais")
	void nao_deve_aceitar_um_nome_com_caracteres_especiais() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setNome("M@nuela Alves Rios da Silva"), "Esperado lançar um IllegalArgumentException ao setar setNome(\"M@nuela Alves Rios da Silva\")");
		assertTrue(thrown.getMessage().contains("O campo Nome do Funcionário deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😀 Teste de Cargo válido")
	void deve_aceitar_um_cargo_valido() { 
		funcionario.setCargo("Estagiário");
		assertEquals("Estagiário", funcionario.getCargo());
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com menos de 5 caracteres")
	void nao_deve_aceitar_um_cargo_com_menos_de_5_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("Chef"), "Esperado lançar um IllegalArgumentException ao setar setCargo(\"Chef\")");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve possuir no mínimo 5 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com mais de 25 caracteres")
	void nao_deve_aceitar_um_cargo_com_mais_de_25_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("Funcionáriozinho Queridinho"), "Esperado lançar um IllegalArgumentException ao setar setCargo(\"Funcionáriozinho Queridinho\")");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve possuir no máximo 25 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo nulo")
	void nao_deve_aceitar_um_cargo_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo(null), "Esperado lançar um IllegalArgumentException ao setar setCargo(null)");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo vazio")
	void nao_deve_aceitar_um_cargo_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo(""), "Esperado lançar um IllegalArgumentException ao setar setCargo(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com espaço")
	void nao_deve_aceitar_um_cargo_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("	"), "Esperado lançar um IllegalArgumentException ao setar setCargo(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com números")
	void nao_deve_aceitar_um_cargo_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("Chef3"), "Esperado lançar um IllegalArgumentException ao setar setCargo(\"Chef3\")");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com caracters especiais")
	void nao_deve_aceitar_um_cargo_com_caracteres_especiais() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setCargo("Chef&"), "Esperado lançar um IllegalArgumentException ao setar setCargo(\"Chef&\")");
		assertTrue(thrown.getMessage().contains("O campo Cargo do Funcionário deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😀 Teste de Setor válido")
	void deve_aceitar_um_setor_valido() {
		funcionario.setSetor("Tecnologia");
		assertEquals("Tecnologia", funcionario.getSetor());
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com menos de 2 caracteres")
	void nao_deve_aceitar_um_setor_com_menos_de_2_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("R"), "Esperado lançar um IllegalArgumentException ao setar setSetor(\"R\")");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário deve possuir no mínimo 2 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com mais de 20 caracteres")
	void nao_deve_aceitar_um_setor_com_mais_de_20_caracteres() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("Funcionáriozinho Fofo"), "Esperado lançar um IllegalArgumentException ao setar setSetor(\"Funcionáriozinho Fofo\")");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário deve possuir no máximo 20 caracteres."));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor nulo")
	void nao_deve_aceitar_um_setor_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor(null), "Esperado lançar um IllegalArgumentException ao setar setSetor(null)");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor vazio")
	void nao_deve_aceitar_um_setor_vazio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor(""), "Esperado lançar um IllegalArgumentException ao setar setSetor(\"\")");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário não pode estar vazio."));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com espaço")
	void nao_deve_aceitar_um_setor_com_espaco() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("	"), "Esperado lançar um IllegalArgumentException ao setar setSetor(\"	\")");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário precisa ser válido."));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com números")
	void nao_deve_aceitar_um_setor_com_numeros() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("Chef3"), "Esperado lançar um IllegalArgumentException ao setar setSetor(\"Chef3\")");
 		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com caracteres especiais")
	void nao_deve_aceitar_um_setor_com_caracteres_especiais() { 
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSetor("Chef&"), "Esperado lançar um IllegalArgumentException ao setar setSetor(\"Chef&\"");
		assertTrue(thrown.getMessage().contains("O campo Setor do Funcionário deve conter somente letras."));
	}
	
	@Test
	@DisplayName("😀 Teste de Data de Nascimento válida")
	void deve_aceitar_uma_data_de_nascimento_valida() {
		funcionario.setDataNascimento(LocalDate.of(2003, 11, 16));
		assertEquals(LocalDate.of(2003, 11, 16), funcionario.getDataNascimento());
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Nascimento nula")
	void nao_deve_aceitar_uma_data_de_nascimento_nula() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setDataNascimento(null), "Esperado lançar um IllegalArgumentException ao setar setDataNascimento(null)");
		assertTrue(thrown.getMessage().contains("O campo Data de Nascimento do Funcionário é obrigatório."));
	}
	
	
	@Test
	@DisplayName("😢 Teste de Data de Nascimento mínima")
	void nao_deve_aceitar_um_funcionario_menor_de_idade() {
		LocalDate data = LocalDate.parse("2004-12-16");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setDataNascimento(data), "Esperado lançar um IllegalArgumentException ao setar setDataNascimento(data)");
		assertTrue(thrown.getMessage().contains("A idade mínima para ser um Funcionário é de 18 anos."));
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Nascimento máxima")
	void nao_deve_aceitar_um_funcionario_com_mais_de_70_anos() {
		LocalDate data = LocalDate.parse("1951-11-20");
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setDataNascimento(data), "Esperado lançar um IllegalArgumentException ao setar setDataNascimento(data)");
		assertTrue(thrown.getMessage().contains("A idade máxima para ser um Funcionário é de 70 anos."));
	}
	
	
	@Test
	@DisplayName("😀 Teste de Salário válido")
	void deve_aceitar_um_salario_valido() {
		BigDecimal salario = new BigDecimal(2500);
		funcionario.setSalario(salario);
		assertEquals(salario, funcionario.getSalario());
	}
	
	@Test
	@DisplayName("😢 Teste de Salário nulo")
	void nao_deve_aceitar_um_salario_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(null), "Esperado lançar um IllegalArgumentException ao setar setSalario(null)");
		assertTrue(thrown.getMessage().contains("O campo Salário do Funcionário é obrigatório."));
	}
	
	@Test
	@DisplayName("😢 Teste de Salário mínimo")
	void nao_deve_aceitar_um_salario_menor_que_o_minimo() {
		BigDecimal salario = new BigDecimal(1211);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(salario), "Esperado lançar um IllegalArgumentException ao setar setSalario(salario)");
		assertTrue(thrown.getMessage().contains("O valor do Salário do Funcionário não pode ser inferior a R$ 1.212."));
	}
	
	@Test
	@DisplayName("😢 Teste de Salário máximo")
	void nao_deve_aceitar_um_salario_maior_que_o_maximo() {
		BigDecimal salario = new BigDecimal(15001);
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setSalario(salario), "Esperado lançar um IllegalArgumentException ao setar setSalario(salario)");
		assertTrue(thrown.getMessage().contains("O valor do Salário do Funcionário não pode ser superior a R$ 15.000."));
	}
	
	@Test
	@DisplayName("😀 Teste de Situação do Funcionário válida")
	void deve_aceitar_um_ativo_valido() {
		funcionario.setAtivo(true);
		assertEquals(true, funcionario.getAtivo());
	}
	
	@Test
	@DisplayName("😢 Teste de Situação nula")
	void nao_deve_aceitar_um_ativo_nulo() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
				() -> funcionario.setAtivo(null), "Esperado lançar um IllegalArgumentException ao setar setAtivo(null)");
		assertTrue(thrown.getMessage().contains("O campo Ativo do Funcionário é obrigatório."));
	}
	
	@Test
	@DisplayName("😀 Teste de Objetos iguais")
	void deve_retornar_true_no_equals_quando_dois_objetos_forem_iguais() {
		Funcionario funcionario1 = new Funcionario("01234");
		assertEquals(funcionario1, funcionario1);
	}

	@Test
	@DisplayName("😢 Teste de Objetos diferentes")
	void deve_retornar_false_no_equals_quando_dois_objetos_forem_diferentes() { 
		Funcionario funcionario1 = new Funcionario("01234");
		Funcionario funcionario2 = new Funcionario("02345");
		assertNotEquals(funcionario1, funcionario2);
	}
	
	@Test
	@DisplayName("😢 Teste de Classes diferentes")
	void deve_retornar_false_no_equals_quando_duas_classes_forem_diferentes() {
		Funcionario funcionario1 = new Funcionario("01234");
		assertNotEquals(funcionario1, new Object());
	}
	
	@Test
	@DisplayName("😀 Teste de Objeto nulo")
	void deve_retornar_true_no_equals_quando_o_objeto_for_nulo() {
		Funcionario funcionario1 = new Funcionario("01234");
		Funcionario funcionario2 = null;
		assertNotEquals(funcionario1, funcionario2);
	}
	
	@Test
	@DisplayName("😀 Teste de Hashcodes iguais")
	void deve_retornar_true_quando_dois_hashcode_forem_iguais() {
		Funcionario funcionario1 = new Funcionario("01234");
		Funcionario funcionario2 = new Funcionario("01234");
		assertEquals(funcionario1.hashCode(), funcionario2.hashCode());
	}
	
	@Test
	@DisplayName("😢 Teste de Hashcodes diferentes")
	void deve_retornar_false_quando_dois_hashcode_forem_diferentes() { 
		Funcionario funcionario1 = new Funcionario("01234");
		Funcionario funcionario2 = new Funcionario("02345");
		assertNotEquals(funcionario1.hashCode(), funcionario2.hashCode());
	}
	
	@Test
	@DisplayName("😀 Teste de Objetos iguais ao toString")
	void deve_retornar_true_se_o_objeto_for_igual_ao_tostring() { 
		final String matricula = "01234";
		final String cpf = "49523197843";
		final String nome = "Manuela";
		final String cargo = "Estagiário";
		final String setor = "Tecnologia";
		final LocalDate dataNascimento = LocalDate.of(2003, 11, 16);
		final BigDecimal salario = new BigDecimal(2500);
		final Boolean ativo = true;
		Funcionario funcionario1 = new Funcionario(matricula);
		funcionario1.setMatricula(matricula);
		funcionario1.setCpf(cpf);
		funcionario1.setNome(nome);
		funcionario1.setCargo(cargo);
		funcionario1.setSetor(setor);
		funcionario1.setDataNascimento(dataNascimento);
		funcionario1.setSalario(salario);
		funcionario1.setAtivo(ativo);
		assertTrue(funcionario1.toString().contains(matricula));
		assertTrue(funcionario1.toString().contains(cpf));
		assertTrue(funcionario1.toString().contains(nome));
		assertTrue(funcionario1.toString().contains(cargo));
		assertTrue(funcionario1.toString().contains(setor));
		assertTrue(funcionario1.toString().contains(dataNascimento.toString()));
		assertTrue(funcionario1.toString().contains(salario.toString()));
		assertTrue(funcionario1.toString().contains(String.valueOf(ativo)));
	}
}


