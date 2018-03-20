package br.com.fiap.jpa.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TecnicoDAO;
import br.com.fiap.jpa.dao.TimeDAO;
import br.com.fiap.jpa.dao.impl.TecnicoDAOImpl;
import br.com.fiap.jpa.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Patrocinio;
import br.com.fiap.jpa.entity.Posicao;
import br.com.fiap.jpa.entity.Tecnico;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		TimeDAO timeDao = new TimeDAOImpl(em);
		TecnicoDAO tecnicoDao = new TecnicoDAOImpl(em);
		
		//cadastrar o time, tecnico e os jogadores
		Tecnico tecnico = new Tecnico("Diego Aguirre", false);
		Time t1 = new Time("São Paulo", 100, tecnico);
		Time t2 = new Time("Flamengo", 125000, tecnico);
		
		Jogador j1 = new Jogador("Diego Souza", 100000, Posicao.MEIA);
		Jogador j2 = new Jogador("Cidão", 70000, Posicao.GOLEIRO);
		Jogador j3 = new Jogador("Hernanes", 200000, Posicao.VOLANTE);
		
		Jogador j4 = new Jogador("Diego", 500000, Posicao.ATACANTE);
		Jogador j5 = new Jogador("Muralha", 70000, Posicao.GOLEIRO);
		Jogador j6 = new Jogador("Marcelo Dourado", 150000, Posicao.ATACANTE);
		
		t1.adicionarJogador(j1);
		t1.adicionarJogador(j2);
		t1.adicionarJogador(j3);
		
		t2.adicionarJogador(j4);
		t2.adicionarJogador(j5);
		t2.adicionarJogador(j6);
		
		Patrocinio p1 = new Patrocinio("Caixa Economica", 1500000);
		Patrocinio p2 = new Patrocinio("BMG", 280000000);
		
		List<Patrocinio> patrocinios = new ArrayList<>();
		patrocinios.add(p1);
		patrocinios.add(p2);
		
		t1.setPatrocinios(patrocinios);
		
		try {
			tecnicoDao.cadastrar(tecnico);
			timeDao.cadastrar(t1);
			timeDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}

}
