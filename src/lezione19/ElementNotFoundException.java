package lezione19;

public class ElementNotFoundException extends Exception {
	
	@Override
	public String getMessage() {
		return "l'elemento non e' presente nel dizionario";
	}

}
