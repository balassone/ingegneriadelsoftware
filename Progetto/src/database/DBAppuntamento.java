package database;

import java.sql.SQLException;
import java.sql.ResultSet;

public class DBAppuntamento {
	private int id;
	private String data;
	private String ora;
	private String note;
	private int esito;
	private DBTelefonata telefonata;
	private int precedente; 
	private DBAgentediVendita agente; 
	
	public DBAppuntamento() {
		super();
	}
	
	public DBAppuntamento(int id) {
		super();
		this.id=id;
		this.precedente=-1;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = "SELECT * FROM appuntamenti WHERE idappuntamenti='"+this.id+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			
			if(rs.next()) {
				this.data=rs.getString("data");
				this.ora=rs.getString("ora");
				this.note=rs.getString("note");
				this.esito=rs.getInt("esito");
				if(rs.getInt("precedente")>0) {
					this.precedente = rs.getInt("precedente");
				}
				
			}
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
	public int ottieniLatestID() {
		int ret = 0;
		
		String query = "SELECT MAX(idappuntamenti) FROM appuntamenti;";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=rs.getInt(1)+1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	*/
	public void caricaTelefonataDaDB() {
		String query = "SELECT * FROM telefonate WHERE id =(SELECT telefonata FROM appuntamenti WHERE idappuntamenti='"+this.id+"');";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				DBTelefonata t = new DBTelefonata();
				t.setId(rs.getInt("id"));
				t.setData(rs.getString("data"));
				t.setOra(rs.getString("ora"));
				t.setEsito(rs.getInt("esito"));
				t.setAppuntamento(this);
				t.setNote(rs.getString("note"));
				this.telefonata=t;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void caricaAgenteDaDB() {
		String query = "SELECT * FROM agentidivendita WHERE codicefiscale=(SELECT agente FROM appuntamenti WHERE idappuntamenti='"+this.id+"');";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				DBAgentediVendita a = new DBAgentediVendita();
				a.setCodicefiscale(rs.getString("codicefiscale"));
				this.agente=a;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int scriviSuDB() {
		int ret=0;
		String query = "INSERT INTO appuntamenti(idappuntamenti,data,ora,note,esito,telefonata,agente) VALUES (\'"+this.id+"\',\'"+this.data+"\',\'"+this.ora+"\',\'"+this.note+"\',\'"+this.esito+"\',\'"+this.telefonata.getId()+"\',\'"+this.agente.getCodicefiscale()+"\');";
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			ret=-1;
		}
		return ret;
	}
	/*
	public int trovaAppuntamento(int id) {
		int ret = 0;
		
		String query = "SELECT * FROM appuntamenti WHERE idappuntamenti='"+id+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				ret=1;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = -1;
		}
		return ret;
	}
	*/
	public int aggiornaSuDB() {
		int ret=0;
		String query = "UPDATE appuntamenti SET note='"+this.note+"' WHERE idappuntamenti='"+this.id+"';";
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			ret=-1;
		}
		return ret;
	}
	
	public int referenziaInDB() {
		int ret=0;
		String query = "UPDATE appuntamenti SET precedente='"+this.precedente+"' WHERE idappuntamenti='"+this.id+"';";
		try {
			ret = DBConnectionManager.updateQuery(query);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			ret=-1;
		}
		return ret;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getEsito() {
		return esito;
	}

	public void setEsito(int esito) {
		this.esito = esito;
	}

	public DBTelefonata getTelefonata() {
		return telefonata;
	}

	public void setTelefonata(DBTelefonata telefonata) {
		this.telefonata = telefonata;
	}

	public int getPrecedente() {
		return precedente;
	}

	public void setPrecedente(int precedente) {
		this.precedente = precedente;
	}

	public DBAgentediVendita getAgente() {
		return agente;
	}

	public void setAgente(DBAgentediVendita agente) {
		this.agente = agente;
	}

	@Override
	public String toString() {
		return "DBAppuntamento [id=" + id + ", data=" + data + ", ora=" + ora + ", note=" + note + ", esito=" + esito
				+ ", telefonata=" + telefonata + ", precedente=" + precedente + ", agente=" + agente + "]";
	}
	
	
	
}
