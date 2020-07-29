package lezione7;

import java.util.Arrays;
import java.util.Random;

public class Cell {
	
	/**
	 * states of a cell during the gameplay
	 * @author giaco
	 *
	 */
	public enum State {
			UNKNOWN("*"), DISCOVERED(" "), FLAGGED("!"), EXPLODED("@");
		
		private String value;
		
		private State(String s) {
			value = s;
		}
		
		@Override
		public String toString() {
			//remember that if this is discovered and it's next to a bomb it's string value
			//won't be a space anymore but the number of bombs nearby this cell
			return value;
		}
	}
	
	private static int BOMB_COUNTER = 10;
	//cell state 
	private State cellState;
	private boolean isABomb;
	public boolean getIsABomb(){ return  isABomb; }
	public int bombCount;
	//cell index from zero to nxn of the matrix table
	private int cellNumber;
	private int cellRow, cellCol;
	public int getCellRow() { return cellRow; }
	public int getCellCol() { return cellCol; }
	//array with the indices of the neighbors cells indices
	private int[] neighborsCellsIndeces;
	//array with references of the neighbors cells
	private Cell[] neighborsCells;

	public Cell(int index, int matrixLen) {
		bombCount = 0;
		cellRow = index/matrixLen;
		cellCol = index % matrixLen;
		cellNumber = index;//my index in the matrix
		neighborsCellsIndeces = initNeighborsIndices(matrixLen);//array of cells' indeces
		neighborsCells = new Cell[neighborsCellsIndeces.length];
		initState();
	}
	
	private void initState() {
		//a cell has 20% of being a bomb but no more than BOMB_COUNTER cells can be a bomb
		Random rand = new Random();
		int r = rand.nextInt(100);
		if(r<20 && BOMB_COUNTER-- > 0) {
			//it is a bomb
			this.cellState = State.UNKNOWN;
			isABomb = true;
		}
		else {
			this.cellState = State.UNKNOWN;
			isABomb = false;
		}
	}
	
	private int[] initNeighborsIndices(int matrixLen) {
		int lastIndex = matrixLen * matrixLen;
		int count = 0;
		int temp;
		int[] tempArray = new int[8];
		//allora dato il mio indice e la lunghezza
		//per ogni cella ci possono essere 8 vicini
		
		
		if(cellCol == 0) {
			//non ha nessun vicino a sinistra ne sopra ne sotto
			//up
			temp = cellNumber-matrixLen;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//up-right
			temp = cellNumber-matrixLen + 1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//right
			temp = cellNumber+1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//centre-down
			temp = cellNumber+matrixLen;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//down-right
			temp = cellNumber+matrixLen+1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
		}
		else if(cellCol == matrixLen-1) {
			//up
			temp = cellNumber-matrixLen;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//up-left
			temp = cellNumber-matrixLen - 1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//left
			temp = cellNumber-1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//centre-down
			temp = cellNumber+matrixLen;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//down-left
			temp = cellNumber+matrixLen-1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
		}
		else {
			//up
			temp = cellNumber-matrixLen;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//up-left
			temp = cellNumber-matrixLen - 1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//up-right
			temp = cellNumber-matrixLen + 1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//left
			temp = cellNumber-1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//right
			temp = cellNumber+1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//centre-down
			temp = cellNumber+matrixLen;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//down-left
			temp = cellNumber+matrixLen-1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
			//down-right
			temp = cellNumber+matrixLen+1;
			if(temp >= 0 && temp < lastIndex && temp != cellNumber)
				tempArray[count++] = temp;
		}
		
		return Arrays.copyOf(tempArray, count);
	}
	
	public int[] getNeighborsCellsIndeces() {
		return neighborsCellsIndeces;
	}
	
	public Cell[] getNeighborsCells() {
		return neighborsCells;
	}
	
	//SE GLI INDICI DELLE CELLE VICINE NON SONO CORRETTI SAREBBE MEGLIO BLOCCARE L'ESECUZIONE
	//anche se questo metodo non è che servi a qualcosa
	public void setNeighborsCells(Cell[] neighborsCells) {
		this.neighborsCells = neighborsCells;
	}
	
	public State getCellState() {
		return cellState;
	}
	
	public void setCellState(State cellState) {
		this.cellState = cellState;
	}
	
	@Override
	public String toString() {
		
		switch(cellState) {
		case DISCOVERED:
			//empty value or bomb number
			if(bombCount == 0) return cellState.toString();
			else 
				return bombCount +"";
		case EXPLODED:
			//explosion state value 
			return cellState.toString();
		case FLAGGED:
			//flagged state value
			return cellState.toString();
		case UNKNOWN:
			//simple unknown state value
			return cellState.toString();
		}
		//QUI SI RITORNERA' A SECONDA DELLO STATO IL RELATIVO VALORE E/O IL NUMERO DI BOMBE
		return super.toString();
	}
}
