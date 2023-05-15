package Domain.Entities;
import java.util.UUID;

import Domain.ValueObjects.Cargo;
import Domain.ValueObjects.Email;
import Domain.ValueObjects.Endereco;
import Domain.ValueObjects.Nome;
import Domain.ValueObjects.NumeroDeTelefone;

public class Funcionario {
    public UUID Id;
    public Nome nome;
    public Cargo cargo;
    public Email email;
    public NumeroDeTelefone numeroDeTelefone;
    public Endereco endereco;

    public Funcionario(UUID id, Nome nome, Cargo cargo, Email email, NumeroDeTelefone numeroDeTelefone, Endereco endereco) {
        this.Id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.endereco = endereco;
    }
}
