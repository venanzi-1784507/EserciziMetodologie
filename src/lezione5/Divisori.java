package lezione5;

public class Divisori {

	public static void divisori(int n) {
		int div = (int) Math.sqrt(n);
		for (; div > 0; div--)
			if (n % div == 0)
				System.out.print("(" + n / div + "," + div + ")");
	}

	public static void divisoriLento(int n) {
		for (int i = n - 1; i > 0; i--)
			if (n % i == 0)
				System.out.print(i + " ");
	}

	public static void main(String[] args) {
		// divisori(1000000000);
		System.out.println();
		divisoriLento(1000000000);
	}

}
