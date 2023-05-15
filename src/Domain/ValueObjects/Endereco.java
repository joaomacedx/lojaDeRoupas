package Domain.ValueObjects;

public class Endereco {
    private String rua;
    private Integer numero; 
    private String cep; 
    private String complemento;
    public Endereco(String rua, Integer numero, String cep, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }
}
