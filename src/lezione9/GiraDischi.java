package lezione9;

public class GiraDischi extends RiproduttoreMusicale {
	
	public GiraDischi(DiscoA33Giri d) {
		super(d);
	}

	public GiraDischi(DiscoA45Giri d) {
		super(d);
	}
	
	@Override
	public boolean inserisciSupporto(Supporto s) {
		if(s.getClass() == DiscoA33Giri.class || s.getClass() == DiscoA45Giri.class)
			return super.inserisciSupporto(s);
		return false;
	}
}
