package br.com.lojaDeRoupas.Application.UseCases.Funcionario.ListFuncionariosCadastrados;

import br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects.ListFuncionarioDTO;
import br.com.lojaDeRoupas.Domain.Entities.Funcionario;
import br.com.lojaDeRoupas.Domain.Repositories.IFuncionarioRepository;

import java.util.ArrayList;
import java.util.List;

public class ListFuncionariosCadastradosUseCase {
  private IFuncionarioRepository funcionarioRepository;
  public ListFuncionariosCadastradosUseCase(IFuncionarioRepository funcionarioRepository) {
    this.funcionarioRepository = funcionarioRepository;
  }
  public List<ListFuncionarioDTO> Execute() {
    try {
      List<Funcionario> listFuncionarios = this.funcionarioRepository.List();
      List<ListFuncionarioDTO> listFuncionarioDTO = new ArrayList<ListFuncionarioDTO>();
      for(Funcionario funcionario : listFuncionarios) {
        ListFuncionarioDTO dto = new ListFuncionarioDTO(funcionario.nome.nome, funcionario.cargo.toString(), funcionario.email.enderecoDeEmail);
        listFuncionarioDTO.add(dto);
      }
      return listFuncionarioDTO;
    } catch (Exception ex) {
      throw new Error(ex.getMessage());
    }
  }
}
