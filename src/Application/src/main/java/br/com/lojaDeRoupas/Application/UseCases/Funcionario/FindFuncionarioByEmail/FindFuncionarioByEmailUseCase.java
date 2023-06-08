package br.com.lojaDeRoupas.Application.UseCases.Funcionario.FindFuncionarioByEmail;

import br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects.EmailDTO;
import br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects.FuncionarioEncontradoDTO;
import br.com.lojaDeRoupas.Domain.Entities.Funcionario;
import br.com.lojaDeRoupas.Domain.Repositories.IFuncionarioRepository;
import br.com.lojaDeRoupas.Domain.ValueObjects.Email;

public class FindFuncionarioByEmailUseCase {
  private IFuncionarioRepository funcionarioRepository;
  public FindFuncionarioByEmailUseCase(IFuncionarioRepository funcionarioRepository) {
    this.funcionarioRepository = funcionarioRepository;
  }

  public FuncionarioEncontradoDTO execute(EmailDTO emailDTO) {
    try{
      Funcionario funcionarioEncontrado = this.funcionarioRepository.FindByEmail(new Email(emailDTO.email));
      FuncionarioEncontradoDTO funcionarioFoundDTO = new FuncionarioEncontradoDTO(funcionarioEncontrado.email.enderecoDeEmail,
              funcionarioEncontrado.nome.nome, funcionarioEncontrado.nome.sobrenome,
              funcionarioEncontrado.numeroDeTelefone.numeroDeTelefone, funcionarioEncontrado.cargo.toString());
      return funcionarioFoundDTO;
    } catch (Exception ex) {
      throw new Error(ex.getMessage());
    }

  }
}
