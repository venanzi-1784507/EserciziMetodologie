package finoLezione4;

public class StampaNome {

	public StampaNome(String s) {
		System.out.println("+----------+");
		System.out.println(s);
		System.out.println("+----------+");

	}

	public static void main(String[] args) {
		StampaNome sN = new StampaNome(args[0]);
	}
}
