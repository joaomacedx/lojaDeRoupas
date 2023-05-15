package Domain.Entities;
import java.util.UUID;


import Domain.ValueObjects.Nome;

public class Funcionario {
    private UUID Id;
    private Nome nome;

    public Funcionario(UUID id, Nome nome) {
        this.Id = id;
        this.nome = nome;
    }
}
