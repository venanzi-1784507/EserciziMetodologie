package lezione18;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class InvertiEMax {

	/**
	 * metodo che inverte l'ordine degli elementi di una lista generica
	 * @param <E>
	 * @param <E>
	 * @param <E>
	 * @param lista
	 */
	public static <E> List<E> inverti(List<E> lista){
		Stack<E> pila = new Stack<>();
		//inserisco gli elementi in una pila
		for(int i=0; i<lista.size(); i++)
			pila.add(lista.get(i));
		//re-inserisci in ordine inverso
		for(int i=0; i<lista.size(); i++)
			lista.set(i, pila.pop());
		return lista;
	}
	
	/**
	 * metodo generico che prende una lista di comparable e ritorna i massimo dei comparable
	 * @param <T>
	 * @param lista
	 * @return
	 */
	public static <T extends Comparable<T>> T max(List<T> lista){
		T currMax = lista.get(0);
		for(int i=0; i<lista.size(); i++)
			currMax = currMax.compareTo(lista.get(i)) >0? currMax: lista.get(i);
			
		return currMax;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> interi = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));
		System.out.println(interi.toString());
		
		//stampa massimo
		System.out.println(max(interi));
		
		//inverti l'ordine
		inverti(interi);
		System.out.println(interi.toString());
		
		
	}
}
