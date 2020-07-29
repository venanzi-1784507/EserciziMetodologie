package lezione8;

public class GommeDaMasticare extends Prodotto {

	public static final double GOMMA = 1.9;
	
	public GommeDaMasticare() {
		prezzo = GOMMA;
	}
	
	public GommeDaMasticare(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "GommeDaMasticare";
	}
}
