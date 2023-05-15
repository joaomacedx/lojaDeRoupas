package Application;

import java.util.UUID;

import Domain.Entities.Funcionario;
import Domain.ValueObjects.Cargo;
import Domain.ValueObjects.Nome;

public class Programa {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Funcionario f1 = new Funcionario(UUID.randomUUID(), new Nome("João", "Macêdo"), Cargo.Gerente);
        System.out.println(f1.nome.nome + "\n" + f1.nome.sobrenome+ "\n" + f1.cargo.toString() + "\n" +  f1.Id);
    }
}
