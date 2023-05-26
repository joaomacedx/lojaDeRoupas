package Application.UseCases.FindByEmail;

import Application.DataTransferObjects.FuncionarioEmailDTO;
import Application.DataTransferObjects.FuncionarioFoundDTO;
import Domain.Entities.Funcionario;
import Domain.Repositories.IFuncionarioRepository;
import Domain.ValueObjects.Email;

public class FindByEmailUseCase {
    private IFuncionarioRepository funcionarioRepository; 
    public FindByEmailUseCase(IFuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = this.funcionarioRepository;
    }

    public FuncionarioFoundDTO execute(FuncionarioEmailDTO emailDTO) {
        Funcionario funcionarioEncontrado = this.funcionarioRepository.findByEmail(new Email(emailDTO.email));
        FuncionarioFoundDTO funcionarioFoundDTO = new FuncionarioFoundDTO(funcionarioEncontrado.email.enderecoDeEmail,
            funcionarioEncontrado.nome.nome, funcionarioEncontrado.nome.sobrenome,
            funcionarioEncontrado.numeroDeTelefone.numeroDeTelefone, funcionarioEncontrado.cargo.toString());
        return funcionarioFoundDTO;
    }
}
