package lezione14;

public class Paperino implements Disney, DoppiaVita{

	private Paperinik superPaperino;
	private boolean amAHero;
	
	public Paperino() {
		superPaperino = new Paperinik();
		amAHero = false;
	}
	
	@Override
	public void assumiIdentitaSegreta() {
		amAHero = true;
	}

	@Override
	public void assumiIdentitaPubblica() {
		amAHero = false;
	}
	
	public void attacca() {
		if(amAHero)
			superPaperino.attacca();
		else
			System.out.println("paperino è un comune cittadino e ha paura.");
	}
	
	private class Paperinik implements SuperEroe{
		
		/**
		 * non fa nulla, stampa solo a video per vedere che e' stato usato
		 */
		@Override
		public void attacca() {
			System.out.println("paperinik ATTACCA!!!");
		}
	}

}
