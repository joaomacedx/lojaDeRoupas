package br.com.lojaDeRoupas.Application.UseCases.Funcionario.FindFuncionarioByEmail;

import br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects.EmailDTO;
import br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects.FuncionarioEncontradoDTO;

public class FindFuncionarioByEmailController {
  private FindFuncionarioByEmailUseCase findFuncionarioByEmailUseCase;
  public FindFuncionarioByEmailController(FindFuncionarioByEmailUseCase findFuncionarioByEmailUseCase) {
    this.findFuncionarioByEmailUseCase = findFuncionarioByEmailUseCase;
  }
  public FuncionarioEncontradoDTO Handle(String enderecoDeEmail) {
    FuncionarioEncontradoDTO funcionarioEncontrado = this.findFuncionarioByEmailUseCase.execute(new EmailDTO(enderecoDeEmail));
    return funcionarioEncontrado;
  }
}
