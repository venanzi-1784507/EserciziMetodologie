package lezione19;

public class Secchio {

	private boolean isEmpty;
	public boolean IsEmpty() { return isEmpty; }
	
	public void fill() {
		isEmpty = false;
	}
	
	public void spill() {
		isEmpty = true;
	}
}
