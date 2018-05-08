package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName="SQ_T_PACIENTE", allocationSize=1)
public class Paciente {

	@Id
	@Column(name="cd_paciente", nullable=false, length=10)
	@GeneratedValue(generator="paciente", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_paciente", nullable=false, length=30)
	private String nome;
	
	@Column(name="dt_nascimento")
	private Calendar dataNasc;

	public Paciente() {
		super();
	}

	public Paciente(String nome, Calendar dataNasc) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
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

	public Calendar getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
}
