/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.monte.sistemafowlrun.dao;

import com.br.monte.sistemafowlrun.domain.Cidade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Usuario
 */
public class CidadeDAO {
    private EntityManager em;
	private Session session;

	public CidadeDAO() {
		em = Conexao.getConexao(); // abre uma conexão
	}
	
	public Cidade salvar(Cidade cidade) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();		
		try {
			cidade = em.merge(cidade);
			transacao.commit();
			return cidade;
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}
	}
        
        public Cidade atualizar(Cidade cidade) throws Exception {
		Transaction transacao = null;
                 try {
                     transacao = session.beginTransaction();
                     session.update(cidade);
                     transacao.commit();
                     return cidade;
                 }
                 catch (Exception ex) {
                     transacao.rollback();
                     throw ex;
                 }                 
        
	}
        
        public void excluir(Cidade cidade) {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();	
		try {
			em.remove(cidade);
			transacao.commit();
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}		
	}
	
	public List<Cidade> buscarTodos3(){
            List<Cidade> list = new ArrayList<>();
            EntityTransaction transacao = session.getTransaction();
            transacao.begin();
            list = session.createQuery("from Cidade").list();
            session.getTransaction().commit();
            session.close();
		
            return list;
	}
	
	public Cidade buscarPorCodigo(Long codigo) {
		Criteria criteria = session.createCriteria(Cidade.class);
		criteria.add(Restrictions.eq("codigo", codigo));
		return (Cidade) criteria.uniqueResult();
	}

       
        @SuppressWarnings("unchecked")
        public List<Cidade> buscarTodos2(){
		return session.createCriteria(Cidade.class).list();
	}
        
        @SuppressWarnings("unchecked")
         public List<Cidade> buscarTodos() {
                   return em.createQuery("FROM " + Cidade.class.getName()).getResultList();
         }
        
	protected Session getSession() {
		return session;
	}
}
