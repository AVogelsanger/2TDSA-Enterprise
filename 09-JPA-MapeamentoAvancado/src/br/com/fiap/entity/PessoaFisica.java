package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{

	@Column(name="nr_cpf")
	private long cpf;
	
	@Column(name="ds_sexo")
	private Sexo sexo;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, long cpf, Sexo sexo) {
		super(nome);
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
}
