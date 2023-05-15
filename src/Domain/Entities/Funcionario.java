package Domain.Entities;
import java.util.UUID;

import Domain.ValueObjects.Cargo;
import Domain.ValueObjects.Nome;

public class Funcionario {
    public UUID Id;
    public Nome nome;
    public Cargo cargo;

    public Funcionario(UUID id, Nome nome, Cargo cargo) {
        this.Id = id;
        this.nome = nome;
        this.cargo = cargo;
    }
}
