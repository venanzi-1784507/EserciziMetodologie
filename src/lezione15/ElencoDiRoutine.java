package lezione15;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ElencoDiRoutine {

	public static enum funzioni { LEN, Y, TO_INTERO, SOMMA; }
	private Function<String, Integer> len;
	private Function<String, Integer> occorrenzeY;
	private Function<String, Integer> toIntero;
	private Function<String, Integer> somma;
	private HashMap<funzioni,Function<String, Integer>> funzs;
	
	public ElencoDiRoutine() {
		len = String::length;
		occorrenzeY = s -> ElencoDiRoutine.contaOccorrenzeY(s);
		toIntero = Integer::parseInt;
		somma = s -> ElencoDiRoutine.sommaSingoliInteri(s);
		funzs = new HashMap<>(Map.of(funzioni.LEN, len, funzioni.Y, occorrenzeY, funzioni.TO_INTERO, toIntero, funzioni.SOMMA, somma));      
	}
	
	private static Integer contaOccorrenzeY(String s) {
		int count = 0;
		for(int i=0; i<s.length(); i++)
			count += s.charAt(i) == 'y'? 1:0;
		return count;
	}
	
	private static Integer sommaSingoliInteri(String s) {
		int count = 0;
		for(int i=0; i<s.length(); i++)
			count += Character.isDigit(s.charAt(i))? Integer.parseInt(""+s.charAt(i)):0;
		return count;
	}
	
	public Integer esegui(funzioni f, String s) {
		switch(f) {
		case LEN: return len.apply(s);
		case Y: return occorrenzeY.apply(s);
		case TO_INTERO: return toIntero.apply(s);
		case SOMMA: return somma.apply(s);
		default: return null;
		}
	}
	
	public Integer eseguiFigo(funzioni f, String s) {
		return funzs.get(f).apply(s);
	}
}
