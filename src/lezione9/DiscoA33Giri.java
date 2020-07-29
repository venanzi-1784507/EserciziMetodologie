package lezione9;

import java.util.ArrayList;

public class DiscoA33Giri extends Supporto {

	public static final int DISCO_33_GIRI_MAX_BRANI = 14;
	
	public DiscoA33Giri() {
		brani = new ArrayList<Brano>();
		for(int i = 0; i<DISCO_33_GIRI_MAX_BRANI; i++)
			brani.add(null);
	}
}
