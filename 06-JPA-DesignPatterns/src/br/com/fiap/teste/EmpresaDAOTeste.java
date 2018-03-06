package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.EmpresaDAO;
import br.com.fiap.jpa.dao.impl.EmpresaDAOImpl;
import br.com.fiap.jpa.entity.Empresa;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class EmpresaDAOTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		EmpresaDAO dao = new EmpresaDAOImpl(em); 
		//cadastro
		
		Empresa emp = new Empresa("123", "FIAP", 100000000);
		try {
			dao.cadastrar(emp);
			dao.commit();
			System.out.println("Cadastrado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		//Buscar
		Empresa empresaBusca = dao.buscar("123");
		System.out.println(empresaBusca.getNome());

		//Atualização
		empresaBusca.setNome("FIAP School");
		
		try {
			dao.atualizar(empresaBusca);
			dao.commit();
			System.out.println("Atualizado!");
		} catch (CommitException e) {
			System.err.println(e.getMessage());
		}
		
		//Remoção
		try {
			dao.excluir("123");
			dao.commit();
			System.out.println("Excluído!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
