package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_EMPRESA")
public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_cnpj", length=20)
	private String codigo;
	
	@Column(name="nm_empresa", nullable=false, length=100)
	private String nome;
	
	@Column(name="vl_faturamento")
	private double valorFaturamento;

	public Empresa() {
		super();
	}

	public Empresa(String codigo, String nome, double valorFaturamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valorFaturamento = valorFaturamento;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorFaturamento() {
		return valorFaturamento;
	}

	public void setValorFaturamento(double valorFaturamento) {
		this.valorFaturamento = valorFaturamento;
	}
	
	
}
