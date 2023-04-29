package riflessiva;

import java.util.ArrayList;

public class Azienda {
	
	
	private String nome;
	
	private Azienda controllante;
	
	//private ArrayList<Azienda> controllate;
	
	//COSTRUTTORE
	public Azienda(String n) {nome = n;}
	
	public Azienda getControllante() {
		
		return this.controllante;
	}
	
	public void setControllante(Azienda a) {
		
		this.controllante = a;
	}
	
	
	public String toString() {
		
		return nome + ((this.controllante ==null)?" ": (" controllata da :"+controllante));
	}

}
