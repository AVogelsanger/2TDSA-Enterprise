package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Publicacao;

public class BuscarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2TDSA");
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao p = em.find(Publicacao.class, 1);
		
		System.out.println(p.getConteudo());
		System.out.println(p.getAutor());
		
		em.close();
		fabrica.close();
	}

}
