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
		Matrix matrix = new Matrix(6,3);		// Dane testowe
		
		initializeMatrix(matrix);
		
		printMatrix(matrix);
	}
	
	public static void printMatrix(Matrix matrix) {
		for(int i = 0; i < matrix.rows; i++) {
			for(int j = 0; j < matrix.collumns; j++) {
				System.out.print(matrix.board[i][j].state + " ");
			}
			System.out.println();
		}
	}
	
	public static void initializeMatrix(Matrix matrix) {
		for(int i = 0; i < matrix.rows; i++) {
			for(int j = 0; j < matrix.collumns; j++) {
				matrix.board[i][j] = new Cell(2);
			}
		}
	}
}
