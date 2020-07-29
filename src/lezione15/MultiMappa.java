package lezione15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class MultiMappa {

	private HashMap<String, ArrayList<Integer>> mappa;
	
	public MultiMappa() {
		mappa = new HashMap<>();
	}
	
	/**
	 * ritorna tutti i valori della chiave data in input altrimenti null
	 * @param s chiave della mappa
	 * @return un array relativo a tutte le occorrenze della chiave specificata
	 */
	public ArrayList<Integer> get(String s) {
		return mappa.getOrDefault(s, null);
	}
	
	public void set(String s, Integer i) {		
		mappa.merge(s, new ArrayList<Integer>(List.of(i)), (old, nuevo)-> old);
		mappa.get(s).add(i);
	}
	
	public Set<Integer> valueSet(){
		Set<Integer> out = new HashSet<>();
		mappa.values().forEach(array -> out.addAll(array));
		return out;
	}
	
	public Set<String> keySet(){
		return mappa.keySet();
	}
	
	public ArrayList<Integer> values(){
		
		ArrayList<Integer> out = new ArrayList<>();
		//aggiungi tutti gli elementi all'array da ritornare
		mappa.values().forEach(array-> out.addAll(array));
		//ordina l'array in ordine decrescente
		out.sort((x1, x2) -> -(x1-x2));
		
		
		return out;
	}
	
	
}







