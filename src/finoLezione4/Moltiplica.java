package finoLezione4;

public class Moltiplica {

	public Moltiplica(int a, int b) {
		System.out.println(a * b);
	}

	public static void main(String[] args) {
		Moltiplica m = new Moltiplica(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}

}
