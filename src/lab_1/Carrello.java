package lab_1;

import java.util.ArrayList;
import java.util.Iterator;

import lab_1.Articolo.Stato;

public class Carrello implements Iterable<Articolo>{

	ArrayList<Articolo> articoli;
	
	public Carrello() {
		articoli = new ArrayList<>();
	}
	
	public void aggiungiAlCarrello(Articolo a) {
		articoli.add(a);
	}
	
	public void aggiungiAlCarrello(Articolo... a) {
		for(Articolo ar: a)
			aggiungiAlCarrello(ar);
	}
	
	public void rimuoviArticolo(int index) {
		articoli.remove(index);
	}
	
	public Iterator<Articolo> iterator(){
		return new Iterator<>() {
			
			int index;
			
			public boolean hasNext() {
				return index < articoli.size();
			}
			
			public Articolo next() {
				return articoli.get(index++);
			}
		};
	}
	
	/**
	 * metodo per ottenere il costo di tutti gli articoli nel carrello
	 * @param bool booleano che definisce se gli articoli ricondizionati sono in sconto
	 * @return il saldo totale del carrello
	 */
	public double getPrezzoTotale(boolean bool) {
		double saldo = 0;
		for(Articolo a: articoli) {
			if(a.getStato() == Stato.RICONDIZIONATO && bool)
				saldo += a.getPrezzo() * 0.80;
			else
				saldo += a.getPrezzo();
		}
		return saldo;
	}
}
