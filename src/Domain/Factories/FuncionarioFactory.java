package Domain.Factories;

import java.util.UUID;

import Domain.Entities.Funcionario;
import Domain.ValueObjects.Cargo;
import Domain.ValueObjects.Email;
import Domain.ValueObjects.Endereco;
import Domain.ValueObjects.Nome;
import Domain.ValueObjects.NumeroDeTelefone;

public class FuncionarioFactory {

    public Funcionario criarNovoFuncionario( String nome, String sobrenome, String numeroDeTelefone,
     String enderecoDeEmail, String rua, String cep, String cargo ) {
        Cargo novoCargo = Cargo.valueOf(cargo);
        Funcionario novoFuncionario = new Funcionario(UUID.randomUUID(),
             new Nome(nome, sobrenome), novoCargo, new Email(enderecoDeEmail),
             new NumeroDeTelefone(numeroDeTelefone), new Endereco(rua, cep));
        return novoFuncionario;
    }
    public Funcionario criarFuncionarioExistente(UUID id, String nome, String sobrenome, String numeroDeTelefone,
     String enderecoDeEmail, String rua, String cep, String cargo ) {
       Cargo novoCargo = Cargo.valueOf(cargo);
       Funcionario funcionarioExistente = new Funcionario(id,
             new Nome(nome, sobrenome), novoCargo, new Email(enderecoDeEmail),
             new NumeroDeTelefone(numeroDeTelefone), new Endereco(rua, cep));
       return funcionarioExistente;
   }
}
