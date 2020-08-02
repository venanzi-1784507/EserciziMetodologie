package lezione19;

public class DatiInsufficientiException extends Exception{

	@Override
	public String getMessage() {
		return "dati in memoria insufficienti";
	}
}
