package lezione6;

import java.util.Arrays;

public class Istogrammi {

	private int[] intervallo;
	private int[] dati;
	
	/**
	 * 
	 * @param minimo
	 * @param massimo il valore massimo è escluso dall'intervallo
	 */
	public Istogrammi(int minimo, int massimo) {
		intervallo = new int[massimo-minimo];
		dati = new int[massimo - minimo];
		for(int i = minimo; i < massimo; i++)
			intervallo[i-minimo] = i;
	}
	
	private int indiceIntervallo(int elemento) {
		for(int i=0; i<intervallo.length; i++)
			if(intervallo[i] == elemento) return i;
		return -1;
	}
	
	public void incremento(int dato) {
		dati[indiceIntervallo(dato)]++;
	}
	
	
	public String stampaVerticale() {
		String istogramma = "";
		for(int elem: intervallo)
			istogramma += elem + " ";
		istogramma += "\n";
		int[] copia = Arrays.copyOf(dati, dati.length);
		for(int i=0; i<intervallo.length; i++) {
			for(int k=0; k<copia.length; k++) {
				if(copia[k]-- <= 0) 
					istogramma += " " + " ";
				else
					istogramma += "*" + " ";
			}
			istogramma += "\n";
		}
		return istogramma;
	}
	@Override
	public String toString() {
		String istogramma = "";
		//questa volta lo stampo in orizzontale
		for(int elem: intervallo) {
			istogramma+= elem + ": ";
			for(int i=0; i< dati[indiceIntervallo(elem)]; i++)
				istogramma+="*";
			istogramma+="\n";
		}
		return istogramma;
	}
	
	public static void main(String[] args) {
		Istogrammi is = new Istogrammi(0, 7);
		
		is.incremento(5);
		is.incremento(5);
		is.incremento(5);
		is.incremento(5);
		is.incremento(5);
		
		is.incremento(1);
		is.incremento(1);
		is.incremento(1);
		
		is.incremento(3);
		is.incremento(3);
		is.incremento(3);
		
		is.incremento(6);
		is.incremento(6);
		is.incremento(6);
		
		is.incremento(4);
		is.incremento(4);
		is.incremento(4);
		is.incremento(4);
		
		is.incremento(2);
		is.incremento(2);
		
		System.out.println(is);
		System.out.println(is.stampaVerticale());
	}
}
