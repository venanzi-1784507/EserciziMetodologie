package lezione9;

import java.util.ArrayList;

public abstract class Supporto {

	protected ArrayList<Brano> brani;
	
	/**
	 * metodo che inserisce un brano dato in input nel supporto se è presente ancora posto
	 * @param b brano da voler inserire nel supporto
	 * @return true se l'operazione è andata a buon fine altrimenti false
	 */
	protected boolean aggiungiBrano(Brano nb) {
		//se non ci sono spazi disponibili nel supporto ritorna falso
		if(!(spazioLibero())) return false;
		//e' una lista non un array
		for(Brano b: brani) {
			if(b==null) {
				brani.add(brani.indexOf(b), nb);
				return true;
			}
		}
		return false;
	}
	
	protected boolean spazioLibero() {
		for(Brano b: brani)
			if(b == null) return true;
		return false;
	}
	
	public Brano getBrano(int index) {
		if(index >= brani.size()) return null;
		return brani.get(index);
	}
}
