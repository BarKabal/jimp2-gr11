package loadsavefile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import wireworldfiles.Matrix;

public class SaveFile {
	public SaveFile() {

	}

	public static void saveFile(int n, Matrix matrix) {
		File myObj = new File("wireworldmacierz.txt");
		try {
			FileWriter myWriter = new FileWriter(myObj);
			myWriter.write(matrix.rows + " " + matrix.collumns + "\n");
			for (int i = 0; i < matrix.rows; i++) {
				for (int j = 0; j < matrix.collumns; j++) {
					if (matrix.board[i][j][n].state == 1) {
						myWriter.write("ElectronHead" + " " + i + " " + j + "\n");
					} else if (matrix.board[i][j][n].state == 2) {
						myWriter.write("ElectronTail" + " " + i + " " + j + "\n");
					} else if (matrix.board[i][j][n].state == 3) {
						myWriter.write("Conductor" + " " + i + " " + j + "\n");
					}
				}
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}