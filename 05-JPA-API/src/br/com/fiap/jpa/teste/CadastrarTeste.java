package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Privacidade;
import br.com.fiap.jpa.entity.Publicacao;

public class CadastrarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2TDSA");
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao pub = new Publicacao("Camões", new GregorianCalendar(2018,Calendar.MAY,2), 
				null, "Ola Mundo", 0,Privacidade.PUBLICO);
		
		em.getTransaction().begin();
		em.persist(pub);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
