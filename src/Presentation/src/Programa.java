package Presentation.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import Application.UseCases.CreateFuncionario.CreateFuncionarioController;
import Application.UseCases.CreateFuncionario.CreateFuncionarioUseCase;
import Application.UseCases.FindByEmail.FindByEmailController;
import Application.UseCases.FindByEmail.FindByEmailUseCase;
import Application.UseCases.ListFuncionarios.ListFuncionariosController;
import Application.UseCases.ListFuncionarios.ListFuncionariosUseCase;
import Domain.Entities.Funcionario;
import Domain.Factories.FuncionarioFactory;
import Domain.Repositories.IFuncionarioRepository;
import Domain.ValueObjects.Cargo;
import Domain.ValueObjects.Email;
import Domain.ValueObjects.Endereco;
import Domain.ValueObjects.Nome;
import Domain.ValueObjects.NumeroDeTelefone;
import Infrastructure.Repositories.InMemory.InMemoryFuncionarioRepository;

public class Programa {
    private static IFuncionarioRepository funcionarioRepository;
    private static FuncionarioFactory funcionarioFactory;
    private static CreateFuncionarioUseCase createFuncionarioUseCase;
    private static CreateFuncionarioController createFuncionarioController;
    private static ListFuncionariosController listFuncionariosController;
    private static ListFuncionariosUseCase listFuncionariosUseCase;
    private static Scanner scanner;
    private static FindByEmailController findByEmailController;
    private static FindByEmailUseCase findByEmailUseCase;
    public void init() {
        initFuncionarioPatterns();
        System.out.println("----------------------------------------------------------------------------------------\n");
        System.out.println("Bem-vindo ao Sistema de Cadastro da nossa Loja de roupas\n");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("Atualmente o nosso sistema e capaz de efetuar as seguintes operaçoes para os funcionarios\n");
        System.out.println("Listar os funcionarios cadastrados - 1\n");
        System.out.println("Cadastrar um funcionario - 2\n");
        System.out.println("Buscar um funcionario pelo email - 3\n");
        System.out.println("Sair - 4\n");
        System.out.println("----------------------------------------------------------------------------------------\n");
        System.out.println("Digite o número da opção desejada:\n");
        Integer opcaoDesejada = scanner.nextInt();
        switch(opcaoDesejada) {
            case 1:
                menuListarFuncionarios();
                digiteAOpcaoDesejada();
            case 2:
                menuCadastrarFuncionario();
                digiteAOpcaoDesejada();
            case 3: 
                buscarFuncionario();
                digiteAOpcaoDesejada();
            case 4:
                sair();
            case 5:
                voltar();
                digiteAOpcaoDesejada();
        }
    }
    public static void casesMenu() {
        digiteAOpcaoDesejada();
        Integer opcaoDesejada = scanner.nextInt();
        switch(opcaoDesejada) {
            case 1:
                menuListarFuncionarios();
                digiteAOpcaoDesejada();
            case 2:
                menuCadastrarFuncionario();
                digiteAOpcaoDesejada();
            case 3: 
                buscarFuncionario();
                digiteAOpcaoDesejada();
            case 4:
                sair();
            case 5:
                voltar();
                digiteAOpcaoDesejada();
        }
        
    }
    public static void digiteAOpcaoDesejada() {
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("1 - Listar os funcionarios cadastrados\n");
        System.out.println("2 - Cadastrar um funcionario\n");
        System.out.println("3 - Buscar um funcionario pelo email\n");
        System.out.println("4 - Voltar para o menu anterior\n");
        voltar();
    }
    public static void menu() {
        System.out.println("----------------------------------------------------------------------------------------\n");
        System.out.println("Bem-vindo ao Sistema de Cadastro da nossa Loja de roupas\n");
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("Atualmente o nosso sistema e capaz de efetuar as seguintes operaçoes para os funcionarios\n");
        System.out.println("Listar os funcionarios cadastrados - 1\n");
        System.out.println("Cadastrar um funcionario - 2\n");
        System.out.println("Buscar um funcionario pelo email - 3\n");
        System.out.println("Sair - 4\n");
        System.out.println("----------------------------------------------------------------------------------------\n");
        System.out.println("Digite o número da opção desejada:\n");
    }
    public static void voltar() {
        menu();
    }
    public static void sair() {
        System.exit(0);
    }
    public static void initFuncionarioPatterns() {
        scanner = new Scanner(System.in);
        cadastrarFuncionariosAutomaticamente();
        funcionarioFactory = new FuncionarioFactory();
        createFuncionarioUseCase = new CreateFuncionarioUseCase(funcionarioRepository, funcionarioFactory);
        createFuncionarioController = new CreateFuncionarioController(createFuncionarioUseCase);
        listFuncionariosUseCase = new ListFuncionariosUseCase(funcionarioRepository);
        listFuncionariosController = new ListFuncionariosController(listFuncionariosUseCase);
        findByEmailUseCase = new FindByEmailUseCase(funcionarioRepository);
        findByEmailController = new FindByEmailController(findByEmailUseCase);
        
    }        
    public static void menuCadastrarFuncionario() {
        System.out.println("Você deseja cadastrar um funcionario?\n Digite 'True' se sim  e 'False' se não");
        Boolean cadastrarFuncionario = scanner.nextBoolean();
        if(cadastrarFuncionario) {
            createFuncionarioController.handle();
        } 
    }
    public static void buscarFuncionario() {
        System.out.println("Você deseja buscar um funcionario pelo email?\n Digite 'True' se sim  e 'False' se não");
        Boolean buscarPeloEmail = scanner.nextBoolean();
        if(buscarPeloEmail) {
            findByEmailController.handle();
        } 
    }

