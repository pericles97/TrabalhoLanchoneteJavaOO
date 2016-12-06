
package models;

import java.util.List;

public class Venda {
    private int codigo;
    private int qtdLanche;
    private double valorVenda;
    private Cliente cliente;
    private List<Lanche> lanches;

    public int getCodigo() {
        return codigo;
    }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

    public int getQtdLanche() {
        return qtdLanche;
    }

        public void setQtdLanche(int qtdLanche) {
            this.qtdLanche = qtdLanche;
        }

    public double getValorVenda() {
        double precoFinal = 0;
        for(Lanche l : lanches){
            precoFinal += l.getPreco();
        }
        return precoFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

    public List<Lanche> getLanches() {
        return lanches;
    }
    
    
}
