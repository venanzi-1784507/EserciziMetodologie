package lezione19;

public class GradinoIrraggiungibileException extends Exception {

	@Override
	public String getMessage() {
		return "il gradino non dista 1 dal precedente";
	}
}
