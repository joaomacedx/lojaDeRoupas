package br.com.lojaDeRoupas.Application.UseCases.Funcionario.ListFuncionariosCadastrados;
import java.util.List;
import br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects.ListFuncionarioDTO;

public class ListFuncionariosCadastradosController {
  private ListFuncionariosCadastradosUseCase listFuncionariosCadastradosUseCase;
  public ListFuncionariosCadastradosController(ListFuncionariosCadastradosUseCase listFuncionariosCadastradosUseCase) {
    this.listFuncionariosCadastradosUseCase = listFuncionariosCadastradosUseCase;
  }
  public List<ListFuncionarioDTO> Handle() {
    List<ListFuncionarioDTO> funcionariosToList = listFuncionariosCadastradosUseCase.Execute();
    return  funcionariosToList;
  }
}
