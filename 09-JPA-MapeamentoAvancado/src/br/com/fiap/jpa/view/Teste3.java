package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.entity.Pessoa;
import br.com.fiap.entity.PessoaFisica;
import br.com.fiap.entity.PessoaJuridica;
import br.com.fiap.entity.Sexo;
import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste3 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Pessoa pessoa = new Pessoa("Rubéns");
		PessoaFisica pf = new PessoaFisica("Berta", 123456678, Sexo.FEMININO);
		PessoaJuridica pj = new PessoaJuridica("Carlos", 123456678, "Escandalo");
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		dao.cadastrar(pessoa);
		dao.cadastrar(pj);
		dao.cadastrar(pf);
		try {
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
