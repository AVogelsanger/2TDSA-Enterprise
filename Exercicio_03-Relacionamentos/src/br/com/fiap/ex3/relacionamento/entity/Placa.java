package br.com.fiap.ex3.relacionamento.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PLACA")
@SequenceGenerator(name="placa", sequenceName="SQ_T_PLACA")
public class Placa {

	@Id
	@Column(name="cd_placa")
	@GeneratedValue(generator="placa", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nr_placa", nullable=false, length=7)
	private int numero;
	
	@Column(name="ds_pais")
	private Pais pais;

	public Placa() {
		super();
	}

	public Placa(int codigo, int numero, Pais pais) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.pais = pais;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
