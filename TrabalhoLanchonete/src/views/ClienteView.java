package views;

import banco.BancoDadosLanchonete;
import controllers.ClientesController;
import java.util.Scanner;
import models.Cliente;

public class ClienteView {
    Scanner scan = new Scanner(System.in);

    public int Menu(){
        
        System.out.println("----------GERENCIAR CLIENTES----------");;
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Exibir Clientes");
        System.out.println("3 - Alterar Cliente por codigo");
        System.out.println("4 - Excluir Cliente por codigo");
        System.out.println("5 - Pesquisar Cliente por codigo");
        System.out.println("6 - Voltar");
        System.out.print("Informe a opção desejada: ");
        int op = scan.nextInt();
        scan.nextLine();
        
        return op;
        
    }
    
    public void exibirMenuCadastroCliente() {
        int opcao;
        do {
            opcao = Menu();
        
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    exibirClientes();
                    break;
                case 3:
                    alterarCliente();
                    break;
                case 4:
                    excluirCliente();
                    break;
                case 5:
                    pesquisarClientePorCodigo();
                    break;
            }
        } while (opcao != 6);
    }
    
    private void cadastrarCliente() {
        System.out.print("Digite o codigo do cliente: ");
        int cod = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite o nome do cliente: ");
        String nome = scan.nextLine();

        System.out.print("Digite o cpf do cliente: ");
        String cpf = scan.nextLine();

        ClientesController.adicionarCliente(cod, nome, cpf);
    }

    private void exibirClientes() {

        System.out.println("---");

        for (Cliente a : BancoDadosLanchonete.getTabelaCliente()) {

            System.out.println("Codigo cliente: " + a.getCodigo());
            System.out.println("Nome cliente: " + a.getNome());
            System.out.println("Cpf cliente: " + a.getCpf());
            System.out.println("");
        }
        System.out.println("---");
    }

    private void pesquisarClientePorCodigo() {
        System.out.print("Digite o codigo do cliente: ");
        int cod = scan.nextInt();
        scan.nextLine();

        Cliente c = ClientesController.buscarPorCodigo(cod);

        if (c != null) {
            System.out.println("");
            System.out.println("Codigo: " + c.getCodigo());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Cpf: " + c.getCpf());
            System.out.println("");
        } else {
            System.out.println("Cliente não encontrado");
        }

    }
    
    private static void alterarCliente() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o codigo do cliente: ");
        int cod = scan.nextInt();
        scan.nextLine();
        
        Cliente c = ClientesController.buscarPorCodigo(cod);
        
        if (c != null) {
            System.out.print("Informe o novo codigo do cliente: (anterior: "+ c.getCodigo() + "): ");
            int codLanche = scan.nextInt();
            scan.nextLine();
            c.setCodigo(codLanche);
            
            System.out.print("Informe o novo nome do cliente: (anterior: "+ c.getNome()+ "): ");
            String nomeCliente = scan.nextLine();
            c.setNome(nomeCliente);
            
        }else{
            System.out.println("Cliente nao cadastrado!!!");
        }
    }
    
    private static void excluirCliente() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o codigo do cliente: ");
        int cod = scan.nextInt();
        scan.nextLine();

        Cliente c = ClientesController.buscarPorCodigo(cod);

        if (c != null) {
            BancoDadosLanchonete.getTabelaCliente().remove(c);
            System.out.println("Cliente removido com sucesso");
        } else {
            System.out.println("Cliente não encontrado!!");
        }
    }
}
