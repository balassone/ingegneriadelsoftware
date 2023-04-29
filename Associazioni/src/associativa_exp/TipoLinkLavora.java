package associativa_exp;



public class TipoLinkLavora {
	
	private final Persona pers;
	private final Azienda az;
	
	private final int annoAssuzione; 
	
	public TipoLinkLavora(Azienda az , Persona pers, int annoAssunzione) throws EccezionePrecondizioni {
		
		if ( az==null || pers == null) 
			throw new EccezionePrecondizioni("Gli oggetti devono essere inizializzati");
		
		this.pers=pers;
		this.az=az;
		this.annoAssuzione=annoAssunzione;
	}

	public Persona getPers() {
		return pers;
	}

	public Azienda getAz() {
		return az;
	}

	public int getAnnoAssuzione() {
		return annoAssuzione;
	}


	
	
	
}
