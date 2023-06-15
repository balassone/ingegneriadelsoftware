package exceptions;

public class NoteNonValide extends Exception{
	public NoteNonValide() {
		super();
	}
	
	public String toString() {
		return "[ECCEZIONE] Note Non Valide!";
	}
}
