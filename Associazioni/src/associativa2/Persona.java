package associativa2;

import java.util.HashSet;
import java.util.Set;

public class Persona {

	private String nome;
	private HashSet<TipoLinkHaLavorato> insiemeLink;
	
	public Persona(String nome) {
		
		this.nome=nome;
		insiemeLink = new HashSet<TipoLinkHaLavorato>();
	}
	
	public String getNome() {return this.nome;}
	
	public void inserisciLinkHaLavorato(TipoLinkHaLavorato t) {
		
		if (t != null && t.getPers() == this)
			insiemeLink.add(t);
	}
	
	public void eliminaLinkHaLavorato(TipoLinkHaLavorato t) {
		
		if (t != null && t.getPers() == this)
			insiemeLink.remove(t);
	}
	
	public Set<TipoLinkHaLavorato> getLinkHaLavorato() {
		
		return (HashSet<TipoLinkHaLavorato>)insiemeLink.clone();
	}
}
