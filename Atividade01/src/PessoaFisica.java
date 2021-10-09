import java.util.Calendar;

public class PessoaFisica extends Pessoa{
    private Integer cpf;
    private Calendar dtNascimento;
    private String genero;

    public PessoaFisica(Integer id, String nome, String endereco, Integer cpf, Calendar dtNascimento, String genero) {
        super(id, nome, endereco);
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.genero = genero;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Calendar getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Calendar dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getIdade(){
        Calendar dateNow = Calendar.getInstance();
        return dateNow.get(Calendar.YEAR) - this.dtNascimento.get(Calendar.YEAR);
    }


}
