package br.com.fiap.ejb.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.fiap.ejb.bo.ClienteBO;

public class ConsoleView {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

		try {
			Context context = new InitialContext(prop);
			
			ClienteBO bo = (ClienteBO) context.lookup("ejb:/10-EJB/ClienteBOImpl!br.com.fiap.ejb.bo.ClienteBO");
			
			int idade = bo.calcularIdade(new GregorianCalendar(1980, Calendar.MAY, 8));
			
			System.out.println(idade);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
