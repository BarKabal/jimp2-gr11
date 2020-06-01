package gui;

import loadsavefile.LoadFile;
import loadsavefile.SaveFile;
import wireworldfiles.Matrix;

import static loadsavefile.CreateImage.MakeImage;

import java.io.File;

public class WireWorld {

    public static Matrix matrix;
    public static File selectedFile;
    public static void main(String[] args){
    	selectedFile = new File("wireworldmacierzIn.txt");
        loadMatrix(selectedFile);
        makeIterations();
        Window window = new Window();
        window.run();
        SaveFile.saveFile(Matrix.iteration - 1, matrix);
    }
    
    public static void loadMatrix(File file) {
    	matrix = LoadFile.loadMatrixSize(file);
        matrix.startMatrix();
        LoadFile.loadMatrixState(file, matrix);
    }

    public static void makeIterations() {
        for (int n = 0; n < Matrix.iteration; n++) {
            matrix.checkCell(n);
            matrix.printMatrix(n);
            matrix.initializeMatrix();
            if (n + 1 < Matrix.iteration)
                matrix.changeMatrix(n);
            MakeImage(matrix, n);
        }
    }
}
