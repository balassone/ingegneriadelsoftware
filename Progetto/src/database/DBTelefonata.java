package database;

public class DBTelefonata {
	private int id;
	private String data;
	private String ora;
	private String note;
	private int esito;
	private DBCentralinista centralinista;
	private DBAppuntamento appuntamento;
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
