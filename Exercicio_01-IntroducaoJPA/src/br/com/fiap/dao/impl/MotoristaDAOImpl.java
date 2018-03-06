package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Motorista;

public class MotoristaDAOImpl {

	private EntityManager em;

	public MotoristaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrarMoto(Motorista moto) {
		em.persist(moto);
	}
	
	public Motorista buscarMoto(int carteira) {
		return em.find(Motorista.class, carteira);
	}
	
	public void modificarMoto(Motorista moto) {
		em.merge(moto);
	}
	
	public void apagarMoto(int carteira) throw {
		Motorista m = buscarMoto(carteira);
		if(m = null) {
			throw new MotoristaNaoEncontradoException("Motorista não encontrado.");
			em.remove(m);
		}
	}
}
