package lezione9;

public abstract class RiproduttoreMusicale {

	protected Supporto supporto;
	protected int currentBrano = 0;
	protected boolean inEsecuzione = false;;
	
	public RiproduttoreMusicale(Supporto s) {
		supporto = s;
	}
	
	public RiproduttoreMusicale() {
	}
	
	public boolean inserisciSupporto(Supporto s) {
		if(supporto != null) return false;
		supporto = s;
		return true;
	}
	
	/**
	 * espelle il supporto presente e azzera il selezionatore di brano
	 */
	public void espelliSupporto() {
		supporto = null;
		currentBrano = 0;
	}
	
	/**
	 * metodo che ritorna il brano attualmente in esecuzione
	 * @return oggetto Brano
	 */
	public Brano getBrano() {
		//se nel riproduttore non è inserito nessun supporto ritornare null;
		if(supporto == null) return null;
		return inEsecuzione? supporto.getBrano(currentBrano): null;
	}
	
	/**
	 * se un supporto è presente mette in esecuzione il riproduttore 
	 * se il supporto non e' presente non fa nulla
	 */
	public void play() {
		//se il supporto non è presente non far partire nulla
		if(supporto == null) return;
		//se la canzone non è presente nel supporto
		if(supporto.getBrano(currentBrano) == null) return;
		inEsecuzione = true;
		System.out.println("esegui: "+supporto.getBrano(currentBrano).getNomeCanzone());
	}
	
	public void stop() {
		inEsecuzione = false;
	}
	
	//se il supporto non è presente non fare nulla
	public void prev() {
		if(supporto == null) return;
		if(currentBrano>=1) currentBrano--;
	}
	public void next() {
		//se il supporto non è presente non fare nulla
		if(supporto == null) return;
		if(supporto.getBrano(currentBrano+1) != null) currentBrano++;
	}
	
	@Override
	public String toString() {
		if(supporto == null || !inEsecuzione) return null;
		return supporto.getBrano(currentBrano).toString();
	}
}
