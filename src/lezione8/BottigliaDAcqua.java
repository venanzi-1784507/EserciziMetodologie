package lezione8;

public class BottigliaDAcqua extends Prodotto {

	public static final double ACQUA = 1.5;
	
	public BottigliaDAcqua() {
		prezzo = ACQUA;
	}
	
	public BottigliaDAcqua(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "BottigliaDAcqua";
	}
}
