package br.com.contmatic.prova.util;

import java.math.BigDecimal;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import br.com.contmatic.prova.empresa.Cliente;
import br.com.contmatic.prova.empresa.Empresa;
import br.com.contmatic.prova.empresa.Funcionario;
import br.com.contmatic.prova.endereco.Endereco;
import br.com.contmatic.prova.telefone.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class FixtureFactory implements TemplateLoader {
    @Override
    public void load() {
        LocalDateTime criacao = new LocalDateTime(2022, 01, 01, 15, 8);
        LocalDateTime atualizacao = LocalDateTime.now();
        Fixture.of(Cliente.class).addTemplate("válido", new Rule() {
            {
                add("cpf", random("49523197843", "87147963091"));
                add("nome", random("ManuelaAlves", "LeonardoSouza")); 
                add("email", "${nome}@gmail.com");
                add("criadoPor", random("Ricardo Pereira", "Amélia Silveira"));
                add("atualizadoPor", random("João Jorge", "Márcia Duarte"));
                add("dataCriacao", criacao);
                add("ultimaAtualizacao", atualizacao);
                add("ipCriacao", random("127.0.0.1", "152.84.253.41"));
                add("ipUltimaAtualizacao", random("127.0.0.1", "152.84.253.41"));
            }
        });
        
        LocalDate abertura = new LocalDate(2021, 12, 19);
        Fixture.of(Empresa.class).addTemplate("válido", new Rule() {
            {
                add("cnpj", random("05823382000177", "92754738000162"));
                add("nomeFantasia", random("Renner", "RI Happy"));
                add("razaoSocial", random("Lojas Renner S.A", "RI Happy Brinquedos S.A"));
                add("telefones", has(1).of(Telefone.class, "válido"));
                add("enderecos", has(1).of(Endereco.class, "válido"));
                add("dataAbertura", abertura);
                add("criadoPor", random("Ricardo Pereira", "Amélia Silveira"));
                add("atualizadoPor", random("João Jorge", "Márcia Duarte"));
                add("dataCriacao", criacao);
                add("ultimaAtualizacao", atualizacao);
                add("ipCriacao", random("127.0.0.1", "152.84.253.41"));
                add("ipUltimaAtualizacao", random("127.0.0.1", "152.84.253.41"));
            }
        });
        
        LocalDate nascimento = new LocalDate(2003, 7, 5);
        BigDecimal salario1 = new BigDecimal(2500);
        BigDecimal salario2 = new BigDecimal(1500);
        Fixture.of(Funcionario.class).addTemplate("válido", new Rule() {
            {
                add("matricula", random("12345", "54321"));
                add("cpf", random("49523197843", "87147963091"));
                add("nome", random("Victor Silva", "Felipe Gomes"));
                add("cargo", random("Estagiário", "Gestor"));
                add("setor", random("RH", "Suporte"));
                add("dataNascimento", nascimento);
                add("salario", random(salario1, salario2));
                add("ativo", true);
                add("criadoPor", random("Ricardo Pereira", "Amélia Silveira"));
                add("atualizadoPor", random("João Jorge", "Márcia Duarte"));
                add("dataCriacao", criacao);
                add("ultimaAtualizacao", atualizacao);
                add("ipCriacao", random("127.0.0.1", "152.84.253.41"));
                add("ipUltimaAtualizacao", random("127.0.0.1", "152.84.253.41"));
            }
        });
        
        Fixture.of(Endereco.class).addTemplate("válido", new Rule() {
            {
                add("cep", random("07500000", "18209003"));
                add("numero", random("12", "231"));
                add("logradouro", random("Rua das Flores", "Avenida Aurora"));
                add("bairro", random("Jardim Eldorado", "Alvorada"));
                add("cidade", random("Santa Isabel", "Porto Alegre"));
                add("uf", random("SP", "RS"));
            }
        });
        
        Fixture.of(Telefone.class).addTemplate("válido", new Rule() {
            {
                add("ddi", "55");
                add("ddd", random("11", "51"));
                add("numero", random("930468142", "82445439"));
            }
        });
    }
}
