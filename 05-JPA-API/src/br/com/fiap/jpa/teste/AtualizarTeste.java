package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Privacidade;
import br.com.fiap.jpa.entity.Publicacao;

public class AtualizarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2TDSA");
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao p = //em.find(Publicacao.class, 1);
					new Publicacao("Carlos", Calendar.getInstance(), null, "Olá Mundo!", 
							20, Privacidade.PUBLICO);
		p.setCodigo(1);
		//p.setAutor("HEMAN");
		//p.setNrCurtidas(10);
		em.merge(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();

	}

}
