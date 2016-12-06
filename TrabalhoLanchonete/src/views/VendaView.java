package views;

import banco.BancoDadosLanchonete;
import java.util.Scanner;
import models.Cliente;
import models.Lanche;
import models.Venda;
import views.LancheView;

public class VendaView {

    Scanner scan = new Scanner(System.in);

    private static void clienteCadastrado() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o codigo do cliente: ");
        int codCliente = scan.nextInt();
        scan.nextLine();

        Cliente c = controllers.ClientesController.buscarPorCodigo(codCliente);

        if (c != null) {

            int codLanche = 0;
            do {
                System.out.print("Digite o codigo do lanche: ");
                codLanche = scan.nextInt();
                scan.nextLine();

                Lanche l = controllers.LanchesController.buscarPorCodigo(codLanche);

                if (l != null) {

                    Venda v = new Venda();
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

    public void tabelaVenda() {

        System.out.print("Informe a quantidade do lanche: ");
        int qtdLanche = scan.nextInt();
        scan.nextLine();
    }

    public void notaFiscal() {

    }

    public int Menu() {
        System.out.println("");
        exibirLanches();
        System.out.println("");
        System.out.println("----------LANCHES----------");
        System.out.println("1 - Efetuar venda");
        System.out.println("2 - Valor total das vendas realizadas");
        System.out.println("3 - Voltar");
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
                    criarVenda();
                    break;
                case 2:
                    clienteNaoCadastrado();
                    break;
            }
        } while (opcao != 3);
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

    private void clienteNaoCadastrado() {

    }

    private void valorTotalVendas() {

    }

    private void criarVenda() {
        //Se o se identiificar 10% desconto, senao faz a compra normal
        
        // cadastrar cliente ou nao
        Venda v = new Venda();
        System.out.print("Deseja se identificar? (S/N): ");
        String opcao = scan.nextLine();
        if (opcao == "s") {
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Digite o codigo do cliente: ");
            int codCliente = scan.nextInt();
            scan.nextLine();
            Cliente c = controllers.ClientesController.buscarPorCodigo(codCliente);
            //se o cliente tem cadastro, pesquisa por codigo
            if (v.getCliente() != null) {

            }
        }else{
            
        fazerPedido(v);
        //v.setCliente();
        }
    }

    private void fazerPedido(Venda v) {

        if (v.getCliente() != null) {

            int codLanche = 0;
            do {
                System.out.print("Digite o codigo do lanche: ");
                codLanche = scan.nextInt();
                scan.nextLine();

                Lanche l = controllers.LanchesController.buscarPorCodigo(codLanche);
                
                if (l != null) {
                    
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

}
