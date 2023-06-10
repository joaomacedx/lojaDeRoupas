package br.com.lojaDeRoupas.Domain.Factories;

import br.com.lojaDeRoupas.Domain.Entities.Funcionario;
import br.com.lojaDeRoupas.Domain.ValueObjects.*;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class FuncionarioFactoryTest {
  @Test
  public void criarNovo_com_sucesso_QUANDO_argumentos_passados_sao_validos_ENTAO_verifica_se_o_Funcionario_criado_possui_o_Id_esperado() {

    //Arrange
    String nomeDoFuncionario = "Gabriel";
    String sobrenomeDoFuncionario = "Macedo";
    String telefone = "12345678";
    String email = "joaomacedo1234@email.com";
    String ruaOndeFuncionarioMora = "Rua das babilonia";
    String cepDaRuaDoFuncionario = "987654321";
    String cargoDoFuncionario = "Gerente";
    FuncionarioFactory funcionarioFactory = new FuncionarioFactory();

    //Act
    Funcionario funcionarioAtual = funcionarioFactory.criarNovoFuncionario(nomeDoFuncionario, sobrenomeDoFuncionario,
            telefone, email, ruaOndeFuncionarioMora,
            cepDaRuaDoFuncionario, cargoDoFuncionario);

    //Assert
    Funcionario funcionarioEsperado = new Funcionario(funcionarioAtual.Id,
            new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
            Cargo.Gerente, new Email(email), new NumeroDeTelefone(telefone),
            new Endereco(ruaOndeFuncionarioMora,
                    cepDaRuaDoFuncionario));
    assertEquals(funcionarioEsperado.Id, funcionarioAtual.Id);
  }
  @Test
  public void criarExistente_com_sucesso_QUANDO_argumentos_passados_sao_validos_ENTAO_verifica_se_o_Funcionario_criado_possui_o_Id_esperado() {

    //Arrange
    UUID id = UUID.randomUUID();
    String nomeDoFuncionario = "Gabriel";
    String sobrenomeDoFuncionario = "Macedo";
    String telefone = "12345678";
    String email = "joaomacedo1234@email.com";
    String ruaOndeFuncionarioMora = "Rua das babilonia";
    String cepDaRuaDoFuncionario = "987654321";
    String cargoDoFuncionario = "Gerente";
    FuncionarioFactory funcionarioFactory = new FuncionarioFactory();

    //Act
    Funcionario funcionarioAtual = funcionarioFactory.criarFuncionarioExistente(id,nomeDoFuncionario, sobrenomeDoFuncionario,
            telefone, email, ruaOndeFuncionarioMora,
            cepDaRuaDoFuncionario, cargoDoFuncionario);

    //Assert
    Funcionario funcionarioEsperado = new Funcionario(funcionarioAtual.Id,
            new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
            Cargo.Gerente, new Email(email), new NumeroDeTelefone(telefone),
            new Endereco(ruaOndeFuncionarioMora,
                    cepDaRuaDoFuncionario));
    assertEquals(funcionarioEsperado.Id, funcionarioAtual.Id);
  }
}