package lezione14;

public class PeterParker implements Marvel, DoppiaVita{

	private SpiderMan spider;
	private boolean amAHero;
	
	
	public PeterParker() {
		spider = new SpiderMan();
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
			spider.attacca();
		else
			System.out.println("peter è un comune cittadino e non ha responsabilità.");
	}

	private class SpiderMan implements SuperEroe{
		
		@Override
		public void attacca() {
			System.out.println("spiderman LANCIA UNA RAGNATELA!");
		}
	}
}
