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
		
		EntityCentralino singleton = EntityCentralino.getInstance();
		
		ret = singleton.trovaLista(id); // Information Expert
		if(!(ret>0)) {
			throw new ListaNonTrovata();
		}
		return ret;
		
	}
	
	public static int trovaCentralinista(int id) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.trovaCentralinista(id);
	}
	
	public static String datiCentralinista(int id) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.datiCentralinista(id);
	}
	
	public static int trovaAgente(String CF) {
		int ret = 0;
		EntityCentralino singleton = EntityCentralino.getInstance();
		ret = singleton.trovaAgente(CF);
		return ret;
	}
	
	public static String[] agentiDisponibili() {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.agentiDisponibili();
	}
	
	public static int creaLista(String nome) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.creaLista(nome);
	}
	
	public static int aggiungiNumero(int idLista, String numero) {
		EntityCentralino singleton = EntityCentralino.getInstance();	
		return singleton.aggiungiNumero(idLista, numero);
	}
	
	public static int rimuoviNumero(int idLista, String numero) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.rimuoviNumero(idLista, numero);
	}
	
	// Trova Gruppo: Tipo di ritorno è 0 in caso di fallimento, >0 in caso di successo.
	// In caso di fallimento lancia un'eccezione.
	
	public static int trovaGruppo(int id) throws GruppoNonTrovato{
		int ret=0;
		EntityCentralino singleton = EntityCentralino.getInstance();
		ret = singleton.trovaGruppo(id);
		if(!(ret>0)) {
			throw new GruppoNonTrovato();
		}
		return ret;
	}
	
	public static int creaGruppo(String descrizione) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.creaGruppo(descrizione);
	}
	
	public static int inserisciCentralinistaGruppo(int idGruppo, int idCentralinista) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.inserisciCentralinistaGruppo(idGruppo, idCentralinista);
	}
	
	public static int rimuoviGruppo(int id) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.rimuoviGruppo(id);
	}
	
	public static int assegnaListaGruppo(int idLista, int idGruppo) {
		
		EntityCentralino singleton = EntityCentralino.getInstance();
		
		return singleton.assegnaListaGruppo(idLista, idGruppo);
	}
	
	public static String stampaAppuntamenti(String cf) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.stampaAppuntamenti(cf);
	}
	
	public static String visualizzaNoteChiamata(String cf, int idChiamata) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.visualizzaNoteChiamata(cf, idChiamata);
	}
	
	public static String visualizzaDettagliAppuntamento(String cf, int idAppuntamento) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.visualizzaDettagliAppuntamento(cf, idAppuntamento);
		
	}
	
	public static String ottieniNoteAppuntamento(String cf, int idAppuntamento) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.ottieniNoteAppuntamento(cf, idAppuntamento);
	}
	
	public static String ottieniEsitoAppuntamento(String cf, int idAppuntamento) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.ottieniEsitoAppuntamento(cf, idAppuntamento);
	}
	
	public static int modificaNoteAppuntamento(String cf, int idAppuntamento, String nuoveNote, int esito) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.modificaNoteAppuntamento(cf, idAppuntamento, nuoveNote, esito);
	}
	
	public static ArrayList<String> numeriDaChiamare(int idCentralinista) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.numeriDaChiamare(idCentralinista);
	}
	
	public static int registraEsitoChiamata(String data, String ora, String note, int esito, int idCentralinista) {
		EntityCentralino singleton = new EntityCentralino();
		return singleton.registraEsitoChiamata(data, ora, note, esito, idCentralinista);
	}
	
	public static int creaAppuntamento(String data, String ora, String agente, int idTelefonata) {
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.creaAppuntamento(data, ora, agente, idTelefonata);
	}
	
	// Centralino information expert degli appuntamenti.
	// Non è funzione di uno specifico agente di vendita perché un appuntamento potrebbe non essere assegnato a tale agente.
	
	public static int trovaAppuntamento(int id) {
		
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.trovaAppuntamento(id);
		
	}
	
	public static int referenziaAppuntamento(int idVecchio, int idNuovo) {
		
		EntityCentralino singleton = EntityCentralino.getInstance();
		return singleton.referenziaAppuntamento(idVecchio, idNuovo);
		
	}
	
	// FUNZIONI DI CONTROLLO
	
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
	
	public static boolean isNotaValida(String nota) throws NoteNonValide{
		if(nota.length()<=1000) {
			return true;
		} else {
			throw new NoteNonValide();
		}
	}
	
}
