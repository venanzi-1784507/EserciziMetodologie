package lezione9;

import java.util.ArrayList;

public class CompactDisc extends Supporto {

	public static final int COMPACT_DISC_MAX_BRANI = 20;
	
	public CompactDisc() {
		brani = new ArrayList<>(COMPACT_DISC_MAX_BRANI);
	}
}
