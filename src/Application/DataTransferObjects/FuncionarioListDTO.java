package Application.DataTransferObjects;

public class FuncionarioListDTO {
    public String enderecoDeEmail;
    public String nome;
    public String cargo;
    public FuncionarioListDTO(String nome, String cargo, String enderecoDeEmail) {
        this.enderecoDeEmail = enderecoDeEmail;
        this.cargo = cargo;
        this.nome = nome;
    }
}
