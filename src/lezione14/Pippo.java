package lezione14;

public class Pippo implements Disney, DoppiaVita {

	private SuperPippo superPippo;
	private boolean amAHero;
	
	public Pippo() {
		superPippo = new SuperPippo();
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
			superPippo.attacca();
		else
			System.out.println("pippo scappa!!!");
	}

	private class SuperPippo implements SuperEroe {
		
		@Override
		public void attacca() {
			System.out.println("super pippo SUPER COLPO DI TOSSE!!!");
		}
	}
}
