package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		//BUSCAR CIDADES POR UF===================================================================
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		//Listar as cidades
		List<Cidade> lista = cidadeDao.listar();
		//Exibir cidades
		System.out.println("LISTAR CIDADES");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}

		//Buscar por estado
		lista = cidadeDao.buscarPorEstado("SP");
		System.out.println("BUSCAR POR ESTADO");
		//exibir as cidade
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}

		// OBTER TODOS OS CLIENTES ================================================================

		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		List<Cliente> listaCliente = clienteDao.listar();
		System.out.println("CLIENTES");
		for (Cliente cliente : listaCliente) {
			System.out.println(cliente.getNome() + " " + cliente.getCpf());
		}
		
		// OBTER CLIENTE PELO NOME ================================================================
		listaCliente = clienteDao.buscarPorNome("a");
		System.out.println("BUSCAR CLIENTE PELO NOME:");
		for (Cliente cliente : listaCliente) {
			System.out.println(cliente.getNome());
		}
		

		// OBTER TODOS OS PACOTES POR UM TRANSPORTE ESPECÍFICO (OBJETO TRANSPORTE)=================
		TransporteDAO transDao = new TransporteDAOImpl(em);
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		
		Transporte transporte = transDao.pesquisar(1);
		List<Pacote> listaPacote = pacoteDao.listarPorTransporte(transporte);
		System.out.println("BUSCAR PACOTE POR CIA DE TRANSPORTE");
		for (Pacote pacote : listaPacote) {
			System.out.println(pacote.getDescricao());
		}

		// OBTER TODOS OS CLIENTE LOCALIZADOS POR ESTADO ============================================
		listaCliente = clienteDao.buscarPorEstado("BA");
		for (Cliente cliente : listaCliente) {
			System.out.println("ClIENTES POR ESTADO: ");
			System.out.println(cliente.getNome());
		}

		// Obter todos os clientes que efetuaram reservas em uma quantidade de dias específico=======
		listaCliente = clienteDao.buscarPorReserva(10);
		for (Cliente cliente : listaCliente) {
			System.out.println("CLIENTE QUE EFETUARAM RESERVAS EM QTDE DE DIAS ESPECIFICOS: ");
			System.out.println(cliente.getNome());
		}
		
		//BUSCAR POR DATAS ==========================================================================
		
		
		
		em.close();
		fabrica.close();
	}

}