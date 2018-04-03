package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> listarPorTransporte(Transporte cia) {
		TypedQuery<Pacote> query = em.createQuery("from Pacote where transporte = :cia", Pacote.class);
		query.setParameter("cia", cia);
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorData(Calendar inicio, Calendar fim) {
		
		return em.createQuery("from Pacote p where p.dataSaida between :dataI and :dataF", Pacote.class)
				.setParameter("dataI", inicio).setParameter("dataF", fim).getResultList();
	}

}
