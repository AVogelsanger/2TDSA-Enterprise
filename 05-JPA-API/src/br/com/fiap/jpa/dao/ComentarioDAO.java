package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Comentario;

public interface ComentarioDAO {

	void cadastrar (Comentario coment);
	
	Comentario buscar(int codigo);
	
	void modificar(Comentario coment);
	
	
}
