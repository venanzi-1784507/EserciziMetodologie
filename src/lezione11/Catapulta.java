package lezione11;

public class Catapulta implements Armi {

	public static final int DANNO = 1000;
	public static final int TURNI_RICARICA = 4;
	
	private int caricamento;
	
	public Catapulta() {
		//fa danno solo alle mura (prima difesa)
		//deve aspettare 4 attacchi/turni prima di poter attaccare di nuovo
		//all'inizio non deve aspettare
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
			c.subisciDanno(DANNO);
			break;
		case SECONDA:
			//fa danno solo alla prima difesa
			break;
		case TERZA:
			//fa danno solo alla prima difesa
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
