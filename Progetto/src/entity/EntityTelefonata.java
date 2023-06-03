package entity;

import database.DBTelefonata;
import database.DBCentralinista;

public class EntityTelefonata {
	private int id;
	private String data;
	private String ora;
	private String note;
	private int esito;
	private EntityCentralinista centralinista;
	private EntityAppuntamento appuntamento;
	
	public EntityTelefonata() {
		super();
	}
	
	public EntityTelefonata(int id) {
		super();
		this.id=id;
		DBTelefonata t = new DBTelefonata(id);
		this.data=t.getData();
		this.ora=t.getOra();
		this.note=t.getNote();
		this.esito=t.getEsito();
		//t.caricaAppuntamentoDaDB();
		//caricaAppuntamento(t);
		//t.caricaCentralinistaDaDB();
		//caricaCentralinista(t);
	}
	
	public EntityTelefonata(DBTelefonata t) {
		super();
		this.id=t.getId();
		this.data=t.getData();
		this.ora=t.getOra();
		this.note=t.getNote();
		this.esito=t.getEsito();
		//t.caricaAppuntamentoDaDB();
		//caricaAppuntamento(t);
		//t.caricaCentralinistaDaDB();
		//caricaCentralinista(t);
	}
	
	public void caricaAppuntamento(DBTelefonata t) {
		EntityAppuntamento a = new EntityAppuntamento(t.getAppuntamento());
		this.appuntamento=a;
	}
	
	public void caricaCentralinista(DBTelefonata t) {
		EntityCentralinista c = new EntityCentralinista(t.getCentralinista());
		this.centralinista=c;
	}
	
	public int salvaInDB() {
		int ret=0;
		
		DBTelefonata t = new DBTelefonata();
		t.setId(this.id);
		t.setData(data);
		t.setOra(ora);
		t.setNote(note);
		t.setEsito(esito);
		DBCentralinista c = new DBCentralinista(centralinista.getId());
		t.setCentralinista(c);
		
		ret = t.salvaInDB();
		
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

	public EntityCentralinista getCentralinista() {
		return centralinista;
	}

	public void setCentralinista(EntityCentralinista centralinista) {
		this.centralinista = centralinista;
	}

	public EntityAppuntamento getAppuntamento() {
		return appuntamento;
	}

	public void setAppuntamento(EntityAppuntamento appuntamento) {
		this.appuntamento = appuntamento;
	}

	@Override
	public String toString() {
		return "EntityTelefonata [id=" + id + ", data=" + data + ", ora=" + ora + ", esito=" + esito
				+ ", centralinista=" + centralinista + ", appuntamento=" + appuntamento + "]";
	}
	
	
	
}
