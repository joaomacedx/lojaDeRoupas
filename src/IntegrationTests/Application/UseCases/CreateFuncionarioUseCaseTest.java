package IntegrationTests.Application.UseCases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Application.DataTransferObjects.FuncionarioDTO;
import Application.UseCases.CreateFuncionario.CreateFuncionarioUseCase;
import Domain.Entities.Funcionario;
import Domain.Factories.FuncionarioFactory;
import Domain.ValueObjects.Email;
import Domain.ValueObjects.Endereco;
import Domain.ValueObjects.Nome;
import Domain.ValueObjects.NumeroDeTelefone;
import Infrastructure.Repositories.InMemory.InMemoryFuncionarioRepository;

public class CreateFuncionarioUseCaseTest {
    @Test
    public void execute_com_sucesso_QUANDO_os_argumentos_passados_sao_validos_ENTAO_salva_o_funcionario() {

        //Arrange
        FuncionarioDTO dto = new FuncionarioDTO("joaomacedo1234@email.com",
             "Gabriel", "Macedo", 
             "12345678", "Rua das babilonia",
              "987654321", "Gerente");
        FuncionarioFactory funcionarioFactory = new FuncionarioFactory();
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        InMemoryFuncionarioRepository inMemoryFuncionarios = new InMemoryFuncionarioRepository(funcionarios);
        CreateFuncionarioUseCase usecase = new CreateFuncionarioUseCase(inMemoryFuncionarios, funcionarioFactory);
        //Act
        usecase.execute(dto);
        //Assert
       
        Funcionario expectedFuncionario = inMemoryFuncionarios.findByEmail(new Email(dto.enderecoDeEmail));
        Funcionario funcionarioAtual = new Funcionario(expectedFuncionario.Id,
        new Nome(dto.nome, dto.sobrenome),
        expectedFuncionario.cargo, new Email(dto.enderecoDeEmail), new NumeroDeTelefone(dto.numeroDeTelefone),
        new Endereco(dto.rua,
        dto.cep));
        assertEquals(expectedFuncionario.Id, funcionarioAtual.Id);

    }
}
