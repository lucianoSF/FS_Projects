public class PessoaJuridica extends Pessoa{
    private Integer cnpj;
    private String atividade;

    public PessoaJuridica(Integer id, String nome, String endereco, Integer cnpj, String atividade) {
        super(id, nome, endereco);
        this.cnpj = cnpj;
        this.atividade = atividade;
    }

    public Integer getCnpj() {
        return cnpj;
    }

    public void setCnpj(Integer cnpj) {
        this.cnpj = cnpj;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }
}
