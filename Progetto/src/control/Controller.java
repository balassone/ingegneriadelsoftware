package control;

import entity.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import exceptions.*;

// Classe preposta ad implementare tutti i metodi chiamati al click dei bottoni della GUI.

public class Controller {
	
	// Trova Lista: Tipo di ritorno è 0 in caso di fallimento, >0 in caso di successo.
	// In caso di fallimento lancia un'eccezione.
	
	public static int trovaLista(int id) throws ListaNonTrovata{
		int ret=0;
		
		ret = EntityCentralino.trovaLista(id); // Information Expert
		if(!(ret>0)) {
			throw new ListaNonTrovata();
		}
		return ret;
		
	}
	
	public static int trovaCentralinista(int id) {
		int ret = 0;
		ret = EntityCentralino.trovaCentralinista(id);
		return ret;
	}
	
	public static String datiCentralinista(int id) {
		EntityCentralinista c = new EntityCentralinista(id);
		return c.getNome()+" "+c.getCognome();
	}
	
	public static int trovaAgente(String CF) {
		int ret = 0;
		ret = EntityCentralino.trovaAgente(CF);
		return ret;
	}
	
	public static String agentiDisponibili() {
		return EntityCentralino.agentiDisponibili();
	}
	
	// Crea Lista: Tipo di ritorno è 0 in caso di fallitmento, ID della nuova lista in caso di successo.
	
	public static int creaLista(String nome) {
		int ret=0;
		
		int id = EntityCentralino.ottieniLatestIDLista(); // Conosce l'ID che può essere assegnato ad una nuova Lista.
		
		EntityListaNumeriTelefonici lista = new EntityListaNumeriTelefonici();
		
		ret = lista.ScriviSuDB(id, nome);
		
		if(ret>0) {
			ret=id;
		}
		return ret;
	}
	
	// Aggiungi Numero: Tipo di ritorno è 0 in caso di fallimento, >0 in caso di successo.
	
	public static int aggiungiNumero(int idLista, String numero) {
		int ret=0;
			
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(idLista);
			
		EntityNumeroTelefonico n = new EntityNumeroTelefonico(numero);
			
		if(!l.verificaPresenza(n)) {
			ret = n.aggiungiNumero(idLista, numero);
		}
		
		return ret;
	}
	
	// Rimuovi Numero: Tipo di ritorno è 0 in caso di fallimento, >0 in caso di successo.
	
	public static int rimuoviNumero(int idLista, String numero) {
		int ret=0;
		
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(idLista);
		EntityNumeroTelefonico n = new EntityNumeroTelefonico(numero);
			
		if(l.verificaPresenza(n)) {
			ret = n.rimuoviNumero();
		}
		
		return ret;
	}
	
	// Trova Gruppo: Tipo di ritorno è 0 in caso di fallimento, >0 in caso di successo.
	// In caso di fallimento lancia un'eccezione.
	
	public static int trovaGruppo(int id) throws GruppoNonTrovato{
		int ret=0;
		
		ret = EntityCentralino.trovaGruppo(id);
		
		if(!(ret>0)) {
			throw new GruppoNonTrovato();
		}
		return ret;
	}
	
	// Crea Gruppo: Tipo di ritorno è 0 in caso di fallitmento, ID del nuovo gruppo in caso di successo.
	
	public static int creaGruppo(String descrizione) {
		int ret=0;
		int id=0;
		
		id = EntityCentralino.ottieniLatestIDGruppo();
		
		EntityGruppo g = new EntityGruppo();
		
		ret = g.scriviSuDB(id,descrizione);
		
		if(ret>0) {
			ret=id;
		}
		
		return ret;
	}
	
	// Inserisci Centralinista nel Gruppo: Tipo di ritorno è 0 in caso di fallitmento, >0 in caso di successo.
	
