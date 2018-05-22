package br.com.fiap.nac.dao.impl;

import javax.persistence.EntityManager;

import br.co.fiap.nac.entity.ItemPedido;
import br.com.fiap.nac.dao.ItemPedidoDAO;

public class ItemPedidoDAOImpl extends GenericDAOImpl<ItemPedido, Integer>
					implements ItemPedidoDAO{

	public ItemPedidoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
		
}
