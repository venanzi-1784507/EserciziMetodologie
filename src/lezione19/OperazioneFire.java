package lezione19;

import java.util.LinkedList;

public class OperazioneFire {

	private LinkedList<VolontarioSemplice> volontari;
	private Incendio incendio;
	
	/**
	 * costruttore della classe
	 * @param n numero di volontari per spegnore l'incendio
	 * @param i riferimento all'incendio
	 */
	public OperazioneFire(int n, Incendio i) {
		volontari = new LinkedList<>();
		volontariInit(n);
		incendio = i;
	}

	private void volontariInit(int n) {
		volontari.add(new VolontariaAcquaFredda());
		for(int i=1; i<n-1; i++)
			volontari.add(new VolontarioSemplice());
		volontari.add(new VolontarioFuoco());
	}
	
	public void spegniFuoco() {
		Secchio s = new Secchio();
		//finche' il fuoco non e' spendo
		loop:
		while(true) {
			for(VolontarioSemplice v: volontari) {
				try {
					v.estinguiIncendio(incendio, s);
				} catch (FuocoEstintoException e) {
					e.printStackTrace();
				} catch (BastaAcquaException e) {
					e.printStackTrace();
					break loop;
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return volontari.toString() + ", " + incendio.getIntensity();
	}
	
	public static void main(String[] args) {
		OperazioneFire of = new OperazioneFire(5, new Incendio(3));
		
		System.out.println(of);
		
		of.spegniFuoco();
		
		System.out.println(of);
	}
}
