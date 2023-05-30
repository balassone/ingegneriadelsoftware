package control;

import java.util.ArrayList;

import entity.EntitySegreteria;
import entity.EntityStudente;
import entity.EntityTesto;

public class Controller {

	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<String> elencoMatricole(){
		
		
		ArrayList<String> matricole = new ArrayList<String>();		
						
		matricole = EntitySegreteria.getListaMatricole();
		
		return matricole;
	}
	
	
	public static int InserisciTesto(int idTesti, String nome, int idCorso) {
		
		EntityTesto testo = new EntityTesto();
		
		int ret = testo.ScriviSuDB(idTesti, nome, idCorso);
		
		if(ret!=-1) {
			
			testo.setNome(nome);
			testo.setIdTesto(idTesti);
		}
		
		return ret;
	}
	
	public static int CercaTesto(int idTesti) {
		
		int ret = 0;
		EntityTesto t = new EntityTesto();
		
		ret = t.CercaTesto(idTesti);
		
		return ret;
	}
}
