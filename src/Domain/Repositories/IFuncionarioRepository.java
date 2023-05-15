 package Domain.Repositories;

import java.util.UUID;

import Domain.Entities.Funcionario;
import Domain.ValueObjects.Email;

public interface IFuncionarioRepository {
    public Funcionario findByEmail(Email email);
    public void Save(Funcionario novoFuncionario);
    public Funcionario findById(UUID idDoFuncionario);
    public void Delete(Funcionario funcionarioParaDeletar);   
}