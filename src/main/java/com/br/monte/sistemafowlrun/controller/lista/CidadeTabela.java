
package com.br.monte.sistemafowlrun.controller.lista;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Cristiano Henrique Monte Alto
 */
public class CidadeTabela {
    
    private final SimpleIntegerProperty codigo;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty uf;

    
    
    public CidadeTabela(int codigo, String nome, String uf) {
        super();
        
        this.codigo = new SimpleIntegerProperty(codigo);
        this.nome = new SimpleStringProperty(nome);
        this.uf = new SimpleStringProperty(uf);
    }

    
    
    public int getCodigo() {
        return codigo.get();
    }

    public String getNome() {
        return nome.get();
    }

    public String getUf() {
        return uf.get();
    }
    
    
    
}
