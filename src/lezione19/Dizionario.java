package lezione19;

import java.util.HashMap;

public class Dizionario {

	private HashMap<Integer, String> dizionario;
	
	public Dizionario() {
		dizionario = new HashMap<>();
	}
	
	public void add(Integer chiave, String value) throws ElementAlreadyContainedException{
		//se la chiave è gia presente lanciare l'eccezione
		if(dizionario.containsKey(chiave)) throw new ElementAlreadyContainedException();
		
		dizionario.put(chiave, value);
	}
	
	public int size() { return dizionario.size(); }
	
	public String search(Integer chiave) throws ElementNotFoundException{
		//se la chiave non e' presente lanciare ElementNotFoundException
		if(!dizionario.containsKey(chiave)) throw new ElementNotFoundException();
		
		return dizionario.get(chiave);
	}
	
	public void delete(Integer chiave) throws ElementNotFoundException {
		//se la chiave non e' presente lanciare eccezione
		try {
			search(chiave);
		} catch (ElementNotFoundException e) {
			throw e;
		}
		
		//altrimenti lo cancella
		dizionario.remove(chiave);
	}
	
	@Override
	public String toString() {
		return dizionario.toString();
	}
	
	public static void main(String[] args) {
		
		Dizionario diz = new Dizionario();
		
		try {
			diz.add(1, "uno");
		} catch (ElementAlreadyContainedException e) {
			e.printStackTrace();
		}
		
		try {
			diz.add(1, "due");
		} catch (ElementAlreadyContainedException e) {
			e.printStackTrace();
		}
		
		try {
			diz.add(3, "tre");
		} catch (ElementAlreadyContainedException e) {
			e.printStackTrace();
		}
		
		System.out.println(diz.toString());
		
		System.out.println(diz.size());
		
		try {
			diz.delete(4);
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(diz.size());
		
		try {
			System.out.println(diz.search(2));
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(diz.toString());
	}
}
