package wireworldfiles;

public class DiodeReversed {

	public static void createDiodeReversed(Matrix matrix, int i, int j) {
		matrix.board[i][j].get(0).state = 3;
		matrix.board[i][j + 1].get(0).state = 3;
		matrix.board[i + 1][j + 1].get(0).state = 3;
		matrix.board[i + 2][j].get(0).state = 3;
		matrix.board[i + 2][j + 1].get(0).state = 3;
		matrix.board[i + 1][j - 1].get(0).state = 3;
		matrix.board[i + 1][j + 2].get(0).state = 3;
	}

	public static boolean checkDiodeReversed(Matrix matrix, int i, int j, int n) {
		if (matrix.board[i][j].get(n).isActive == true && matrix.board[i][j + 1].get(n).isActive == true
				&& matrix.board[i + 1][j + 1].get(n).isActive == true && matrix.board[i + 2][j].get(n).isActive == true
				&& matrix.board[i + 2][j + 1].get(n).isActive == true
				&& matrix.board[i + 1][j - 1].get(n).isActive == true
				&& matrix.board[i + 1][j + 2].get(n).isActive == true) {
			return true;
		}
		return false;
	}

	public static void saveAsDiodeReversed(Matrix matrix, int i, int j, int n) {
		diodeReversedState(matrix.board[i][j].get(n));
		diodeReversedState(matrix.board[i][j + 1].get(n));
		diodeReversedState(matrix.board[i + 1][j + 1].get(n));
		diodeReversedState(matrix.board[i + 2][j].get(n));
		diodeReversedState(matrix.board[i + 2][j + 1].get(n));
		diodeReversedState(matrix.board[i + 1][j - 1].get(n));
		diodeReversedState(matrix.board[i + 1][j + 2].get(n));
	}

	private static void diodeReversedState(Cell cell) {
		if (cell.state != 3) {
			cell.alreadyInFile = false;
		} else
			cell.alreadyInFile = true;
	}

}
