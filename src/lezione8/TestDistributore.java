package lezione8;

import lezione8.Distributore.Prodotti;

public class TestDistributore {

	public static void main(String[] args) {
		
		Distributore d = new Distributore(10);
		
		d.inserisciImporto(100);
		
		System.out.println(d.getProdotto(Prodotti.BARRADICIOCCOLATO));
		System.out.println(d.getProdotto(Prodotti.BARRADICIOCCOLATO));
		System.out.println(d.getProdotto(Prodotti.BOTTIGLIADACQUA));
		System.out.println(d.getProdotto(Prodotti.BARRADICIOCCOLATO));
		System.out.println(d.getProdotto(Prodotti.GOMMEDAMASTICARE));
		
		System.out.println(d.getResto());
	}
}
