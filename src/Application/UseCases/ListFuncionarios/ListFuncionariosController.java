package Application.UseCases.ListFuncionarios;

import java.util.List;

import Application.DataTransferObjects.FuncionarioListDTO;

public class ListFuncionariosController {
    private ListFuncionariosUseCase funcionariosUseCase;

    public ListFuncionariosController(ListFuncionariosUseCase funcionariosUseCase) {
        this.funcionariosUseCase = funcionariosUseCase;
    }
    public void handle() {
      List<FuncionarioListDTO> funcionariosToList = funcionariosUseCase.execute();
      for(FuncionarioListDTO funcionarioDTO : funcionariosToList) {
        System.out.println("------------------------------------------\n");
        System.out.println("Funcionario: " + funcionarioDTO.nome + "\n");
        System.out.println("Cargo: " + funcionarioDTO.cargo + "\n");
        System.out.println("Email: " + funcionarioDTO.enderecoDeEmail + "\n");
        System.out.println("--------------------------------------------\n");
      }
    }
}
