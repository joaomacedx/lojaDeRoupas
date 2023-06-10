package br.com.lojaDeRoupas.Application.UseCases.Funcionario.CreateFuncionario;

import br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects.FuncionarioDTO;
import br.com.lojaDeRoupas.Domain.Entities.Funcionario;
import br.com.lojaDeRoupas.Domain.Factories.FuncionarioFactory;
import br.com.lojaDeRoupas.Domain.Repositories.IFuncionarioRepository;

public class CreateFuncionarioUseCase {
  private IFuncionarioRepository funcionarioRepository;
  private FuncionarioFactory funcionarioFactory;

  public CreateFuncionarioUseCase(IFuncionarioRepository funcionarioRepository, FuncionarioFactory funcionarioFactory) {
    this.funcionarioFactory = funcionarioFactory;
    this.funcionarioRepository = funcionarioRepository;
  }
  public void Execute(FuncionarioDTO dto) {
    try {
      Funcionario novoFuncionario = this.funcionarioFactory.criarNovoFuncionario(dto.nome, dto.sobrenome,
              dto.numeroDeTelefone, dto.enderecoDeEmail, dto.rua, dto.cep, dto.cargo);
      this.funcionarioRepository.Save(novoFuncionario);
    } catch (Exception ex) {
        throw new Error(ex.getMessage());
    }
  }
}
