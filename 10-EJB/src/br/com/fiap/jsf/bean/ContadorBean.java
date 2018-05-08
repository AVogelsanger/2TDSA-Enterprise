package br.com.fiap.jsf.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.fiap.ejb.bo.ContadorBO;

@ManagedBean
@SessionScoped
public class ContadorBean {

	private int total;

	@EJB
	private ContadorBO bo;
	
	public void adicionar() {
		bo.incrementar();
		total = bo.verTotal();
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	} 
	
}
