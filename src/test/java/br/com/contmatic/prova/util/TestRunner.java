package br.com.contmatic.prova.util;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import br.com.contmatic.prova.empresa.ClienteTest;
import br.com.contmatic.prova.empresa.EmpresaTest;
import br.com.contmatic.prova.empresa.FuncionarioTest;
import br.com.contmatic.prova.endereco.EnderecoTest;
import br.com.contmatic.prova.telefone.TelefoneTest;

@SelectPackages({"br.com.contmatic.prova.empresa"})
@SelectClasses({ClienteTest.class, EmpresaTest.class, EnderecoTest.class, FuncionarioTest.class, TelefoneTest.class})
@Suite
@SuiteDisplayName("Testes do domínio Empresa")

public class TestRunner {

}

