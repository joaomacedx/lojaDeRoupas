package br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects;

public class FuncionarioEncontradoDTO {
  public String enderecoDeEmail;
  public String nome;
  public String sobrenome;
  public String numeroDeTelefone;
  public String cargo;
  public FuncionarioEncontradoDTO (String enderecoDeEmail, String nome,
                             String sobrenome, String numeroDeTelefone, String cargo) {
    this.enderecoDeEmail = enderecoDeEmail;
    this.cargo = cargo;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.numeroDeTelefone = numeroDeTelefone;
  }
}
