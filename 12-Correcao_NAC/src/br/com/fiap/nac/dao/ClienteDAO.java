package br.com.fiap.nac.dao;

import java.util.Calendar;
import java.util.List;

import br.co.fiap.nac.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente, Integer>{

	List<Cliente> buscarPorDataPedido(Calendar i, Calendar f);
}
