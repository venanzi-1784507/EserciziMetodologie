package lezione19;

public class FuocoEstintoException extends Exception {
	
	private String MESSAGE = "il fuoco e' stato spento.";
	
	@Override
	public String getMessage() {
		return MESSAGE;
	}

}
