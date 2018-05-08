package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{
	
	long contarTotal();

	List<Cliente> listar();
	
	List<Cliente> buscarPorEstado(String estado);
	
	List<Cliente> buscarPorReserva(int dias);
	
	List<Cliente> buscarPorNome(String nome);
	
	List<Cliente> buscar(String nome, String cidade);
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
	long contarPorEstado(String uf);
	
	List<Cliente> buscarMaiorNumeroReserva();
}