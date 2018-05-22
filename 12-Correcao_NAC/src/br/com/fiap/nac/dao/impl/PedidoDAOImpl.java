package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.co.fiap.nac.entity.Pedido;
import br.com.fiap.nac.dao.PedidoDAO;

public class PedidoDAOImpl extends GenericDAOImpl<Pedido, Integer> implements PedidoDAO{

	public PedidoDAOImpl(EntityManager em) {
		super(em);
		
	}

	@Override
	public long contarPorCliente(int codigoCliente) {
		
		return em.createQuery("select count(p) from Pedido p where p.cliente.codigo = :c", Long.class)
				.setParameter("c", codigoCliente)
				.getSingleResult();
	}
	

}
