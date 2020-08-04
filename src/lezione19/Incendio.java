package lezione19;

public class Incendio {
	
	private boolean isOnFire;
	private int intensity;
	public int getIntensity() { return intensity; }
	
	/**
	 * costruttore della classe
	 * @param intensity intensita' dell'incendio, deve essere maggiore o uguale ad 1
	 */
	public Incendio(int intensity) {
		this.intensity = intensity;
		isOnFire = true;
	}

	public boolean getIsOnFire() { return isOnFire; }
	
	public void decreaseIntensityByOne() { 
		intensity--;
		if(intensity<0) intensity = 0;
		update();
	}
	
	public void update() {
		if(intensity==0) isOnFire = false;
	}
}
