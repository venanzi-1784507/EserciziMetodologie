package lezione19;

public class BastaAcquaException extends Exception{

	final String MESSAGE = "Basta riempire secchi.";
	@Override
	public String getMessage() {
		return MESSAGE;
	}
}
