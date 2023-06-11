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
	
	public static int trovaLista(int id) {
		int ret = 0;
		
		ret = DBCentralino.trovaLista(id);
		
		return ret;
	}
	
	public static int ottieniLatestIDLista() {
		int ret=0;
		ret = DBCentralino.ottieniLatestIDLista();
		return ret;
	}
	
	public static int trovaGruppo(int id) {
		int ret=0;
		ret = DBCentralino.trovaGruppo(id);
		return ret;
	}
	
	public static int ottieniLatestIDGruppo() {
		int id=0;
		id = DBCentralino.ottieniLatestIDGruppo();
		return id;
	}
	
	public static int trovaCentralinista(int id) {
		int ret=0;
		ret = DBCentralino.trovaCentralinista(id);
		return ret;
	}
	
	public static int liberaTutti(int idGruppo) {
		int ret = 0;
		ret = DBCentralino.liberaTutti(idGruppo);
		return ret;
	}
	
	public static int trovaAgente(String CF) {
		int ret=0;
		ret = DBCentralino.trovaAgente(CF);
		return ret;
	}
	
	public static String agentiDisponibili() {
		String s = "";
		ArrayList<String> agenti = DBCentralino.agentiDisponibili();
		for(int i=0; i<agenti.size(); i++) {
			s=s+agenti.get(i)+"\n";
		}
		return s;
	}
	
	public static boolean checkListaAssegnata(int id) {
		boolean assegnata=true;
		assegnata = DBCentralino.checkListaAssegnata(id);
		return assegnata;
	}
	
	public static int trovaAppuntamento(int id) {
		int ret=0;
		ret = DBCentralino.trovaAppuntamento(id);
		return ret;
	}
	
	public static int ottieniLatestIDAppuntamento() {
		int id=0;
		id = DBCentralino.ottieniLatestIDAppuntamento();
		return id;
	}
	public static int ottieniLatestIDTelefonata() {
		int id=0;
		id = DBCentralino.ottieniLatestIDTelefonata();
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
