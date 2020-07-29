package finoLezione4;

public class Variabili {

	public static void main(String[] args) {
		int i;
		String s;
		double d;
		s = args[0];
		i = Integer.parseInt(s);
		d = (double) i / 2;
		System.out.println(s);
		System.out.println(i);
		System.out.println(d);
	}
}
