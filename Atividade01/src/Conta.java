public class Conta {
    private Pessoa cliente;
    private Integer nrConta;
    private Double saldo;

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Integer getNrConta() {
        return nrConta;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void abrirConta(Pessoa cliente, Integer nrConta, Double saldo){
        this.cliente = cliente;
        this.nrConta = nrConta;
        this.saldo = saldo;
    }
    public void sacar(Double valor){
        if(temSaldo(valor)){
            this.saldo = this.saldo - valor;
            System.out.println("Valor " + valor + " sacado com sucesso!");
        }else{
            System.out.println("Saldo indisponível!");
        }
    }
    private void debitar(Double valor){
        if(temSaldo(valor)){
            this.saldo = this.saldo - valor;
            System.out.println("Valor " + valor + " debitado com sucesso!");
        }else{
            System.out.println("Saldo indisponível!");
        }
    }
    protected Boolean temSaldo(Double valor){
        return this.saldo >= valor;
    }
    public void depositar(Double valor){
        this.saldo = this.saldo + valor;
    }
    public void transferir(Double valor, Conta conta2){
        if(temSaldo(valor)){
            this.debitar(valor);
            conta2.depositar(valor);
            System.out.println("Valor " + valor + " transferido com sucesso!");

        }else{
            System.out.println("Saldo indisponível!");
        }

    }
}
