package exceptions;

public class EsitoAppuntamentoNonValido extends Exception{
	public EsitoAppuntamentoNonValido() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Esito Non Valido!";
	}
}
