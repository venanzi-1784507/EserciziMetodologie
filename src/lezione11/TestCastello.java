package lezione11;

import java.util.ArrayList;

public class TestCastello {

	public static void main(String[] args) {
		//arraylist di armi in cui reinserire più volte la stessa arma (oggetto) 
		// per usarla ripetutamente
		Castello castello = new Castello();
		
		ArrayList<Armi> listaArmi = new ArrayList<>();
		Pistola p = new Pistola();
		Catapulta c = new Catapulta();
		Arco a = new Arco();
				
		//x5
		listaArmi.add(p);
		listaArmi.add(p);
		listaArmi.add(p);
		listaArmi.add(p);
		listaArmi.add(p);
		
		listaArmi.add(c);
		
		listaArmi.add(a);
		listaArmi.add(a);
		
		//x5
		listaArmi.add(p);
		listaArmi.add(p);
		listaArmi.add(p);
		
		listaArmi.add(a);
		listaArmi.add(a);
		listaArmi.add(a);
		listaArmi.add(a);
		listaArmi.add(a);
		listaArmi.add(a);
		listaArmi.add(a);
		
		
		if(!castello.subisciAttacco(listaArmi))
			System.out.println("abbattuto");
		
	}
}
