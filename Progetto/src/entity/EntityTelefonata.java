package entity;

import database.DBTelefonata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import database.DBCentralinista;
import exceptions.DataNonValida;
import exceptions.EsitoTelefonataNonValido;
import exceptions.NoteNonValide;
import exceptions.OraNonValida;

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
		
	}
	
	public EntityTelefonata(DBTelefonata t) {
		super();
		this.id=t.getId();
		this.data=t.getData();
		this.ora=t.getOra();
		this.note=t.getNote();
		this.esito=t.getEsito();
		
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
	
	// N.B. Nei setters ci sono gli stessi controlli effettuati dalle classi boundary
	// Per Test jUnit
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) throws DataNonValida{
		DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        formatoData.setLenient(false); // Impedisce la conversione di date non valide

        try {
            formatoData.parse(data);
            this.data=data;
        } catch (ParseException e) {
            throw new DataNonValida();
        }
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) throws OraNonValida{
		DateFormat formatoOra = new SimpleDateFormat("HH:mm");
        formatoOra.setLenient(false); // Impedisce la conversione di orari non validi

        try {
            formatoOra.parse(ora);
            this.ora=ora;
        } catch (ParseException e) {
            throw new OraNonValida();
        }
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) throws NoteNonValide{
		if(note.length()<=1000) {
			this.note=note;
		} else {
			throw new NoteNonValide();
		}
	}

	public int getEsito() {
		return esito;
	}

	public void setEsito(int esito) throws EsitoTelefonataNonValido{
		if(esito>0 && esito<6) {
			this.esito=esito;
		} else {
			throw new EsitoTelefonataNonValido();
		}
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
