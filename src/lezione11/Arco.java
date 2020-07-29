package lezione11;

import java.util.Random;

public class Arco implements Armi {

	Random random = new Random();
	private final int MAX_DANNO = 200;
	private final int MIN_DANNO = 100;
	private double danno;
	
	public static final int TURNI_RICARICA = 4;
	
	private int caricamento;
	
	public Arco() {
		//il danno è randomico ma solo al momento di istanziazione poi rimane fisso
		//da 0 a 99 a cui poi sommo 100, così da ottenere un numero da 100 a 200
		danno = random.nextInt(MIN_DANNO) + MIN_DANNO;
		//non fa danno alle mura (prima difesa)
		//fa il 10% di danno alle difese esterne (seconda difesa)
		//all'ultima/terza difesa fa il 100% di danno + 5% di danno della vita rimanente del castello
		//l'arco scocca solo ogni 2 attacchi
		//all'inizio non deve caricare
		caricamento = 0;
	}
	
	@Override
	public void attacca(Castello c) {
		if(staCaricando())
			return;
		
		//altrimenti
		caricamento = TURNI_RICARICA;
		
		switch(c.getDifesa()) {
		case PRIMA:
			//non fa danno alle prime difese
			break;
		case SECONDA:
			c.subisciDanno(danno * 0.10);
			break;
		case TERZA:
			c.subisciDanno(danno + (c.getVita() * 0.05));
			break;
		}

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
