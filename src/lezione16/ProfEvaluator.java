package lezione16;

import java.util.Comparator;

public class ProfEvaluator {

	private CV curriculum;
	
	public ProfEvaluator(CV cv) {
		curriculum = cv;
	}
	
	public int getHIndex() {
		int H = 0;
		while(true) {
			int count = 0;
			for(Pubblicazione p: curriculum.getPubblicazioni()) 
				if(p.getNumCitazioni()>=H) count++;
			if(count < H) break;
			H++;
		}
		return H;
	}
	
	public static void main(String[] args) {
		Autore pinco = new Autore("pinco", "pallo"); 
		Autore maria = new Autore("maria", "rossi"); 
		Autore luca = new Autore("luca", "rapallo"); 
		CV cv = new CV(pinco);
		Pubblicazione p1 = new Pubblicazione("pub1", "Roma1", 1999, 3, pinco, maria);
		Pubblicazione p2 = new Pubblicazione("pub2", "Roma2", 2001, 5, pinco, luca);
		Pubblicazione p3 = new Pubblicazione("pub3", "Roma1", 1997, 2, pinco, maria);
		Pubblicazione p4 = new Pubblicazione("pub4", "Roma3", 2009, 1, pinco, luca);
		Pubblicazione p5 = new Pubblicazione("pub5", "Roma1", 2005, 10, pinco, luca);
		cv.addPubblicazione(p1);
		cv.addPubblicazione(p2);
		cv.addPubblicazione(p3);
		cv.addPubblicazione(p4);
		cv.addPubblicazione(p5);
		
		ProfEvaluator eval = new ProfEvaluator(cv);
		//stampa h-index
		System.out.println(eval.getHIndex());
		//stampa autori ordinati normale
		System.out.println(cv.getAutoriOrdinati());
		//stampa autori ordinati al contrario
		System.out.println(cv.getAutoriOrdinati(Comparator.comparing(Autore::getNome).thenComparing(Autore::getCognome)));
	}
}
