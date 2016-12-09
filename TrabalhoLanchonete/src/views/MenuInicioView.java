package views;

import banco.BancoDadosLanchonete;
import java.util.Scanner;
import views.ClienteView;
import views.LancheView;
import views.VendaView;

public class MenuInicioView {
        
        ClienteView clienteView = new ClienteView();
        LancheView lancheView = new LancheView();
        VendaView vendaView = new VendaView();
        private int inicio(){
            Scanner scan = new Scanner(System.in);
            System.out.println("");
            System.out.println("---------Sistema Lanchonete-------------");
            System.out.println("1 - Cadastro de clientes");
            System.out.println("2 - Cadastro de lanches");
            System.out.println("3 - Efetuar vendas");
            System.out.print("Digite sua opção: ");
            
            int op = scan.nextInt();
            scan.nextLine();
            return op;
        }
        
        public void exibirMenu(){
            while (true) {
                int opcao = 0;
                do {
                    opcao = inicio();
                    switch(opcao){
                        case 1:
                            try{
                                clienteView.exibirMenuCadastroCliente();
                            }catch(Exception erro){
                                System.out.println("Erro: "+ erro);
                            }
                            break;
                        case 2:
                            try{
                                lancheView.exibirMenuCadastroLanche();
                            }catch(Exception erro){
                                System.out.println("Erro: "+ erro);
                            }
                            break;
                        case 3:
                            try{
                                vendaView.exibirMenuVendas();
                            }catch(Exception erro){
                                System.out.println("Erro: "+ erro);
                            }
                            break;
                    }
                } while (opcao != 4);  
            }
        }
        
    }
