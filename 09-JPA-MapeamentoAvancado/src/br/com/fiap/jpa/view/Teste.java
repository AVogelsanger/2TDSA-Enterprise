package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.entity.CategoriaLivro;
import br.com.fiap.entity.Livro;
import br.com.fiap.jpa.dao.ExemplarDAO;
import br.com.fiap.jpa.dao.impl.ExemplarDAOImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ExemplarDAO dao = new ExemplarDAOImpl(em);
		Livro livro = new Livro(97885359, "O último grito", CategoriaLivro.SUSPENSE, 579);
	}
}
