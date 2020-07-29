package lab_1;

import static org.junit.Assert.*;

import org.junit.Test;

import lab_1.Articolo.Stato;

public class TestCarrello {

	@Test
	public void test() {
		Carrello carrello = new Carrello();
		Articolo pane = new Articolo("pane", 1.3, Stato.NUOVO, "pane fresco");
		Articolo acqua = new Articolo("acqua", 2.4, Stato.USATO, "acqua gia' bevuta");
		Articolo biscotti = new Articolo("biscotti", 5.3, Stato.USATO, "biscotti gia' mangiati");
		Articolo radio = new Articolo("radio", 10, Stato.RICONDIZIONATO, "radio messa a posto");
		
		carrello.aggiungiAlCarrello(pane);
		carrello.aggiungiAlCarrello(acqua, biscotti, radio);
		
		for(Articolo a: carrello)
			System.out.println(a);
		
		assertTrue(carrello.getPrezzoTotale(false) == 19);
		assertTrue(carrello.getPrezzoTotale(true) == 17);
	}

}
