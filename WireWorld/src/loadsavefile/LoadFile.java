package loadsavefile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadFile {
	public static void loadFile() {
		try {
			File myObj = new File("wireworldmacierz.txt");
			Scanner myReader = new Scanner(myObj);
			System.out.println(myReader.nextInt() + " " + myReader.nextInt());
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
