package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

@Entity
@Table(name="T_PESSOA")
@SequenceGenerator(name="pessoa", sequenceName="SQ_T_PESSOA", allocationSize=1)
public class Pessoa {

	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(generator="pessoa", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_pessoa")
	private String nome;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome) {
		super();
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
