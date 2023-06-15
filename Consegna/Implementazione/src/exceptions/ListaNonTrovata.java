package exceptions;

public class ListaNonTrovata extends Exception{
	public ListaNonTrovata() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Lista Non Trovata!";
	}
}
