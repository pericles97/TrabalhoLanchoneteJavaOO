package banco;

import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import models.Lanche;
import models.Venda;

public class BancoDadosLanchonete {
    
    private static List<Cliente> tabelaCliente;
    private static List<Lanche> tabelaLanche;
    private static List<Venda> tabelaVenda;

    public static List<Cliente> getTabelaCliente() {
        return tabelaCliente;
    }
    public static List<Lanche> getTabelaLanche() {
        return tabelaLanche;
    }
    public static List<Venda> getTabelaVenda() {
        return tabelaVenda;
    }
    
    public static void inicializarBancoCliente(){
        tabelaCliente = new ArrayList<Cliente>();
    }
    public static void inicializarBancoLanche(){
        tabelaLanche = new ArrayList<Lanche>();
    }
    public static void inicializarBancoVenda(){
        tabelaVenda = new ArrayList<Venda>();
    }
    
}
