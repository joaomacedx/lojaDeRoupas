package br.com.lojaDeRoupas.Application.UseCases.Funcionario.CreateFuncionario;

import br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects.FuncionarioDTO;

public class CreateFuncionarioController {
  private CreateFuncionarioUseCase createFuncionarioUseCase;
  private CreateFuncionarioController(CreateFuncionarioUseCase createFuncionarioUseCase) {
    this.createFuncionarioUseCase = createFuncionarioUseCase;
  }
  public void Handle(String enderecoDeEmail, String nome, String sobrenome, String numeroDeTelefone, String rua, String cep, String cargo) {
    FuncionarioDTO dadosDoFuncionarioParaEfetuarOCadastro = new FuncionarioDTO(enderecoDeEmail, nome, sobrenome, numeroDeTelefone, rua, cep, cargo);
    this.createFuncionarioUseCase.Execute(dadosDoFuncionarioParaEfetuarOCadastro);
  }
}
