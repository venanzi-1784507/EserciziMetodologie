package lab_1;

public class TestDama {

	
	public static void main(String[] args) {
		
		ScacchieraDama scd = new ScacchieraDama();
		
		scd.caricaConfig("primo_salvataggio2.txt");
//		scd.tuttaNera();
		System.out.println(scd);
		
//		scd.salva("primo_salvataggio.txt");
		
		
		scd.caricaConfig("primo_salvataggio.txt");
//		scd.tuttaVuota();
		System.out.println(scd);
//		scd.salva("primo_salvataggio2.txt");
		
		scd.tuttaBianca();
		System.out.println(scd);
	}
}
