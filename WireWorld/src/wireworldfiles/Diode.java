package wireworldfiles;

public class Diode {
	public static void createDiode(Matrix matrix, int i, int j) {
		matrix.board[i][j].get(0).state = 3;
		matrix.board[i][j + 1].get(0).state = 3;
		matrix.board[i + 1][j].get(0).state = 3;
		matrix.board[i + 2][j].get(0).state = 3;
		matrix.board[i + 2][j + 1].get(0).state = 3;
	}

	public static boolean checkDiode(Matrix matrix, int i, int j, int n) {
		if (matrix.board[i][j].get(n).isActive == true && matrix.board[i][j + 1].get(n).isActive == true
				&& matrix.board[i + 1][j].get(n).isActive == true && matrix.board[i + 2][j].get(n).isActive == true
				&& matrix.board[i + 2][j + 1].get(n).isActive == true) {
			return true;
		}
		return false;
	}
	
	public static void saveAsDiode(Matrix matrix, int i, int j, int n) {
		diodeState(matrix.board[i][j].get(n));
		diodeState(matrix.board[i][j + 1].get(n));
		diodeState(matrix.board[i + 1][j].get(n));
		diodeState(matrix.board[i + 2][j].get(n));
		diodeState(matrix.board[i + 2][j + 1].get(n));
	}
	
	public static void diodeState(Cell cell) {
		if (cell.state != 3 ) {
			cell.alreadyInFile = false;
		}
		else
			cell.alreadyInFile = true;
	}
}
