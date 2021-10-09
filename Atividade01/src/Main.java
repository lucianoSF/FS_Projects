import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(1996,Calendar.JANUARY,31);

        PessoaFisica p_fis = new PessoaFisica(1, "joao", "endereco1", 14, c, "masc");

        PessoaJuridica p_jur = new PessoaJuridica(2, "Empresa x", "endereco2", 15, "TI");

        List<Pessoa> listPessoa = new ArrayList<>();


        ContaPoupanca conta1 = new ContaPoupanca();
        conta1.abrirConta(p_fis, 1111, 14.50);
        p_fis.addConta(conta1);

        ContaEspecial conta2 = new ContaEspecial();
        conta2.abrirConta(p_fis, 1112, 1000.0);
        p_fis.addConta(conta2);

        ContaPoupanca conta3 = new ContaPoupanca();
        conta3.abrirConta(p_jur, 1113, 200.0);
        p_jur.addConta(conta3);

        ContaPoupanca conta4 = new ContaPoupanca();
        conta4.abrirConta(p_jur, 1114, 1600.0);
        p_jur.addConta(conta4);
        

        listPessoa.add(p_fis);
        listPessoa.add(p_jur);

        exibirContas(listPessoa);


    }
    public static void exibirContas(List<Pessoa> listPessoa){
        for(int i = 0; i<listPessoa.size(); i++){
            List<Conta> listContas = listPessoa.get(i).getListConta();
            Double saldoTotal = 0.0;
            for(int j = 0; j<listContas.size(); j++){
                System.out.println("Nome: " + listPessoa.get(i).getNome() + "   Numero da conta: " + listContas.get(j).getNrConta() + "   Saldo: " + listContas.get(j).getSaldo());
                saldoTotal += listContas.get(j).getSaldo();
            }
            System.out.println("Total: " + saldoTotal + "\n");
        }

    }
}
