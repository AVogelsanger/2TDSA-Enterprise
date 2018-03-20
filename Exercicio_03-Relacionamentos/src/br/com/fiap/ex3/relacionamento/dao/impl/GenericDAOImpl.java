package br.com.fiap.ex3.relacionamento.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.ex3.relacionamento.dao.GenericDAO;
import br.com.fiap.ex3.relacionamento.exception.CommitException;
import br.com.fiap.ex3.relacionamento.exception.RegistroNaoEncontradoException;

public abstract class GenericDAOImpl <Tabela, Chave> implements GenericDAO<Tabela, Chave>{

	private EntityManager em;
	
	private Class<Tabela> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		classe = (Class<Tabela>)
				((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void cadastrar(Tabela tabela) {
		em.persist(tabela);
		
	}

	@Override
	public void atualizar(Tabela tabela) {
		em.merge(tabela);
		
	}

	@Override
	public void excluir(Chave codigo) throws RegistroNaoEncontradoException {
		Tabela t = buscar(codigo);
		if(t == null)
			throw new RegistroNaoEncontradoException("Registro não encontrado!");
			em.remove(t);
	}

	@Override
	public Tabela buscar(Chave codigo) {
		
		return em.find(classe, codigo);
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
			throw new CommitException("Erro ao realizar o commit!");
		}
		
	}
	
}
