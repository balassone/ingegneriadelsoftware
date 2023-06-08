package database;
import java.sql.SQLException;
import java.sql.ResultSet;
public class DBTelefonata {
	private int id;
	private String data;
	private String ora;
	private String note;
	private int esito;
	private DBCentralinista centralinista;
	private DBAppuntamento appuntamento;
	
	public DBTelefonata() {
		super();
	}
	
	public DBTelefonata(int id) {
		super();
		this.id=id;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = "SELECT * FROM telefonate WHERE id='"+this.id+"';";
		
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.data=rs.getString("data");
				this.ora=rs.getString("ora");
				this.note=rs.getString("note");
				this.esito=rs.getInt("esito");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void caricaCentralinistaDaDB() {
		String query = "SELECT * FROM centralinisti WHERE id=(SELECT centralinista FROM telefonate WHERE id='"+this.id+"');";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				DBCentralinista c = new DBCentralinista();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCognome(rs.getString("cognome"));
				c.setEmail(rs.getString("email"));
				this.centralinista=c;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/*
	public int ottieniLatestID() {
		int ret = 0;
		
		String query = "SELECT MAX(id) FROM telefonate;";
		
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
	public void caricaAppuntamentoDaDB() {
		String query = "SELECT * FROM appuntamenti WHERE telefonata='"+this.id+"';";
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				DBAppuntamento c = new DBAppuntamento();
				c.setId(rs.getInt("idappuntamenti"));
				c.setData(rs.getString("data"));
				c.setOra(rs.getString("ora"));
				c.setNote(rs.getString("note"));
				c.setEsito(rs.getInt("esito"));
				c.setTelefonata(this);
				this.appuntamento=c;
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int salvaInDB() {
		int ret=0;
		String query = "INSERT INTO telefonate(id,data,ora,note,esito,centralinista) VALUES(\'"+this.id+"\',\'"+this.data+"\',\'"+this.ora+"\',\'"+this.note+"\',\'"+this.esito+"\',\'"+this.centralinista.getId()+"\');";
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
	public DBCentralinista getCentralinista() {
		return centralinista;
	}
	public void setCentralinista(DBCentralinista centralinista) {
		this.centralinista = centralinista;
	}
	public DBAppuntamento getAppuntamento() {
		return appuntamento;
	}
	public void setAppuntamento(DBAppuntamento appuntamento) {
		this.appuntamento = appuntamento;
	}
	
	
	
}
