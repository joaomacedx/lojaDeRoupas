package Application.UseCases.CreateFuncionario;

import java.util.Scanner;

import Application.DataTransferObjects.FuncionarioDTO;

public class CreateFuncionarioController {

    private CreateFuncionarioUseCase funcionarioUseCase;
    public CreateFuncionarioController(CreateFuncionarioUseCase funcionarioUseCase) {
        this.funcionarioUseCase = funcionarioUseCase;
    }
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do funcionario a ser cadastrado");
        String nome = scanner.nextLine();
        System.out.println("Informe o sobrenome do funcionario a ser cadastrado");
        String sobrenome = scanner.nextLine();
        System.out.println("Informe o email do funcionario a ser cadastrado");
        String email = scanner.nextLine();
        System.out.println("Informe o cargo do funcionario a ser cadastrado");
        String cargo = scanner.nextLine();
        System.out.println("Informe o numero de telefone do funcionario a ser cadastrado");
        String numeroDeTelefone = scanner.nextLine();
        System.out.println("Informe a rua onde funcionario a ser cadastrado mora");
        String rua = scanner.nextLine();
        System.out.println("Informe o cep da rua do funcionario a ser cadastrado");
        String cep = scanner.nextLine();
        FuncionarioDTO dto = new FuncionarioDTO(email, nome, sobrenome, numeroDeTelefone, rua, cep, cargo);
        this.funcionarioUseCase.execute(dto);
        scanner.close();
    }
}
