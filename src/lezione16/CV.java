package lezione16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CV {

	private Autore autore;
	private HashSet<Pubblicazione> pubblicazioni;
	
	/** 
	 * aggiunge una pubblicazione al set
	 * @param p istanza di Pubblicazione
	 */
	public void addPubblicazione(Pubblicazione p) { pubblicazioni.add(p); }
	public HashSet<Pubblicazione> getPubblicazioni() { return pubblicazioni; }
	
	public Autore getAutore() { return autore; }
	
	public CV(Autore a) {
		autore = a;
		pubblicazioni = new HashSet<>();
	}
	
	/**
	 * restituisce tutti gli autori che hanno lavorato con il docente
	 * @return
	 */
	public HashSet<Autore> getAutori(){
		HashSet<Autore> output = new HashSet<>();
		//itero tutte le pubblicazioni e aggiungo gli autori al set temporaneo
		for(Pubblicazione p: pubblicazioni) {
			output.addAll(Arrays.asList(p.getAutori()));
		}
		return output;
	}
	
	public List<Autore> getAutoriOrdinati(){
		return this.getAutoriOrdinati(Comparator.comparing(Autore::getCognome).thenComparing(Autore::getNome));
	}
	
	public List<Autore> getAutoriOrdinati(Comparator<Autore> cmp){
		List<Autore> output = new ArrayList<>(this.getAutori());
		output.sort(cmp);
		return output;
	}
}
