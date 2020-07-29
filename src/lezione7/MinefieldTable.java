package lezione7;

public class MinefieldTable {
	
	//array of cells
	private Cell[][] minefield;
	
	//length of the field 
	private int fieldLength;
	private boolean exploded;
	public boolean getExploded() { return exploded; }
	
	public MinefieldTable(int len) {
		fieldLength = len;
		exploded = false; //it is true when a mine explode
		initField();
		initCellNeighbors();
	}

	/**
	 * init every cell of the minefield with their correct data
	 */
	private void initField(){
		minefield = new Cell[fieldLength][fieldLength];
		for(int i=0; i<fieldLength; i++)
			for(int j=0; j<fieldLength; j++)
				minefield[i][j] = new Cell(i*fieldLength + j, fieldLength);
	}
	
	/**
	 * define the neighbors' reference of every cell in the field
	 */
	private void initCellNeighbors() {
		int[] indeces;
		int count;
		//iter every row of cells in the field
		for(Cell[] cells: minefield) {
			//iter every cell in the row
			for(Cell c: cells) {
				indeces = c.getNeighborsCellsIndeces();
				count = 0;
				//iter every neighbor index of the cell and associate the relative reference
				for(int index: indeces) {
					//HERE I CAN SET THE NUMBER OF BOMB NEARBY THIS CELL
					c.getNeighborsCells()[count++] = minefield[index/fieldLength][index%fieldLength];
					if(c.getNeighborsCells()[count-1].getIsABomb())
						c.bombCount++;
				}
			}
		}
	}
	
	public void updateCell(Cell.State state, int row, int col) {
		//se la cella è flag e il comando è flag togliere solo il flag e ritornare
		//se il comando è scopri e la cella è flag togliere solo il flag e ritornare
		//se la cella è già scoperta ritornare direttamente
		//per tutti gli altri casi richiamare il secondo update
		if(minefield[row][col].getCellState() == Cell.State.DISCOVERED) return;
		
		switch(state) {
		case DISCOVERED:
			if(minefield[row][col].getCellState() == Cell.State.FLAGGED) {
				minefield[row][col].setCellState(Cell.State.UNKNOWN);
				return;
			}	
			updateCell(minefield[row][col]);
			return;
		case FLAGGED:
			//set or unset the state as flagged
			if(minefield[row][col].getCellState() == Cell.State.FLAGGED)
				minefield[row][col].setCellState(Cell.State.UNKNOWN);
			else if(minefield[row][col].getCellState() == Cell.State.UNKNOWN)
				minefield[row][col].setCellState(Cell.State.FLAGGED);
			return;
		default:
			return;
		}
	}
	
	private void updateCell(Cell c) {
		switch(c.getCellState()) {
		case DISCOVERED:
			return;
		case EXPLODED:
			return;
		case FLAGGED:
			return;
		case UNKNOWN:
			c.setCellState(Cell.State.DISCOVERED);
			//base case 1
			if(c.getIsABomb()) {
				//it's a bomb set the state and the boolean
				exploded = true;
				c.setCellState(Cell.State.EXPLODED);
				return;
			}
			if(c.bombCount > 0)
				return;
			break;
		}
		//COSÌ NON SI FERMA MAI SE LA CELLA È VICINA AD UNA BOMBA SETTARLA SCOPERTA E RITORNARE SUBITO
		for(Cell neighbor: c.getNeighborsCells()) {
			updateCell(neighbor);
		}
		return;
	}
	
	@Override
	public String toString() {
		
		StringBuilder output = new StringBuilder();
		for(int row=0; row<fieldLength; row++) {
			for(int col=0; col<fieldLength; col++)
				output.append(minefield[row][col].toString());
			output.append("\n");
		}
		//DA MODIFICARE PER RITORNARE POI SOTTO FORMA DI STRINGA PROPRIO IL CAMPO
		return output.toString();
	}
}
