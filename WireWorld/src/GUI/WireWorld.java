package gui;

import loadsavefile.LoadFile;
import loadsavefile.SaveFile;
import wireworldfiles.Matrix;

import static loadsavefile.CreateImage.MakeImage;
import static wireworldfiles.Matrix.DEFAULT_ITERATION;

public class WireWorld {

    public static Matrix matrix;

    public static void main(String[] args){
        matrix = LoadFile.loadMatrixSize();
        matrix.startMatrix();
        LoadFile.loadMatrixState(matrix);
        for (int n = 0; n < Matrix.DEFAULT_ITERATION; n++) {
            matrix.checkCell(n);
            matrix.printMatrix(n);
            matrix.initializeMatrix();
            if (n + 1 < DEFAULT_ITERATION)
                matrix.changeMatrix(n);
            MakeImage(matrix, n);
        }
        Window window = new Window();
        window.run();
        SaveFile.saveFile(Matrix.DEFAULT_ITERATION - 1, matrix);
    }
    
    public static void loadMatrix() {
    	matrix = LoadFile.loadMatrixSize();
        matrix.startMatrix();
        LoadFile.loadMatrixState(matrix);
    }
}
