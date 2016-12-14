package views;

import banco.BancoDadosLanchonete;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Lanche;
import models.Venda;
import views.LancheView;

public class VendaView {

    Scanner scan = new Scanner(System.in);

    DecimalFormat df = new DecimalFormat("#.00");

    private void clienteCadastrado() {
        Venda v = new Venda();
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o codigo do cliente: ");
        int codCliente = scan.nextInt();
        scan.nextLine();

        Cliente c = controllers.ClientesController.buscarPorCodigo(codCliente);

        if (c != null) {

            v.setCliente(c);
            //fazerPedido(v);

            int codLanche = 0;
            do {
                System.out.print("Digite o codigo do lanche: ");
                codLanche = scan.nextInt();
                scan.nextLine();

                Lanche l = controllers.LanchesController.buscarPorCodigo(codLanche);

                if (l != null) {

                    v.setCliente(c);
                    //fazerPedido(v);

                    v.setCliente(c);
                    v.getLanches().add(l);

                    BancoDadosLanchonete.getTabelaVenda().add(v);
                    System.out.println("Compra realizada com sucesso!");
                } else {
                    System.out.println("Lanche não cadastrado");
                }

            } while (codLanche != 0);

        } else {
            System.out.println("Cliente não cadastrado");
        }

    }

    private int Menu() {
        System.out.println("");
        exibirLanches();
        System.out.println("");
        System.out.println("----------LANCHES----------");
        System.out.println("1 - Efetuar venda");
        System.out.println("2 - Voltar");
        System.out.print("Informe a opção desejada: ");
        int op = scan.nextInt();
        scan.nextLine();

        return op;
    }

    public void exibirMenuVendas() {
        int opcao;
        do {
            opcao = Menu();

            switch (opcao) {
                case 1:
                    //clienteCadastrado();
                    criarVenda();
                    break;
            }
        } while (opcao != 2);
    }

    private void exibirLanches() {
        System.out.println("---");

        for (Lanche l : BancoDadosLanchonete.getTabelaLanche()) {
            System.out.println("");
            System.out.println("Codigo lanche: " + l.getCodigo());
            System.out.println("Nome lanche: " + l.getNome());
            System.out.println("Preço lanche: R$ " + l.getPreco());
            System.out.println("");
        }
        System.out.println("---");
    }
    
    public void totVenda(){
        /*double totVenda = 0;
        totVenda = totVenda + v.
        for (Venda v : BancoDadosLanchonete.getTabelaVenda()) {
            System.out.println("");
            
            System.out.println("");
        }*/
        
    }

    public void criarVenda() {
        //Se o se identiificar 10% desconto, senao faz a compra normal

        // cadastrar cliente ou nao
        Venda v = new Venda();
        System.out.print("Deseja se identificar? (S=1 / N=0): ");
        int opcao = scan.nextInt();
        scan.nextLine();
        if (opcao == 1) {

            //se o cliente tem cadastro, pesquisa por codigo
            Scanner scan = new Scanner(System.in);
            System.out.print("Digite o codigo do cliente: ");
            int codCliente = scan.nextInt();
            scan.nextLine();
            Cliente c = controllers.ClientesController.buscarPorCodigo(codCliente);
            if (c != null) {
                v.setCliente(c);
                fazerPedido(v, opcao);
            }
        } else if (opcao == 0) {

            fazerPedido(v, opcao);
            //v.setCliente();
        }
    }

    private double fazerPedido(Venda v, int opcao) {

        double totalVenda = 0;

        int codLanche = 0;
        do {
            System.out.print("Digite o codigo do lanche: ");
            codLanche = scan.nextInt();
            scan.nextLine();

            Lanche l = controllers.LanchesController.buscarPorCodigo(codLanche);

            if (l != null) {
                totalVenda = totalVenda + l.getPreco();
                v.getLanches().add(l);

                BancoDadosLanchonete.getTabelaVenda().add(v);
            } else {
                System.out.println("Lanche não cadastrado");
            }
        } while (codLanche != 0);
        
        if (v.getCliente() != null) {
            totalVenda = (totalVenda * 10) / 100;
        }

        if (v.getCliente() != null) {
            totalVenda -= (totalVenda * 10) / 100;
            //totalVenda -=totalVenda*0.10;
            System.out.println("O total a ser pago é de: R$" + df.format(totalVenda));
            System.out.println("Compra realizada com sucesso!");
            return totalVenda;
        } else {
            System.out.println("O total a ser pago é de: R$" + df.format(totalVenda));
            System.out.println("Compra realizada com sucesso!");
            return totalVenda;
        }

        //alt + shift + f
        //return totalVenda;
    }
}
