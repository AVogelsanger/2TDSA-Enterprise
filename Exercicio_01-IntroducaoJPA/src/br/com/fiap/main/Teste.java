package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.MotoristaDAO;
import br.com.fiap.dao.impl.MotoristaDAOImpl;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Motorista;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		
		MotoristaDAO dao = new MotoristaDAOImpl(em);
		
		Motorista moto = new Motorista(1, "123-12", new GregorianCalendar(2017, Calendar.JANUARY, 2), 
				null, Genero.MASCULINO);
		//cadastro
		try {
			dao.cadastrar(moto);
			dao.commit();
			System.out.println("Motorista cadastrado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		//buscar
		Motorista motoBusca = dao.buscar("123-12");
		System.out.println(motoBusca.getNumero());
		
		
		//Atualizar
		
		
	}

}
