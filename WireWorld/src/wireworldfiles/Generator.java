package wireworldfiles;

public class Generator {
	public static void createGenerator(Matrix matrix, int i, int j) {
		matrix.board[i][j].get(0).state = 3;
		matrix.board[i][j + 1].get(0).state = 3;
		matrix.board[i][j + 2].get(0).state = 3;
		matrix.board[i][j + 3].get(0).state = 3;
		matrix.board[i][j + 4].get(0).state = 3;
		matrix.board[i + 1][j + 5].get(0).state = 3;
		matrix.board[i + 2][j + 4].get(0).state = 3;
		matrix.board[i + 2][j + 3].get(0).state = 3;
		matrix.board[i + 2][j + 2].get(0).state = 3;
		matrix.board[i + 2][j + 1].get(0).state = 3;
		matrix.board[i + 2][j].get(0).state = 3;
		matrix.board[i + 1][j - 1].get(0).state = 3;
	}

	public static boolean checkGenerator(Matrix matrix, int i, int j, int n) {
		if (matrix.board[i][j].get(n).isActive == true && matrix.board[i][j + 1].get(n).isActive == true
				&& matrix.board[i][j + 2].get(n).isActive == true && matrix.board[i][j + 3].get(n).isActive == true
				&& matrix.board[i][j + 4].get(n).isActive == true && matrix.board[i + 1][j + 5].get(n).isActive == true
				&& matrix.board[i + 2][j + 4].get(n).isActive == true
				&& matrix.board[i + 2][j + 3].get(n).isActive == true
				&& matrix.board[i + 2][j + 2].get(n).isActive == true
				&& matrix.board[i + 2][j + 1].get(n).isActive == true && matrix.board[i + 2][j].get(n).isActive == true
				&& matrix.board[i + 1][j - 1].get(n).isActive == true) {
			return true;
		}
		return false;
	}

	public static void saveAsGenerator(Matrix matrix, int i, int j, int n) {
		generatorState(matrix.board[i][j].get(n));
		generatorState(matrix.board[i][j + 1].get(n));
		generatorState(matrix.board[i][j + 2].get(n));
		generatorState(matrix.board[i][j + 3].get(n));
		generatorState(matrix.board[i][j + 4].get(n));
		generatorState(matrix.board[i + 1][j + 5].get(n));
		generatorState(matrix.board[i + 2][j + 4].get(n));
		generatorState(matrix.board[i + 2][j + 3].get(n));
		generatorState(matrix.board[i + 2][j + 2].get(n));
		generatorState(matrix.board[i + 2][j + 1].get(n));
		generatorState(matrix.board[i + 2][j].get(n));
		generatorState(matrix.board[i + 1][j - 1].get(n));
	}

	public static void generatorState(Cell cell) {
		if (cell.state != 3) {
			cell.alreadyInFile = false;
		} else
			cell.alreadyInFile = true;
	}
}
