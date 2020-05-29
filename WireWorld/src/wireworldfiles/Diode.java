package wireworldfiles;

public class Diode {
	public static void createDiode(Matrix matrix, int i, int j) {
		matrix.board[i][j].get(0).state = 3;
		matrix.board[i][j + 1].get(0).state = 3;
		matrix.board[i + 1][j].get(0).state = 3;
		matrix.board[i + 2][j].get(0).state = 3;
		matrix.board[i + 2][j + 1].get(0).state = 3;
	}

	public static boolean checkDiode(Matrix matrix, int i, int j) {
		if (matrix.board[i][j].get(0).state == 3 && matrix.board[i][j + 1].get(0).state == 3
				&& matrix.board[i + 1][j].get(0).state == 3 && matrix.board[i + 2][j].get(0).state == 3
				&& matrix.board[i + 2][j + 1].get(0).state == 3) {
			return true;
		}
		return false;
	}
	
	public static void saveAsDiode(Matrix matrix, int i, int j, int n) {
		matrix.board[i][j].get(n).alreadyInFile = true;
		matrix.board[i][j + 1].get(n).alreadyInFile = true;
		matrix.board[i + 1][j].get(n).alreadyInFile = true;
		matrix.board[i + 2][j].get(n).alreadyInFile = true;
		matrix.board[i + 2][j + 1].get(n).alreadyInFile = true;
	}
}
