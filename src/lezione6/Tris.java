package lezione6;

import java.util.Scanner;

public class Tris {
	
	private CellaTris[] tavola;
	private String giocatore1;
	private String giocatore2;
	private boolean exit;
	private boolean firstPlayer;
	private Scanner scanner;

	public Tris(String giocat1, String giocat2) {
		scanner = new Scanner(System.in);
		exit = false;
		firstPlayer = true;
		giocatore1 = giocat1;
		giocatore2 = giocat2;
		tavola = new CellaTris[9];
		for(int i=0; i<9; i++)
			tavola[i] = new CellaTris();
	}
	
	public void play() {
		//stampo prima di tutto il tris
		this.draw();
		
		while(!exit) {
			//qui ci sarà il gioco in loop
			
			//input
			while(true) {
				//dichiarazione di turno
				if(firstPlayer)
					System.out.println("questo è il turno di " + giocatore1);
				else
					System.out.println("questo è il turno di " + giocatore2);
				//spiegazione regole
				System.out.println("inserisci due numeri(da 1 a 3 separati da uno "
						+ "spazio per riga e colonna (riga colonna)"
						+ " altrimenti scrivere exit per uscire dal gioco");
				//input da parte del giocatore
				if(firstPlayer) {
					if(getInput("X", scanner.nextLine())) {
						firstPlayer = false;
						break;
					}
				}
				else {
					if(getInput("O", scanner.nextLine())) {
						firstPlayer = true;
						break;
					}
				}
				System.out.println("DATI INSERITI NON CORRETTI, REINSERIRLI");
			}
			
			if(exit){
				System.out.println("sessione di gioco terminata");
				return;
			}
			
			//update
			//controllare se un giocatore ha vinto nel caso stampare tavola e uscire dal while
			if(gameStatus()) {
				this.draw();
				//il bool firstPlayer è stato modificato precedentemente
				if(firstPlayer)
					//ha vinto il secondo player
					System.out.println("congratulazioni " + giocatore2 + " hai vinto!!");
				else
					//ha vinto il primo
					System.out.println("congratulazioni " + giocatore1 + " hai vinto!!");
				return;
			}
			
			//draw
			this.draw();
		}
	}
	
	public boolean getInput(String sign, String input) {
		if(input.equals("exit")) exit = true;
		else if(input.length() == 3) {
			//primo(0) char indice di riga terzo(2) char indice di colonna
			int riga = Integer.parseInt(input.charAt(0)+"")-1;
			int col = Integer.parseInt(input.charAt(2)+"")-1;
			tavola[3*riga + col].changeValue(sign);
		}
		else 
			//se il dato non è stati inserito correttamente, dovrà essere reinserito di nuovo
			return false;
	
		return true;
	}
	
	/**
	 * metodo che controlla lo stato di gioco
	 * @return ritorna un boolean che è true se un giocatore ha vinto
	 */
	public boolean gameStatus() {
		for(int i=0; i<3; i++) {
			//prima devo controllare che triple di celle siano tutte X o O
			if(tavola[i].toString().equals("X") || tavola[i].toString().equals("O")) {
				//controllo colonne verticali
				if(tavola[i].equals(tavola[i+3]) && tavola[i].equals(tavola[i+6]))
						return true;
			}
			if(tavola[i*3].toString().equals("X") || tavola[i*3].toString().equals("O")) {
				//controllo righe orizzontali
				if(tavola[i*3].equals(tavola[i*3+1]) && tavola[i*3].equals(tavola[i*3+2]))
					return true;
			}
		}
		
		if(tavola[4].toString().equals("X") || tavola[4].toString().equals("O")) {
			//controllo diagonale principale
			if(tavola[0].equals(tavola[4]) && tavola[0].equals(tavola[8]))
				return true;
			//controllo diagonale secondaria
			if(tavola[6].equals(tavola[4]) && tavola[6].equals(tavola[2]))
				return true;
		}
		
		//altrimenti non ha ancora vinto nessuno
		return false;
	}
	
	public void draw() {
		System.out.println(this.toString());
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(int i=0; i<9; i++) {
			s.append(tavola[i] + "|");
			if(i == 2 || i == 5 || i == 8) {
				s.deleteCharAt(s.length()-1);
				if(i!=8)
					s.append("\n_ _ _\n");
			}
		}return s.toString();
		
	}
	
}
