package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.ATUALIZADO_POR_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADOR_POR_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.CRIADO_POR_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_ATUALIZACAO_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_ATUALIZACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_CRIACAO_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.DATA_CRIACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_ATUALIZACAO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.AuditoriaConstante.IP_CRIACAO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.EmpresaConstante.CNPJ_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.DATA_ABERTURA_MAXIMA_MENSAGEM;
import static br.com.contmatic.prova.constantes.EmpresaConstante.DATA_ABERTURA_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_ENDERECOS_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.LISTA_TELEFONES_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.NOME_FANTASIA_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EmpresaConstante.RAZAO_SOCIAL_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.util.Violations.getErros;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.joda.time.DateTime;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import br.com.contmatic.prova.constantes.EmpresaConstante;
import br.com.contmatic.prova.endereco.Endereco;
import br.com.contmatic.prova.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class EmpresaTest {

    private static Empresa empresa;

    @BeforeAll
    static void deve_exibir_antes_de_todos_os_testes() {
        System.out.println("Executando os testes da classe Empresa...");
    }

    @BeforeEach
    public void deve_criar_antes_de_cada_teste() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova.util");
        empresa = Fixture.from(Empresa.class).gimme("válido");
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
    @DisplayName("😀 Teste de empresa válida")
    void deve_aceitar_uma_empresa_valida() {
        Set<String> erros = getErros(empresa);
        System.out.println(erros);
        System.out.println(empresa);
        assertThat(erros.size(), is(0));
    }
    
    @Test
    @DisplayName("😀 Teste de Getter e Setter")
    void deve_receber_pelo_setter_e_resgatar_pelo_getter() {
        empresa.setCnpj("05823382000177");
        assertEquals("05823382000177", empresa.getCnpj());
    }

    @Test
    @DisplayName("😢 Teste de CNPJ com cálculo inválido")
    void nao_deve_aceitar_um_cnpj_invalido() {
        empresa.setCnpj("11113382000177");
        assertThat(getErros(empresa), hasItem(CNPJ_MENSAGEM_INVALIDO));
    }

    @Test
    @DisplayName("😢 Teste de CNPJ com menos de 14 dígitos")
    void nao_deve_aceitar_um_cnpj_com_menos_de_14_caracteres() {
        empresa.setCnpj("9431860000014");
        assertThat(getErros(empresa), hasItem(CNPJ_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de CNPJ com mais de 14 dígitos")
    void nao_deve_aceitar_um_cnpj_com_mais_de_14_caracteres() {
        empresa.setCnpj("943186000000014");
        assertThat(getErros(empresa), hasItem(CNPJ_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de CNPJ com caracteres especiais")
    void nao_deve_aceitar_um_cnpj_com_caracteres_especiais() {
        empresa.setCnpj("9431860000014@");
        assertThat(getErros(empresa), hasItem(CNPJ_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😢 Teste de CNPJ com letras")
    void nao_deve_aceitar_um_cnpj_com_letras() {
        empresa.setCnpj("AAAAAAAAAAAAAA");
        assertThat(getErros(empresa), hasItem(CNPJ_MENSAGEM_LETRAS));
    }

    @Test
    @DisplayName("😢 Teste de CNPJ nulo")
    void nao_deve_aceitar_um_cnpj_nulo() {
        empresa.setCnpj(null);
        assertThat(getErros(empresa), Matchers.hasItem(EmpresaConstante.CNPJ_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de CNPJ vazio")
    void nao_deve_aceitar_um_cnpj_vazio() {
        empresa.setCnpj("");
        assertThat(getErros(empresa), hasItem(EmpresaConstante.CNPJ_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de CNPJ espaço")
    void nao_deve_aceitar_um_cnpj_com_espaco() {
        empresa.setCnpj("   ");
        assertThat(getErros(empresa), hasItem(CNPJ_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de CNPJ com números iguais")
    void nao_deve_aceitar_um_cnpj_com_numeros_iguais() {
        empresa.setCnpj("1111111111111 ");
        assertThat(getErros(empresa), hasItem(EmpresaConstante.CNPJ_MENSAGEM_INVALIDO));
    }

    @Test
    @DisplayName("😢 Teste de Nome Fantasia com menos de 5 caracteres")
    void nao_deve_aceitar_um_nome_fantasia_com_menos_de_5_caracteres() {
        empresa.setNomeFantasia("Renn");
        assertThat(getErros(empresa), hasItem(NOME_FANTASIA_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Nome Fantasia com mais de 35 caracteres")
    void nao_deve_aceitar_um_nome_fantasia_com_mais_de_35_caracteres() {
        empresa.setNomeFantasia("Loja super maneira e legal comprem aqui por favor tem desconto");
        assertThat(getErros(empresa), hasItem(NOME_FANTASIA_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Nome Fantasia nulo")
    void nao_deve_aceitar_um_nome_fantasia_nulo() {
        empresa.setNomeFantasia(null);
        assertThat(getErros(empresa), hasItem(NOME_FANTASIA_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Nome Fantasia vazio")
    void nao_deve_aceitar_um_nome_fantasia_vazio() {
        empresa.setNomeFantasia("");
        assertThat(getErros(empresa), hasItem(NOME_FANTASIA_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Nome Fantasia com espaço")
    void nao_deve_aceitar_um_nome_fantasia_com_espaco() {
        empresa.setNomeFantasia("  ");
        assertThat(getErros(empresa), hasItem(NOME_FANTASIA_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de Razão Social com menos de 5 caracteres")
    void nao_deve_aceitar_uma_razao_social_com_menos_de_5_caracteres() {
        empresa.setRazaoSocial("S.A");
        assertThat(getErros(empresa), hasItem(RAZAO_SOCIAL_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Razão Social com mais de 50 caracteres")
    void nao_deve_aceitar_uma_razao_social_com_mais_de_50_caracteres() {
        empresa.setRazaoSocial("Loja super maneira e legal comprem aqui por favor tem desconto");
        assertThat(getErros(empresa), hasItem(RAZAO_SOCIAL_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Razão Social nula")
    void nao_deve_aceitar_uma_razao_social_nula() {
        empresa.setRazaoSocial(null);
        assertThat(getErros(empresa), hasItem(RAZAO_SOCIAL_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Razão Social vazia")
    void nao_deve_aceitar_uma_razao_social_vazia() {
        empresa.setRazaoSocial("");
        assertThat(getErros(empresa), hasItem(RAZAO_SOCIAL_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Razão Social com espaço")
    void nao_deve_aceitar_uma_razao_social_com_espaco() {
        empresa.setRazaoSocial("   ");
        assertThat(getErros(empresa), hasItem(RAZAO_SOCIAL_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😀 Teste de Lista de Telefones válidos")
    void deve_aceitar_lista_com_telefones_validos() {
        Set<Telefone> telefones = new HashSet<Telefone>();
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
        empresa.setTelefones(null);
        assertThat(getErros(empresa), hasItem(LISTA_TELEFONES_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Lista de Telefones vazia")
    void nao_deve_aceitar_lista_de_telefones_vazia() {
        Set<Telefone> telefones = new HashSet<Telefone>();
        empresa.setTelefones(telefones);
        assertThat(getErros(empresa), hasItem(LISTA_TELEFONES_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Lista de Telefones com mais de 5 registros")
    void nao_deve_aceitar_lista_de_telefones_com_mais_de_5_registros() {
        Set<Telefone> telefones = new HashSet<Telefone>();
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
        empresa.setTelefones(telefones);
        assertThat(getErros(empresa), hasItem(LISTA_TELEFONES_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😀 Teste de Lista de Endereços válidos")
    void deve_aceitar_lista_com_enderecos_validos() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
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
        empresa.setEnderecos(null);
        assertThat(getErros(empresa), hasItem(LISTA_ENDERECOS_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Lista de Endereços vazia")
    void nao_deve_aceitar_lista_de_enderecos_vazia() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
        empresa.setEnderecos(enderecos);
        assertThat(getErros(empresa), hasItem(LISTA_ENDERECOS_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Lista de Endereços com mais de 5 registros")
    void nao_deve_aceitar_lista_de_enderecos_com_mais_de_5_registros() {
        Set<Endereco> enderecos = new HashSet<Endereco>();
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

        empresa.setEnderecos(enderecos);
        assertThat(getErros(empresa), hasItem(LISTA_ENDERECOS_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Data de Abertura nula")
    void nao_deve_aceitar_uma_data_de_abertura_nula() {
        empresa.setDataAbertura(null);
        assertThat(getErros(empresa), hasItem(DATA_ABERTURA_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Data de Abertura maior que a data atual")
    void nao_deve_aceitar_uma_data_de_abertura_maior_que_a_data_atual() {
        DateTime dataMaxima = new DateTime(2027, 12, 19, 15, 8, 0, 0);
        empresa.setDataAbertura(dataMaxima);
        assertThat(getErros(empresa), hasItem(DATA_ABERTURA_MAXIMA_MENSAGEM));
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
        final DateTime dataAbertura = new DateTime(2022, 12, 19, 15, 8, 0, 0);
        Empresa empresa1 = new Empresa(cnpj);
        empresa1.setNomeFantasia(nomeFantasia);
        empresa1.setRazaoSocial(razaoSocial);
        empresa1.setDataAbertura(dataAbertura);
        assertTrue(empresa1.toString().contains(cnpj));
        assertTrue(empresa1.toString().contains(nomeFantasia));
        assertTrue(empresa1.toString().contains(dataAbertura.toString()));
    }

    // AUDITORIA

    @Test
    @DisplayName("😢 Teste de Criado Por nulo")
    void nao_deve_aceitar_um_criador_nulo() {
        empresa.setCriadoPor(null);
        assertThat(getErros(empresa), hasItem(CRIADOR_POR_MENSAGEM_NULO));     
    }

    @Test
    @DisplayName("😢 Teste de Criado Por vazio")
    void nao_deve_aceitar_um_criador_vazio() {
        empresa.setCriadoPor("");
        assertThat(getErros(empresa), hasItem(CRIADO_POR_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Criado Por com espaço")
    void nao_deve_aceitar_um_criador_com_espaco() {
        empresa.setCriadoPor("	");
        assertThat(getErros(empresa), hasItem(CRIADO_POR_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de Criado Por com menos de 3 caracteres")
    void nao_deve_aceitar_um_criador_com_menos_de_3_caracteres() {
        empresa.setCriadoPor("Ma");
        assertThat(getErros(empresa), hasItem(CRIADO_POR_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Criado Por com mais de 40 caracteres")
    void nao_deve_aceitar_um_criador_com_mais_de_40_caracteres() {
        empresa.setCriadoPor("Manuela Manuela Manuela Manuela Manuela Manuela");
        assertThat(getErros(empresa), hasItem(CRIADO_POR_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Criado Por com números")
    void nao_deve_aceitar_um_criador_com_numeros() {
        empresa.setCriadoPor("M4nuela");
        assertThat(getErros(empresa), hasItem(CRIADO_POR_MENSAGEM_NUMEROS));
    }

    @Test
    @DisplayName("😢 Teste de Criado Por com caractere especial")
    void nao_deve_aceitar_um_criador_com_caractere_especial() {
        empresa.setCriadoPor("M@nuela");
        assertThat(getErros(empresa), hasItem(CRIADO_POR_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😢 Teste de Atualizado Por nulo")
    void nao_deve_aceitar_um_atualizador_nulo() {
        empresa.setAtualizadoPor(null);
        assertThat(getErros(empresa), hasItem(ATUALIZADO_POR_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Atualizado Por vazio")
    void nao_deve_aceitar_um_atualizador_vazio() {
        empresa.setAtualizadoPor("");
        assertThat(getErros(empresa), hasItem(ATUALIZADO_POR_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Atualizado Por com espaço")
    void nao_deve_aceitar_um_atualizador_com_espaco() {
        empresa.setAtualizadoPor("	");
        assertThat(getErros(empresa), hasItem(ATUALIZADO_POR_MENSAGEM_ESPACO));
    }

    @Disabled("Desabilitado por ser um teste duplicado")
    @Test
    @DisplayName("😢 Teste de Atualizado Por com espaço")
    void nao_deve_aceitar_um_atualizador_com_sem_nada() {
        empresa.setAtualizadoPor("	");
        assertThat(getErros(empresa), hasItem(ATUALIZADO_POR_MENSAGEM_ESPACO));
    }

    @Test
    @Timeout(3)
    @DisplayName("😢 Teste de Atualizado Por com menos de 3 caracteres")
    void nao_deve_aceitar_um_atualizador_com_menos_de_3_caracteres() throws InterruptedException {
        empresa.setAtualizadoPor("Ma");
        assertThat(getErros(empresa), hasItem(ATUALIZADO_POR_MENSAGEM_TAMANHO));
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    @DisplayName("😢 Teste de Atualizado Por com mais de 40 caracteres")
    void nao_deve_aceitar_um_atualizador_com_mais_de_40_caracteres() {
        empresa.setAtualizadoPor("Manuela Manuela Manuela Manuela Manuela Manuela");
        assertThat(getErros(empresa), hasItem(ATUALIZADO_POR_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Atualizado Por com números")
    void nao_deve_aceitar_um_atualizador_com_numeros() {
        empresa.setAtualizadoPor("M4nuela");
        assertThat(getErros(empresa), hasItem(ATUALIZADO_POR_MENSAGEM_NUMEROS));
    }

    @Test
    @DisplayName("😢 Teste de Atualizado Por com caractere especial")
    void nao_deve_aceitar_um_atualizador_com_caractere_especial() {
        empresa.setAtualizadoPor("M@nuela");
        assertThat(getErros(empresa), hasItem(ATUALIZADO_POR_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😢 Teste de Data de Criação nula")
    void nao_deve_aceitar_uma_data_de_criacao_nula() {
        empresa.setDataCriacao(null);
        assertThat(getErros(empresa), hasItem(DATA_CRIACAO_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Data de Criação maior que a data atual")
    void nao_deve_aceitar_uma_data_de_criacao_maior_que_a_data_atual() {
        DateTime dataMaxima = new DateTime(2023, 12, 19, 15, 8, 0, 0);
        empresa.setDataCriacao(dataMaxima);
        assertThat(getErros(empresa), hasItem(DATA_CRIACAO_MAXIMA_MENSAGEM));
    }

    @Test
    @DisplayName("😢 Teste de Data de Atualização nula")
    void nao_deve_aceitar_uma_data_de_atualizacao_nula() {
        empresa.setUltimaAtualizacao(null);
        assertThat(getErros(empresa), hasItem(DATA_ATUALIZACAO_MENSAGEM_NULO));
    }
 
    @Test
    @DisplayName("😢 Teste de Data de Atualização maior que a data atual")
    void nao_deve_aceitar_uma_data_de_atualizacao_depois_da_data_atual() {
        DateTime dataMaxima = new DateTime(2027, 12, 19, 15, 8, 0, 0);
        empresa.setUltimaAtualizacao(dataMaxima);
        assertThat(getErros(empresa), hasItem(DATA_ATUALIZACAO_MAXIMA_MENSAGEM));
    }

    @Test
    @DisplayName("😢 Teste de IP de Criação nulo")
    void nao_deve_aceitar_um_ip_de_criacao_nulo() {
        empresa.setIpCriacao(null);
        assertThat(getErros(empresa), hasItem(IP_CRIACAO_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Criação vazio")
    void nao_deve_aceitar_um_ip_de_criacao_vazio() {
        empresa.setIpCriacao("");
        assertThat(getErros(empresa), hasItem(IP_CRIACAO_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Criação com espaço")
    void nao_deve_aceitar_um_ip_de_criacao_com_espaco() {
        empresa.setIpCriacao("	");
        assertThat(getErros(empresa), hasItem(IP_CRIACAO_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Criação com menos de 7 caracteres")
    void nao_deve_aceitar_um_ip_de_criacao_com_menos_de_7_caracteres() {
        empresa.setIpCriacao("127.0.");
        assertThat(getErros(empresa), hasItem(IP_CRIACAO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Criação com mais de 14 caracteres")
    void nao_deve_aceitar_um_ip_de_criacao_com_mais_de_14_caracteres() {
        empresa.setIpCriacao("101.102.103.104");
        assertThat(getErros(empresa), hasItem(IP_CRIACAO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Criação inválido")
    void nao_deve_aceitar_um_ip_de_criacao_invalido() {
        empresa.setIpCriacao("127.0.00");
        assertThat(getErros(empresa), hasItem(IP_CRIACAO_MENSAGEM_INVALIDO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Atualização nulo")
    void nao_deve_aceitar_um_ip_de_atualizacao_nulo() {
        empresa.setIpUltimaAtualizacao(null);
        assertThat(getErros(empresa), hasItem(IP_ATUALIZACAO_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Atualização vazio")
    void nao_deve_aceitar_um_ip_de_atualizacao_vazio() {
        empresa.setIpUltimaAtualizacao("");
        assertThat(getErros(empresa), hasItem(IP_ATUALIZACAO_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Atualização com espaço")
    void nao_deve_aceitar_um_ip_de_atualizacao_com_espaco() {
        empresa.setIpUltimaAtualizacao("	");
        assertThat(getErros(empresa), hasItem(IP_ATUALIZACAO_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Atualização com menos de 7 caracteres")
    void nao_deve_aceitar_um_ip_de_atualizacao_com_menos_de_7_caracteres() {
        empresa.setIpUltimaAtualizacao("127.0.");
        assertThat(getErros(empresa), hasItem(IP_ATUALIZACAO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Atualização com mais de 14 caracteres")
    void nao_deve_aceitar_um_ip_de_atualizacao_com_mais_de_14_caracteres() {
        empresa.setIpUltimaAtualizacao("101.102.103.104");
        assertThat(getErros(empresa), hasItem(IP_ATUALIZACAO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de IP de Atualização inválido")
    void nao_deve_aceitar_um_ip_de_atualizacao_invalido() {
        empresa.setIpUltimaAtualizacao("127.0.00");
        assertThat(getErros(empresa), hasItem(IP_ATUALIZACAO_MENSAGEM_INVALIDO));
    }

    @Test
    @DisplayName("😀 Teste de Objeto igual ao toString - Auditoria")
    void deve_retornar_true_se_o_objeto_for_igual_ao_tostring_auditoria() {
        final String criadoPor = "Manu";
        final String atualizadoPor = "Leonardo";
        final DateTime dataCriacao = new DateTime(2022, 12, 19, 15, 8, 0, 0);
        final DateTime ultimaAtualizacao = new DateTime(2022, 12, 19, 15, 8, 0, 0);
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
