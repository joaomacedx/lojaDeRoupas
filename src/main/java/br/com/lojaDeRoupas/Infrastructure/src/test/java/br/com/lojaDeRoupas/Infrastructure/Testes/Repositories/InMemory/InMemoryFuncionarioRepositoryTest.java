package br.com.lojaDeRoupas.Infrastructure.Testes.Repositories.InMemory;

import br.com.lojaDeRoupas.Domain.Entities.Funcionario;
import br.com.lojaDeRoupas.Domain.Exceptions.EntityAlreadyExistsException;
import br.com.lojaDeRoupas.Domain.Exceptions.EntityNotFoundException;
import br.com.lojaDeRoupas.Domain.ValueObjects.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;


public class InMemoryFuncionarioRepositoryTest {
    @Test
    public void findByEmail_com_sucesso_QUANDO_nao_existem_registros_do_funcionario_no_sistema_ENTAO_verifica_se_o_funcionario_encontrado_e_o_esperado() {
      //Arrange
      EntityId id = new EntityId(UUID.randomUUID());
      String nomeDoFuncionario = "Gabriel";
      String sobrenomeDoFuncionario = "Macedo";
      String telefone = "12345678";
      String email = "joaomacedo1234@email.com";
      String ruaOndeFuncionarioMora = "Rua das babilonia";
      String cepDaRuaDoFuncionario = "987654321";
      Cargo cargoDoFuncionario = Cargo.Gerente;
      Funcionario funcionarioEsperado = new Funcionario(id,
              new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
              cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
                      cepDaRuaDoFuncionario));
      List<Funcionario> funcionarios = new ArrayList<>();
      funcionarios.add(funcionarioEsperado);
      InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);

      //Act
      Funcionario funcionarioAtual = inMemoryFuncionarios.FindByEmail(funcionarioEsperado.email);

      //Assert
      assertEquals(funcionarioEsperado,funcionarioAtual);
    }
    @Test(expected = EntityNotFoundException.class)
    public void findByEmail_com_Error_QUANDO_argumentos_passados_para_o_funcionario_existem_no_sistema_ENTAO_deve_estourar_uma_EntityNotFoundException() {
      //Arrange
      EntityId id = new EntityId(UUID.randomUUID());
      String nomeDoFuncionario = "Gabriel";
      String sobrenomeDoFuncionario = "Macedo";
      String telefone = "12345678";
      String email = "joaomacedo1234@email.com";
      String ruaOndeFuncionarioMora = "Rua das babilonia";
      String cepDaRuaDoFuncionario = "987654321";
      Cargo cargoDoFuncionario = Cargo.Gerente;
      Funcionario novofuncionario = new Funcionario(id,
              new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
              cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
                      cepDaRuaDoFuncionario));
      List<Funcionario> funcionarios = new ArrayList<>();
      InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);

      //Act
      Funcionario funcionarioExperado = inMemoryFuncionarios.FindByEmail(novofuncionario.email);

      //Assert
      Boolean contaisFuncionario = inMemoryFuncionarios.funcionariosInMemory.contains(funcionarioExperado);
      assertEquals(contaisFuncionario, false);
    }
    @Test
    public void save_com_sucesso_QUANDO_argumentos_passados_sao_validos_ENTAO_verifica_se_o_Funcionario_salvo_e_o_esperado() {
      //Arrange
      EntityId id = new EntityId(UUID.randomUUID());
      String nomeDoFuncionario = "Gabriel";
      String sobrenomeDoFuncionario = "Macedo";
      String telefone = "12345678";
      String email = "joaomacedo1234@email.com";
      String ruaOndeFuncionarioMora = "Rua das babilonia";
      String cepDaRuaDoFuncionario = "987654321";
      Cargo cargoDoFuncionario = Cargo.Gerente;
      Funcionario funcionarioAtual = new Funcionario(id,
              new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
              cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
                      cepDaRuaDoFuncionario));
      List<Funcionario> funcionarios = new ArrayList<>();

      InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);
      //Act
      inMemoryFuncionarios.Save(funcionarioAtual);
      //Assert
      Boolean containsFuncionario = inMemoryFuncionarios.funcionariosInMemory.contains(funcionarioAtual);
      assertEquals(containsFuncionario, true);
    }
    @Test(expected = EntityAlreadyExistsException.class)
    public void save_com_error_QUANDO_argumentos_passados_para_o_funcionario_a_ser_cadastrado_ja_existem_no_sistema_ENTAO_deve_estourar_uma_EntityAlreadyExistsException() {
      //Arrange
      EntityId id = new EntityId(UUID.randomUUID());
      String nomeDoFuncionario = "Gabriel";
      String sobrenomeDoFuncionario = "Macedo";
      String telefone = "12345678";
      String email = "joaomacedo1234@email.com";
      String ruaOndeFuncionarioMora = "Rua das babilonia";
      String cepDaRuaDoFuncionario = "987654321";
      Cargo cargoDoFuncionario = Cargo.Gerente;
      Funcionario funcionarioAtual = new Funcionario(id,
              new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
              cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
                      cepDaRuaDoFuncionario));
      List<Funcionario> funcionarios = new ArrayList<>();
      funcionarios.add(funcionarioAtual);
      InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);

      //Act

      inMemoryFuncionarios.Save(funcionarioAtual);
      //Assert

      Boolean containsFuncionario = inMemoryFuncionarios.funcionariosInMemory.contains(funcionarioAtual);
      assertEquals(containsFuncionario, true);
    }
    @Test
    public void findById_com_sucesso_QUANDO_argumentos_passados_sao_validos_ENTAO_retorna_instancia_de_Funcionario() {
      //Arrange

      EntityId id = new EntityId(UUID.randomUUID());
      String nomeDoFuncionario = "Gabriel";
      String sobrenomeDoFuncionario = "Macedo";
      String telefone = "12345678";
      String email = "joaomacedo1234@email.com";
      String ruaOndeFuncionarioMora = "Rua das babilonia";
      String cepDaRuaDoFuncionario = "987654321";
      Cargo cargoDoFuncionario = Cargo.Gerente;
      Funcionario funcionarioAtual = new Funcionario(id,
              new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
              cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
                      cepDaRuaDoFuncionario));
      List<Funcionario> funcionarios = new ArrayList<>();
      funcionarios.add(funcionarioAtual);
      InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);
      //Act

      Funcionario funcionarioExperado = inMemoryFuncionarios.FindById(funcionarioAtual.Id);
      //Assert

      assertEquals(funcionarioExperado,funcionarioAtual);
    }
    @Test(expected = EntityNotFoundException.class)
    public void findById_com_erro_QUANDO_nao_existe_registros_do_funcionario_no_sistema_ENTAO_estoura_uma_EntityNotFoundException() {
      //Arrange

      EntityId id = new EntityId(UUID.randomUUID());
      String nomeDoFuncionario = "Gabriel";
      String sobrenomeDoFuncionario = "Macedo";
      String telefone = "12345678";
      String email = "joaomacedo1234@email.com";
      String ruaOndeFuncionarioMora = "Rua das babilonia";
      String cepDaRuaDoFuncionario = "987654321";
      Cargo cargoDoFuncionario = Cargo.Gerente;
      Funcionario funcionarioAtual = new Funcionario(id,
              new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
              cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
                      cepDaRuaDoFuncionario));
      List<Funcionario> funcionarios = new ArrayList<>();
      InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);

      //Act
      inMemoryFuncionarios.FindById(funcionarioAtual.Id);
      //Assert
      Boolean containsFuncionario = inMemoryFuncionarios.funcionariosInMemory.contains(funcionarioAtual);
      assertEquals(containsFuncionario, false);
    }
    @Test(expected = EntityNotFoundException.class)
    public void Delete_com_erro_QUANDO_funcionario_passado_nao_esta_cadastrado__ENTAO_estourar_uma_EntityNotFoundException() {
      //Arrange

      EntityId id = new EntityId(UUID.randomUUID());
      String nomeDoFuncionario = "Gabriel";
      String sobrenomeDoFuncionario = "Macedo";
      String telefone = "12345678";
      String email = "joaomacedo1234@email.com";
      String ruaOndeFuncionarioMora = "Rua das babilonia";
      String cepDaRuaDoFuncionario = "987654321";
      Cargo cargoDoFuncionario = Cargo.Gerente;
      Funcionario funcionario = new Funcionario(id,
              new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
              cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
                      cepDaRuaDoFuncionario));
      List<Funcionario> funcionarios = new ArrayList<>();
      InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);

      //Act
      inMemoryFuncionarios.Delete(funcionario);
      //Assert
      Boolean containsFuncionario = inMemoryFuncionarios.funcionariosInMemory.contains(funcionario);
      assertEquals(containsFuncionario, false);
    }
    @Test
    public void Delete_com_sucesso_QUANDO_funcionario_passado_esta_cadastrado_ENTAO_remove_funcionario_da_lista() {
      //Arrange

      EntityId id = new EntityId(UUID.randomUUID());
      String nomeDoFuncionario = "Gabriel";
      String sobrenomeDoFuncionario = "Macedo";
      String telefone = "12345678";
      String email = "joaomacedo1234@email.com";
      String ruaOndeFuncionarioMora = "Rua das babilonia";
      String cepDaRuaDoFuncionario = "987654321";
      Cargo cargoDoFuncionario = Cargo.Gerente;
      Funcionario funcionario = new Funcionario(id,
              new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
              cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
                      cepDaRuaDoFuncionario));
      List<Funcionario> funcionarios = new ArrayList<>();
      funcionarios.add(funcionario);
      InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);
      //Act
      inMemoryFuncionarios.Delete(funcionario);
      //Assert
      Boolean containsFuncionario = inMemoryFuncionarios.funcionariosInMemory.contains(funcionario);
      assertEquals(false, containsFuncionario);
    }
  }

