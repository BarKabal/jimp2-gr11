package wireworldfiles;
import loadsavefile.LoadFile;
import loadsavefile.SaveFile;
public class Matrix {
	public int rows;
	public int collumns;
	public int iteration;

	public Cell[][][] board; // Cell[rows][collumns][iteration]

	public Matrix(int rows, int collumns, int iteration) {
		this.rows = rows;
		this.collumns = collumns;
		this.iteration = iteration;
		this.board = new Cell[rows][collumns][iteration];
	}

	public Matrix(int rows, int collumns, Cell board[][][]) {
		this.rows = rows;
		this.collumns = collumns;
		this.board = board;
	}

	public static void main(String[] args) {
		Matrix matrix = new Matrix(5, 5, 5);
		initializeMatrix(matrix);
		for (int n = 0; n < matrix.iteration; n++) {
			checkCell(matrix.rows, matrix.collumns, n, matrix);
			printMatrix(n, matrix);
			
			if(n+1 < matrix.iteration)
				changeMatrix(n, matrix);
		}
		SaveFile.saveFile(matrix.iteration - 1, matrix);
	}


	public static void printMatrix(int n, Matrix matrix) {

		System.out.println((n + 1) + ". Iteracja:");
		for (int i = 0; i < matrix.rows; i++) {
			for (int j = 0; j < matrix.collumns; j++) {
				System.out.print(matrix.board[i][j][n].state + " ");
			}
			System.out.println();
		}

	}

	public static void initializeMatrix(Matrix matrix) {
		for (int n = 0; n < matrix.iteration; n++) {
			for (int i = 0; i < matrix.rows; i++) {
				for (int j = 0; j < matrix.collumns; j++) {
					matrix.board[i][j][n] = new Cell(1);
				}
			}
		}
	}

	public static void checkCell(int rows, int collumns, int n, Matrix matrix) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < collumns; c++) {
				if (c - 1 >= 0) {
					if (r - 1 >= 0) {
						if (matrix.board[r - 1][c - 1][n].state == 1)
							matrix.board[r][c][n].headCounter++;
					}
					if (matrix.board[r][c - 1][n].state == 1) {
						matrix.board[r][c][n].headCounter++;
					}
					if (r + 1 < rows) {
						if (matrix.board[r + 1][c - 1][n].state == 1) {
							matrix.board[r][c][n].headCounter++;
						}
					}
				}
				if (r - 1 >= 0) {
					if (matrix.board[r - 1][c][n].state == 1) {
						matrix.board[r][c][n].headCounter++;
					}
				}
				if (r + 1 < rows) {
					if (matrix.board[r + 1][c][n].state == 1) {
						matrix.board[r][c][n].headCounter++;
					}
				}
				if (c + 1 < collumns) {
					if (r - 1 >= 0) {
						if (matrix.board[r - 1][c + 1][n].state == 1) {
							matrix.board[r][c][n].headCounter++;
						}
					}

					if (matrix.board[r][c + 1][n].state == 1) {
						matrix.board[r][c][n].headCounter++;
					}

					if (r + 1 < rows) {
						if (matrix.board[r + 1][c + 1][n].state == 1) {
							matrix.board[r][c][n].headCounter++;
						}
					}
				}
			}
		}

	}

	public static void changeMatrix(int n, Matrix matrix) {
		for (int i = 0; i < matrix.rows; i++) {
			for (int j = 0; j < matrix.collumns; j++) {
				changeState(matrix.board[i][j][n], matrix.board[i][j][n+1]);
			}
		}
	}

	private static void changeState(Cell cell1, Cell cell2) {
		if (cell1.state == 0)
			cell2.state = 0;
		else if (cell1.state == 1)
			cell2.state = 2;
		else if (cell1.state == 2) 
			cell2.state = 3;
		else if (cell1.headCounter == 1 || cell1.headCounter == 2)
			cell2.state = 1;
		else
			cell2.state = 3;
	}

}
