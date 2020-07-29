package lezione14;

//import java.util.Comparator;
import java.util.TreeSet;

public class RaccoltaOrdinata {

public TreeSet<Canzone> canzoni;
	
	public RaccoltaOrdinata() {
		canzoni = new TreeSet<>();
//		canzoni = new TreeSet<>(new Comparator<Canzone>() {
//				
//			@Override
//			public int compare(Canzone arg0, Canzone arg1) {
//				if(arg0.getNome().equals(arg1.getNome()))
//					return arg0.getAutore().compareTo(arg1.getAutore());
//				return arg0.getNome().compareTo(arg1.getNome());
//			}
//		});
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
		//TreeSet deve avere in input una implementazione di comparator
		//oppure l'oggetto che deve comparare deve avere implementato Comparable<oggetto>
		//ed aver overridato compareTo
		RaccoltaOrdinata r = new RaccoltaOrdinata();
		Canzone c1 = new Canzone("bella ciao", "non lo so");
		Canzone c2 = new Canzone("bella ciao", "non lo so diverso");
		Canzone c3 = new Canzone("dragostea", "un portoghese");
		Canzone c4 = new Canzone("tisca tusca", "topolino");
		
		r.add(c1);
		r.add(c2);
		r.add(c3);
		r.add(c4);
		
//		r.canzoni.forEach((a)-> System.out.print(a.toString()));
		
//		System.out.println();
		System.out.println(r);
	}
}
