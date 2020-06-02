package wireworldfiles;

public class ORGate {
	public static void createORGate(Matrix matrix, int i, int j) {
		matrix.board[i][j].get(0).state = 3;
		matrix.board[i][j + 1].get(0).state = 3;
		matrix.board[i + 1][j + 2].get(0).state = 3;
		matrix.board[i + 2][j + 2].get(0).state = 3;
		matrix.board[i + 2][j + 3].get(0).state = 3;
		matrix.board[i + 2][j + 1].get(0).state = 3;
		matrix.board[i + 3][j + 2].get(0).state = 3;
		matrix.board[i + 4][j].get(0).state = 3;
		matrix.board[i + 4][j + 1].get(0).state = 3;
	}

	public static boolean checkORGate(Matrix matrix, int i, int j, int n) {
		if (matrix.board[i][j].get(n).isActive == true && matrix.board[i][j + 1].get(n).isActive == true
				&& matrix.board[i + 1][j + 2].get(n).isActive == true
				&& matrix.board[i + 2][j + 2].get(n).isActive == true
				&& matrix.board[i + 2][j + 3].get(n).isActive == true
				&& matrix.board[i + 2][j + 1].get(n).isActive == true
				&& matrix.board[i + 3][j + 2].get(n).isActive == true && matrix.board[i + 4][j].get(n).isActive == true
				&& matrix.board[i + 4][j + 1].get(n).isActive == true) {
			return true;
		}
		return false;
	}

	public static void saveAsORGate(Matrix matrix, int i, int j, int n) {
		ORGateState(matrix.board[i][j].get(n));
		ORGateState(matrix.board[i][j + 1].get(n));
		ORGateState(matrix.board[i + 1][j+2].get(n));
		ORGateState(matrix.board[i + 2][j+2].get(n));
		ORGateState(matrix.board[i + 2][j + 3].get(n));
		ORGateState(matrix.board[i + 2][j + 1].get(n));
		ORGateState(matrix.board[i + 2][j + 2].get(n));
		ORGateState(matrix.board[i + 3][j + 2].get(n));
		ORGateState(matrix.board[i + 4][j].get(n));
		ORGateState(matrix.board[i + 4][j + 1].get(n));
	}

	private static void ORGateState(Cell cell) {
		if (cell.state != 3) {
			cell.alreadyInFile = false;
		} else
			cell.alreadyInFile = true;
	}
}
