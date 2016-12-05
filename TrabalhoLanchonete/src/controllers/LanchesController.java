
package controllers;

import banco.BancoDadosLanchonete;
import models.Lanche;

public class LanchesController {
        public static void adicionarLanche(int codigo, String nome, double preco){
        // criei o objeto para ir para o banco
        Lanche l = new Lanche();
        
        // Preenchendo o objeto
        l.setCodigo(codigo);
        l.setNome(nome);
        l.setPreco(preco);
        
        BancoDadosLanchonete.getTabelaLanche().add(l);
    }
    
    public static Lanche buscarPorCodigo(int codigo){
        
        for(Lanche l : BancoDadosLanchonete.getTabelaLanche()){
            if(l.getCodigo() == codigo){
                return l;
            }
        }
        
        return null;
    }
}
