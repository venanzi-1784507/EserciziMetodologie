package lezione11;

import java.util.ArrayList;

public class Castello {

	public enum difesa {
		PRIMA, SECONDA, TERZA
	}
	public static final int VITA = 2000;
	
	private double vitaAttuale;
	
	public Castello() {
		vitaAttuale = VITA + 0;
	}
	
	/**
	 * 
	 * @param armi
	 * @return true se il castello sopravvive all'assedio
	 */
	public boolean subisciAttacco(ArrayList<Armi> armi) {
		
		//qui in input passo la lista di armi che creo nel main
		//poi all'interno di questo metodo passo in input alle armi 
		//questo castello così infliggono direttamente loro i danni
		for(Armi ar: armi)
			ar.attacca(this);
		
		return vitaAttuale > 0;
	}
	
	public difesa getDifesa() {
		double perc = (100 * vitaAttuale) / VITA;
		
		if(perc<= 25)
			return difesa.TERZA;
		else if(perc <= 50)
			return difesa.SECONDA;
		else
			return difesa.PRIMA;
	}
	
	public void subisciDanno(double danno) {
		vitaAttuale -= danno;
	}
	
	/**
	 * 
	 * @return true se il castello è resistito all'assedio
	 */
	public boolean isAlive() {
		return vitaAttuale > 0;
	}
	
	public double getVita() {
		return vitaAttuale;
	}
}
