package wireworldfiles;

public class Matrix {
	public int rows;
	public int collumns;
	public int iteration;
	
	public Cell[][][] board; // Cell[rows][collumns][iteration]
	
	Matrix(int rows, int collumns, Cell[][][] board){
		this.rows = rows;
		this.collumns = collumns;
		this.board = board;
	}
	
	public static void main(int args) {
		
	}
}
