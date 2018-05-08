package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
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
		
		// BUSCAR POR DATAS DE SAIDA ==================================================================
		Calendar inicio = new GregorianCalendar(2015, Calendar.MAY,2);
		Calendar fim = new GregorianCalendar(2018, Calendar.MAY,2);
		listaPacote = pacoteDao.buscarPorData(inicio, fim);
		System.out.println("Buscar pacotes por data");
		for (Pacote pacote : listaPacote) {
			System.out.println(pacote.getDescricao());
		}
		
		// BUSCAR CLIENTES POR NOME E CIDADE =============================================================
		listaCliente = clienteDao.buscar("a", "a");
		System.out.println("Buscar cliente por nome e cidade");
		for (Cliente cliente : listaCliente) {
			System.out.println(cliente.getNome() + " - " + cliente.getEndereco().getCidade().getNome());
		}
		
		// RETORNA TODOS OS CLIENTES CONFORME OS ESTADOS PASSADOS COMO PARAMETRO ==========================
		List<String> estados = new ArrayList<>();
		estados.add("SP");
		estados.add("RJ");
		estados.add("BA");
		estados.add("TO");
		estados.add("RR");
		estados.add("GO");
		listaCliente = clienteDao.buscarPorEstados(estados);
		for (Cliente c : listaCliente) {
			System.out.println(c.getNome() + "" + c.getEndereco().getCidade().getUf());
		}
		
		
		// LISTAR OS TRANSPORTES (GENERIC DAO) =============================================================
		List<Transporte> transportes = transDao.listar();
		System.out.println("LISTAR TRANSPORTES");
		for (Transporte t : transportes) {
			System.out.println(t.getEmpresa());
		}
		
		// EXIBIR A QUANTIDADE  DE CLIENTES CADASTRADOS
		System.out.println("Clientes: " + clienteDao.contarTotal());
		
		// CALCULAR A MÉDIA DOS PREÇOS DOS PACOTES ========================================================
		System.out.println("Pacotes: " + pacoteDao.mediaPrecoPacotes());
		
		// CONTAR A QUANTIDADE DE CLIENTE POR ESTADO ======================================================
		System.out.println("Quantidade de clientes em SP: " + clienteDao.contarPorEstado("SP"));
		
		// CONTAR A QUANTIDADE DE RESERVA POR CLIENTE
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		System.out.println("Reservas: " + reservaDao.contarPorCliente(clienteDao.pesquisar(2)));
		
		
		//Buscar Pacotes por descricao
		listaPacote = pacoteDao.buscarPorDescricao("a");
		System.out.println("BUSCA PACOTE POR DESCRIÇÃO");
		for (Pacote p : listaPacote) {
			System.out.println(p.getDescricao());
		}
		
		//BUSCAR O CLIENTES QUE POSSUAM MAIOR NUMERO DE RESERVA
		listaCliente = clienteDao.buscarMaiorNumeroReserva();
		for (Cliente c : listaCliente) {
			System.out.println(c.getNome());
			System.out.println(reservaDao.contarPorCliente(c));
		}
		
		em.close();
		fabrica.close();
	}

}