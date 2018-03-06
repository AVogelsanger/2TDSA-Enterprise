package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Publicacao")
@SequenceGenerator(name="Pub", sequenceName="SQ_T_Publicacao", allocationSize=1)
public class Publicacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CD_Publicacao", nullable=false)
	@GeneratedValue(generator="publicacao", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="DS_Autor", nullable=false, length=50)
	private String autor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_Publicacao", nullable=false)
	private Calendar dataPublicacao;
	
	@Lob
	@Column(name="FL_Imagem")
	private byte[] imagem;
	
	@Column(name="DS_Conteudo", nullable=false, length=250)
	private String conteudo;
	
	@Column(name="NR_Curtidas")
	private int nrCurtidas;
	
	@Column(name="DS_Privacidade", nullable=false)
	private Privacidade privacidade;

	public Publicacao() {
		super();
	}

	public Publicacao(String autor, Calendar dataPublicacao, byte[] imagem, String conteudo, int nrCurtidas,
			Privacidade privacidade) {
		super();
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
		this.imagem = imagem;
		this.conteudo = conteudo;
		this.nrCurtidas = nrCurtidas;
		this.privacidade = privacidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getNrCurtidas() {
		return nrCurtidas;
	}

	public void setNrCurtidas(int nrCurtidas) {
		this.nrCurtidas = nrCurtidas;
	}

	public Privacidade getPrivacidade() {
		return privacidade;
	}

	public void setPrivacidade(Privacidade privacidade) {
		this.privacidade = privacidade;
	}

}
