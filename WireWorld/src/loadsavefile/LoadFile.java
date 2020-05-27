package loadsavefile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import wireworldfiles.Matrix;

public class LoadFile {
	public static Matrix loadMatrixSize() {
		try {
			File myObj = new File("wireworldmacierz.txt");
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
}
