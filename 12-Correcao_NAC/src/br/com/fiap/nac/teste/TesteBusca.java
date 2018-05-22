package br.com.fiap.nac.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.co.fiap.nac.entity.Cliente;
import br.co.fiap.nac.entity.Produto;
import br.com.fiap.nac.dao.ClienteDAO;
import br.com.fiap.nac.dao.PedidoDAO;
import br.com.fiap.nac.dao.ProdutoDAO;
import br.com.fiap.nac.dao.impl.ClienteDAOImpl;
import br.com.fiap.nac.dao.impl.PedidoDAOImpl;
import br.com.fiap.nac.dao.impl.ProdutoDAOImpl;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class TesteBusca {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//xerc 01
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		Calendar i = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		Calendar f = new GregorianCalendar(2019, Calendar.JANUARY, 1);
		List<Cliente> clientes = clienteDao.buscarPorDataPedido(i, f);
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		
		//exerc 02
		PedidoDAO pedidoDao = new PedidoDAOImpl(em);
		System.out.println("Pedidos: " + pedidoDao.contarPorCliente(1));
		
		//exerc 03
		ProdutoDAO produtoDao = new ProdutoDAOImpl(em);
		List<Produto> produtos = produtoDao.buscarPorDescricao("Queijo");
		for (Produto produto : produtos) {
			System.out.println(produto.getDescricao());
		}
	}

}
