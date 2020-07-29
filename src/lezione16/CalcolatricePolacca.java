package lezione16;

import java.util.List;

public class CalcolatricePolacca {

	//merda
	public static Integer calcola(List<Character> chars) {
		int out = 0;
		Integer temp1 = 0;
		Integer temp2 = 0;
		char c;
		int count = 0;
		while(!chars.isEmpty()) {
			c = chars.get(count++);
			if(Character.isDigit(c)) {
				if(temp1.equals(0)) temp1 = Integer.parseInt(c+"");
				else temp2 = Integer.parseInt(c+"");
			}
			else {
				switch(c) {
				case '+': out+=temp1 + temp2; break;
				case '-': out-= temp1 + temp2; break;
				case '*': out*= temp1 + temp2; break;
				default:
					return null;
				}
				temp1 = temp2 = 0;
			}
				
		}
		return out;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(calcola(List.of('1', '1', '+', '1', '-', '2', '*', '2', '+')));
	}
}
