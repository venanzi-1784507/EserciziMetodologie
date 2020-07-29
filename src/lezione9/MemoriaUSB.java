package lezione9;

import java.util.ArrayList;

public class MemoriaUSB extends Supporto {

	public static final int MEMORIA_USB_MAX_BRANI = 1024;
	
	public MemoriaUSB() {
		brani = new ArrayList<>(MEMORIA_USB_MAX_BRANI);
	}
	
	//considerando che questo supporto permette di avere la musica inserita dove si vuole
	//tra le canzoni momentaneamente presenti nel supporto
	
	@Override
	protected boolean aggiungiBrano(Brano nb) {
		// TODO Auto-generated method stub
		return super.aggiungiBrano(nb);
	}
	
	protected boolean aggiungiBrano(Brano nb, int pos) {
		//se il numero e' negativo non fare nulla
		if(pos < 0) return false;
		//controllo se c'e' un posto libero altrimenti nulla
		if(!spazioLibero()) return false;
		//se e' 0 inserire la canzone e ritornare
		if(pos == 0) {
			brani.add(0, nb);
			return true;
		}
		//controllo se prima dell'indice specificato non sono presenti canzoni nel caso
		//inserisco la canzone nella prima posizione disponibile vuoto
		if(getBrano(pos-1) == null)
			return super.aggiungiBrano(nb);
		//se non è nessuno dei casi precedenti 
		brani.add(pos, nb);
		return true;
	}
}
