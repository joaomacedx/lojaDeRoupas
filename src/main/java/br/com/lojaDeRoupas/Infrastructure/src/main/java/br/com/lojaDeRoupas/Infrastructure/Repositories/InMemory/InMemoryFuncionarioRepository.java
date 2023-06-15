package br.com.lojaDeRoupas.Infrastructure.Repositories.InMemory;

import br.com.lojaDeRoupas.Domain.Entities.Funcionario;
import br.com.lojaDeRoupas.Domain.Exceptions.EntityAlreadyExistsException;
import br.com.lojaDeRoupas.Domain.Exceptions.EntityNotFoundException;
import br.com.lojaDeRoupas.Domain.Repositories.IFuncionarioRepository;
import br.com.lojaDeRoupas.Domain.ValueObjects.Email;
import br.com.lojaDeRoupas.Domain.ValueObjects.EntityId;

import java.util.List;

public class InMemoryFuncionarioRepository implements IFuncionarioRepository {
  public List<Funcionario> funcionariosInMemory;

  public InMemoryFuncionarioRepository(List<Funcionario> funcionarios) {
    this.funcionariosInMemory = funcionarios;
  }

  public Funcionario FindByEmail(Email email) {
    for(Funcionario funcionarioEncontrado : this.funcionariosInMemory) {
      if(funcionarioEncontrado.email.enderecoDeEmail.equals(email.enderecoDeEmail)) return funcionarioEncontrado;
    }
    throw new EntityNotFoundException("Nao foi encontrado nenhum funcionario cadastrado com o email" + email.enderecoDeEmail );
  }

  public void Save(Funcionario novoFuncionario) {
    for(Funcionario funcionarioExistente : this.funcionariosInMemory) {
      if(funcionarioExistente.email.equals(novoFuncionario.email))
            throw new EntityAlreadyExistsException("Nao foi possivel cadastrar o funcionario, pois o email informado " +
                    "ja esta cadastrado no sistema" + novoFuncionario.email);
    }
    this.funcionariosInMemory.add(novoFuncionario);
  }

  public Funcionario FindById(EntityId idDoFuncionario) {
    for(Funcionario funcionarioEncontrado : this.funcionariosInMemory) {
      if(funcionarioEncontrado.Id.equals(idDoFuncionario)) return funcionarioEncontrado;
    }
    throw new EntityNotFoundException("Nao foi encontrado nenhum funcionario" + idDoFuncionario);
  }

  public void DeleteById(EntityId idFuncionario) {
    for (Funcionario funcionario : funcionariosInMemory) {
      if(funcionario.Id.equals(idFuncionario)) {
        int indexOfToRemove = this.funcionariosInMemory.indexOf(funcionario);
        Funcionario funcionarioDeletado = this.funcionariosInMemory.remove(indexOfToRemove);
        return;
      }   
    }
      throw new EntityNotFoundException("Nao foi possivel encontrar um funcionario com o Id:" + idFuncionario);  
  }

  public List<Funcionario> List() {
    return this.funcionariosInMemory;
  }

}


