package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Publicacao;

public class RefreshTeste {

	public static void main(String[] args) {
		// Criar o Entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2TDSA");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar o conteudo
		Publicacao pub = em.find(Publicacao.class, 1);
		
		//Exibir 
		System.out.println(pub.getConteudo());
		
		//Alterar conteudo o conteudo da publicacao do java
		pub.setConteudo("Teste altera conteudo");
		
		//Refresh
		em.refresh(pub);
		
		//Exibir o conteudo
		System.out.println(pub.getConteudo());
		 
		em.close();
		fabrica.close();
	}

}
