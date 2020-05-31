package gui;

import loadsavefile.LoadFile;
import loadsavefile.SaveFile;
import wireworldfiles.Matrix;

import static loadsavefile.CreateImage.MakeImage;

public class WireWorld {

    public static Matrix matrix;

    public static void main(String[] args){
        loadMatrix();
        makeIterations();
        Window window = new Window();
        window.run();
        SaveFile.saveFile(Matrix.iteration - 1, matrix);
    }
    
    public static void loadMatrix() {
    	matrix = LoadFile.loadMatrixSize();
        matrix.startMatrix();
        LoadFile.loadMatrixState(matrix);
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
