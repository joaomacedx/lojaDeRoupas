package br.com.lojaDeRoupas.Domain.Entities;

import br.com.lojaDeRoupas.Domain.ValueObjects.Cargo;
import br.com.lojaDeRoupas.Domain.ValueObjects.Endereco;
import br.com.lojaDeRoupas.Domain.ValueObjects.EntityId;
import br.com.lojaDeRoupas.Domain.ValueObjects.Nome;
import br.com.lojaDeRoupas.Domain.ValueObjects.Email;
import br.com.lojaDeRoupas.Domain.ValueObjects.NumeroDeTelefone;

public class Funcionario {
  public EntityId Id;
  public Nome nome;
  public Cargo cargo;
  public Email email;
  public NumeroDeTelefone numeroDeTelefone;
  public Endereco endereco;
  public Funcionario(EntityId id, Nome nome, Cargo cargo, Email email, NumeroDeTelefone numeroDeTelefone, Endereco endereco) {
    this.Id = id;
    this.nome = nome;
    this.cargo = cargo;
    this.email = email;
    this.numeroDeTelefone = numeroDeTelefone;
    this.endereco = endereco;
  }
}
