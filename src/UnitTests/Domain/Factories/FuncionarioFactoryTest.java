package UnitTests.Domain.Factories;
import org.junit.Test;

import Domain.Entities.Funcionario;
import Domain.Factories.FuncionarioFactory;
import Domain.ValueObjects.*;
public class FuncionarioFactoryTest {
    @Test
    public void criaNovo_com_sucesso_QUANDO_argumentos_passados_sao_validos_ENTAO_retorna_nova_instancia_de_Funcionario() {

        //Arrange
        String nomeDoFuncionario = "Gabriel";
        String sobrenomeDoFuncionario = "Macedo";
        String telefone = "12345678";
        String email = "joaomacedo1234@email.com";
        String ruaOndeFuncionarioMora = "Rua das babilonia";
        String cepDaRuaDoFuncionario = "987654321";
        Cargo cargoDoFuncionario = Cargo.Gerente;
        FuncionarioFactory funcionarioFactory = new FuncionarioFactory();
        //Act
        Funcionario funcionarioAtual = funcionarioFactory.criarNovoFuncionario(nomeDoFuncionario, sobrenomeDoFuncionario,
             telefone, email, ruaOndeFuncionarioMora,
              cepDaRuaDoFuncionario, cargoDoFuncionario);
        //Assert
        Funcionario funcionarioEsperado = new Funcionario(funcionarioAtual.Id,
             new Nome(nomeDoFuncionario, sobrenomeDoFuncionario),
             cargoDoFuncionario, new Email(email), new NumeroDeTelefone(telefone),
              new Endereco(ruaOndeFuncionarioMora,
               cepDaRuaDoFuncionario));
        funcionarioAtual.equals(funcionarioEsperado);
    }
}
