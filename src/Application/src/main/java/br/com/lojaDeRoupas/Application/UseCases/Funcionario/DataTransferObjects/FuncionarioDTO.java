package br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects;

public class FuncionarioDTO {
  public String enderecoDeEmail;
  public String nome;
  public String sobrenome;
  public String numeroDeTelefone;
  public String rua;
  public String cep;
  public String cargo;

  public FuncionarioDTO(String enderecoDeEmail, String nome,
                        String sobrenome, String numeroDeTelefone,
                        String rua, String cep, String cargo) {
    this.enderecoDeEmail = enderecoDeEmail;
    this.cargo = cargo;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cep = cep;
    this.rua = rua;
    this.numeroDeTelefone = numeroDeTelefone;
  }
}