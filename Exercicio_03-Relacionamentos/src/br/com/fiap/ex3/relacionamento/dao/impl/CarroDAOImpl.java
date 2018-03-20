package br.com.fiap.ex3.relacionamento.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.ex3.relacionamento.dao.CarroDAO;
import br.com.fiap.ex3.relacionamento.entity.Carro;

public class CarroDAOImpl extends GenericDAOImpl<Carro, Integer> implements CarroDAO{

	public CarroDAOImpl(EntityManager em) {
		super(em);
		
	}

}
