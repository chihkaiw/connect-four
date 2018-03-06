package connect.model;

public class Position {

	private int row;
	private int col;
	private Disc disc;

	public Position(int row, int col, Disc disc) {
		this.row = row;
		this.col = col;
		this.disc = disc;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public Disc getDisc() {
		return disc;
	}

}
