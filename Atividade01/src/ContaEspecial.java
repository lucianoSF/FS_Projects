public class ContaEspecial extends Conta{
    private Double limite;

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
    protected Boolean temSaldo(Double valor){
        return super.temSaldo(valor);
    }
    public void abrirConta(PessoaFisica cliente, Integer nrConta, Double saldo){
        super.abrirConta(cliente, nrConta, saldo);
    }
    public void abrirConta(PessoaJuridica cliente, Integer nrConta, Double saldo){
        super.abrirConta(cliente, nrConta, saldo);
    }

}
