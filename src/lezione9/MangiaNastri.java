package lezione9;

public class MangiaNastri extends RiproduttoreMusicale {

	public MangiaNastri(Nastro n) {
		super(n);
	}
	
	@Override
	public boolean inserisciSupporto(Supporto s) {
		if(s.getClass() == Nastro.class)
			return super.inserisciSupporto(s);
		return false;
	}
}
