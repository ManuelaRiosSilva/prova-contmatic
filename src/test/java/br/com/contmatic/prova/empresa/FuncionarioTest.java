package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.FuncionarioConstante.ATIVO_FUNCIONARIO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CARGO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.CPF_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.DATA_NASCIMENTO_MENSAGEM;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.DATA_NASCIMENTO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.MATRICULA_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.NOME_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SALARIO_MAXIMO_MENSAGEM;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SALARIO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SALARIO_MINIMO_MENSAGEM;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.FuncionarioConstante.SETOR_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.util.Violations.getErros;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Set;

import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class FuncionarioTest {
	
	private static Funcionario funcionario;
	
	@BeforeAll
	static void deve_exibir_antes_de_todos_os_testes() {
		 System.out.println("Executando os testes da classe Funcionário...");
	}
	
	@BeforeEach
    public void deve_criar_antes_de_cada_teste() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova.util");
        funcionario = Fixture.from(Funcionario.class).gimme("válido");
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
	@DisplayName("😀 Teste de Funcionário válido")
	void deve_aceitar_um_funcionario_valido(){
	    Set<String> erros = getErros(funcionario);
        assertThat(erros.size(), is(0));
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com menos de 5 caracteres")
	void nao_deve_aceitar_uma_matricula_com_menos_de_5_caracteres() {
	    funcionario.setMatricula("1234");
	    assertThat(getErros(funcionario), hasItem(MATRICULA_MENSAGEM_TAMANHO));
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com mais de 5 caracteres")
	void nao_deve_aceitar_uma_matricula_com_mais_de_5_caracteres() {
	    funcionario.setMatricula("123456");
	    assertThat(getErros(funcionario), hasItem(MATRICULA_MENSAGEM_TAMANHO));    
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula nula")
	void nao_deve_aceitar_uma_matricula_nula() {
		funcionario.setMatricula(null);
	      assertThat(getErros(funcionario), hasItem(MATRICULA_MENSAGEM_NULO));   
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula vazia")
	void nao_deve_aceitar_uma_matricula_vazia() {
		funcionario.setMatricula("");
	      assertThat(getErros(funcionario), hasItem(MATRICULA_MENSAGEM_VAZIO));   
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com espaço")
	void nao_deve_aceitar_uma_matricula_com_espaco() {
		funcionario.setMatricula("	");
	      assertThat(getErros(funcionario), hasItem(MATRICULA_MENSAGEM_ESPACO));   
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com letras")
	void nao_deve_aceitar_uma_matricula_com_letras() { 
		funcionario.setMatricula("1234A");
	      assertThat(getErros(funcionario), hasItem(MATRICULA_MENSAGEM_LETRAS));   
	}
	
	@Test
	@DisplayName("😢 Teste de Matrícula com caracteres especiais")
	void nao_deve_aceitar_uma_matricula_com_caracteres_especiais() { 
		funcionario.setMatricula("1234@");
	      assertThat(getErros(funcionario), hasItem(MATRICULA_MENSAGEM_CARACTERE_ESPECIAL));   
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com menos de 11 caracteres")
	void nao_deve_aceitar_um_cpf_com_menos_de_11_caracteres() {
	    funcionario.setCpf("495231978");
	    assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_TAMANHO));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com mais de 11 caracteres")
	void nao_deve_aceitar_um_cpf_com_mais_de_11_caracteres() {
		funcionario.setCpf("4952319784341");
		assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_TAMANHO));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com cálculo inválido")
	void nao_deve_aceitar_um_cpf_invalido() {
		funcionario.setCpf("11123197843");
		assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_INVALIDO));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF nulo")
	void nao_deve_aceitar_um_cpf_nulo() {
		funcionario.setCpf(null);
		assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_NULO));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF vazio")
	void nao_deve_aceitar_um_cpf_vazio() {
		funcionario.setCpf("");
		assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_VAZIO));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com espaço")
	void nao_deve_aceitar_um_cpf_com_espaco() {
		funcionario.setCpf("	");
		assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_ESPACO));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com letras")
	void nao_deve_aceitar_um_cpf_com_letras() {
		funcionario.setCpf("4952319784A");
		assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_LETRAS));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com caracteres especiais")
	void nao_deve_aceitar_um_cpf_com_caracteres_especiais() {
		funcionario.setCpf("4952319784!");
		assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_CARACTERE_ESPECIAL));
	}
	
	@Test
	@DisplayName("😢 Teste de CPF com números iguais")
	void nao_deve_aceitar_um_cpf_com_numeros_iguais() {
		funcionario.setCpf("11111111111");
		assertThat(getErros(funcionario), hasItem(CPF_MENSAGEM_INVALIDO));
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome com menos de 5 caracteres")
	void nao_deve_aceitar_um_nome_com_menos_de_5_caracteres() {
		funcionario.setNome("João");
		assertThat(getErros(funcionario), hasItem(NOME_MENSAGEM_TAMANHO));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com mais de 40 caracteres")
	void nao_deve_aceitar_um_nome_com_mais_de_40_caracteres() {
		funcionario.setNome("Leôncio Aurélio da Lambreta Perneta Costa");
		assertThat(getErros(funcionario), hasItem(NOME_MENSAGEM_TAMANHO));
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome nulo")
	void nao_deve_aceitar_um_nome_nulo() {
		funcionario.setNome(null);
		assertThat(getErros(funcionario), hasItem(NOME_MENSAGEM_NULO));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome vazio")
	void nao_deve_aceitar_um_nome_vazio() {
		funcionario.setNome("");
		assertThat(getErros(funcionario), hasItem(NOME_MENSAGEM_VAZIO));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com espaço")
	void nao_deve_aceitar_um_nome_com_espaco() {
		funcionario.setNome("	");
		assertThat(getErros(funcionario), hasItem(NOME_MENSAGEM_ESPACO));
	}
	
	@Test
	@DisplayName("😢 Teste de Nome com números")
	void nao_deve_aceitar_um_nome_com_numeros() {
		funcionario.setNome("M4nuela");
		assertThat(getErros(funcionario), hasItem(NOME_MENSAGEM_NUMEROS));
	}
	
	@Test 
	@DisplayName("😢 Teste de Nome com caracteres especiais")
	void nao_deve_aceitar_um_nome_com_caracteres_especiais() { 
		funcionario.setNome("M@nuela Alves Rios da Silva");
		assertThat(getErros(funcionario), hasItem(NOME_MENSAGEM_CARACTERE_ESPECIAL));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com menos de 5 caracteres")
	void nao_deve_aceitar_um_cargo_com_menos_de_5_caracteres() {
		funcionario.setCargo("Chef");
		assertThat(getErros(funcionario), hasItem(CARGO_MENSAGEM_TAMANHO));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com mais de 25 caracteres")
	void nao_deve_aceitar_um_cargo_com_mais_de_25_caracteres() {
		funcionario.setCargo("Funcionáriozinho Queridinho");
		assertThat(getErros(funcionario), hasItem(CARGO_MENSAGEM_TAMANHO));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo nulo")
	void nao_deve_aceitar_um_cargo_nulo() {
		funcionario.setCargo(null);
		assertThat(getErros(funcionario), hasItem(CARGO_MENSAGEM_NULO));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo vazio")
	void nao_deve_aceitar_um_cargo_vazio() {
		funcionario.setCargo("");
		assertThat(getErros(funcionario), hasItem(CARGO_MENSAGEM_VAZIO));;
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com espaço")
	void nao_deve_aceitar_um_cargo_com_espaco() {
		funcionario.setCargo("	");
		assertThat(getErros(funcionario), hasItem(CARGO_MENSAGEM_ESPACO));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com números")
	void nao_deve_aceitar_um_cargo_com_numeros() {
		funcionario.setCargo("Chef3");
		assertThat(getErros(funcionario), hasItem(CARGO_MENSAGEM_NUMEROS));
	}
	
	@Test
	@DisplayName("😢 Teste de Cargo com caracters especiais")
	void nao_deve_aceitar_um_cargo_com_caracteres_especiais() { 
		funcionario.setCargo("Chef&");
		assertThat(getErros(funcionario), hasItem(CARGO_MENSAGEM_CARACTERE_ESPECIAL));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com menos de 2 caracteres")
	void nao_deve_aceitar_um_setor_com_menos_de_2_caracteres() {
		funcionario.setSetor("R");
		assertThat(getErros(funcionario), hasItem(SETOR_MENSAGEM_TAMANHO));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com mais de 20 caracteres")
	void nao_deve_aceitar_um_setor_com_mais_de_20_caracteres() {
		funcionario.setSetor("Funcionáriozinho Fofo");
		assertThat(getErros(funcionario), hasItem(SETOR_MENSAGEM_TAMANHO));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor nulo")
	void nao_deve_aceitar_um_setor_nulo() {
		funcionario.setSetor(null);
		assertThat(getErros(funcionario), hasItem(SETOR_MENSAGEM_NULO));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor vazio")
	void nao_deve_aceitar_um_setor_vazio() {
		funcionario.setSetor("");
		assertThat(getErros(funcionario), hasItem(SETOR_MENSAGEM_VAZIO));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com espaço")
	void nao_deve_aceitar_um_setor_com_espaco() {
		funcionario.setSetor("	");
		assertThat(getErros(funcionario), hasItem(SETOR_MENSAGEM_ESPACO));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com números")
	void nao_deve_aceitar_um_setor_com_numeros() {
		funcionario.setSetor("Chef3");
		assertThat(getErros(funcionario), hasItem(SETOR_MENSAGEM_NUMEROS));
	}
	
	@Test
	@DisplayName("😢 Teste de Setor com caracteres especiais")
	void nao_deve_aceitar_um_setor_com_caracteres_especiais() { 
		funcionario.setSetor("Chef&");
		assertThat(getErros(funcionario), hasItem(SETOR_MENSAGEM_CARACTERE_ESPECIAL));
	}

	@Test
	@DisplayName("😢 Teste de Data de Nascimento nula")
	void nao_deve_aceitar_uma_data_de_nascimento_nula() {
		funcionario.setDataNascimento(null);
		assertThat(getErros(funcionario), hasItem(DATA_NASCIMENTO_MENSAGEM_NULO));
	}
	
	
	@Test
	@DisplayName("😢 Teste de Data de Nascimento mínima")
	void nao_deve_aceitar_um_funcionario_menor_de_idade() {
	    DateTime data = new DateTime(2005, 12, 25, 0, 0, 0, 0);
		funcionario.setDataNascimento(data);
		assertThat(getErros(funcionario), hasItem(DATA_NASCIMENTO_MENSAGEM));
	}
	
	@Test
	@DisplayName("😢 Teste de Data de Nascimento máxima")
	void nao_deve_aceitar_um_funcionario_com_mais_de_70_anos() {
	    DateTime data = new DateTime(1951, 12, 25, 0, 0, 0, 0);
	    funcionario.setDataNascimento(data);
	    assertThat(getErros(funcionario), hasItem(DATA_NASCIMENTO_MENSAGEM));
	}
	
	@Test
	@DisplayName("😢 Teste de Salário nulo")
	void nao_deve_aceitar_um_salario_nulo() {
		funcionario.setSalario(null);
		assertThat(getErros(funcionario), hasItem(SALARIO_MENSAGEM_NULO));
	}
	
	@Test
	@DisplayName("😢 Teste de Salário mínimo")
	void nao_deve_aceitar_um_salario_menor_que_o_minimo() {
		BigDecimal salario = new BigDecimal(1211);
		funcionario.setSalario(salario);
		assertThat(getErros(funcionario), hasItem(SALARIO_MINIMO_MENSAGEM));
	}
	
	@Test
	@DisplayName("😢 Teste de Salário máximo")
	void nao_deve_aceitar_um_salario_maior_que_o_maximo() {
		BigDecimal salario = new BigDecimal(15001);
		funcionario.setSalario(salario);
		assertThat(getErros(funcionario), hasItem(SALARIO_MAXIMO_MENSAGEM));
	}
	
	@Test
	@DisplayName("😢 Teste de Situação nula")
	void nao_deve_aceitar_um_ativo_nulo() {
		funcionario.setAtivo(null);
		assertThat(getErros(funcionario), hasItem(ATIVO_FUNCIONARIO_MENSAGEM_NULO));
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
		final DateTime dataNascimento =  new DateTime(2003, 7, 5, 0, 0, 0, 0);      
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


