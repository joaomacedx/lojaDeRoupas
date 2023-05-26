package Application.UseCases.ListFuncionarios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.FocusManager;

import Application.DataTransferObjects.FuncionarioListDTO;
import Domain.Entities.Funcionario;
import Domain.Repositories.IFuncionarioRepository;

public class ListFuncionariosUseCase {
    private IFuncionarioRepository funcionarioRepository; 
    
    public ListFuncionariosUseCase(IFuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    public List<FuncionarioListDTO> execute(){
        List<Funcionario> listFuncionarios = this.funcionarioRepository.List();
        List<FuncionarioListDTO> listFuncionarioDTO = new ArrayList<FuncionarioListDTO>();
        for(Funcionario funcionario : listFuncionarios) {
            FuncionarioListDTO dto = new FuncionarioListDTO(funcionario.nome.nome, funcionario.cargo.toString(), funcionario.email.enderecoDeEmail);
            listFuncionarioDTO.add(dto);
        }
        return listFuncionarioDTO;
    }
}
