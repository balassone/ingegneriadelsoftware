package database;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAgentediVendita {
	private String codicefiscale;
	private ArrayList<DBAppuntamento> appuntamenti;
	
	public DBAgentediVendita() {
		super();
		appuntamenti = new ArrayList<DBAppuntamento>();
	}
	
	public DBAgentediVendita(String cf) {
		super();
		this.codicefiscale=cf;
		appuntamenti = new ArrayList<DBAppuntamento>();
	}
	
	public void caricaAppuntamentiDaDB() {
		String query = "SELECT * FROM appuntamenti WHERE agente='"+this.codicefiscale+"';";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			while(rs.next()) {
				DBAppuntamento a = new DBAppuntamento();
				a.setId(rs.getInt("idappuntamenti"));
				a.setData(rs.getString("data"));
				a.setOra(rs.getString("ora"));
				a.setNote(rs.getString("note"));
				a.setEsito(rs.getInt("esito"));
				a.setAgente(this);
				a.setPrecedente(rs.getInt("precedente"));
				this.appuntamenti.add(a);
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public ArrayList<DBAppuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(ArrayList<DBAppuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

	@Override
	public String toString() {
		return "DBAgentediVendita [codicefiscale=" + codicefiscale + ", appuntamenti=" + appuntamenti + "]";
	}
	
	
	
}
