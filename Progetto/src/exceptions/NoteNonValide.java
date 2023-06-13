package exceptions;

public class NoteNonValide extends Exception{
	public NoteNonValide() {
		super();
	}
	
	public String toString() {
		return "Note Non Valide!";
	}
}
