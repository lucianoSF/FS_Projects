package br.ufg.inf.fs.entities;

public class Hospede {
    private Integer idHospede;
    private String nmHospede;
    private String dtNascimento;
    private Integer cpf;

    public Hospede() {super();}

    public Hospede(Integer idHospede, String nmHospede, String dtNascimento, Integer cpf) {
        super();
        this.idHospede = idHospede;
        this.nmHospede = nmHospede;
        this.dtNascimento = dtNascimento;
        this.cpf = cpf;
    }

    public Integer getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Integer idHospede) {
        this.idHospede = idHospede;
    }

    public String getNmHospede() {
        return nmHospede;
    }

    public void setNmHospede(String nmHospede) {
        this.nmHospede = nmHospede;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "idHospede=" + idHospede +
                ", nmHospede='" + nmHospede + '\'' +
                ", dtNascimento='" + dtNascimento + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
