package lezione5;

public class TernePitagoriche {

	/**
	 * metodo statico che stampa tutte le terne pitagoriche con ipotenusa <= n
	 * 
	 * @param n
	 */
	public static void terne(int n) {
		// a, b, c elementi della terna pitagorica, a^2+b^2=c^2
		for (int a = 1; a < n; a++) {
			double c;// così utilizzo la stessa allocazione di memoria
			for (int b = a; b < n; b++) {
				// a^2+b^2=c^2
				c = Math.sqrt(a * a + b * b);
				if (b > c)
					break;
				if ((c - (int) c) == 0)
					System.out.println("a=" + a + ",b=" + b + ",c=" + c);
			}
		}
	}

	public static void main(String[] args) {
		terne(15);
	}
}
