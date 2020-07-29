package lezione6;

import java.util.Arrays;
import java.util.Random;

import lezione6.Carta.SEME;

public class MazzoDiCarte {
	
	private Carta[] mazzo;
	
	public MazzoDiCarte() {
		mazzo = new Carta[52];
		for(int i=0; i<4; i++) {
			Carta.SEME s = seme(i);
			for(int k=0; k<13; k++) {
				int indice = i*13 + k;
				mazzo[indice] = new Carta(s,k);
			}
		}
	}
	
	private Carta.SEME seme(int i){
		switch(i) {
		case 0: return Carta.SEME.CUORI;
		case 1: return Carta.SEME.FIORI;
		case 2: return Carta.SEME.QUADRI;
		case 3: return Carta.SEME.PICCHE;
		}
		return Carta.SEME.CUORI;
	}
	
	public void mescola() {
		Random random = new Random();
		int indice;
		Carta temp;
		for(int i=0; i<52; i++) {
			indice = random.nextInt(52);
			temp = mazzo[indice];
			mazzo[indice] = mazzo[i];
			mazzo[i] = temp;
		}
	}
	
	/**
	 * restituisce la carta in cima al mazzo e la mette in fondo
	 * @return la carta in cima al mazzo sotto forma di stringa
	 */
	public String distribuisci() {
		Carta c = mazzo[0];
		//mi creo un nuovo array metto dentro da 1 a n-1 poi n diventa 0
		Carta[] temp = new Carta[52];
		for(int i=1; i<52; i++)
			temp[i-1] = mazzo[i];
		temp[51] = c;
		//cambio il vecchio mazzo con quello nuovo creato
		mazzo = temp;
		return c.toString();
	}

	public void stampaMazzo() {
		for(int i=0; i<52; i++)
			System.out.println(mazzo[i]);
	}
}
