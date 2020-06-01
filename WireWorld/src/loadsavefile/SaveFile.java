package loadsavefile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import wireworldfiles.Diode;
import wireworldfiles.DiodeReversed;
import wireworldfiles.Generator;
import wireworldfiles.Matrix;
import wireworldfiles.XORGate;

public class SaveFile {

	public static void saveFile(File file, int n, Matrix matrix) {
		File myObj = file;
		try {
			FileWriter myWriter = new FileWriter(myObj);
			myWriter.write(matrix.rows + " " + matrix.columns);
			matrix.clearSave(n);
			matrix.isActive(n);
			for (int i = 0; i < matrix.rows; i++) {
				for (int j = 0; j < matrix.columns; j++) {
					if (matrix.board[i][j].get(n).alreadyInFile == false
							&& matrix.board[i][j].get(n).isActive == true) {
						if ((i + 4 < matrix.rows) && (j + 2 < matrix.columns) && (j - 1 > 0)
								&& XORGate.checkXORGate(matrix, i, j, n) == true) {
							myWriter.write("\n" + "XORGate" + " " + i + " " + j);
							XORGate.saveAsXORGate(matrix, i, j, n);
						
						} else if ((i + 2 < matrix.rows) && (j + 5 < matrix.columns) && (j - 1 > 0)
								&& Generator.checkGenerator(matrix, i, j, n) == true) {
							myWriter.write("\n" + "Generator" + " " + i + " " + j);
							Generator.saveAsGenerator(matrix, i, j, n);
							
						} else if ((i + 2 < matrix.rows) && (j + 1 < matrix.columns && (j - 1 > 0))
								&& Diode.checkDiode(matrix, i, j, n) == true) {
							myWriter.write("\n" + "Diode" + " " + i + " " + j);
							Diode.saveAsDiode(matrix, i, j, n);
							
						} else if ((i + 2 < matrix.rows) && (j + 1 < matrix.columns && (j - 1 > 0))
								&& DiodeReversed.checkDiodeReversed(matrix, i, j, n) == true) {
							myWriter.write("\n" + "DiodeReversed" + " " + i + " " + j);
							DiodeReversed.saveAsDiodeReversed(matrix, i, j, n);
						}

						if (matrix.board[i][j].get(n).state == 1) {
							myWriter.write("\n" + "ElectronHead" + " " + i + " " + j);
							matrix.board[i][j].get(n).alreadyInFile = true;
						} else if (matrix.board[i][j].get(n).state == 2) {
							myWriter.write("\n" + "ElectronTail" + " " + i + " " + j);
							matrix.board[i][j].get(n).alreadyInFile = true;
						} else if (matrix.board[i][j].get(n).state == 3
								&& matrix.board[i][j].get(n).alreadyInFile == false) {
							myWriter.write("\n" + "Conductor" + " " + i + " " + j);
							matrix.board[i][j].get(n).alreadyInFile = true;
						}
					}
				}
			}

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (

		IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}