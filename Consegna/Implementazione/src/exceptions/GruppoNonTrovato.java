package exceptions;

public class GruppoNonTrovato extends Exception{
	public GruppoNonTrovato() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Gruppo Non Trovato!";
	}
}
