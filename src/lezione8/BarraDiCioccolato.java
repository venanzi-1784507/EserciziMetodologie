package lezione8;

public class BarraDiCioccolato extends Prodotto {

	public static final double CIOCCOLATO = 2.4;
	
	public BarraDiCioccolato() {
		prezzo = CIOCCOLATO;
	}
	
	public BarraDiCioccolato(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "BarraDiCioccolato";
	}
}
