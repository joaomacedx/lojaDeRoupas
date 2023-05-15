package Infrastructure.Repositories.InMemory;

import java.util.UUID;

import Domain.Entities.Funcionario;
import Domain.Repositories.IFuncionarioRepository;
import Domain.ValueObjects.Email;

public class InMemoryFuncionarioRepository implements IFuncionarioRepository {

    public Funcionario findByEmail(Email email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
    public void Save(Funcionario novoFuncionario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Save'");
    }
    public Funcionario findById(UUID idDoFuncionario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    public void Delete(Funcionario funcionarioParaDeletar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Delete'");
    }
    
}
