package lezione7;

import java.util.Scanner;

import lezione7.Cell.State;

public class MinefieldGameplay {

	private MinefieldTable table;
	private Scanner scanner;
	private boolean playing;
	private boolean correctInput;
	private int inputRow, inputCol;
	private State inputCommand;
	
	public MinefieldGameplay(int len) {
		table = new MinefieldTable(len);
		scanner = new Scanner(System.in);
		playing = correctInput = true;
	}
	
	public void play() {
		draw();
		while(playing) {
			
			//input
			input();
			
			//update
			update();
			
			//draw
			draw();
		}
	}
	
	private void input() {
		correctInput = true;
		//loop until the user insert a decent input
		System.out.println("INSERIRE IL COMANDO ('SCOPRI', 'FLAG') + SPAZIO + IL NUMERO DI RIGA + \n"
				+ "+ SPAZIO + IL NUMERO DI COLONNA.\n ALTRIMENTI INSERIRE EXIT PER USCIRE.\n");
		
		String in = scanner.nextLine();
		if(in.toLowerCase().equals("exit")) {
			playing = false;
			return;
		}
		
		String[] s = in.toLowerCase().split(" ");
		if(s.length >3) return;
		
		inputRow = Integer.parseInt(s[1]);
		inputCol = Integer.parseInt(s[2]);
		
		switch(s[0]) {
		case "scopri":
			//ora scopri ricorsivamente le caselle e termina se perdi
			//se la casella
			inputCommand = State.DISCOVERED;
			break;
		case "flag":
			//setta lo stato di flagged sulla casella
			//se la casella aveva già il flag lo disinserisce
			inputCommand = State.FLAGGED;
			break;
		default:
			correctInput = false;
			System.out.println("incorrect input try again");
		}
	}
	
	private void update() {
		if(!playing || !correctInput) return;
		
		table.updateCell(inputCommand, inputRow, inputCol);
		if(table.getExploded())
			playing = false;
	}
	
	private void draw() {
		//if(!playing || !correctInput) return;
		if(!correctInput) return;
		System.out.println(table.toString());
	}
}
