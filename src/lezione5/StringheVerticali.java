package lezione5;

public class StringheVerticali {

	public static void stampaVerticale(String[] parole) {
		int max = 0;
		for (int k = 0; k < parole.length; k++)
			max = parole[k].length() > max ? parole[k].length() : max;
		for (int j = 0; j < max; j++) {
			for (int k = 0; k < parole.length; k++)
				System.out.print(parole[k].length() <= j ? " " : parole[k].charAt(j));
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		stampaVerticale(args);
	}
}
