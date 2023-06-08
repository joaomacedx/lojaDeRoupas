package br.com.lojaDeRoupas.Domain.Repositories;

import java.util.List;

import br.com.lojaDeRoupas.Domain.Entities.Funcionario;
import br.com.lojaDeRoupas.Domain.ValueObjects.Email;
import br.com.lojaDeRoupas.Domain.ValueObjects.EntityId;

public interface IFuncionarioRepository {
  public Funcionario FindByEmail(Email email);
  public void Save(Funcionario novoFuncionario);
  public Funcionario FindById(EntityId idDoFuncionario);
  public void Delete(Funcionario funcionarioParaDeletar);
  public List<Funcionario> List();
}
