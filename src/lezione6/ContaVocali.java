package lezione6;

public class ContaVocali {

	public static void contaVocali(String parola) {
		int[] counterVocali = new int[5];
		char[] charVocali = new char[] { 'a', 'e', 'i', 'o', 'u' };

		for (int i = 0; i < parola.length(); i++)
			switch (parola.charAt(i)) {
			case 'a': counterVocali[0]++; break;
			case 'e': counterVocali[1]++; break;
			case 'i': counterVocali[2]++; break;
			case 'o': counterVocali[3]++; break;
			case 'u': counterVocali[4]++; break;
			}
		for (int i = 0; i < counterVocali.length; i++)
			System.out.println(String.valueOf(charVocali[i]) + "=" + counterVocali[i] + ", ");
	}

	public static void main(String[] args) {
		contaVocali("le aiuole sono pulite");
	}
}
