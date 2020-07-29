package lezione5;

public class StringaVerticale {

	public static void stampaVerticale(String parola) {
		for (int k = 0; k < parola.length(); k++)
			System.out.println(parola.charAt(k));
	}

	public static void main(String[] args) {
		stampaVerticale(args[0]);
	}
}
