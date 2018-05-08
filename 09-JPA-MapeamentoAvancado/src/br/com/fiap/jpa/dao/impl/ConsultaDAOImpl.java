package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Consulta;
import br.com.fiap.entity.ConsultaPK;
import br.com.fiap.jpa.dao.ConsultaDAO;

public class ConsultaDAOImpl extends GenericDAOImpl<Consulta, ConsultaPK> implements ConsultaDAO{

	public ConsultaDAOImpl(EntityManager em) {
		super(em);
		
	}

}
