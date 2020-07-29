package lezione5;

public class Palindroma {

	private String testo;

	public Palindroma(String frase) {
		testo = frase.replace(" ", "");
	}

	public boolean palindroma() {
		int len = testo.length();
		for (int i = 0; i < len; i++) {
			if (testo.charAt(i) != testo.charAt(len - i - 1))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Palindroma p = new Palindroma("i topi non avevano nipoti");
		System.out.print(p.palindroma());
	}
}
