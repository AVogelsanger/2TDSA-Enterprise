package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{

	@Column(name="nr_cnpj")
	private long cnpj;
	
	@Column(name="nm_fantasia")
	private String nomeFantasia;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, long cnpj, String nomeFantasia) {
		super(nome);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
}
