package lezione8;

import java.util.Random;

public class Distributore {

	public static enum Prodotti { BOTTIGLIADACQUA(0), BARRADICIOCCOLATO(1), GOMMEDAMASTICARE(2);
		
		int indice;
		
		Prodotti(int i){ indice = i; }
		
		private int toInt() {
			return indice;
		}
	}
	
	private double[] prezzi = new double[3];
	private int[] prodotti = new int[3];
	private double saldo;
	
	public Distributore(int n_prodotti) {
		initDistributore(n_prodotti);
		prezzi[0] = new BottigliaDAcqua().getPrezzo();
		prezzi[1] = new BarraDiCioccolato().getPrezzo();
		prezzi[2] = new GommeDaMasticare().getPrezzo();
	}
	
	public Distributore(int n_prodotti, BottigliaDAcqua ba, BarraDiCioccolato bc, GommeDaMasticare gm) {
		initDistributore(n_prodotti);
		prezzi[0] = ba.getPrezzo();
		prezzi[1] = bc.getPrezzo();
		prezzi[2] = gm.getPrezzo();
	}
	
	public void initDistributore(int n) {
		Random r = new Random();
		//by a random number from 0 to 2
		//fill the vending machine
		for(; n>0; n--) prodotti[r.nextInt(3)]++;
	}
	
	public void inserisciImporto(double d) {
		saldo = d;
	}
	
	public Prodotto getProdotto(Prodotti p) {
		
		switch(p.toInt()) {
		case 0: {
			if(prodotti[0] == 0 || saldo < prezzi[0]) return null;
			prodotti[0]--;
			saldo -= prezzi[0];
			return new BottigliaDAcqua(prezzi[0]);
		}
		case 1:{
			if(prodotti[1] == 0 || saldo < prezzi[1]) return null;
			prodotti[1]--;
			saldo -= prezzi[1];
			return new BarraDiCioccolato(prezzi[1]);
		}
		case 2:{
			if(prodotti[2] == 0 || saldo < prezzi[2]) return null;
			prodotti[2]--;
			saldo -= prezzi[2];
			return new GommeDaMasticare(prezzi[2]);
		}
		default: return null;
		}
	}
	
	public double getResto() {
		double resto = saldo;
		saldo = 0;
		return resto;
	}
}
