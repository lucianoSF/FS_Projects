public class ContaPoupanca extends Conta{
    private Double txCorrecao;

    public Double getTxCorrecao() {
        return txCorrecao;
    }

    public void setTxCorrecao(Double txCorrecao) {
        this.txCorrecao = txCorrecao;
    }

    public void atualizaSaldoRendimento(){
        Double saldo = super.getSaldo();
        super.depositar(saldo*(this.txCorrecao/100));
    }
    public void abrirConta(PessoaFisica cliente, Integer nrConta, Double saldo){
        super.abrirConta(cliente, nrConta, saldo);
    }
    public void abrirConta(PessoaJuridica cliente, Integer nrConta, Double saldo){
        super.abrirConta(cliente, nrConta, saldo);
    }
}
