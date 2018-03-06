package br.com.fiap.dao;

import br.com.fiap.entity.Veiculo;

public interface VeiculoDAO {

	void cadastrarVeic(Veiculo veic);
	
	Veiculo buscarVeic(int codigo);
	
	void modificarVeic(Veiculo veic);
	
	void apagarVeic(int carteira);
	
	
}
