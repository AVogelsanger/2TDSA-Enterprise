package br.com.fiap.exercicio04.jpql.dao;

public interface GenericDao <Tabela, Chave>{

	void cadastrar(Tabela tabela);
	
	void atualizar(Tabela tabela);
	
	void excluir(Chave codigo);
	
	Tabela buscar(Chave codigo);
	
	void commit();
}
