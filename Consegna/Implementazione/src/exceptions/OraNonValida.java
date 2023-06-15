package exceptions;

public class OraNonValida extends Exception{
	public OraNonValida() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Ora Non Valida!";
	}
}
