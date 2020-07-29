package lezione9;

public class LettoreCD extends RiproduttoreMusicale{

	public LettoreCD(CompactDisc cd) {
		super(cd);
	}
	
	@Override
	public boolean inserisciSupporto(Supporto s) {
		if(s.getClass() == CompactDisc.class)
			return super.inserisciSupporto(s);
		return false;
	}
}
