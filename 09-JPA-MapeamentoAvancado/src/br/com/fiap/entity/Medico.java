package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
@SecondaryTable(name="T_MEDICO_FINANCEIRO")
public class Medico {

	@Id
	@Column(name="nr_crm", nullable=false, length=6)
	private int crm;
	
	@Column(name="nm_medico", nullable=false, length=30)
	private String nome;
	
	@Column(name="ds_especialidade", nullable=false, length=30)
	private String especialidade;
	
	@Column(name="vl_salario", table="T_MEDICO_FINANCEIRO")
	private double salario;
	
	@Column(name="nr_conta", table="T_MEDICO_FINANCEIRO")
	private int conta;

	public Medico() {
		super();
	}
	
	public Medico(int crm, String nome, String especialidade, double salario, int conta) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
		this.salario = salario;
		this.conta = conta;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}
	
}
