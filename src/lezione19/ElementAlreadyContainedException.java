package lezione19;

public class ElementAlreadyContainedException extends Exception {
	
	@Override
	public String getMessage() {
		return "l'elemento e' gia' contenuto nel dizionario";
	}

}
