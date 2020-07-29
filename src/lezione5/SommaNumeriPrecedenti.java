package lezione5;

public class SommaNumeriPrecedenti {

	public static void sommaNumeriPrecedenti(int a, int b, int n) {
		System.out.print(a + " " + b + " ");
		int temp;
		for (; n > 0; n--) {
			temp = a + b;
			a = b;
			b = temp;
			System.out.print(temp + " ");
		}
	}

	public static void main(String[] args) {
		sommaNumeriPrecedenti(2, 3, 6);
	}
}
