package control;

import entity.EntityListaNumeriTelefonici;
import entity.EntityNumeroTelefonico;

public class Centralino {
	
	public Centralino() {
		super();
	}
	
	public static int creaLista(int id, String nome) {
		EntityListaNumeriTelefonici lista = new EntityListaNumeriTelefonici();
		int ret = lista.ScriviSuDB(id, nome);
		if(ret!=-1) {
			lista.setId(id);
			lista.setNome(nome);
		}
		return ret;
	}
	
	public static int trovaLista(int id) {
		int ret=0;
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici();
		ret = l.trovaLista(id);
		
		return ret;
		
	}
	
	public static int aggiungiNumero(int idLista, String numero) {
		int ret=0;
		
		if(trovaLista(idLista)>0) {
			
			EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(idLista);
			
			EntityNumeroTelefonico n = new EntityNumeroTelefonico(numero);
			
			if(!l.verificaPresenza(n)) {
				ret = n.aggiungiNumero(idLista, numero);
			} else {
				System.out.println("Numero Già Presente!");
			}
		} else {
			ret=-1;
			System.out.println("Lista non trovata!");
		}
		return ret;
	}
	
	public static int rimuoviNumero(int idLista, String numero) {
		int ret=0;
		if(trovaLista(idLista)>0) {
			EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(idLista);
			EntityNumeroTelefonico n = new EntityNumeroTelefonico(numero);
			
			if(l.verificaPresenza(n)) {
				ret = n.rimuoviNumero();
			} else {
				System.out.println("Numero Non Presente!");
			}
		} else {
			ret=-1;
			System.out.println("Lista non trovata!");
		}
		return ret;
	}
	
	public static int creaGruppo(int id, String descrizione, int size) {
		int ret=0;
		
		EntityGruppo = new EntityGruppo();
		
		return ret;
	}
	
	public static int rimuoviGruppo() {
		int ret=0;
		return ret;
	}
	
	public static int trovaGruppo() {
		int ret=0;
		return ret;
	}
	
	public static int assegnaListaGruppo() {
		int ret=0;
		return ret;
	}
	
	public static int visualizzaNoteChiamata() {
		int ret=0;
		return ret;
	}
	
	public static int visualizzaDettagliAppuntamento() {
		int ret=0;
		return ret;
	}
	
	public static int modificaNoteAppuntamento() {
		int ret=0;
		return ret;
	}
	
	public static int richiediProssimoNumero() {
		int ret=0;
		return ret;
	}
	
	public static int registraEsitoChiamata() {
		int ret=0;
		return ret;
	}
	
	public static int creaAppuntamento() {
		int ret=0;
		return ret;
	}
	
	public static int referenziaAppuntamento() {
		int ret=0;
		return ret;
	}
}
