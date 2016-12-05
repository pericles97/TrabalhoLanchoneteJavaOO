package controllers;

import banco.BancoDadosLanchonete;
import models.Cliente;

public class ClientesController {
    
    public static void adicionarCliente(int codigo, String nome, String cpf){
        // criei o objeto para ir para o banco
        Cliente c = new Cliente();
        
        // Preenchendo o objeto
        c.setCodigo(codigo);
        c.setNome(nome);
        c.setCpf(cpf);
        
        BancoDadosLanchonete.getTabelaCliente().add(c);
    }
    
    public static Cliente buscarPorCodigo(int codigo){
        
        for(Cliente c : BancoDadosLanchonete.getTabelaCliente()){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        
        return null;
    }

}
