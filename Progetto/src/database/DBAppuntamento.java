package database;

public class DBAppuntamento {
	private int id;
	private String data;
	private String ora;
	private String note;
	private String esito;
	private DBTelefonata telefonata;
	private DBAppuntamento precedente; // Potrebbe anche essere int, vediamo come caricarlo dal DB
	private DBAgentediVendita agente;
}
