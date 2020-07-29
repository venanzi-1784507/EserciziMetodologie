package lezione11;

public interface Armi {
	
	void attacca(Castello c);
	
	/**
	 * 
	 * @return true se l'arma sta caricando e non può attaccare
	 */
	boolean staCaricando();
}
