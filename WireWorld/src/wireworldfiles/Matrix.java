package wireworldfiles;

public class Matrix {
	public int rows;
	public int collumns;
	public int iteration;

	public Cell[][][] board; // Cell[rows][collumns][iteration]

	Matrix(int rows, int collumns, int iteration) {
		this.rows = rows;
		this.collumns = collumns;
		this.iteration = iteration;
		this.board = new Cell[rows][collumns][iteration];
	}

	Matrix(int rows, int collumns, Cell board[][][]) {
		this.rows = rows;
		this.collumns = collumns;
		this.board = board;
	}

	public static void main(String[] args) {
		Matrix matrix = new Matrix(5, 4, 2);

		initializeMatrix(matrix);
		printMatrix(matrix);
	}

	public static void printMatrix(Matrix matrix) {
		for (int n = 0; n < matrix.iteration; n++) {
			System.out.println((n+1) + ". Iteracja:");
			for (int i = 0; i < matrix.rows; i++) {
				for (int j = 0; j < matrix.collumns; j++) {
					System.out.print(matrix.board[i][j][0].state + " ");
				}
				System.out.println();
			}
		}
	}

	public static void initializeMatrix(Matrix matrix) {
		for (int n = 0; n < matrix.iteration; n++) {
			for (int i = 0; i < matrix.rows; i++) {
				for (int j = 0; j < matrix.collumns; j++) {
					matrix.board[i][j][n] = new Cell(2);
				}
			}
		}
	}
}
