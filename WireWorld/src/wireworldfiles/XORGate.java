package wireworldfiles;

public class XORGate {

	public static void createXORGate(Matrix matrix, int i, int j) {
		matrix.board[i][j].get(0).state = 3;
		matrix.board[i + 1][j - 1].get(0).state = 3;
		matrix.board[i + 1][j].get(0).state = 3;
		matrix.board[i + 1][j + 1].get(0).state = 3;
		matrix.board[i + 1][j + 2].get(0).state = 3;
		matrix.board[i + 2][j - 1].get(0).state = 3;
		matrix.board[i + 2][j + 2].get(0).state = 3;
		matrix.board[i + 3][j - 1].get(0).state = 3;
		matrix.board[i + 3][j].get(0).state = 3;
		matrix.board[i + 3][j + 1].get(0).state = 3;
		matrix.board[i + 3][j + 2].get(0).state = 3;
		matrix.board[i + 4][j].get(0).state = 3;
	}

	public static boolean checkXORGate(Matrix matrix, int i, int j, int n) {
		if (matrix.board[i][j].get(n).isActive == true && matrix.board[i + 1][j - 1].get(n).isActive == true
				&& matrix.board[i + 1][j].get(n).isActive == true && matrix.board[i + 1][j + 1].get(n).isActive == true
				&& matrix.board[i + 1][j + 2].get(n).isActive == true
				&& matrix.board[i + 2][j - 1].get(n).isActive == true
				&& matrix.board[i + 2][j + 2].get(n).isActive == true
				&& matrix.board[i + 3][j - 1].get(n).isActive == true && matrix.board[i + 3][j].get(n).isActive == true
				&& matrix.board[i + 3][j + 1].get(n).isActive == true
				&& matrix.board[i + 3][j + 2].get(n).isActive == true
				&& matrix.board[i + 4][j].get(n).isActive == true) {
			return true;
		}
		return false;
	}

	public static void saveAsXORGate(Matrix matrix, int i, int j, int n) {
		XORGateState(matrix.board[i][j].get(n));
		XORGateState(matrix.board[i + 1][j - 1].get(n));
		XORGateState(matrix.board[i + 1][j].get(n));
		XORGateState(matrix.board[i + 1][j + 1].get(n));
		XORGateState(matrix.board[i + 1][j + 2].get(n));
		XORGateState(matrix.board[i + 2][j - 1].get(n));
		XORGateState(matrix.board[i + 2][j + 2].get(n));
		XORGateState(matrix.board[i + 3][j - 1].get(n));
		XORGateState(matrix.board[i + 3][j].get(n));
		XORGateState(matrix.board[i + 3][j + 1].get(n));
		XORGateState(matrix.board[i + 3][j + 2].get(n));
		XORGateState(matrix.board[i + 4][j].get(n));
	}

	public static void XORGateState(Cell cell) {
		if (cell.state != 3) {
			cell.alreadyInFile = false;
		} else
			cell.alreadyInFile = true;
	}
}
