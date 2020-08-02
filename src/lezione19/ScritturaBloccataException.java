package lezione19;

public class ScritturaBloccataException extends Exception{

	@Override
	public String getMessage() {
		return "impossibile modificare i dati, scrittura bloccata";
	}
}
