package lab_1;

import lab_1.PedinaDama.TIPO;

public class ScacchieraDama {

	public PedinaDama[][] scacchiera;
	
	public ScacchieraDama() {
		scacchiera = new PedinaDama[8][8];
	}
	
	private void tuttaDiUnColore(TIPO col) {
		for(int r=0; r<8; r++) {
			for(int c=0; c<8; c++) {
				scacchiera[r][c] = new PedinaDama(col);
			}
		}
	}
	
	public void tuttaNera() {
		this.tuttaDiUnColore(TIPO.NERO);
	}
	
	public void tuttaBianca() {
		this.tuttaDiUnColore(TIPO.BIANCO);
	}
	
	public void tuttaVuota() {
		this.tuttaDiUnColore(TIPO.VUOTA);
	}
	
	public void setPedina(int riga, int colonna, PedinaDama pd) {
		scacchiera[riga][colonna] = pd;
	}
	
	PedinaDama getPedina(int riga, int colonna) {
		return scacchiera[riga][colonna];
	}
	
	public void salva(String nomeFile) {
		GestoreSaveGame.salvaPartita(nomeFile, creaConfig());
	}
	
	private String creaConfig() {
		StringBuilder sb = new StringBuilder();
		
		for(int r=0; r<scacchiera.length; r++) {
			for(int c=0; c<scacchiera[r].length; c++) {
				sb.append(scacchiera[r][c].getTipo());//ritorna "B", "N", oppure "V"
				sb.append(";");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void caricaConfig(String nomeConfig) {
		String s = GestoreSaveGame.caricaPartita(nomeConfig);
		String[] lines = s.split("\n");
		int index = 0;
		for(String linea: lines) {
			String[] pedine = linea.split(";");
			for(String p: pedine) {
				switch(p) {
				case "V":
					scacchiera[index/8][index%8] = new PedinaDama(TIPO.VUOTA);
					break;
				case "B":
					scacchiera[index/8][index%8] = new PedinaDama(TIPO.BIANCO);
					break;
				case "N":
					scacchiera[index/8][index%8] = new PedinaDama(TIPO.NERO);
					break;
				}
				//aumenta l'indice
				index++;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int r=0; r<scacchiera.length; r++) {
			for(int c=0; c<scacchiera[r].length; c++) {
				if(!(scacchiera[r][c].getTipo() == TIPO.VUOTA))
					sb.append(scacchiera[r][c].getTipo());//ritorna "B", "N"
				else
					sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
