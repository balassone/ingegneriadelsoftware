package entity;

import java.util.ArrayList;
import database.DBAgentediVendita;

public class EntityAgentediVendita {
	private String codicefiscale;
	private ArrayList<EntityAppuntamento> appuntamenti;
	
	public EntityAgentediVendita() {
		super();
		this.appuntamenti=new ArrayList<EntityAppuntamento>();
	}
	
	public EntityAgentediVendita(String cf) {
		this.codicefiscale=cf;
		this.appuntamenti=new ArrayList<EntityAppuntamento>();
		DBAgentediVendita a = new DBAgentediVendita(cf);
		a.caricaAppuntamentiDaDB(); 
		caricaAppuntamenti(a); 
	}
	
	public EntityAgentediVendita(DBAgentediVendita a) {
		this.codicefiscale=a.getCodicefiscale();
		a.caricaAppuntamentiDaDB();
		caricaAppuntamenti(a);
	}
	
	public void caricaAppuntamenti(DBAgentediVendita a) {
		for(int i=0; i<a.getAppuntamenti().size(); i++) {
			EntityAppuntamento ap = new EntityAppuntamento(a.getAppuntamenti().get(i)); //problema?
			this.appuntamenti.add(ap);
		}
	}

	public String getCodicefiscale() {
		return codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public ArrayList<EntityAppuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(ArrayList<EntityAppuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

	@Override
	public String toString() {
		return "EntityAgentediVendita [codicefiscale=" + codicefiscale + ", appuntamenti=" + appuntamenti + "]";
	}
	
	
	
}
