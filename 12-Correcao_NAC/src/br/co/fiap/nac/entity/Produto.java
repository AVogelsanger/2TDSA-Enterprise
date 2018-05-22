package br.co.fiap.nac.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="NAC_PRODUTO")
@SequenceGenerator(name="produto",sequenceName="SEQ_NAC_PRODUTO",allocationSize=1)
public class Produto {
	
	@Id
	@GeneratedValue(generator="produto",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(length=500)
	private String descricao;
	
	@Lob
	private byte[] imagem;
	
	@OneToMany(mappedBy="produto")
	private List<ItemPedido> itens;
	
	

	public List<ItemPedido> getPedidos() {
		return itens;
	}

	public void setPedidos(List<ItemPedido> pedidos) {
		this.itens = pedidos;
	}

	

	public Produto(String nome, String descricao, byte[] imagem, List<ItemPedido> itens) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.itens = itens;
	}

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
	
	
	

}
