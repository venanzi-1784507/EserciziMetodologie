package lezione16;

import java.util.Stack;

public class ParentesiAnnidate {

	public static boolean checkParentesi(String string, Stack<Character> stack, int currentIndex) {
		//itero finche' non trovo una parentesi itero la stringa
		while(!isAParentesi(string.charAt(currentIndex)) && currentIndex < string.length()) {
			currentIndex++;
		}
		
		//se la stringa è finita e lo stack non è vuoto ritornare falso
		if(currentIndex >= string.length()) {
			if(!stack.isEmpty()) return false;
			return true;
		}
			
		//se arrivo qui ho trovato una parentesi
		switch(string.charAt(currentIndex)) {
		case '(': case '[': stack.add(string.charAt(currentIndex)); break;
		case ')': 
			if(stack.peek() == '(') 
				stack.pop();
			else
				return false;
			break;
		case ']': 
			if(stack.peek() == '[') 
				stack.pop();
			else
				return false;
			break;
		}
		//mando avanti il punatore al char corrente
		currentIndex++;
		//se la stringa è finita e lo stack è vuoto ritornare true
		if(currentIndex >= string.length()) {
			if(!stack.isEmpty()) return false;
			return true;
		}
		//se la stringa non è finita ripetere
		return checkParentesi(string, stack, currentIndex);
	}
	
	public static boolean isAParentesi(char c) {
		return c == '(' || c == ')' || c == '[' || c == ']';
	}
	
	public static void main(String[] args) {
		System.out.println(
				ParentesiAnnidate.checkParentesi("   (( [(   )]) )", new Stack<Character>(), 0));
	}
}
