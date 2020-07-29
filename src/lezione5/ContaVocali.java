package lezione5;

public class ContaVocali {

	public static void contaVocali(String testo) {
		int a, e, i, o, u;
		a = e = i = o = u = 0;
		for (int k = 0; k < testo.length(); k++)
			switch (testo.charAt(k)) {
			case 'a':
				a++;
				break;
			case 'e':
				e++;
				break;
			case 'i':
				i++;
				break;
			case 'o':
				o++;
				break;
			case 'u':
				u++;
				break;
			}
		System.out.print("a=" + a + " ");
		System.out.print("e=" + e + " ");
		System.out.print("i=" + i + " ");
		System.out.print("o=" + o + " ");
		System.out.print("u=" + u);
	}

	public static void main(String[] args) {
		contaVocali("le aiuole sono pulite");
	}
}
