package exceptions;

public class NumeroNonValido extends Exception{
	public NumeroNonValido() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Numero Non Valido!";
	}
}
