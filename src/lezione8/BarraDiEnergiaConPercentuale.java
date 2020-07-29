package lezione8;

public class BarraDiEnergiaConPercentuale extends BarraDiEnergia {

	public BarraDiEnergiaConPercentuale(int maxLength) {
		super(maxLength);
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " " + currentLength * 100 / maxLength + "%";
	}
}
