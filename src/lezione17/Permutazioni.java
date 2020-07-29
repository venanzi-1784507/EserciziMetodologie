package lezione17;

import java.util.List;
import java.util.ArrayList;

public class Permutazioni {
	
	
	public static ArrayList<String> perm(String s){
		
		//caso base su lunghezza uguale ad 1
		if(s.length() == 1)
			return new ArrayList<String>(List.of(s));
		ArrayList<String> out = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {
			String temp = s.substring(0, i)+s.substring(i+1, s.length());
			ArrayList<String> tempList = perm(temp);
			for(String t: tempList)
				out.add(s.charAt(i)+t);
		}
		
		return out;
	}
	
	

	public static void main(String[] args) {
		
		String s = "albero";
		System.out.println(s.substring(0, 0));
		System.out.println(s);
		System.out.println(s.substring(0, 0).length());
		
		System.out.println(perm("abc").toString());
	}
}
