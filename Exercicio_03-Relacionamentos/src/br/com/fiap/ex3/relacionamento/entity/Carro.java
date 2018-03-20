package br.com.fiap.ex3.relacionamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_CARRO")
@SequenceGenerator(name="carro", sequenceName="SQ_T_CARRO")
public class Carro {

	@Id
	@Column(name="nr_renavam")
	@GeneratedValue(generator="carro", strategy=GenerationType.SEQUENCE)
	private int renavam;
	
	@Column(name="ds_cor", nullable=false, length=50)
	private String cor;
	
	@Column(name="nr_ano")
	private int ano;

	public Carro() {
		super();
	}

	public Carro(int renavam, String cor, int ano) {
		super();
		this.renavam = renavam;
		this.cor = cor;
		this.ano = ano;
	}

	public int getRenavam() {
		return renavam;
	}

	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
