package finoLezione4;

public class Rettangolo {

	private Punto2D origine;
	private int lenght;
	private int height;
	private Colore color;

	/**
	 * costruttore Rettangolo in cui il campo colore è nero
	 * 
	 * @param x
	 * @param y
	 * @param lenght
	 * @param height
	 */
	public Rettangolo(float x, float y, int lenght, int height) {
		origine = new Punto2D(x, y);
		this.lenght = lenght;
		this.height = height;
		this.color = new Colore(0, 0, 0);
	}

	/**
	 * costruttore Rettangolo in cui il campo colore può essere personalizzato
	 * 
	 * @param x
	 * @param y
	 * @param lenght
	 * @param height
	 * @param r      intero compreso tra 0 e 255
	 * @param g      intero compreso tra 0 e 255
	 * @param b      intero compreso tra 0 e 255
	 */
	public Rettangolo(float x, float y, int lenght, int height, int r, int g, int b) {
		origine = new Punto2D(x, y);
		this.lenght = lenght;
		this.height = height;
		this.color = new Colore(r, g, b);
	}

	public void trasla(float x, float y) {
		origine.traslaX(x);
		origine.traslaY(y);
	}

	public void cambiaColore(int r, int g, int b) {
		color = new Colore(r, g, b);
	}

	public void cambiaColore(Colore.Colori c) {
		color = new Colore(c);
	}

	public String stampaColore() {
		return color.toString();
	}

	@Override
	public String toString() {
		String downLeft = origine.toString();
		String topRight = new Punto2D(origine.getX() + lenght, origine.getY() + height).toString();
		return downLeft + "->" + topRight;
	}

}
