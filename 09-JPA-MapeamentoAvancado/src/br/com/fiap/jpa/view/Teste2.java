package br.com.fiap.jpa.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.entity.Consulta;
import br.com.fiap.entity.Medico;
import br.com.fiap.entity.Paciente;
import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.dao.impl.ConsultaDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste2 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Medico medico = new Medico(123, "Alberto", "Pediatra", 10000000, 020304);
		Paciente paciente = new Paciente("Poliana", new GregorianCalendar(1999, Calendar.JANUARY, 29));
		Consulta consulta = new Consulta(Calendar.getInstance(), medico, paciente, "Consulta rotina", false);
		
		ConsultaDAO dao = new ConsultaDAOImpl(em);
		dao.cadastrar(consulta);
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
	}
}