	public static int inserisciCentralinistaGruppo(int idGruppo, int idCentralinista) {
		int ret=0;
		EntityCentralinista c = new EntityCentralinista();
		ret = c.assegnaGruppo(idGruppo, idCentralinista);
		return ret;
	}
	
	// Rimuovi Gruppo: per evitare inconsistenze lato DB,
	// 1. Viene chiamata una funzione responsabile di rimuovere i centralinisti dal gruppo che si vuole eliminare;
	// 2. Una volta completato, viene effettivamente rimosso il gruppo.
	
	public static int rimuoviGruppo(int id) {
		int ret=0;
		
		if(EntityCentralino.liberaTutti(id)>0) {
			EntityGruppo g = new EntityGruppo();
			ret = g.rimuoviDaDB(id);
		}
		
		return ret;
	}
	// Assegna Lista a Gruppo:
	// Centralino verifica che la lista non sia stata precedentemente assegnata ad un altro gruppo.
	
	public static int assegnaListaGruppo(int idLista, int idGruppo) {
		int ret=0;
		
		EntityGruppo g = new EntityGruppo();
		
		if(!(EntityCentralino.checkListaAssegnata(idLista))) {
			ret=g.assegnaLista(idLista, idGruppo);
		}
		
		return ret;
	}
	
	// Dato il CF dell'agente di vendita, secondo la navigabilità dell'associazione, avrà accesso a tutti i suoi appuntamenti.
	
	public static ArrayList<EntityAppuntamento> ottieniAppuntamenti(String cf) {
		EntityAgentediVendita a = new EntityAgentediVendita(cf);
		return a.getAppuntamenti();
	}
	
	// Come l'agente ha accesso ad i suoi appuntamenti, essendo un appuntamento mappato uno a uno con una telefonata, è possibile
	// accedere in molto semplice all'oggetto Telefonata relativa all'Appuntamento.
	
