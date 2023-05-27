package Application.UseCases.FindByEmail;

import java.util.Scanner;

import Application.DataTransferObjects.FuncionarioEmailDTO;
import Application.DataTransferObjects.FuncionarioFoundDTO;

public class FindByEmailController {
    private FindByEmailUseCase findByEmailUseCase;
    public FindByEmailController(FindByEmailUseCase findByEmailUseCase) {
        this.findByEmailUseCase = findByEmailUseCase;
    }
    public void handle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite o endereco de email do usuario que deseja buscar\n");
        String email = scanner.nextLine();
        FuncionarioFoundDTO funcionarioEncontradoDTO =  this.findByEmailUseCase.execute(new FuncionarioEmailDTO(email));
        System.out.println("\n------------------------------------------\n");
        System.out.println("Funcionario: " + funcionarioEncontradoDTO.nome + "\n");
        System.out.println("Sobrenome: " + funcionarioEncontradoDTO.sobrenome + "\n");
        System.out.println("Cargo: " + funcionarioEncontradoDTO.cargo + "\n");
        System.out.println("Email: " + funcionarioEncontradoDTO.enderecoDeEmail + "\n");
        System.out.println("Telefone: " + funcionarioEncontradoDTO.numeroDeTelefone + "\n");
        System.out.println("\n--------------------------------------------\n");
        scanner.close();
    }
}
