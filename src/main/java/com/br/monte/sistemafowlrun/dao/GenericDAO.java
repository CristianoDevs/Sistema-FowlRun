/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.monte.sistemafowlrun.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Usuario
 */
public class GenericDAO<T> {
    
    private EntityManager em;

	public GenericDAO() {
		em = Conexao.getConexao(); // abre uma conexão
	}
	
	public T salvar(T t) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();		
		try {
			t = em.merge(t);
			transacao.commit();
			return t;
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}
	}
}
