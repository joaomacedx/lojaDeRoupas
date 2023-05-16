package UnitTests.Infrastructure.InMemory;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import Domain.Entities.Funcionario;
import Domain.ValueObjects.Cargo;
import Domain.ValueObjects.Email;
import Domain.ValueObjects.Endereco;
import Domain.ValueObjects.Nome;
import Domain.ValueObjects.NumeroDeTelefone;
import Infrastructure.Repositories.InMemory.InMemoryFuncionarioRepository;

public class InMemoryFuncionarioRepositoryTest {
    
    @Test
    public void findByEmail_com_sucesso_QUANDO_argumentos_passados_sao_validos_ENTAO_retorna_instancia_de_Funcionario() {
        //Arrange 
        UUID id = UUID.randomUUID();
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
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        funcionarios.add(funcionarioEsperado);
        InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);

        //Act
        Funcionario funcionarioAtual = inMemoryFuncionarios.findByEmail(funcionarioEsperado.email);

        //Assert
        funcionarioAtual.equals(funcionarioEsperado);
    }
    @Test(expected = Error.class)
    public void findByEmail_com_Error_QUANDO_argumentos_passados_sao_invalidos_ENTAO_retorna_um_error() {
        //Arrange 
        UUID id = UUID.randomUUID();
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
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);

        //Act
        Funcionario funcionarioExperado = inMemoryFuncionarios.findByEmail(novofuncionario.email);
        
        //Assert
        Boolean contaisFuncionario = inMemoryFuncionarios.funcionariosInMemory.contains(funcionarioExperado);
        assertEquals(contaisFuncionario, false);
    }
    @Test
    public void save_com_sucesso_QUANDO_argumentos_passados_sao_validos_ENTAO_retorna_instancia_de_Funcionario() {
        //Arrange
        UUID id = UUID.randomUUID();
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
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        
        InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);
        //Act
        inMemoryFuncionarios.Save(funcionarioAtual);
        //Assert
        Boolean containsFuncionario = inMemoryFuncionarios.funcionariosInMemory.contains(funcionarioAtual);
        containsFuncionario.equals(true);
    }
}
