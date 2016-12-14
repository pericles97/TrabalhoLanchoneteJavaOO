package models;

import banco.BancoDadosLanchonete;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import views.VendaView;
import views.ClienteView;

public class Venda {

    private int codigo;
    private int qtdLanche;
    private double valorVenda;
    private Cliente cliente;
    private List<Lanche> lanches;
    private List<Cliente> Clientes;

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
    
    public double tot(){
        double tot = 0;
        for (Lanche l : lanches) {
           // tot += .l.getPreco();
        }
        return tot;
    }
    
    public double getValorVenda() {
        double precoFinal = 0;
        for (Lanche l : lanches) {
            precoFinal += l.getPreco();
        }

        /*if (controllers.ClientesController.buscarPorCodigo() != null) {
            return precoFinal*10/100;
        }else{
            return precoFinal;
        }*/
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

    public Venda() {
        lanches = new ArrayList<Lanche>();
    }

}
