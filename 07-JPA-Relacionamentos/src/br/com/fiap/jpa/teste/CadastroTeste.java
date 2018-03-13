package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TecnicoDAO;
import br.com.fiap.jpa.dao.TimeDAO;
import br.com.fiap.jpa.dao.impl.TecnicoDAOImpl;
import br.com.fiap.jpa.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.entity.Tecnico;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		TimeDAO timeDao = new TimeDAOImpl(em);
		TecnicoDAO tecnicoDao = new TecnicoDAOImpl(em);
		//cadastrar
		Tecnico tecnico = new Tecnico("Diego Aguirre", false);
		Time time = new Time("São Paulo", 100, tecnico);
		
		
		try {
			tecnicoDao.cadastrar(tecnico);
			timeDao.cadastrar(time);
			timeDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}

}
