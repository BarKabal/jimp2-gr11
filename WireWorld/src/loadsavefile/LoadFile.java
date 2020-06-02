package loadsavefile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import wireworldfiles.Diode;
import wireworldfiles.DiodeReversed;
import wireworldfiles.Generator;
import wireworldfiles.Matrix;
import wireworldfiles.ORGate;
import wireworldfiles.XORGate;

public class LoadFile {

	public static Matrix loadMatrixSize(File selectedFile) {
		try {
			File myObj = selectedFile;
			Scanner myReader = new Scanner(myObj);
			int rows = myReader.nextInt();
			int columns = myReader.nextInt();
			myReader.close();
			Matrix matrix = new Matrix(rows, columns);
			return matrix;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
	}

	public static void loadMatrixState(File selectedFile, Matrix matrix) {
		try {
			File myObj = selectedFile;
			Scanner myReader = new Scanner(myObj);
			int i = 3;
			int j = 3;
			while (myReader.hasNextLine()) {
				String n = myReader.next();
				if (n.equals("ORGate")) {
					i = myReader.nextInt();
					j = myReader.nextInt();
					ORGate.createORGate(matrix, i, j);
				} else if (n.equals("XORGate")) {
					i = myReader.nextInt();
					j = myReader.nextInt();
					XORGate.createXORGate(matrix, i, j);
				} else if (n.equals("Generator")) {
					i = myReader.nextInt();
					j = myReader.nextInt();
					Generator.createGenerator(matrix, i, j);
				} else if (n.equals("Diode")) {
					i = myReader.nextInt();
					j = myReader.nextInt();
					Diode.createDiode(matrix, i, j);
				} else if (n.equals("DiodeReversed")) {
					i = myReader.nextInt();
					j = myReader.nextInt();
					DiodeReversed.createDiodeReversed(matrix, i, j);
				} else if (n.equals("Conductor")) {
					i = myReader.nextInt();
					j = myReader.nextInt();
					matrix.board[i][j].get(0).state = 3;
				} else if (n.equals("ElectronTail")) {
					i = myReader.nextInt();
					j = myReader.nextInt();
					matrix.board[i][j].get(0).state = 2;

				} else if (n.equals("ElectronHead")) {
					i = myReader.nextInt();
					j = myReader.nextInt();
					matrix.board[i][j].get(0).state = 1;
				}
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
