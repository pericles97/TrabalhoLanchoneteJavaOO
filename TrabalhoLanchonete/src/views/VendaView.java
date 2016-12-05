
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
        
            /*switch (op) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
            }*/
        System.out.print("Digite o codigo do lanche: ");
        int codCurso = scan.nextInt();
        scan.nextLine();
        
        Lanche l = controllers.LanchesController.buscarPorCodigo(codCurso);
        
            if (l != null) {
                
                
                Venda v = new Venda();
                v.setCliente(c);
                v.setLanche(l);
                
                BancoDadosLanchonete.getTabelaVenda().add(v);
                System.out.println("Compra realizada com sucesso!");
            } else {
                System.out.println("Lanche não cadastrado");
            }
        
        }else {
            System.out.println("Cliente não cadastrado");
        }
        
    }
    
    public void tabelaVenda(){
        
                System.out.print("Informe a quantidade do lanche: ");
                int qtdLanche = scan.nextInt();
                scan.nextLine();
    }
    
    public void notaFiscal(){
        
    }
    
    public int Menu(){
        System.out.println("");
        exibirLanches();
        System.out.println("");
        System.out.println("----------LANCHES----------");
        System.out.println("1 - Cliente cadastrado");
        System.out.println("2 - Cliente nao cadastrado");
        System.out.println("3 - Valor total das vendas realizadas");
        System.out.println("4 - Voltar");
        System.out.print("Informe a opção desejada: ");
        int op = scan.nextInt();
        scan.nextLine();
        
        return op;
    }
    
    public void exibirMenuVendas(){
        int opcao;
        do {
            opcao = Menu();
            
            switch (opcao) {
                case 1:
                    clienteCadastrado();
                    break;
                case 2:
                    clienteNaoCadastrado();
                    break;
                case 3:
                    valorTotalVendas();
                    break;
            }
        } while (opcao != 4);
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
    
}
