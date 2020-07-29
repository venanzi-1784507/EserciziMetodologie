package lezione9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lezione9.EssereVivente.Gender;

public class TestEssereUmano {

	EssereUmano e1;
	EssereUmano e2;
	EssereUmano e3;
	Gatto g;
	
	@Before
	public void setUp() {
		e1 = new EssereUmano("giggi", 42, Gender.M);
		e2 = new EssereUmano("fabiola", 42, Gender.F);
		e3 = new EssereUmano("giggi", 33, Gender.M);
		g = new Gatto();
	}
	
	@Test
	public void testAge1() {
		assertEquals(e1.age, e2.age);
	}
	
	@Test
	public void testAge2() {
		assertNotEquals(e1.age, e3.age);
	}

	@Test
	public void testGender1() {
		assertNotEquals(e1.gender, e2.gender);
	}
	
	@Test
	public void testGender2() {
		assertEquals(e1.gender, e3.gender);
	}
	
	@Test
	public void testRiproduciCon1() throws Exception {
		
		try {
			e1.siRiproduceCon(g);
		} catch (Exception e) {
			e.getMessage().equals("Sesso tra specie non ammesso, malandrino.");
		}

		//e1.siRiproduceCon(g);
	}
	
	@Test
	public void testRiproduciCon2() throws Exception {
		
		try {
			e1.siRiproduceCon(e3);
		} catch (Exception e) {
			e.getMessage().equals("Niente sesso per i gay.");
		}
	}
}
