package br.com.contmatic.prova.endereco;

import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.BAIRRO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CEP_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.CIDADE_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.LOGRADOURO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.NUMERO_MENSAGEM_VAZIO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_CARACTERE_ESPECIAL;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_ESPACO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_NULO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_NUMEROS;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_TAMANHO;
import static br.com.contmatic.prova.constantes.EnderecoConstante.UF_MENSAGEM_VAZIO;
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

import br.com.contmatic.prova.constantes.EnderecoConstante;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class EnderecoTest {

    private static Endereco endereco;
    private EstadoType estado = EstadoType.SP;

    @BeforeAll
    static void deve_exibir_antes_de_todos_os_testes() {
        System.out.println("Executando os testes da classe Endereço...");
    }

    @BeforeEach
    public void deve_criar_antes_de_cada_teste() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.prova.util");
        endereco = Fixture.from(Endereco.class).gimme("válido");
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
    @DisplayName("😀 Teste de Endereço válido")
    void deve_aceitar_um_endereco_valido() {
        Set<String> erros = getErros(endereco);
        System.out.println(erros);
        assertThat(erros.size(), is(0));
    }

    @Test
    @DisplayName("😢 Teste de CEP com menos de 8 caracteres")
    void nao_deve_aceitar_um_cep_com_menos_de_8_caracteres() {
        endereco.setCep("0750000");
        assertThat(getErros(endereco), hasItem(CEP_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de CEP com mais de 8 caracteres")
    void nao_deve_aceitar_um_cep_com_mais_de_8_caracteres() {
        endereco.setCep("075000000");
        assertThat(getErros(endereco), hasItem(EnderecoConstante.CEP_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de CEP nulo")
    void nao_deve_aceitar_um_cep_nulo() {
        endereco.setCep(null);
        assertThat(getErros(endereco), hasItem(CEP_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de CEP vazio")
    void nao_deve_aceitar_um_cep_vazio() {
        endereco.setCep("");
        assertThat(getErros(endereco), hasItem(CEP_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de CEP com espaço")
    void nao_deve_aceitar_um_cep_com_espaco() {
        endereco.setCep("	");
        assertThat(getErros(endereco), hasItem(CEP_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de CEP com letras")
    void nao_deve_aceitar_um_cep_com_letras() {
        endereco.setCep("0750000O");
        assertThat(getErros(endereco), hasItem(EnderecoConstante.CEP_MENSAGEM_LETRAS));
    }

    @Test
    @DisplayName("😢 Teste de CEP com caracteres especiais")
    void nao_deve_aceitar_um_cep_com_caracteres_especiais() {
        endereco.setCep("0750000!");
        assertThat(getErros(endereco), hasItem(CEP_MENSAGEM_CARACTERE_ESPECIAL));    }

    @Test
    @DisplayName("😢 Teste de Número com mais de 4 caracteres")
    void nao_deve_aceitar_um_numero_com_mais_de_4_caracteres() {
        endereco.setNumero("12345");
        assertThat(getErros(endereco), hasItem(NUMERO_MENSAGEM_TAMANHO));  
    }

    @Test
    @DisplayName("😢 Teste de Número nulo")
    void nao_deve_aceitar_um_numero_nulo() {
        endereco.setNumero(null);
        assertThat(getErros(endereco), hasItem(NUMERO_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Número vazio")
    void nao_deve_aceitar_um_numero_vazio() {
        endereco.setNumero("");
        assertThat(getErros(endereco), hasItem(NUMERO_MENSAGEM_VAZIO));    }

    @Test
    @DisplayName("😢 Teste de Número com espaço")
    void nao_deve_aceitar_um_numero_com_espaco() {
        endereco.setNumero("	");
        assertThat(getErros(endereco), hasItem(NUMERO_MENSAGEM_ESPACO));    }

    @Test
    @DisplayName("😢 Teste de Número com caractere especial")
    void nao_deve_aceitar_um_numero_com_caractere_especial() {
        endereco.setNumero("12&4");
        assertThat(getErros(endereco), hasItem(NUMERO_MENSAGEM_CARACTERE_ESPECIAL));    }

    @Test
    @DisplayName("😢 Teste de Logradouro com menos de 3 caracteres")
    void nao_deve_aceitar_um_logradouro_com_menos_de_3_caracteres() {
        endereco.setLogradouro("Av");
        assertThat(getErros(endereco), hasItem(LOGRADOURO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Logradouro com mais de 60 caracteres")
    void nao_deve_aceitar_um_logradouro_com_mais_de_60_caracteres() {
        endereco.setLogradouro("Travessa Pomposa das Flores Cheirosas e Carinhosas da Dona Rosa");
        assertThat(getErros(endereco), hasItem(LOGRADOURO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Logradouro nulo")
    void nao_deve_aceitar_um_logradouro_nulo() {
        endereco.setLogradouro(null);
        assertThat(getErros(endereco), hasItem(LOGRADOURO_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Logradouro vazio")
    void nao_deve_aceitar_um_logradouro_vazio() {
        endereco.setLogradouro("");
        assertThat(getErros(endereco), hasItem(LOGRADOURO_MENSAGEM_VAZIO));    
    }

    @Test
    @DisplayName("😢 Teste de Logradouro com espaço")
    void nao_deve_aceitar_um_logradouro_com_espaco() {
        endereco.setLogradouro("	");
        assertThat(getErros(endereco), hasItem(LOGRADOURO_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de Logradouro com caractere especial")
    void nao_deve_aceitar_um_logradouro_com_caractere_especial() {
        endereco.setLogradouro("Ru@ das Flores");
        assertThat(getErros(endereco), hasItem(LOGRADOURO_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😢 Teste de Bairro com menos de 3 caracteres")
    void nao_deve_aceitar_um_bairro_com_menos_de_3_caracteres() {
        endereco.setBairro("Ja");
        assertThat(getErros(endereco), hasItem(BAIRRO_MENSAGEM_TAMANHO));    }

    @Test
    @DisplayName("😢 Teste de Bairro com mais de 30 caracteres")
    void nao_deve_aceitar_um_bairro_com_mais_de_30_caracteres() {
        endereco.setBairro("Bairrozinho do Amiguinho Bobinho");
        assertThat(getErros(endereco), hasItem(BAIRRO_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Bairro nulo")
    void nao_deve_aceitar_um_bairro_nulo() {
        endereco.setBairro(null);
        assertThat(getErros(endereco), hasItem(BAIRRO_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Bairro vazio")
    void nao_deve_aceitar_um_bairro_vazio() {
        endereco.setBairro("");
        assertThat(getErros(endereco), hasItem(BAIRRO_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de Bairro com espaço")
    void nao_deve_aceitar_um_bairro_com_espaco() {
        endereco.setBairro("	");
        assertThat(getErros(endereco), hasItem(BAIRRO_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de Bairro com caracteres especiais")
    void nao_deve_aceitar_um_bairro_com_caracteres_especiais() {
        endereco.setBairro("J@rdim Eldorado");
        assertThat(getErros(endereco), hasItem(BAIRRO_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😢 Teste de Cidade com menos de 3 caracteres")
    void nao_deve_aceitar_uma_cidade_com_menos_de_3_caracteres() {
        endereco.setCidade("Sa");
        assertThat(getErros(endereco), hasItem(CIDADE_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Cidade com mais de 20 caracteres")
    void nao_deve_aceitar_uma_cidade_com_mais_de_20_caracteres() {
        endereco.setCidade("Santinha Isabelzinha oba");
        assertThat(getErros(endereco), hasItem(CIDADE_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de Cidade nulo")
    void nao_deve_aceitar_uma_cidade_nula() {
        endereco.setCidade(null);
        assertThat(getErros(endereco), hasItem(CIDADE_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de Cidade vazia")
    void nao_deve_aceitar_uma_cidade_vazia() {
        endereco.setCidade("");
        assertThat(getErros(endereco), hasItem(CIDADE_MENSAGEM_VAZIO));
     }

    @Test
    @DisplayName("😢 Teste de Cidade com espaço")
    void nao_deve_aceitar_uma_cidade_com_espaco() {
        endereco.setCidade("	");
        assertThat(getErros(endereco), hasItem(CIDADE_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de Cidade com números")
    void nao_deve_aceitar_uma_cidade_com_numeros() {
        endereco.setCidade("S4nta Isabel");
        assertThat(getErros(endereco), hasItem(CIDADE_MENSAGEM_NUMEROS));
    }

    @Test
    @DisplayName("😢 Teste de Cidade com caracteres especiais")
    void nao_deve_aceitar_uma_cidade_com_caracteres_especiais() {
        endereco.setCidade("S@nta Isabel");
        assertThat(getErros(endereco), hasItem(CIDADE_MENSAGEM_CARACTERE_ESPECIAL));
    }

    @Test
    @DisplayName("😢 Teste de UF com menos de 2 caracteres")
    void nao_deve_aceitar_uma_uf_com_menos_de_2_caracteres() {
        endereco.setUf("S");
        assertThat(getErros(endereco), hasItem(UF_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de UF com mais de 2 caracteres")
    void nao_deve_aceitar_uma_uf_com_mais_de_2_caracteres() {
        endereco.setUf("SPP");
        assertThat(getErros(endereco), hasItem(UF_MENSAGEM_TAMANHO));
    }

    @Test
    @DisplayName("😢 Teste de UF nula")
    void nao_deve_aceitar_uma_uf_nula() {
        endereco.setUf(null);
        assertThat(getErros(endereco), hasItem(UF_MENSAGEM_NULO));
    }

    @Test
    @DisplayName("😢 Teste de UF vazia")
    void nao_deve_aceitar_uma_vazia() {
        endereco.setUf("");
        assertThat(getErros(endereco), hasItem(UF_MENSAGEM_VAZIO));
    }

    @Test
    @DisplayName("😢 Teste de UF com espaço")
    void nao_deve_aceitar_uma_uf_com_espaco() {
        endereco.setUf("	");
        assertThat(getErros(endereco), hasItem(UF_MENSAGEM_ESPACO));
    }

    @Test
    @DisplayName("😢 Teste de UF com números")
    void nao_deve_aceitar_uma_uf_com_numeros() {
        endereco.setUf("5P");
        assertThat(getErros(endereco), hasItem(UF_MENSAGEM_NUMEROS));
    }

    @Test
    @DisplayName("😢 Teste de UF com caracteres especiais")
    void nao_deve_aceitar_uma_uf_com_caractere_especial() {
        endereco.setUf("$P");
        assertThat(getErros(endereco), hasItem(UF_MENSAGEM_CARACTERE_ESPECIAL));
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
        return Stream.of(arguments("07500000", "1234"), arguments("07176600", "1204"));
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

    @Test
    @DisplayName("😀 Teste de Objeto Igual ao Enum")
    void deve_retornar_true_quando_o_objeto_for_igual_ao_enum() {
        EstadoType estadolocal = EstadoType.SP;
        assertEquals(estadolocal.getEstado(), estado.getEstado());
    }
}
