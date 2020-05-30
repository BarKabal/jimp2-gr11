package wireworldfiles;

import java.util.ArrayList;

public class Matrix {
	public int rows;
	public int columns;
	public static int DEFAULT_ITERATION = 12;

	public ArrayList<Cell>[][] board; // Cell[rows][columns]

	@SuppressWarnings("unchecked") //wyrzuca b³¹d przy tworzeniu ArrayListy podwójnej tablicy, nie sprawia to jednak problemów
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.board = new ArrayList[rows][columns];
	}


	public Matrix(int rows, int columns, ArrayList<Cell>[][] board) {
		this.rows = rows;
		this.columns = columns;
		this.board = board;
	}

	public static void printMatrix(int n, Matrix matrix) {

		System.out.println((n + 1) + ". Iteracja:");
		for (int i = 0; i < matrix.rows; i++) {
			for (int j = 0; j < matrix.columns; j++) {
				System.out.print(matrix.board[i][j].get(n).state + " ");
			}
			System.out.println();
		}

	}

	public static void initializeMatrix(Matrix matrix) {
		for (int i = 0; i < matrix.rows; i++) {
			for (int j = 0; j < matrix.columns; j++) {
				matrix.board[i][j].add(new Cell(0));
			}
		}
	}
	
	public static void startMatrix(Matrix matrix) {
		for (int i = 0; i < matrix.rows; i++) {
			for (int j = 0; j < matrix.columns; j++) {
				matrix.board[i][j] = new ArrayList<Cell>();
				matrix.board[i][j].add(new Cell(0));
			}
		}
	}
	
	public static void checkCell(int rows, int columns, int n, Matrix matrix) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (c - 1 >= 0) {
					if (r - 1 >= 0) {
						if (matrix.board[r - 1][c - 1].get(n).state == 1)
							matrix.board[r][c].get(n).headCounter++;
					}
					if (matrix.board[r][c - 1].get(n).state == 1) {
						matrix.board[r][c].get(n).headCounter++;
					}
					if (r + 1 < rows) {
						if (matrix.board[r + 1][c - 1].get(n).state == 1) {
							matrix.board[r][c].get(n).headCounter++;
						}
					}
				}
				if (r - 1 >= 0) {
					if (matrix.board[r - 1][c].get(n).state == 1) {
						matrix.board[r][c].get(n).headCounter++;
					}
				}
				if (r + 1 < rows) {
					if (matrix.board[r + 1][c].get(n).state == 1) {
						matrix.board[r][c].get(n).headCounter++;
					}
				}
				if (c + 1 < columns) {
					if (r - 1 >= 0) {
						if (matrix.board[r - 1][c + 1].get(n).state == 1) {
							matrix.board[r][c].get(n).headCounter++;
						}
					}

					if (matrix.board[r][c + 1].get(n).state == 1) {
						matrix.board[r][c].get(n).headCounter++;
					}

					if (r + 1 < rows) {
						if (matrix.board[r + 1][c + 1].get(n).state == 1) {
							matrix.board[r][c].get(n).headCounter++;
						}
					}
				}
			}
		}

	}

	public static void changeMatrix(int n, Matrix matrix) {
		for (int i = 0; i < matrix.rows; i++) {
			for (int j = 0; j < matrix.columns; j++) {
				changeState(matrix.board[i][j].get(n), matrix.board[i][j].get(n + 1));
			}
		}
	}

	private static void changeState(Cell previousCell, Cell nextCell) {
		if (previousCell.state == 0)
			nextCell.state = 0;
		else if (previousCell.state == 1)
			nextCell.state = 2;
		else if (previousCell.state == 2)
			nextCell.state = 3;
		else if (previousCell.headCounter == 1 || previousCell.headCounter == 2)
			nextCell.state = 1;
		else
			nextCell.state = 3;
	}
	
	public static void isActive(int n, Matrix matrix) {
		for (int i = 0; i < matrix.rows; i++) {
			for (int j = 0; j < matrix.columns; j++) {
				if (matrix.board[i][j].get(n).state != 0) {
					matrix.board[i][j].get(n).isActive = true;
				}
				else
					matrix.board[i][j].get(n).isActive = false;
			}
		}
	}
}
