package Application.UseCases.CreateFuncionario;


import Application.DataTransferObjects.FuncionarioDTO;
import Domain.Entities.Funcionario;
import Domain.Factories.FuncionarioFactory;
import Domain.Repositories.IFuncionarioRepository;

public class CreateFuncionarioUseCase {
    private IFuncionarioRepository funcionarioRepository; 
    private FuncionarioFactory funcionarioFactory;
    
    public CreateFuncionarioUseCase(IFuncionarioRepository funcionarioRepository, FuncionarioFactory funcionarioFactory) {
        this.funcionarioFactory = funcionarioFactory;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void execute(FuncionarioDTO dto) {
        try{
            Funcionario novoFuncionario = this.funcionarioFactory.criarNovoFuncionario(dto.nome, dto.sobrenome, 
            dto.numeroDeTelefone, dto.enderecoDeEmail, dto.rua, dto.cep, dto.cargo);
            this.funcionarioRepository.Save(novoFuncionario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
