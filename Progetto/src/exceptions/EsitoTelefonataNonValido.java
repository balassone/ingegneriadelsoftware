package exceptions;

public class EsitoTelefonataNonValido extends Exception{
	public EsitoTelefonataNonValido() {
		super();
	}
	
	public String toString() {
		return "Esito Non Valido!";
	}
}
