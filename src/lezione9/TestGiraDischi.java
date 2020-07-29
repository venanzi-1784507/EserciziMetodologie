package lezione9;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestGiraDischi {

//	@Test
//	public void test1() {
//		ArrayList<Integer> a = new ArrayList<>(10);
//	
//		assertEquals(a.size(), 0);
//	}
	
	@Test
	public void test() {
		
		Brano a = new Brano("ciao", "arisa");
		Brano b = new Brano("danilo", "toto' rina");
		Brano c = new Brano("pepe", "roberto spada");
		
		DiscoA33Giri d33 = new DiscoA33Giri();
		d33.aggiungiBrano(a);
		d33.aggiungiBrano(b);
		d33.aggiungiBrano(c);
		
		GiraDischi gd = new GiraDischi(d33);
		
		System.out.println(gd);
		gd.play();
		System.out.println(gd);
		gd.next();
		gd.next();
		System.out.println(gd);
		gd.prev();
		System.out.println(gd);
		
		gd.espelliSupporto();
		
		Nastro n = new Nastro();
		assertFalse(gd.inserisciSupporto(n));
		assertTrue(gd.inserisciSupporto(d33));
		
		gd.play();
		System.out.println(gd);
		gd.next();
		gd.next();
		System.out.println(gd);
		gd.prev();
		System.out.println(gd);
	}

}
