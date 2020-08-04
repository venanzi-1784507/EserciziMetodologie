package lezione19;

public class VolontariaAcquaFredda extends VolontarioSemplice{

	@Override
	public void estinguiIncendio(Incendio i, Secchio s) throws FuocoEstintoException, BastaAcquaException {
		//se il fuoco e' estinto lancia eccezione 
		if(!(i.getIsOnFire())) throw new BastaAcquaException();
		//altrimenti riempi il secchio
		s.fill();
	}
	
	
}
