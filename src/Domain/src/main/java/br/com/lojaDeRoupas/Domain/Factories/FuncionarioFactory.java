package br.com.lojaDeRoupas.Domain.Factories;

import java.util.UUID;
import br.com.lojaDeRoupas.Domain.Entities.Funcionario;
import br.com.lojaDeRoupas.Domain.ValueObjects.EntityId;
import br.com.lojaDeRoupas.Domain.ValueObjects.Nome;
import br.com.lojaDeRoupas.Domain.ValueObjects.Cargo;
import br.com.lojaDeRoupas.Domain.ValueObjects.Email;
import br.com.lojaDeRoupas.Domain.ValueObjects.NumeroDeTelefone;
import br.com.lojaDeRoupas.Domain.ValueObjects.Endereco;


public class FuncionarioFactory {
  public Funcionario criarNovoFuncionario(String nome, String sobrenome, String numeroDeTelefone,
                                          String enderecoDeEmail, String rua, String cep, String cargo ) {
    Cargo novoCargo = Cargo.valueOf(cargo);
    Funcionario novoFuncionario = new Funcionario(new EntityId(UUID.randomUUID()),
            new Nome(nome, sobrenome), novoCargo, new Email(enderecoDeEmail),
            new NumeroDeTelefone(numeroDeTelefone), new Endereco(rua, cep));
    return novoFuncionario;
  }
  public Funcionario criarFuncionarioExistente(UUID id, String nome, String sobrenome, String numeroDeTelefone,
                                               String enderecoDeEmail, String rua, String cep, String cargo ) {
    Cargo novoCargo = Cargo.valueOf(cargo);
    Funcionario funcionarioExistente = new Funcionario(new EntityId(id),
            new Nome(nome, sobrenome), novoCargo, new Email(enderecoDeEmail),
            new NumeroDeTelefone(numeroDeTelefone), new Endereco(rua, cep));
    return funcionarioExistente;
  }
}
