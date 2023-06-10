package entity;

import java.util.ArrayList;

import database.DBAppuntamento;
import database.DBCentralinista;
import database.DBCentralino;
import database.DBGruppo;
import database.DBListaNumeriTelefonici;
import database.DBTelefonata;

public class EntityCentralino {
	private ArrayList<EntityGruppo> gruppi;
	private ArrayList<EntityListaNumeriTelefonici> liste;
	private ArrayList<EntityCentralinista> centralinisti;
	private ArrayList<EntityAppuntamento> appuntamenti;
	private ArrayList<EntityTelefonata> telefonate;
	private ArrayList<EntityAppuntamento> falliti;
	
	public EntityCentralino() {
		super();
	}
	
	public int trovaLista(int id) {
		int ret = 0;
		
		DBCentralino c = new DBCentralino();
		ret = c.trovaLista(id);
		
		return ret;
	}
	
	public int ottieniLatestIDLista() {
		int ret=0;
		DBCentralino c = new DBCentralino();
		ret = c.ottieniLatestIDLista();
		return ret;
	}
	
	public int trovaGruppo(int id) {
		int ret=-1;
		DBCentralino g = new DBCentralino();
		ret = g.trovaGruppo(id);
		return ret;
	}
	
	public int ottieniLatestIDGruppo() {
		int id=0;
		DBCentralino c = new DBCentralino();
		id = c.ottieniLatestIDGruppo();
		return id;
	}
	
	public int liberaTutti(int idGruppo) {
		int ret = 0;
		DBCentralino c = new DBCentralino();
		ret = c.liberaTutti(idGruppo);
		return ret;
	}
	
	public boolean checkListaAssegnata(int id) {
		boolean assegnata=true;
		DBCentralino c = new DBCentralino();
		assegnata = c.checkListaAssegnata(id);
		return assegnata;
	}
	
	public int trovaAppuntamento(int id) {
		int ret=0;
		DBCentralino c = new DBCentralino();
		ret=c.trovaAppuntamento(id);
		return ret;
	}
	
	public int ottieniLatestIDAppuntamento() {
		int id=0;
		DBCentralino c = new DBCentralino();
		id=c.ottieniLatestIDAppuntamento();
		return id;
	}
	public int ottieniLatestIDTelefonata() {
		int id=0;
		DBCentralino c = new DBCentralino();
		id=c.ottieniLatestIDTelefonata();
		return id;
	}

	public ArrayList<EntityGruppo> getGruppi() {
		return gruppi;
	}

	public void setGruppi(ArrayList<EntityGruppo> gruppi) {
		this.gruppi = gruppi;
	}

	public ArrayList<EntityListaNumeriTelefonici> getListe() {
		return liste;
	}

	public void setListe(ArrayList<EntityListaNumeriTelefonici> liste) {
		this.liste = liste;
	}

	public ArrayList<EntityCentralinista> getCentralinisti() {
		return centralinisti;
	}

	public void setCentralinisti(ArrayList<EntityCentralinista> centralinisti) {
		this.centralinisti = centralinisti;
	}

	public ArrayList<EntityAppuntamento> getAppuntamenti() {
		return appuntamenti;
	}

	public void setAppuntamenti(ArrayList<EntityAppuntamento> appuntamenti) {
		this.appuntamenti = appuntamenti;
	}

	public ArrayList<EntityTelefonata> getTelefonate() {
		return telefonate;
	}

	public void setTelefonate(ArrayList<EntityTelefonata> telefonate) {
		this.telefonate = telefonate;
	}

	public ArrayList<EntityAppuntamento> getFalliti() {
		return falliti;
	}

	public void setFalliti(ArrayList<EntityAppuntamento> falliti) {
		this.falliti = falliti;
	}
	
	
	
}