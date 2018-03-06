package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.PublicacaoDAO;
import br.com.fiap.jpa.dao.impl.PublicacaoDAOImpl;
import br.com.fiap.jpa.entity.Privacidade;
import br.com.fiap.jpa.entity.Publicacao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public class PublicacaoDAOTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2TDSA");
		EntityManager em = fabrica.createEntityManager();

		PublicacaoDAO dao = new PublicacaoDAOImpl(em);

		Publicacao p = new Publicacao("Cabral", Calendar.getInstance(), 
				null, "GIT", 10, Privacidade.PRIVADO);

		// Cadastrar =============================================================

		try {
			dao.cadastrar(p);
			dao.commit();
		} catch (Exception e) {
			System.out.println("Erro");
		}

		// Buscar ================================================================

		Publicacao p2 = dao.buscar(2);
		System.out.println(p2.getAutor());

		p2.setConteudo("Android");


		// Modificar =======================================================================		
		try {
			dao.modificar(p2);
			dao.commit();
			System.out.println("Modificado!");
		} catch (Exception e) {
			System.out.println("Erro");
		}

		// Remoção  ========================================================================	

		try {
			dao.apagar(2);
			dao.commit();
			System.out.println("Apagado com Sucesso!");
		} catch (RegistroNaoEncontradoException e) {
			System.out.println("Erro");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		em.close();
		fabrica.close();
	}

}
