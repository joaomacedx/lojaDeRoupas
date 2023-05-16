package Infrastructure.Repositories.InMemory;

import java.util.List;
import java.util.UUID;

import Domain.Entities.Funcionario;
import Domain.Repositories.IFuncionarioRepository;
import Domain.ValueObjects.Email;

public class InMemoryFuncionarioRepository implements IFuncionarioRepository {
    public List<Funcionario> funcionariosInMemory;

    public InMemoryFuncionarioRepository(List<Funcionario> funcionarios) {
        this.funcionariosInMemory = funcionarios;
    }
    public Funcionario findByEmail(Email email) {
        for(Funcionario funcionarioEncontrado : this.funcionariosInMemory) {
            if(funcionarioEncontrado.email.enderecoDeEmail.equals(email.enderecoDeEmail)) return funcionarioEncontrado;
        }
        throw new Error("Nao foi não encontrado nenhum cadastrado funcionario com o email" + email.enderecoDeEmail );
    }
    public void Save(Funcionario novoFuncionario) {
       for(Funcionario funcionarioExiste : this.funcionariosInMemory) {
            if(funcionarioExiste.equals(novoFuncionario)) throw new Error("Nao e possível salva um funcionario existente");
       }
       this.funcionariosInMemory.add(novoFuncionario);
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
