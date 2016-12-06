package views;

import banco.BancoDadosLanchonete;
import controllers.ClientesController;
import controllers.LanchesController;
import java.util.Scanner;
import models.Lanche;

public class LancheView {
    Scanner scan = new Scanner(System.in);
    
    public int Menu(){
        
        System.out.println("----------GERENCIAR LANCHES----------");
        System.out.println("1 - Cadastrar Lanche");
        System.out.println("2 - Exibir Lanches");
        System.out.println("3 - Alterar Lanche por codigo");
        System.out.println("4 - Excluir Lanche por codigo");
        System.out.println("5 - Pesquisar Lanche por codigo");
        System.out.println("6 - Voltar");
        System.out.print("Informe a opção desejada: ");
        int op = scan.nextInt();
        scan.nextLine();
        
        return op;
        
    }
    
    public void exibirMenuCadastroLanche() {
        int opcao;
        do {
            opcao = Menu();
        
            switch (opcao) {
                case 1:
                    cadastrarLanche();
                    break;
                case 2:
                    exibirLanches();
                    break;
                case 3:
                    alterarLanche();
                    break;
                case 4:
                    excluirLanche();
                    break;
                case 5:
                    pesquisarLanchePorCodigo();
                    break;
            }
        } while (opcao != 6);
    }

    private void cadastrarLanche() {
        System.out.print("Digite o codigo do lanche: ");
        int cod = scan.nextInt();
        scan.nextLine();

        System.out.print("Digite o nome do lanche: ");
        String nome = scan.nextLine();

        System.out.print("Digite o preço do lanche: ");
        double preco = scan.nextDouble();

        LanchesController.adicionarLanche(cod, nome, preco);
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

    private void pesquisarLanchePorCodigo() {
        System.out.print("Digite o codigo do aluno: ");
        int cod = scan.nextInt();
        scan.nextLine();

        Lanche l = LanchesController.buscarPorCodigo(cod);

        if (l != null) {
            System.out.println("");
            System.out.println("Codigo: " + l.getCodigo());
            System.out.println("Nome: " + l.getNome());
            System.out.println("Preço: R$ " + l.getPreco());
            System.out.println("");
        } else {
            System.out.println("Cliente não encontrado");
        }
    }
    
    private static void alterarLanche() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o codigo do lanche: ");
        int cod = scan.nextInt();
        scan.nextLine();
        
        Lanche l = LanchesController.buscarPorCodigo(cod);
        
        if (l != null) {
            System.out.print("Informe o novo codigo do lanche: (anterior: "+ l.getCodigo() + "): ");
            int codLanche = scan.nextInt();
            scan.nextLine();
            l.setCodigo(codLanche);
            
            System.out.print("Informe o novo nome do lanche: (anterior: "+ l.getNome()+ "): ");
            String nomeLanche = scan.nextLine();
            l.setNome(nomeLanche); 
            
            System.out.print("Informe o novo nome do lanche: (anterior: "+ l.getPreco()+ "): ");
            double precoLanche = scan.nextDouble();
            l.setPreco(precoLanche); 
            
        }else{
            System.out.println("Lanche nao cadastrado!!!");
        }
    }
    
    private static void excluirLanche() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite o codigo do lanche: ");
        int cod = scan.nextInt();
        scan.nextLine();

        Lanche l = LanchesController.buscarPorCodigo(cod);

        if (l != null) {
            BancoDadosLanchonete.getTabelaLanche().remove(l);
            System.out.println("Lanche removido com sucesso");
        } else {
            System.out.println("Lanche não encontrado!!");
        }
    }
    
}
