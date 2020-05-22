package wireworldfiles;

public class Matrix {
	public int rows;
	public int collumns;
	
	public Cell[][] board;
	
	Matrix(int rows, int collumns, Cell[][] board){
		this.rows = rows;
		this.collumns = collumns;
		this.board = board;
	}
}
