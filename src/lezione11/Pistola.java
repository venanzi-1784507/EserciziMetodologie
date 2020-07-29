package lezione11;

public class Pistola implements Armi {

	public static final int MAX_DANNO = 500;
	public static final int TURNI_RICARICA = 0;
	
	private double danno;
	private int caricamento;
	
	public Pistola() {
		//fa il 2% di danno alle mura (prima difesa)
		//fa il 50% di danno alle difese esterne (seconda difesa)
		//fa il 400% di danno alle difese interne (terza/ultima difesa)
		//ogni colpo perde il 10% del danno attuale
		danno = MAX_DANNO;
		//ogni turno può attacare
	}
	@Override
	public void attacca(Castello c) {
		if(staCaricando())
			return;
		
		//altrimenti
		caricamento = TURNI_RICARICA;
		
		switch(c.getDifesa()) {
		case PRIMA:
			c.subisciDanno(danno * 0.02);
			danno -= danno * 0.1;
			break;
		case SECONDA:
			c.subisciDanno(danno * 0.5);
			danno -= danno * 0.1;
			break;
		case TERZA:
			c.subisciDanno(danno * 400);
			danno -= danno * 0.1;
			break;
		}
		
		//il danno non può scendere sotto i 20
		if(danno < 20)
			danno = 20;
	}
	
	@Override
	public boolean staCaricando() {
		if(caricamento != 0) {
			caricamento--;
			return true;
		}
		return false;
	}

}
