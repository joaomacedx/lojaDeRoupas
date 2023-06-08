package br.com.lojaDeRoupas.Domain.ValueObjects;

public class Endereco {
  public String rua;
  public String cep;
  public Endereco(String rua, String cep) {
    this.rua = rua;
    this.cep = cep;
  }
}
