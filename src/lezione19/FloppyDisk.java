package lezione19;

public class FloppyDisk {
	
	//corrisponde ai char che posso inserire nel floppy
	public final int DIMENSIONE_MAX = 80;
	
	private int testina;
	private String data;
	private boolean isWritable;
	
	public FloppyDisk() {
		testina = 0;
		data = "";
		isWritable = true;
	}
	
	public void posizionaTestina(int k) {
		testina = k;
	}
	
	public void attivaBloccoScrittura() {
		isWritable = false;
	}
	
	public void disattivaBloccoScrittura() {
		isWritable = true;
	}
	
	public void formatta() throws ScritturaBloccataException{
		//se la scrittura e' bloccata lancia eccezione
		if(!isWritable)
			throw new ScritturaBloccataException();
		data = "";
	}
	
	public void scrivi(String s) throws InsufficienteSpazioException, ScritturaBloccataException{
		//se la scrittura e' bloccata lanciare un'eccezione
		if(!isWritable)
			throw new ScritturaBloccataException();
		//controllo se c'e' abbastanza spazio disponibile
		if(s.split("").length > DIMENSIONE_MAX - data.split("").length)
			//lancia eccezione
			throw new InsufficienteSpazioException();
		//se c'e' spazio a sufficienza scrivere il dato passato in input in coda ai precedenti se presenti
		data += s;
	}
	
	public String leggi() throws DatiInsufficientiException{
		//se non ci sono dati in memoria lancia eccezione
		if(data.equals(""))
			throw new DatiInsufficientiException();
		//se la testina supera la posizione dell'ultimo dato inserito lancia eccezione
		if(testina >= data.length())
			throw new DatiInsufficientiException();
		return data.substring(testina);
	}
	
	public static void main(String[] args) {
		
		FloppyDisk fd = new FloppyDisk();
		
		try {
			fd.scrivi("ciao mario come va?");
		} catch (InsufficienteSpazioException | ScritturaBloccataException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(fd.leggi());
		} catch (DatiInsufficientiException e) {
			e.printStackTrace();
		}
		
		fd.posizionaTestina(100);
		
		try {
			System.out.println(fd.leggi());
		} catch (DatiInsufficientiException e) {
			e.printStackTrace();
		}
		
//		//i dati da salvare sono troppi
//		try {
//			fd.scrivi("i topi non avevano nipoti. la gatta frettolosa ha fatto i figli ciechi.");
//		} catch (InsufficienteSpazioException | ScritturaBloccataException e) {
//			e.printStackTrace();
//		}
		
		fd.attivaBloccoScrittura();
		
		try {
			fd.scrivi("hulk spacca tutto");
		} catch (InsufficienteSpazioException | ScritturaBloccataException e) {
			e.printStackTrace();
		}
		
		try {
			fd.formatta();
		} catch (ScritturaBloccataException e) {
			e.printStackTrace();
		}
	}

}
