package lezione5;

public class Cornice {

	private String frase;
	private int n;

	public Cornice(int n, String frase) {
		this.frase = frase;
		this.n = n;
	}

	@Override
	public String toString() {
		return this.corniceStringa();
	}

	public String corniceStringa() {
		// creo la variabile di ritorno
		String ritorno = "";
		// creo la variabile temporanea che contiene i caratteri della prima e ultima
		// riga
		String temp1 = "";
		for (int i = 0; i < n; i++)
			temp1 += "*";
		ritorno += temp1 + "\n";
		// creo la variabile che contiene i carattereri relativi alle righe vuote (senza
		// frase)
		String temp2 = "*";
		for (int i = 0; i < n - 2; i++)
			temp2 += " ";
		temp2 += "*";
		// ora controllo se la frase la posso scrivere tutta su una riga
		if (frase.length() <= n - 3) {
			ritorno += "*" + frase + spazi(n - 2 - frase.length()) + "*\n";
			for (int i = 0; i < n - 3; i++)
				ritorno += temp2 + "\n";
		} else {
			// scrivere la frase finchè c'è qualcosa da scrivere
			int quoziente = frase.length() / (n - 2);
			int resto = frase.length() % (n - 2);
			for (int i = 0; i < quoziente; i++) {
				ritorno += "*" + "" + frase.substring(i * (n - 2), (i + 1) * (n - 2)) + "*\n";
			}
			// scrivere le lettere che avanzano nel caso n-2 non divida perfettamente la
			// frase
			if (resto != 0)
				ritorno += "*" + frase.substring(quoziente * (n - 2)) + spazi(n - 2 - resto) + "*\n";
			// scrivere le righe vuote nel case la frase sia troppo corta
			for (int i = 0; i < n - 2 - quoziente - 1; i++)
				ritorno += temp2 + "\n";
		}

		ritorno += temp1;
		return ritorno;
	}

	public static void cornice(int n) {
		String temp1 = "";
		for (int i = 0; i < n; i++)
			temp1 += "*";
		System.out.println(temp1);
		String temp2 = "*";
		for (int i = 0; i < n - 2; i++)
			temp2 += " ";
		temp2 += "*";
		for (int i = 0; i < n - 2; i++)
			System.out.println(temp2);
		System.out.println(temp1);
	}

	public static void corniceAvanzata(int n, String testo) {
		String temp1 = "";
		for (int i = 0; i < n; i++)
			temp1 += "*";
		System.out.println(temp1);
		// allora la frase se possobile la devo scrivere tutta su una riga
		String temp2 = "*";
		for (int i = 0; i < n - 2; i++)
			temp2 += " ";
		temp2 += "*";
		// ora controllo se la frase la posso scrivere tutta su una riga
		if (testo.length() <= n - 3) {
			// si dovrebbero aggiungere spazi vuoti alla fine del testo nel caso sia troppo
			// corto
			System.out.println("*" + testo + spazi(n - 2 - testo.length()) + "*");
			for (int i = 0; i < n - 3; i++)
				System.out.println(temp2);
		} else {
			// scrivere la frase finchè c'è qualcosa da scrivere
			int quoziente = testo.length() / (n - 2);
			int resto = testo.length() % (n - 2);
			for (int i = 0; i < quoziente; i++) {
				System.out.println("*" + "" + testo.substring(i * (n - 2), (i + 1) * (n - 2)) + "*");
			}
			// qui dovrei stampare il resto nel caso ci sia
			if (resto != 0)
				System.out.println("*" + testo.substring(quoziente * (n - 2)) + spazi(n - 2 - resto) + "*");

			for (int i = 0; i < n - 2 - quoziente - 1; i++)
				System.out.println(temp2);
		}

		System.out.println(temp1);
	}

	private static String spazi(int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s += " ";
		return s;
	}

	public static void main(String[] args) {
//		cornice(5);
//		corniceAvanzata(20,"cornici in java");
		corniceAvanzata(6, "cornici in java");
//		corniceAvanzata(8,"cornici in java");

		Cornice c = new Cornice(6, "cornici in java");
		System.out.println(c);
	}

}
