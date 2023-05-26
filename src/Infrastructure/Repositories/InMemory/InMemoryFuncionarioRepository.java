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
        throw new Error("Nao foi encontrado nenhum cadastrado funcionario com o email" + email.enderecoDeEmail );
    }
    public void Save(Funcionario novoFuncionario) {
       for(Funcionario funcionarioExiste : this.funcionariosInMemory) {
            if(funcionarioExiste.equals(novoFuncionario)) throw new Error("Nao e possível salva um funcionario existente");
       }
       this.funcionariosInMemory.add(novoFuncionario);
    }
    public Funcionario findById(UUID idDoFuncionario) {
        for(Funcionario funcionarioEncontrado : this.funcionariosInMemory) {
            if(funcionarioEncontrado.Id.equals(idDoFuncionario)) return funcionarioEncontrado;
        }
        throw new Error("Nao foi encontrado nenhum funcionario com o id" + idDoFuncionario);
    }
    public void Delete(Funcionario funcionarioParaDeletar) {
        if(!this.funcionariosInMemory.removeIf(funcionario -> funcionario.Id == funcionarioParaDeletar.Id)) 
            throw new Error("Nao e possivel deletar um funcionario inexistente");       
    }
    public List<Funcionario> List() {
       return this.funcionariosInMemory;
    }
}

