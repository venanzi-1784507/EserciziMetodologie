package lezione6;

public class Carta {

	public static enum SEME {FIORI, CUORI, QUADRI, PICCHE};
	public static enum VALORI {UNO, DUE, TRE, QUATTRO, CINQUE, SEI, SETTE, OTTO, NOVE, DIECI, JACK, QUEEN, KING}
	
	private SEME semeCarta;
	private int valore;
	private VALORI valoreCarta;
	
	public Carta(SEME s, int valore) {
		semeCarta = s;
		this.valore = valore;
		valoreCarta = valoreEnumValore();
	}
	
	private VALORI valoreEnumValore() {
		//in base al valore assegnare il valore dell'enum corrispondente
		switch(valore) {
		case 0: return VALORI.UNO;
		case 1: return VALORI.DUE;
		case 2: return VALORI.TRE;
		case 3: return VALORI.QUATTRO;
		case 4: return VALORI.CINQUE;
		case 5: return VALORI.SEI;
		case 6: return VALORI.SETTE;
		case 7: return VALORI.OTTO;
		case 8: return VALORI.NOVE;
		case 9: return VALORI.DIECI;
		case 10: return VALORI.JACK;
		case 11: return VALORI.QUEEN;
		case 12: return VALORI.KING;
		}
		return VALORI.UNO;
	}
	
	@Override
	public String toString() {
		return valoreCarta + " " + semeCarta;
	}
}
