package finoLezione4;

public class Punto2D {

	private float x;
	private float y;

	public Punto2D(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float traslaX(float x) {
		this.x += x;
		return this.x;
	}

	public float traslaY(float y) {
		this.y += y;
		return this.y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
