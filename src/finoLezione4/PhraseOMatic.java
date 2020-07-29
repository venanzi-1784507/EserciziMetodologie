package finoLezione4;

import java.util.Random;

public class PhraseOMatic {

	final String[] i1 = { "salve", "ciao", "hello", "buongiorno", "scialla" };
	final String[] i2 = { "egregio", "eclettico", "inteligentissimo", "astutissimo" };
	final String[] i3 = { "studente", "ragazzo", "giovane", "scapestrato" };

	public PhraseOMatic() {
		Random random = new Random();
		System.out.println(i1[random.nextInt(5)] + " " + i2[random.nextInt(4)] + " " + i3[random.nextInt(4)]);
	}

	public static void main(String[] args) {
		PhraseOMatic pOM = new PhraseOMatic();
	}
}
