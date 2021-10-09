import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private Integer id;
    private String nome;
    private String endereco;
    private List<Conta> listConta = new ArrayList<>();

    public Pessoa(Integer id, String nome, String endereco){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void addConta(Conta conta){
        this.listConta.add(conta);
    }

    public List<Conta> getListConta() {
        return listConta;
    }
}