	public static String visualizzaNoteChiamata(String cf, int idChiamata) {
		EntityAgentediVendita a = new EntityAgentediVendita(cf);
		ArrayList<EntityAppuntamento> l = a.getAppuntamenti();
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getTelefonata().getId()==idChiamata) {
				return l.get(i).getTelefonata().getNote();
			}
		}
		return "Chiamata non trovata";
	}
	
	// Agente visualizza tutte le informazioni relative ad i propri appuntamenti.
	
	public static String visualizzaDettagliAppuntamento(String cf, int idAppuntamento) {
		EntityAgentediVendita a = new EntityAgentediVendita(cf);
		ArrayList<EntityAppuntamento> l = a.getAppuntamenti();
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				return l.get(i).toString();
			}
		}
		return "Non Trovato";
		
	}
	
	// Agente visualizza solo le note, sarà utile come punto di partenza per una eventuale modifica delle note.
	
	public static String ottieniNoteAppuntamento(String cf, int idAppuntamento) {
		String s="";
		EntityAgentediVendita a = new EntityAgentediVendita(cf);
		ArrayList<EntityAppuntamento> l = a.getAppuntamenti();
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				s = l.get(i).getNote();
				return s;
			} 
		}
		
		return "APPUNTAMENTO INESISTENTE";
	}
	
	public static String ottieniEsitoAppuntamento(String cf, int idAppuntamento) {
		String s="";
		EntityAgentediVendita a = new EntityAgentediVendita(cf);
		ArrayList<EntityAppuntamento> l = a.getAppuntamenti();
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				s = String.valueOf(l.get(i).getEsito());
			}
		}
		return s;
	}
	
	// Chiama il metodo Setter dell'entità appuntamento, da poi aggiornare su DB.
	
	public static int modificaNoteAppuntamento(String cf, int idAppuntamento, String nuoveNote, int esito) {
		int ret=0;
		EntityAgentediVendita a = new EntityAgentediVendita(cf);
		ArrayList<EntityAppuntamento> l = a.getAppuntamenti();
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getId()==idAppuntamento) {
				l.get(i).setEsito(esito);
				l.get(i).setNote(nuoveNote);
				ret = l.get(i).aggiornaSuDB();
			}
		}
		
		return ret;
	}
	
	// Il centralinista appartiene ad un gruppo che a sua volta ha una lista assegnata. In tal caso visualizza i numeri da chiamare.
	
	public static ArrayList<EntityNumeroTelefonico> numeriDaChiamare(int idCentralinista) {
		
		EntityCentralinista c = new EntityCentralinista(idCentralinista);
		EntityListaNumeriTelefonici l = new EntityListaNumeriTelefonici(c.getGruppo().getLista().getId());
		ArrayList<EntityNumeroTelefonico> nums = l.getNumeri();
		return nums;
	}
	
	// Form di inserimento telefonata. In caso positivo ne ritorna l'ID.
	
	public static int registraEsitoChiamata(String data, String ora, String note, int esito, int idCentralinista) {
		
		int ret=0;
		
		int id = EntityCentralino.ottieniLatestIDTelefonata();
		EntityTelefonata t = new EntityTelefonata();
		t.setId(id);
		t.setData(data);
		t.setOra(ora);
		t.setNote(note);
		t.setEsito(esito);
		EntityCentralinista ce = new EntityCentralinista(idCentralinista);
		t.setCentralinista(ce);
		
		ret = t.salvaInDB();
		
		if(ret>0) {
			ret=id;
		}
		return ret;
	}
	
	// Form di inserimento appuntamento. In caso positivo ne ritorna l'ID.
	
	public static int creaAppuntamento(String data, String ora, String agente, int idTelefonata) {
		int ret=0;
		int id = EntityCentralino.ottieniLatestIDAppuntamento();
		EntityAppuntamento a = new EntityAppuntamento();
		a.setId(id);
		a.setData(data);
		a.setOra(ora);
		a.setAgente(new EntityAgentediVendita(agente));
		a.setTelefonata(new EntityTelefonata(idTelefonata));
		
		ret = a.salvaInDB();
		
		if(ret>0) {
			ret=id;
		}
		
		return ret;
	}
	
	// Centralino information expert degli appuntamenti.
	// Non è funzione di uno specifico agente di vendita perché un appuntamento potrebbe non essere assegnato a tale agente.
	
	public static int trovaAppuntamento(int id) {
		int ret=0;
		
		ret = EntityCentralino.trovaAppuntamento(id);
		
		return ret;
	}
	
	// Esito positivo se effettivamente l'appuntamento precedente è fallito.
	
	public static int referenziaAppuntamento(int idVecchio, int idNuovo) {
		int ret=0;
		
		EntityAppuntamento a = new EntityAppuntamento(idNuovo);
		EntityAppuntamento b = new EntityAppuntamento(idVecchio);
		if(b.getEsito()==1) {
			a.setPrecedente(idVecchio);
			ret = a.referenziaInDB();
		}
		
			
		
		return ret;
	}
	
	public static boolean isDataValida(String dataStringa) throws DataNonValida{
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        formatoData.setLenient(false); // Impedisce la conversione di date non valide

        try {
            formatoData.parse(dataStringa);
            return true;
        } catch (ParseException e) {
            throw new DataNonValida();
        }
    }
	public static boolean isOraValida(String oraStringa) throws OraNonValida {
        DateFormat formatoOra = new SimpleDateFormat("HH:mm");
        formatoOra.setLenient(false); // Impedisce la conversione di orari non validi

        try {
            formatoOra.parse(oraStringa);
            return true;
        } catch (ParseException e) {
            throw new OraNonValida();
        }
    }
	
	public static boolean isNumeroTelefonoValido(String numeroTelefono) throws NumeroNonValido{
        // Definisci l'espressione regolare per un numero di telefono a 10 cifre
        String regex = "^\\d{10}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numeroTelefono);

        if(matcher.matches()) {
        	return true;
        } else {
        	throw new NumeroNonValido();
        }
    }
	
}
