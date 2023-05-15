package Domain.ValueObjects;

public class Endereco {
    public String rua;
    public Integer numero; 
    public String cep; 
    public String complemento;
    public Endereco(String rua, Integer numero, String cep, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
    }
}
