package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Comentario")
@SequenceGenerator(name="Coment", sequenceName="SQ_T_Comentario", allocationSize=1)
public class Comentario {

	@Id
	@Column(name="CD_Comentario", nullable=false)
	@GeneratedValue(generator="Coment", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_Comentario", nullable=false)
	private Calendar dataComentario;
	
	@Column(name="DS_Conteudo")
	private String descricaoConteudo;

	public Comentario() {
		super();
	}

	public Comentario(Calendar dataComentario, String descricaoConteudo) {
		super();
		this.dataComentario = dataComentario;
		this.descricaoConteudo = descricaoConteudo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Calendar dataComentario) {
		this.dataComentario = dataComentario;
	}

	public String getDescricaoConteudo() {
		return descricaoConteudo;
	}

	public void setDescricaoConteudo(String descricaoConteudo) {
		this.descricaoConteudo = descricaoConteudo;
	}

}
