package br.com.fiap.exercicio04.jpql.entity;

import java.util.Calendar;

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
	@Column(name="nr_carteira")
	@GeneratedValue(generator="motorista", strategy=GenerationType.SEQUENCE)
	private int numeroCarteira;
	
	@Column(name="nm_motorista")
	private String nome;
	
	
	private Calendar dataNascimento;
	
	private byte[] carteira;
	
	private Genero genero;

	public Motorista() {
		super();
	}

	public Motorista(int numeroCarteira, String nome, Calendar dataNascimento) {
		super();
		this.numeroCarteira = numeroCarteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public int getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(int numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public byte[] getCarteira() {
		return carteira;
	}

	public void setCarteira(byte[] carteira) {
		this.carteira = carteira;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