    public static void menuListarFuncionarios() {
        System.out.println("Você deseja listar os funcionarios cadastrados?\n Digite 'True' se sim  e 'False' se não");
        Boolean listarFuncionarios = scanner.nextBoolean();
        if(listarFuncionarios){
            listFuncionariosController.handle();
        } 
    }
    public static void cadastrarFuncionariosAutomaticamente() {
        List<Funcionario> funcionariosPreCadastrados = new ArrayList<Funcionario>();
        Funcionario funcionarioUm = new Funcionario(UUID.randomUUID(),
             new Nome("Gabriel", "Macedo"),
             Cargo.Gerente, new Email("joaomacedo1234@email.com"), new NumeroDeTelefone("12345678"),
             new Endereco("Rua das babilonia",
             "987654321"));
        Funcionario funcionarioDois= new Funcionario(UUID.randomUUID(),
             new Nome("Fernando", "Pereira"),
             Cargo.Vendedor, new Email("fernandoPereira1234@email.com"), new NumeroDeTelefone("12345678"),
             new Endereco("Rua das margaridas",
             "123425"));
        Funcionario funcionarioTres= new Funcionario(UUID.randomUUID(),
             new Nome("Leonardo", "Miranda"),
             Cargo.Vendedor, new Email("leonardoMiranda1234@email.com"), new NumeroDeTelefone("989737734"),
             new Endereco("Rua das garpas",
             "786545"));
         Funcionario funcionarioQuatro= new Funcionario(UUID.randomUUID(),
             new Nome("Erlon", "Silva"),
             Cargo.Vendedor, new Email("erlonsilva1234@email.com"), new NumeroDeTelefone("9876273334"),
             new Endereco("Rua das Pedras",
             "2256667"));
        Funcionario funcionarioCinco= new Funcionario(UUID.randomUUID(),
             new Nome("Maria", "Celia"),
             Cargo.Vendedor, new Email("MariaCelia1234@email.com"), new NumeroDeTelefone("987545234"),
             new Endereco("Rua das araguais",
             "0098732"));
        Funcionario funcionarioSeis= new Funcionario(UUID.randomUUID(),
             new Nome("Micheli", "Macedo"),
             Cargo.Vendedor, new Email("MicheliMacedo1234@email.com"), new NumeroDeTelefone("098676121"),
             new Endereco("Rua das glorias",
             "098763445"));
        Funcionario funcionarioSete= new Funcionario(UUID.randomUUID(),
             new Nome("Mateus", "Fernandes"),
             Cargo.Vendedor, new Email("MateusFernandes1234@email.com"), new NumeroDeTelefone("096541234"),
             new Endereco("Rua das fernandas",
             "000998834"));
        funcionariosPreCadastrados.add(funcionarioUm);
        funcionariosPreCadastrados.add(funcionarioDois);
        funcionariosPreCadastrados.add(funcionarioTres);
        funcionariosPreCadastrados.add(funcionarioQuatro);
        funcionariosPreCadastrados.add(funcionarioCinco);
        funcionariosPreCadastrados.add(funcionarioSeis);
        funcionariosPreCadastrados.add(funcionarioSete);
        funcionarioRepository = new InMemoryFuncionarioRepository(funcionariosPreCadastrados);
    }
        
    }
