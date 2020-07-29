package finoLezione4;

public class Colore {
	public enum Colori {
		BIANCO, NERO
	}

	private int r, g, b;
	final int bianco = 255;
	final int nero = 0;

	public Colore(int r, int g, int b) {
		if (r < 0) {
			this.r = 0;
		} else if (r > 255) {
			this.r = 255;
		} else {
			this.r = b;
		}
		if (g < 0) {
			this.g = 0;
		} else if (g > 255) {
			this.g = 255;
		} else {
			this.g = b;
		}
		if (b < 0) {
			this.b = 0;
		} else if (b > 255) {
			this.b = 255;
		} else {
			this.b = b;
		}
		this.g = g;

	}

	public Colore(Colori c) {
		if (c == Colori.BIANCO) {
			r = g = b = bianco;
		} else if (c == Colori.NERO) {
			r = g = b = bianco;
		}
	}

	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	@Override
	public String toString() {
		return "(" + r + "," + g + "," + b + ")";
	}
}
