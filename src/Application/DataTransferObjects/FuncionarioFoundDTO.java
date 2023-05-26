package Application.DataTransferObjects;

public class FuncionarioFoundDTO {
    public String enderecoDeEmail;
    public String nome;
    public String sobrenome;
    public String numeroDeTelefone;
    public String cargo;
    public FuncionarioFoundDTO(String enderecoDeEmail, String nome,
    String sobrenome, String numeroDeTelefone, String cargo) {
        this.enderecoDeEmail = enderecoDeEmail;
        this.cargo = cargo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroDeTelefone = numeroDeTelefone;
}
}
