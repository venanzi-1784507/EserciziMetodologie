package lezione14;

import java.util.ArrayList;
import java.util.Random;

public class HeroWar {

	public static void main(String[] args) {
		
		ArrayList<Disney> superDisney = new ArrayList<>();
		
		Paperino paperino = new Paperino();
		Pippo pippo = new Pippo();
		Ciccio ciccio = new Ciccio();
		
		ArrayList<Marvel> superMarvel = new ArrayList<>();
		
		Magneto magneto = new Magneto();
		LaCosa laCosa = new LaCosa();
		PeterParker peter = new PeterParker();
		
		
		superDisney.add(paperino);
		superDisney.add(pippo);
		superDisney.add(ciccio);
		
		superMarvel.add(peter);
		superMarvel.add(magneto);
		superMarvel.add(laCosa);
		
		Random random = new Random();
		for(int i = 20; i > 0 ; i--) {
			Disney d = superDisney.get(random.nextInt(100)%3);
			Marvel m = superMarvel.get(random.nextInt(100)%3);
			//attacco disney
			if(d.getClass() == Paperino.class) {
				if(random.nextInt(100) % 2 == 0)  ((Paperino)d).assumiIdentitaPubblica();
				else ((Paperino)d).assumiIdentitaSegreta();
				((Paperino)d).attacca();
			}
			else if(d.getClass() == Pippo.class) {
				if(random.nextInt(100) % 2 == 0)  ((Pippo)d).assumiIdentitaPubblica();
				else ((Pippo)d).assumiIdentitaSegreta();
				((Pippo)d).attacca();
			}
			else {
				if(random.nextInt(100) % 2 == 0)  ((Ciccio)d).assumiIdentitaPubblica();
				else ((Ciccio)d).assumiIdentitaSegreta();
				((Ciccio)d).attacca();
			}
			
			//attacco marvel
			if(m.getClass() == PeterParker.class) {
				if(random.nextInt(100) % 2 == 0)  ((PeterParker)m).assumiIdentitaPubblica();
				else ((PeterParker)m).assumiIdentitaSegreta();
				((PeterParker)m).attacca();
			}
			else if(m.getClass() == Magneto.class) 
				((Magneto)m).attacca();
			else if(m.getClass() == LaCosa.class) 
				((LaCosa)m).attacca();
		}
	}
	
}
