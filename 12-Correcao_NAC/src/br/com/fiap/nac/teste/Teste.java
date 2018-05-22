package br.com.fiap.nac.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.co.fiap.nac.entity.Cliente;
import br.co.fiap.nac.entity.ItemPedido;
import br.co.fiap.nac.entity.Pedido;
import br.co.fiap.nac.entity.Produto;
import br.co.fiap.nac.entity.Sexo;
import br.com.fiap.nac.dao.ItemPedidoDAO;
import br.com.fiap.nac.dao.impl.ItemPedidoDAOImpl;
import br.com.fiap.nac.exception.DBException;
import br.com.fiap.nac.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();

		Cliente cliente = new Cliente("Tiago", "123.654.687-97", Sexo.MASCULINO, null);
		Produto produto = new Produto("Esfirra", "Queijo", null, null);
		Pedido pedido = new Pedido(Calendar.getInstance(), cliente, null);
		ItemPedido item = new ItemPedido(1, 5, pedido, produto);
		
		//Cadastrar o item pedido e os outros objetos em cascata
		ItemPedidoDAO dao = new ItemPedidoDAOImpl(em);
		
		
		try {
			dao.cadastrar(item);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		
		em.close();
		fabrica.close();
	}

}
