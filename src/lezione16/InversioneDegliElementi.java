package lezione16;

import java.util.Stack;

public class InversioneDegliElementi {

	public static String inverti(String s) {
		Stack<Character> chars = new Stack<>();
		for(int i=0; i<s.length(); i++) chars.add(s.charAt(i));
		String out = "";
		int size = chars.size();
		for(int i=0; i<size; i++) out+=chars.pop();
		return out;
	}
	
	public static void main(String[] args) {
		System.out.println(inverti("GIACOMO"));
	}
}
