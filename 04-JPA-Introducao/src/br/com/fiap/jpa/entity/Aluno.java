package br.com.fiap.jpa.entity;

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
import javax.persistence.Transient;

@Entity
@Table(name="T_ALUNO")
@SequenceGenerator(name="aluno",sequenceName="SQ_T_ALUNO",allocationSize=1)
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cd_aluno")
	@GeneratedValue(generator="aluno", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_aluno",nullable=false,length=50)
	private String nome;
	
	@Temporal(TemporalType.TIMESTAMP)//Data e hora no banco
	@Column(name="dt_matricula",nullable=false)
	private Calendar dataDatricula;
	
	@Column(name="st_bolsa",nullable=false)
	private boolean bolsista;

	@Column(name="vl_desconto")
	private int desconto;
	
	@Column(name="ds_turma", length=50)
	private String turma;
	
	@Column(name="vl_media")
	private float media;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;
	
	@Transient //não será uma coluna no banco de dados
	private float mensalidade;
	
	@Lob //arquivo no banco de dados (BLOB)
	@Column(name="fl_foto")
	private byte[] foto;
	
	public Aluno(String nome, Calendar dataDatricula, boolean bolsista, int desconto, String turma, float media,
			Genero genero, float mensalidade, byte[] foto) {
		super();
		this.nome = nome;
		this.dataDatricula = dataDatricula;
		this.bolsista = bolsista;
		this.desconto = desconto;
		this.turma = turma;
		this.media = media;
		this.genero = genero;
		this.mensalidade = mensalidade;
		this.foto = foto;
	}

	public Aluno() {
		super();
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

	public Calendar getDataDatricula() {
		return dataDatricula;
	}

	public void setDataDatricula(Calendar dataDatricula) {
		this.dataDatricula = dataDatricula;
	}

	public boolean isBolsista() {
		return bolsista;
	}

	public void setBolsista(boolean bolsista) {
		this.bolsista = bolsista;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public float getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(float mensalidade) {
		this.mensalidade = mensalidade;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
}




