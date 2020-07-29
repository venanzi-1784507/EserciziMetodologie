package lezione16;

public class TestAlbero {

	
	public static void main(String[] args) {
		
		Albero a = new Albero(new Albero.Nodo(null, 10));
		
		a.aggiungi(11,12,13,14,15);
		System.out.println(a.root);
		a.aggiungi(12,19,20);
		
		a.stampa();
		
		
	}
}
