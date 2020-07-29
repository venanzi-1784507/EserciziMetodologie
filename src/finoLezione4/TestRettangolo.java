package finoLezione4;

public class TestRettangolo {

	public static void main(String[] args) {
		Rettangolo ret = new Rettangolo(0, 0, 20, 10);
		System.out.println(ret);
		ret.trasla(10, 0);
		System.out.println(ret);
		ret.trasla(0, -5);
		System.out.println(ret);
		System.out.println(ret.stampaColore());
		ret.cambiaColore(Colore.Colori.BIANCO);
		System.out.println(ret.stampaColore());
		ret.cambiaColore(123, 70, 186);
		System.out.println(ret.stampaColore());
	}

}
