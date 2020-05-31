package wireworldfiles;

import java.util.ArrayList;

public class Matrix {
	public int rows;
	public int columns;
	public static int iteration = 4;

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

	public void printMatrix(int n) {

		System.out.println((n + 1) + ". Iteracja:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(board[i][j].get(n).state + " ");
			}
			System.out.println();
		}

	}

	public void initializeMatrix() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j].add(new Cell(0));
			}
		}
	}
	
	public void startMatrix() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j] = new ArrayList<Cell>();
				board[i][j].add(new Cell(0));
			}
		}
	}
	
	public void checkCell(int n) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (c - 1 >= 0) {
					if (r - 1 >= 0) {
						if (board[r - 1][c - 1].get(n).state == 1)
							board[r][c].get(n).headCounter++;
					}
					if (board[r][c - 1].get(n).state == 1) {
						board[r][c].get(n).headCounter++;
					}
					if (r + 1 < rows) {
						if (board[r + 1][c - 1].get(n).state == 1) {
							board[r][c].get(n).headCounter++;
						}
					}
				}
				if (r - 1 >= 0) {
					if (board[r - 1][c].get(n).state == 1) {
						board[r][c].get(n).headCounter++;
					}
				}
				if (r + 1 < rows) {
					if (board[r + 1][c].get(n).state == 1) {
						board[r][c].get(n).headCounter++;
					}
				}
				if (c + 1 < columns) {
					if (r - 1 >= 0) {
						if (board[r - 1][c + 1].get(n).state == 1) {
							board[r][c].get(n).headCounter++;
						}
					}

					if (board[r][c + 1].get(n).state == 1) {
						board[r][c].get(n).headCounter++;
					}

					if (r + 1 < rows) {
						if (board[r + 1][c + 1].get(n).state == 1) {
							board[r][c].get(n).headCounter++;
						}
					}
				}
			}
		}

	}

	public void changeMatrix(int n) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				changeState(board[i][j].get(n), board[i][j].get(n + 1));
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
	
	public void isActive(int n) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (board[i][j].get(n).state != 0) {
					board[i][j].get(n).isActive = true;
				}
				else
					board[i][j].get(n).isActive = false;
			}
		}
	}
	
	public void clearSave(int n) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				board[i][j].get(n).alreadyInFile = false;
			}
		}
	}

}
