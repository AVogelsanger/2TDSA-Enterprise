package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
@SequenceGenerator(name="motorista")
public class Motorista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="nr_carteira")
	@GeneratedValue(generator="motorista", strategy=GenerationType.SEQUENCE)
	private int carteira;
	
	@Column(name="nm_motorista", nullable=false, length=150)
	private String numero;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nascimento")
	private Calendar data;
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;

	public Motorista() {
		super();
	}

	public Motorista(int carteira, String numero, Calendar data, byte[] foto, Genero genero) {
		super();
		this.carteira = carteira;
		this.numero = numero;
		this.data = data;
		this.foto = foto;
		this.genero = genero;
	}

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
