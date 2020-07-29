package finoLezione4;

public class BarraDiCompletamento {

	private float count;

	public BarraDiCompletamento() {
		count = 100;
	}

	public BarraDiCompletamento(float valoreIniziale) {
		count = valoreIniziale;
	}

	public void incrementa(float incremento) {
		count += incremento;
	}

	@Override
	public String toString() {
		return "" + Math.round(count);
	}

	public static void main(String[] args) {

		BarraDiCompletamento barra = new BarraDiCompletamento(0);
		barra.incrementa(20);
		barra.incrementa(25);
		System.out.println(barra);
	}
}
