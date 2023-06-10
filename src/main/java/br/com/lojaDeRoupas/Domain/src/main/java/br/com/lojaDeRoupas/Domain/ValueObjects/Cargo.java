package br.com.lojaDeRoupas.Domain.ValueObjects;

public enum Cargo {
  Gerente {
    public String toString(){
      return "Gerente";
    }
  },
  Balconista{
    public String toString(){
      return "Balconista";
    }
  },
  Vendedor{
    public String toString(){
      return "Vendedor";
    }
  }
}
