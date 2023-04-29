package associativa2;

public class TipoLinkHaLavorato {

	private final Persona pers;
	private final Azienda az;
	private final int annoInzio, annoFine;
	
	public TipoLinkHaLavorato(Azienda az, Persona pers, int ai, int af) {
		
		this.az=az;
		this.pers=pers;
		this.annoFine=af;
		this.annoInzio=ai;	
		
	}

	public Persona getPers() {
		return pers;
	}

	public Azienda getAz() {
		return az;
	}

	public int getAnnoInzio() {
		return annoInzio;
	}

	public int getAnnoFine() {
		return annoFine;
	}
	
	
	
}
