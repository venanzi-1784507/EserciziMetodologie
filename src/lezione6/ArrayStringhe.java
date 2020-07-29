package lezione6;

public class ArrayStringhe {

	public static boolean controllaArrayStringhe(String[] parole, String parola) {
		for (int i = 0; i < parole.length; i++)
			if (parole[i].equals(parola))
				return true;
		return false;
	}

	public static int controllaArrayStringhe2(String[] parole, String parola) {
		for (int i = 0; i < parole.length; i++)
			if (parole[i].equals(parola))
				return i;
		return -1;
	}

	public static double maxDoubleArray(double[] numeri) {
		double max = Double.MIN_VALUE;
		for (int i = 0; i < numeri.length; i++)
			max = max < numeri[i] ? numeri[i] : max;
		return max;
	}

	public static void main(String[] args) {
		if (controllaArrayStringhe(new String[] { "balena", "ornitottero", "gerino" }, "ornella"))
			System.out.println("ci sta");
		else
			System.out.println("nada");

		System.out.println(controllaArrayStringhe2(new String[] { "balena", "ornitottero", "gerino" }, "gerino"));

		System.out.println(maxDoubleArray(new double[] { 0, 4, 4.4 }));
	}
}
