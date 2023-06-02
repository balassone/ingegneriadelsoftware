package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBNumeroTelefonico {
	private String numero;
	private DBListaNumeriTelefonici lista;
	
	public DBNumeroTelefonico() {
		super();
	}
	
	public DBNumeroTelefonico(String num) {
		super();
		setNumero(num);
	}
	
	public int aggiungiNumero(int idLista, String numero) {
		int ret=0;
		
		String query = "INSERT INTO numeritelefonici(numero,lista) VALUES(\'"+numero+"\',\'"+idLista+"\');";
		
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
		}
		
		return ret;
	}
	
	public int rimuoviNumero() {
		int ret=0;
		
		String query = "DELETE FROM numeritelefonici WHERE numero='"+this.numero+"';";
		
		try {
			DBConnectionManager.updateQuery(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		if(numero.length()==10) {
			this.numero = numero;
		}
	}

	public DBListaNumeriTelefonici getLista() {
		return lista;
	}

	public void setLista(DBListaNumeriTelefonici lista) {
		this.lista = lista;
	}
	
	
	
}
