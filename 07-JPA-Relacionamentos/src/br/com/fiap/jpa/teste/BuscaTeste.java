package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TimeDAO;
import br.com.fiap.jpa.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class BuscaTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		TimeDAO dao = new TimeDAOImpl(em);
		// Buscar o time 
		Time time = dao.buscar(1);
		// Exibir  o nome do time
		System.out.println(time.getNome());
		//Exibir o nome do tecnico
		System.out.println(time.getTecnico().getNome());
		
		
		em.close();
		fabrica.close();
	}

}
