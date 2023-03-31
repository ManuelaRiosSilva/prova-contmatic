package br.com.contmatic.prova.empresa;

import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.CPF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_INVALIDO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.EMAIL_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.ClienteConstante.NOME_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.util.Violations.getErros;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

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
import nl.jqno.equalsverifier.EqualsVerifier;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ClienteTest {

    private static Cliente cliente;

    @BeforeAll
    static void deve_exibir_antes_de_todos_os_testes() {
        System.out.println("Executando os testes da classe Cliente...");
    }

    @BeforeEach
    public void deve_criar_antes_de_cada_teste() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova.util");
        cliente = Fixture.from(Cliente.class).gimme("válido");
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
    @DisplayName("😀 Teste de Cliente válido")
    void deve_aceitar_um_cliente_valido() {
        Set<String> erros = getErros(cliente);
        assertThat(erros.size(), is(0));
    }

    @Test
    @DisplayName("😀 Teste de Getter e Setter")
    void deve_receber_pelo_setter_e_resgatar_pelo_getter() {
        cliente.setCpf("49523197843");
        assertEquals("49523197843", cliente.getCpf());
    }
    
    @Test
    @DisplayName("😢 Teste de CPF com menos de 11 dígitos")
    void nao_deve_aceitar_um_cpf_com_menos_de_11_caracteres() {
        cliente.setCpf("495231978");
        assertThat(getErros(cliente), hasItem(CPF_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de CPF com mais de 11 dígitos")
    void nao_deve_aceitar_um_cpf_com_mais_de_11_caracteres() {
        cliente.setCpf("4952319784341");
        assertThat(getErros(cliente), hasItem(CPF_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de CPF com cálculo inválido")
    void nao_deve_aceitar_um_cpf_invalido() {
        cliente.setCpf("11123197843");
        assertThat(getErros(cliente), hasItem(CPF_MENSAGEM_INVALIDO));
    }

    @Test
    @DisplayName("😢 Teste de CPF nulo")
    void nao_deve_aceitar_um_cpf_nulo() {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            cliente.setCpf(null);
        });
        assertEquals("cpf is marked non-null but is null", thrown.getMessage());
    }

    @Test
    @DisplayName("😢 Teste de CPF vazio")
    void nao_deve_aceitar_um_cpf_vazio() {
        cliente.setCpf("");
        assertThat(getErros(cliente), hasItem(CPF_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de CPF com espaço")
    void nao_deve_aceitar_um_cpf_com_espaco() {
        cliente.setCpf("	");
        assertThat(getErros(cliente), hasItem(CPF_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de CPF com letras")
    void nao_deve_aceitar_um_cpf_com_letras() {
        cliente.setCpf("4952319784A");
        assertThat(getErros(cliente), hasItem(CPF_MENSAGEM_LETRAS));
    }

    @Test
    @DisplayName("😢 Teste de CPF com caracteres especiais")
    void nao_deve_aceitar_um_cpf_com_caracteres_especiais() {
        cliente.setCpf("4952319784!");
        assertThat(getErros(cliente), hasItem(CPF_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😢 Teste de CPF com números iguais")
    void nao_deve_aceitar_um_cpf_com_numeros_iguais() {
        cliente.setCpf("11111111111");
        assertThat(getErros(cliente), hasItem(CPF_MENSAGEM_INVALIDO));
    }

    @Test
    @DisplayName("😢 Teste de Nome com menos de 5 caracteres")
    void nao_deve_aceitar_um_nome_com_menos_de_5_caracteres() {
        cliente.setNome("João");
        assertThat(getErros(cliente), hasItem(NOME_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Nome com mais de 40 caracteres")
    void nao_deve_aceitar_um_nome_com_mais_de_40_caracteres() {
        cliente.setNome("Leôncio Aurélio da Lambreta Perneta Costa");
        assertThat(getErros(cliente), hasItem(NOME_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Nome nulo")
    void nao_deve_aceitar_um_nome_nulo() {
        cliente.setNome(null);
        assertThat(getErros(cliente), hasItem(NOME_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Nome vazio")
    void nao_deve_aceitar_um_nome_vazio() {
        cliente.setNome("");
        assertThat(getErros(cliente), hasItem(NOME_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Nome com espaço")
    void nao_deve_aceitar_um_nome_com_espaco() {
        cliente.setNome("	");
        assertThat(getErros(cliente), hasItem(NOME_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de Nome com números")
    void nao_deve_aceitar_um_nome_com_numeros() {
        cliente.setNome("M4nu314 R105");
        assertThat(getErros(cliente), hasItem(NOME_MENSAGEM_NUMEROS));
    }

    @Test
    @DisplayName("😢 Teste de Nome com caracteres especiais")
    void nao_deve_aceitar_um_nome_com_caracteres_especiais() {
        cliente.setNome("M@nuela");
        assertThat(getErros(cliente), hasItem(NOME_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😢 Teste de Email com menos de 18 caracteres")
    void nao_deve_aceitar_um_email_com_menos_de_18_caracteres() {
        cliente.setEmail("eli.dia@gmail.com");
        assertThat(getErros(cliente), hasItem(EMAIL_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Email com mais de 40 caracteres")
    void nao_deve_aceitar_um_email_com_mais_de_40_caracteres() {
        cliente.setEmail("leoncio.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com");
        assertThat(getErros(cliente), hasItem(EMAIL_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Email nulo")
    void nao_deve_aceitar_um_email_nulo() {
        cliente.setEmail(null);
        assertThat(getErros(cliente), hasItem(EMAIL_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Email vazio")
    void nao_deve_aceitar_um_email_vazio() {
        cliente.setEmail("");
        assertThat(getErros(cliente), hasItem(EMAIL_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Email com espaço")
    void nao_deve_aceitar_um_email_com_espaco() {
        cliente.setEmail("	");
        assertThat(getErros(cliente), hasItem(EMAIL_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de Email inválido")
    void nao_deve_aceitar_um_email_invalido() {
        cliente.setEmail("manuelariosgmailcom");
        assertThat(getErros(cliente), hasItem(EMAIL_MENSAGEM_INVALIDO));
    }

    @Test
    @DisplayName("😢 Teste de Email com dois @")
    void nao_deve_aceitar_um_email_com_dois_arrobas() {
        cliente.setEmail("manuela.rios@@gmailcom");
        assertThat(getErros(cliente), hasItem(EMAIL_MENSAGEM_INVALIDO));
    }

    @Test
    @DisplayName("😀 Teste de Equals")
    void deve_verificar_a_implementacao_do_equals_com_sucesso() {
        EqualsVerifier.simple().forClass(Cliente.class)
        .withOnlyTheseFields("cpf")
        .verify();
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
