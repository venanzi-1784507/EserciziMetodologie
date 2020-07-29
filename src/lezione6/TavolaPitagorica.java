package lezione6;

public class TavolaPitagorica {

	private int[][] tavola; 
	
	/**
	 * 
	 * @param n grandezza del lato della tavola
	 */
	public TavolaPitagorica(int n) {
		tavola = new int[n][n];
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++)
				tavola[r][c] = r * c;
		}
	}
	
	public int valoreRigaColonna(int riga, int col) {
		return tavola[riga][col];
	}
	
	@Override
	public String toString() {
		String s = "x\t";
		//inserisci nella stringa i vari indici di colonna
		for(int c=0; c<tavola.length; c++)
			s+= c + "\t";
		s+= "\n";
		for(int r=0; r<tavola.length; r++) {
			s+= r + "\t";
			for(int c=0; c<tavola.length; c++)
				s+= tavola[r][c] + "\t";
			//vado a capo
			s+= "\n";
		}
		return s;
	}
	
	
	public static void main(String[] args) {
		TavolaPitagorica tp = new TavolaPitagorica(11);
		
		System.out.println(tp.valoreRigaColonna(3, 3));
		System.out.println();
		System.out.println(tp);
	}
}
