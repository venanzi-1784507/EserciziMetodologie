package lezione19;

public class InsufficienteSpazioException extends Exception{

	@Override
	public String getMessage() {
		return "spazio insufficiente nel floppy";
	}
}
