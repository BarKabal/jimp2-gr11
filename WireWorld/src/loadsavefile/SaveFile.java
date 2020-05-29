package loadsavefile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import wireworldfiles.Diode;
import wireworldfiles.Matrix;

public class SaveFile {
	public SaveFile() {

	}

	public static void saveFile(int n, Matrix matrix) {
		File myObj = new File("wireworldmacierzOut.txt");
		try {
			FileWriter myWriter = new FileWriter(myObj);
			myWriter.write(matrix.rows + " " + matrix.columns);
			for (int i = 0; i < matrix.rows; i++) {
				for (int j = 0; j < matrix.columns; j++) {
					if (matrix.board[i][j].get(n).alreadyInFile == false) {
						if (matrix.board[i][j].get(n).state == 1) {
							myWriter.write("\n" + "ElectronHead" + " " + i + " " + j);
							matrix.board[i][j].get(n).alreadyInFile = true;
						} else if (matrix.board[i][j].get(n).state == 2) {
							myWriter.write("\n" + "ElectronTail" + " " + i + " " + j);
							matrix.board[i][j].get(n).alreadyInFile = true;
						} else if (matrix.board[i][j].get(n).state == 3) {
							if ((i + 2 < matrix.rows) && (j + 1 < matrix.columns)
									&& Diode.checkDiode(matrix, i, j) == true) {
								myWriter.write("\n" + "Diode" + " " + i + " " + j);
								Diode.saveAsDiode(matrix, i, j, n);
							} else {
								myWriter.write("\n" + "Conductor" + " " + i + " " + j);
								matrix.board[i][j].get(n).alreadyInFile = true;
							}
						}
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