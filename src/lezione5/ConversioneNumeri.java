package lezione5;

public class ConversioneNumeri {

	public enum Base {
		DUE, OTTO, SEDICI
	}

	private int num;

	public ConversioneNumeri(String s) {
		num = Integer.parseInt(s);
	}

	public ConversioneNumeri(int n) {
		num = n;
	}

	public String Converti(Base b) {
		switch (b) {
		case DUE:
			return Integer.toBinaryString(num);
		case OTTO:
			return Integer.toOctalString(num);
		case SEDICI:
			return Integer.toHexString(num);
		}
		return "";
	}

	public static void main(String[] args) {
		ConversioneNumeri cN = new ConversioneNumeri(8);
		System.out.println(cN.Converti(Base.DUE));
		System.out.println(cN.Converti(Base.OTTO));
		System.out.println(cN.Converti(Base.SEDICI));
	}
}
