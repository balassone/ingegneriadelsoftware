package control;

import entity.*;
import java.util.ArrayList;

public class Centralino {
	
	public static int trovaLista(int id) {
		int ret=0;
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici();
		ret = l.trovaLista(id);
		return ret;
		
	}
	
	public static int creaLista(String nome) {
		int ret=-1;
		EntityListaNumeriTelefonici lista = new EntityListaNumeriTelefonici();
		int id=lista.ottieniLatestID();
		ret = lista.ScriviSuDB(id, nome);
		if(ret!=-1) {
			lista.setId(id);
			lista.setNome(nome);
		}
		return ret;
	}
	
	
	
	public static int aggiungiNumero(int idLista, String numero) {
		int ret=0;
			
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(idLista);
			
		EntityNumeroTelefonico n = new EntityNumeroTelefonico(numero);
			
		if(!l.verificaPresenza(n)) {
			ret = n.aggiungiNumero(idLista, numero);
		} else {
			ret = -1;
		}
		return ret;
	}
	
	public static int rimuoviNumero(int idLista, String numero) {
		int ret=0;
		
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(idLista);
		EntityNumeroTelefonico n = new EntityNumeroTelefonico(numero);
			
		if(l.verificaPresenza(n)) {
			ret = n.rimuoviNumero();
		}
		
		return ret;
	}
	
	public static int trovaGruppo(int id) {
		int ret=0;
		EntityGruppo g = new EntityGruppo();
		ret = g.trovaGruppo(id);
		return ret;
	}
	
	public static int creaGruppo(int id, String descrizione) {
		int ret=0;
		
		if(!(trovaGruppo(id)>0)) {
			EntityGruppo g = new EntityGruppo();
			ret = g.scriviSuDB(id,descrizione);
			// TODO Da gestire l'aggiunta di centralinisti!
		} else {
			System.out.println("Il gruppo ha un ID già esistente!");
		}
		
		return ret;
	}
	
	
	
	public static int rimuoviGruppo(int id) {
		int ret=0;
		// TODO Da gestire centralinisti con gruppo assegnato!
		if(trovaGruppo(id)>0) {
			EntityGruppo g = new EntityGruppo();
			ret = g.rimuoviDaDB(id);
		} else {
			System.out.println("Gruppo Non Trovato!");
		}
		
		return ret;
	}
	
	public static int assegnaListaGruppo(int idLista, int idGruppo) {
		int ret=0;
		EntityGruppo g = new EntityGruppo();
		if(!(g.checkListaAssegnata(idLista))) {
			ret=g.assegnaLista(idLista, idGruppo);
		} else {
			System.out.println("Lista già assegnata!");
		}
		
		return ret;
	}
	
	public static ArrayList<EntityAppuntamento> ottieniAppuntamenti(String cf) {
		EntityAgentediVendita a = new EntityAgentediVendita(cf);
		return a.getAppuntamenti();
	}
	
	public static String visualizzaNoteChiamata(String cf, int idChiamata) {
		ArrayList<EntityAppuntamento> l = ottieniAppuntamenti(cf);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getTelefonata().getId()==idChiamata) {
				return l.get(i).getTelefonata().getNote();
			}
		}
		return "Chiamata non trovata";
	}
	
	
	public static String visualizzaDettagliAppuntamento(String cf, int idAppuntamento) {
		
		ArrayList<EntityAppuntamento> l = ottieniAppuntamenti(cf);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				return l.get(i).toString();
			}
		}
		return "Non Trovato";
		
	}
	
	public static int modificaNoteAppuntamento(String cf, int idAppuntamento, String nuoveNote) {
		int ret=0;
		
		ArrayList<EntityAppuntamento> l = ottieniAppuntamenti(cf);
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				l.get(i).setNote(nuoveNote);
				ret = l.get(i).aggiornaSuDB();
			}
		}
		
		return ret;
	}
	
	public static int richiediProssimoNumero(int idCentralinista) {
		int ret=0;
		
		EntityCentralinista c = new EntityCentralinista(idCentralinista);
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(c.getGruppo().getLista().getId());
		ArrayList<EntityNumeroTelefonico> nums = l.getNumeri();
		for(int i=0; i<nums.size(); i++) {
			System.out.println(nums.get(i).getNumero());
		}
		
		return ret;
	}
	
	public static int registraEsitoChiamata(int id, String data, String ora, String note, int esito, int idCentralinista) {
		int ret=0;
		
		EntityTelefonata t = new EntityTelefonata();
		t.setId(id);
		t.setData(data);
		t.setOra(ora);
		t.setNote(note);
		t.setEsito(esito);
		EntityCentralinista c = new EntityCentralinista(idCentralinista);
		t.setCentralinista(c);
		
		ret = t.salvaInDB();
		
		if(esito==5) {
			//non so se posso farlo qui creaAppuntamento
		}
		
		return ret;
	}
	
	public static int creaAppuntamento(int id, String data, String ora, String note, int esito, String agente, int idTelefonata) {
		int ret=0;
		
		EntityAppuntamento a = new EntityAppuntamento();
		
		a.setId(id);
		a.setData(data);
		a.setOra(ora);
		a.setNote(note);
		a.setEsito(esito);
		a.setAgente(new EntityAgentediVendita(agente));
		a.setTelefonata(new EntityTelefonata(idTelefonata));
		
		ret = a.salvaInDB();
		
		
		return ret;
	}
	
	public static int trovaAppuntamento(int id) {
		int ret=0;
		
		EntityAppuntamento a = new EntityAppuntamento();
		ret = a.trovaAppuntamento(id);
		
		return ret;
	}
	
	public static int referenziaAppuntamento(int idVecchio, int idNuovo) {
		int ret=0;
		
		if(trovaAppuntamento(idVecchio)>0) {
			if (trovaAppuntamento(idNuovo)>0) {
				System.out.println("Trovati entrambi!");
				EntityAppuntamento a = new EntityAppuntamento(idNuovo);
				EntityAppuntamento b = new EntityAppuntamento(idVecchio);
				a.setPrecedente(b);
				
				ret = a.referenziaInDB();
			}
		}
		
		return ret;
	}
}
