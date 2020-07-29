package lezione9;

public class LettoreMp3 extends RiproduttoreMusicale{

	public LettoreMp3(MemoriaUSB usb) {
		super(usb);
	}
	
	@Override
	public boolean inserisciSupporto(Supporto s) {
		if(s.getClass() == MemoriaUSB.class)
			return super.inserisciSupporto(s);
		return false;
	}
}
