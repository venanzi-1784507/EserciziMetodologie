package lab_1;

public class Articolo {

	public static enum Stato { NUOVO, USATO, RICONDIZIONATO; }
	
	private Stato stato;
	private String nome; 
	private String descrizione;
	private double prezzo;
	
	public Stato getStato() { return stato; }
	public String getNome() { return nome; }
	public String getDescrizione() { return descrizione; }
	public double getPrezzo() { return prezzo; }
	
	public Articolo(String nome, double prezzo, Stato stato, String descrizione) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.stato = stato;
		this.descrizione = descrizione;
	}
	
	@Override
	public String toString() {
		return "nome:" + nome + ", " + prezzo + "€, " + stato;
	}
}
