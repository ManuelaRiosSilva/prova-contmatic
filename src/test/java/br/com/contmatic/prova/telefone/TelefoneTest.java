package br.com.contmatic.prova.telefone;

import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_TERMINADO_EM_0;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDD_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VALOR_INVALIDO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.DDI_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_LETRAS;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.TelefoneConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.util.Violations.getErros;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Set;
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

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class TelefoneTest {

    private static Telefone telefone;
    TelefoneType telefoneEnum = TelefoneType.CELULAR;

    @BeforeAll
    static void deve_exibir_antes_de_todos_os_testes() {
        System.out.println("Executando os testes da classe Telefone...");
    }

    @BeforeEach
    public void deve_criar_antes_de_cada_teste() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova.util");
        telefone = Fixture.from(Telefone.class).gimme("válido");
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
    @DisplayName("😀 Teste de Telefone válido")
    void deve_aceitar_um_telefone_valido() {
        Set<String> erros = getErros(telefone);
        assertThat(erros.size(), is(0));
    }
    
    @Test
    @DisplayName("😀 Teste de setter e getter - DDI")
    void deve_inserir_ddi_pelo_setter_e_acessar_pelo_gette() {
        telefone.setDdi("55");
        assertEquals("55", telefone.getDdi());
    }

    @Test
    @DisplayName("😢 Teste de DDI com menos de 2 dígitos")
    void nao_deve_aceitar_um_ddi_com_menos_de_2_caracteres() {
        telefone.setDdi("1");
        assertThat(getErros(telefone), hasItem(DDI_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de DDI com mais de 2 dígitos")
    void nao_deve_aceitar_um_ddi_com_mais_de_2_caracteres() {
        telefone.setDdi("111");
        assertThat(getErros(telefone), hasItem(DDI_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de DDI fora do Brasil")
    void nao_deve_aceitar_um_ddi_diferente_de_55() {
        telefone.setDdi("56");
        assertThat(getErros(telefone), hasItem(DDI_MENSAGEM_VALOR_INVALIDO));
    }

    @Test
    @DisplayName("😢 Teste de DDI nulo")
    void nao_deve_aceitar_um_ddi_nulo() {
        telefone.setDdi(null);
        assertThat(getErros(telefone), hasItem(DDI_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de DDI vazio")
    void nao_deve_aceitar_um_ddi_vazio() {
        telefone.setDdi("");
        assertThat(getErros(telefone), hasItem(DDI_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de DDI com espaço")
    void nao_deve_aceitar_um_ddi_com_espaco() {
        telefone.setDdi("    ");
        assertThat(getErros(telefone), hasItem(DDI_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de DDI com letras")
    void nao_deve_aceitar_um_ddi_com_letras() {
        telefone.setDdi("SS");
        assertThat(getErros(telefone), hasItem(DDI_MENSAGEM_LETRAS));
    }

    @Test
    @DisplayName("😢 Teste de DDI com caracteres especiais")
    void nao_deve_aceitar_um_ddi_com_caracteres_especiais() {
        telefone.setDdi("5@");
        assertThat(getErros(telefone), hasItem(DDI_MENSAGEM_CARACTERE_ESPECIAL));
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
        telefone.setDdd("5");
        assertThat(getErros(telefone), hasItem(DDD_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de DDD com mais de 2 dígitos")
    void nao_deve_aceitar_um_ddd_com_mais_de_2_caracteres() {
        telefone.setDdd("111");
        assertThat(getErros(telefone), hasItem(DDD_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de DDD terminado em 0")
    void nao_deve_aceitar_um_ddd_terminado_em_0() {
        telefone.setDdd("10");
        assertThat(getErros(telefone), hasItem(DDD_MENSAGEM_TERMINADO_EM_0));
    }

    @Test
    @DisplayName("😢 Teste de DDD nulo")
    void nao_deve_aceitar_um_ddd_nulo() {
        telefone.setDdd(null);
        assertThat(getErros(telefone), hasItem(DDD_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de DDD vazio")
    void nao_deve_aceitar_um_ddd_vazio() {
        telefone.setDdd("");
        assertThat(getErros(telefone), hasItem(DDD_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de DDD com espaço")
    void nao_deve_aceitar_um_ddd__com_espaco() {
        telefone.setDdd("   ");
        assertThat(getErros(telefone), hasItem(DDD_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de DDD com letras")
    void nao_deve_aceitar_um_ddd_com_letras() {
        telefone.setDdd("1A");
        assertThat(getErros(telefone), hasItem(DDD_MENSAGEM_LETRAS));
    }

    @Test
    @DisplayName("😢 Teste de DDD com caracteres especiais")
    void nao_deve_aceitar_um_ddd_com_caracteres_especiais() {
        telefone.setDdd("1!");
        assertThat(getErros(telefone), hasItem(DDD_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😀 Teste de Número de Telefone válido")
    void deve_aceitar_um_numero_valido() {
        telefone.setNumero("930468142");
        assertEquals("930468142", telefone.getNumero());
    }

    @Test
    @DisplayName("😢 Teste de Número de Telefone com menos de 8 caracteres")
    void nao_deve_aceitar_um_telefone_com_menos_de_8_caracteres() {
        telefone.setNumero("9304681");
        assertThat(getErros(telefone), hasItem(NUMERO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Número de Telefone com mais de 9 caracteres")
    void nao_deve_aceitar_um_telefone_com_mais_de_9_caracteres() {
        telefone.setNumero("9304681420");
        assertThat(getErros(telefone), hasItem(NUMERO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Número de Telefone nulo")
    void nao_deve_aceitar_um_telefone_nulo() {
        telefone.setNumero(null);
        assertThat(getErros(telefone), hasItem(NUMERO_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Número de Telefone vazio")
    void nao_deve_aceitar_um_telefone_vazio() {
        telefone.setNumero("");
        assertThat(getErros(telefone), hasItem(NUMERO_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Número de Telefone com espaço")
    void nao_deve_aceitar_um_telefone_com_espaco() {
        telefone.setNumero("    ");
        assertThat(getErros(telefone), hasItem(NUMERO_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de Número de Telefone com letras")
    void nao_deve_aceitar_um_telefone_com_letras() {
        telefone.setNumero("930468A42");
        assertThat(getErros(telefone), hasItem(NUMERO_MENSAGEM_LETRAS));
    }

    @Test
    @DisplayName("😢 Teste de Número de Telefone com com caracteres especiais")
    void nao_deve_aceitar_um_telefone_com_caracteres_especiais() {
        telefone.setNumero("930468@42");
        assertThat(getErros(telefone), hasItem(NUMERO_MENSAGEM_CARACTERE_ESPECIAL));
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
        return Stream.of(arguments("15", "930468142"), arguments("11", "810468142"));
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

    @Test
    @DisplayName("😀 Teste de Objeto Igual ao Enum")
    void deve_retornar_true_quando_o_objeto_for_igual_ao_enum() {
        TelefoneType telefonelocal = TelefoneType.CELULAR;
        assertEquals(telefonelocal.getTelefone(), telefoneEnum.getTelefone());
    }
}
