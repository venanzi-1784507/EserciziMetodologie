package finoLezione4;

public class Stringa42 {

	private String stringa;

	public Stringa42(String s1, String s2, String s3) {
		stringa = s1.concat(" " + s2).concat(" " + s3);
		if (stringa.length() > 42)
			stringa.subSequence(0, 42);
	}

	public String getStringa() {
		return stringa;
	}

	public String getIniziale() {
		return stringa.substring(0, 1);
	}

	public boolean isMagic() {
		return stringa.equals("42 42 42");
	}

	public boolean containMagic() {
		return stringa.indexOf("42") != -1;
	}

	public static void main(String[] args) {

		Stringa42 s = new Stringa42("ciao come va?", "tutto bene?", "42");
		System.out.println(s.getStringa());
		System.out.println(s.getIniziale());
		System.out.println(s.isMagic());
		System.out.println(s.containMagic());

		s = new Stringa42("42", "42", "42");
		System.out.println(s.getStringa());
		System.out.println(s.getIniziale());
		System.out.println(s.isMagic());
		System.out.println(s.containMagic());
	}
}
