package br.com.fiap.nac.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.co.fiap.nac.entity.Cliente;
import br.com.fiap.nac.dao.ClienteDAO;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer>
							implements ClienteDAO{

	public ClienteDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public List<Cliente> buscarPorDataPedido(Calendar i, Calendar f) {
		
		return em.createQuery("select p.cliente from Pedido p where p.data between :i and :f",
				Cliente.class)
				.setParameter("i", i)
				.setParameter("f", f)
				.getResultList();
	}

}
