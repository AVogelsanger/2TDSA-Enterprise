package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.MotoristaNaoEncontradoException;

public abstract class GenericDAOImpl <Tabela, Chave> implements GenericDAO<Tabela, Chave>{

	private EntityManager em;

	@SuppressWarnings("unused")
	private Class<Tabela> clas;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clas = (Class<Tabela>)
				((ParameterizedType)	
						getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(Tabela tabela) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Tabela tabela) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluir(Chave codigo) throws MotoristaNaoEncontradoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Tabela buscar(Chave codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro ao realizar o commit");
		}

	}

}
