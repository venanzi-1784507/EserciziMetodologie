package lezione8;

public class BarraDiEnergia {

	protected int maxLength;
	protected int currentLength;
	
	public void increase() {
		if(currentLength < maxLength) currentLength++;
	}
	
	public BarraDiEnergia(int maxLength) {
		this.maxLength = maxLength;
	}
	
	protected String stringMultiplier(String s, int i) {
		String temp = "";
		for(; i>0; i--)
			temp += s;
		return temp;
	}
	
	@Override
	public String toString() {
		int mod = currentLength % maxLength;
		if(currentLength == maxLength) return stringMultiplier("O", maxLength);
		
		return stringMultiplier("O", mod) + stringMultiplier("=", maxLength-mod);
	}
}
