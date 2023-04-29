package gen;

public class Studente implements Comparable<Studente> {

	private String studentname;
    private int matricola;
    private int eta;
	
    
    
    public Studente(String studentname, int matricola, int eta) {
		super();
		this.studentname = studentname;
		this.matricola = matricola;
		this.eta = eta;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}

	
	@Override
	public String toString() {
		
		return "[ mat=" + matricola + ", name=" + studentname + ", eta=" + eta + "]";
	}
	
	@Override
	public int compareTo(Studente s) {
		
		// TODO Auto-generated method stub
		if ( this.eta < s.getEta()) return 1;
		if ( this.eta > s.getEta()) return -1;
		return 0;
	}
	
	
	
	
    
    
	
}
