package br.com.fiap.dao;

import br.com.fiap.entity.Motorista;

public interface MotoristaDAO {

	void cadastrarMoto(Motorista moto);
	
	Motorista buscarMoto(int codigo);
	
	void modificarMoto(Motorista moto);
	
	void apagarMoto(int codigo);
}
