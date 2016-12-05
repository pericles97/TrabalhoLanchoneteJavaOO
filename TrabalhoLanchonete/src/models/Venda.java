
package models;

public class Venda {
    private int codigo;
    private int qtdLanche;
    private double valorVenda;
    private Cliente cliente;
    private Lanche lanche;

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
        return valorVenda;
    }

        public void setValorVenda(double valorVenda) {
            this.valorVenda = valorVenda;
        }

    public Cliente getCliente() {
        return cliente;
    }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

    public Lanche getLanche() {
        return lanche;
    }

        public void setLanche(Lanche lanche) {
            this.lanche = lanche;
        }
    
    
    
}
