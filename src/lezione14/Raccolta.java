package lezione14;

import java.util.HashSet;

public class Raccolta {

	public HashSet<Canzone> canzoni;
	
	public Raccolta() {
		canzoni = new HashSet<>();
	}
	
	public void add(Canzone c) {
		canzoni.add(c);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Canzone c: canzoni) {
			sb.append(c.toString() + "\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Raccolta r = new Raccolta();
		Canzone c1 = new Canzone("bella ciao", "non lo so");
		Canzone c2 = new Canzone("bella ciao", "non lo so");
		Canzone c3 = new Canzone("dragostea", "un portoghese");
		Canzone c4 = new Canzone("tisca tusca", "topolino");
		
		r.add(c1);
		r.add(c2);
		r.add(c3);
		r.add(c4);
		
		r.canzoni.forEach((a)-> System.out.print(a.toString()));
		
		System.out.println();
		System.out.println(r);
	}
}
