package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Exemplar;
import br.com.fiap.entity.ExemplarPK;
import br.com.fiap.jpa.dao.ExemplarDAO;

public class LivroDAOImpl extends GenericDAOImpl<Exemplar, ExemplarPK> implements ExemplarDAO{

	public LivroDAOImpl(EntityManager em) {
		super(em);
	}

}
