package wireworldfiles;

public class Matrix {
	public int rows;
	public int collumns;
	public int iteration;
	
	public Cell[][] board; // Cell[rows][collumns]
	
	Matrix(int rows, int collumns){
		this.rows = rows;
		this.collumns = collumns;
		this.board = new Cell[rows][collumns];
	}
	
	Matrix(int rows, int collumns, Cell board[][]){
		this.rows = rows;
		this.collumns = collumns;
		this.board = board;
	}
	
	public static void main(String[] args) {
		Matrix matrix = new Matrix(5,2);		// Dane testowe
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 2; j++) {
				matrix.board[i][j] = new Cell(2);
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.print(matrix.board[i][j].state + " ");
			}
			System.out.println();
		}
	}
}
