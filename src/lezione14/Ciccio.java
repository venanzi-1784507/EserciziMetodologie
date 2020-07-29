package lezione14;

public class Ciccio implements Disney, DoppiaVita {

	private Ciccionik ciccionik;
	private boolean amAHero;
	
	public Ciccio() {
		ciccionik = new Ciccionik();
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
			ciccionik.attacca();
		else
			System.out.println("ciccio è un comune cittadino e ha fame.");
	}
	
	private class Ciccionik implements SuperEroe {
		
		public void attacca() {
			System.out.println("super ciccio SI LANCIA DORMENDO!!!");
		}
	}
}
