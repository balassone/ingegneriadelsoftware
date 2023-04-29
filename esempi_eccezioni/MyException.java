
public class MyException extends Exception {

	private String messaggio;
	
	public MyException(String m) {
		
		messaggio = m;
	
	}
	
	public MyException() {
	}
	
	public String toString() {
		
		return messaggio;
	}
	
	
}
