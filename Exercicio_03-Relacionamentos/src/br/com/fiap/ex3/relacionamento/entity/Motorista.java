package br.com.fiap.ex3.relacionamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MOTORISTA")
@SequenceGenerator(name="motorista", sequenceName="SQ_T_MOTORISTA")
public class Motorista {

	@Id
	@Column(name="cd_motorista")
	@GeneratedValue(generator="motorista", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_motorista")
	private String nome;

	public Motorista() {
		super();
	}

	public Motorista(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
