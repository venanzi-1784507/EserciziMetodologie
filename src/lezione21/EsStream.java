package lezione21;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Map;
import static java.util.stream.Collectors.*;

public class EsStream {
	
	public static List<Titolo> insiemeCinqueTitoliConAlPiuUnaRiga(List<Titolo> titoli){
		return titoli.stream().filter(x-> x.getRighe().size() <=1).limit(3).collect(toList());
	}
	
	public static Set<Titolo> insiemeTitoliCentratiOrdineAlfabetico(List<Titolo> titoli){
		return titoli.stream().filter(x->x.getAllineamento() == Titolo.Allineamento.CX)
							  .sorted(Comparator.comparing(x-> x.toString()))
							  .collect(toSet());
	}
	
	public static Map<Titolo.Allineamento, List<Titolo>> mappaAllineamentoListaTitoli(List<Titolo> titoli){
		return titoli.stream()
					 .collect(groupingBy(Titolo::getAllineamento, mapping(Function.identity(), toList())));
	}
	
	public static Map<Titolo.Allineamento, Set<Titolo>> mappaAllineamentoSetTitoli(List<Titolo> titoli){
		return titoli.stream()
					 .collect(groupingBy(Titolo::getAllineamento, mapping(Function.identity(), toSet())));
	}
	
	public static Map<Titolo.Allineamento, String> mappaAllineamentoConcatRigheTitoli(List<Titolo> titoli){
		return titoli.stream()
					 .collect(groupingBy(Titolo::getAllineamento, mapping(Titolo::toString, joining())));
	}
	
	public static Map<Titolo.Allineamento, String> mappaAllineamentoConcatRigheTitoli2(List<Titolo> titoli){
		return titoli.stream()
					 .collect(toMap(Titolo::getAllineamento, Titolo::toString, (x,y)->x+y));
	}
	
	public static Map<Titolo.Allineamento, List<String>> mappaAllineamentoListStringheTitoli(List<Titolo> titoli){
		return titoli.stream()
					 .collect(groupingBy(Titolo::getAllineamento, mapping(x->x.toString(), toList())));
	}
	
	public static Set<String> insiemeRigheTitoliStringa(List<Titolo> titoli){
		return titoli.stream().map(x->x.toString())
						.map(x->x.substring(1, x.length()-2))
//			<>			.map(x->x.split("\\s+"))
//						.flatMap(Arrays::stream)
						.collect(toSet());
	}
	
	public static Set<String> insiemeRigheTitoliStringa2(List<Titolo> titoli){
		return titoli.stream().map(x->x.getRighe())
						.flatMap(x->x.stream())
						.map(x->x.toString().split(" ")[1])
						.collect(toSet());
	}
	
	public static void main(String[] args) {
		
		List<Titolo.Riga> righe1 = List.of(new Titolo.Riga("ciao!",1), new Titolo.Riga("Salve!",3));
		List<Titolo.Riga> righe2 = List.of(new Titolo.Riga("Bella!",2));
		List<Titolo.Riga> righe3 = List.of(new Titolo.Riga("Mouse!",5), new Titolo.Riga("pino?!",8), new Titolo.Riga("gulag",4));
		List<Titolo.Riga> righe4 = List.of(new Titolo.Riga("penna",1), new Titolo.Riga("gassosa?!",7));
		List<Titolo.Riga> righe5 = List.of(new Titolo.Riga("sugo",0), new Titolo.Riga("tonno?!",6));
		
		List<Titolo> titoli = List.of(new Titolo(Titolo.Allineamento.CX, righe1),
									  new Titolo(Titolo.Allineamento.DX, righe2),
									  new Titolo(Titolo.Allineamento.SX, righe3),
									  new Titolo(Titolo.Allineamento.DX, righe4),
									  new Titolo(Titolo.Allineamento.SX, righe5));
		
		System.out.println("insiemeCinqueTitoliConAlPiuUnaRiga");
		
		System.out.println(insiemeCinqueTitoliConAlPiuUnaRiga(titoli));
		
		System.out.println();
		System.out.println("insiemeTitoliContratiOrdineAlfabetico");
		
		System.out.println(insiemeTitoliCentratiOrdineAlfabetico(titoli));
		
		System.out.println();
		System.out.println("mappaAllineamentoListaTitoli");
		
		System.out.println(mappaAllineamentoListaTitoli(titoli));
		
		System.out.println();
		System.out.println("mappaAllineamentoSetTitoli");
		
		System.out.println(mappaAllineamentoSetTitoli(titoli));
		
		System.out.println();
		System.out.println("mappaAllineamentoConcatRigheTitoli");
		
		System.out.println(mappaAllineamentoConcatRigheTitoli(titoli));
		
		System.out.println();
		System.out.println("mappaAllineamentoConcatRigheTitoli2");
		
		System.out.println(mappaAllineamentoConcatRigheTitoli2(titoli));
		
		System.out.println();
		System.out.println("mappaAllineamentoListStringheTitoli");
		
		System.out.println(mappaAllineamentoListStringheTitoli(titoli));
		
		System.out.println();
		System.out.println("insieme delle righe dei titoli ciascuna rappresentata sotto forma di stringa");
		
		System.out.println(insiemeRigheTitoliStringa(titoli));
		
		System.out.println();
		System.out.println("insieme delle righe dei titoli ciascuna rappresentata sotto forma di stringa");
		
		System.out.println(insiemeRigheTitoliStringa2(titoli));
		
	}

}
