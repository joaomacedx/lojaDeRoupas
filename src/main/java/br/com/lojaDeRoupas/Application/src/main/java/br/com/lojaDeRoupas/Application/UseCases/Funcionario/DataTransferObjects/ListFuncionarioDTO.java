package br.com.lojaDeRoupas.Application.UseCases.Funcionario.DataTransferObjects;

public class ListFuncionarioDTO {
    public String enderecoDeEmail;
    public String nome;
    public String cargo;
    public ListFuncionarioDTO(String nome, String cargo, String enderecoDeEmail) {
      this.enderecoDeEmail = enderecoDeEmail;
      this.cargo = cargo;
      this.nome = nome;
    }
  }

