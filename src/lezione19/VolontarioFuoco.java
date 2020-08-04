package lezione19;

public class VolontarioFuoco extends VolontarioSemplice{

	@Override
	public void estinguiIncendio(Incendio i, Secchio s) throws FuocoEstintoException{
		gettaSecchio(i, s);
		//se l'incendio e' domato lancia eccezione
		if(!(i.getIsOnFire())) throw new FuocoEstintoException();
	}
	
	private void gettaSecchio(Incendio i, Secchio s) {
		//riduco il fuoco
		i.decreaseIntensityByOne();
		//svuoto il secchio
		s.spill();
	}
}
