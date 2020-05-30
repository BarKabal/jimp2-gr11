package gui;

import loadsavefile.LoadFile;
import loadsavefile.SaveFile;
import wireworldfiles.Matrix;

import static loadsavefile.CreateImage.MakeImage;
import static wireworldfiles.Matrix.*;
import static wireworldfiles.Matrix.DEFAULT_ITERATION;

public class WireWorld {
	
    public static void main(String[] args){
    	Matrix matrix = LoadFile.loadMatrixSize();
        Matrix.startMatrix(matrix);
        LoadFile.loadMatrixState(matrix);
        for (int n = 0; n < Matrix.DEFAULT_ITERATION; n++) {
            checkCell(matrix.rows, matrix.columns, n, matrix);
            printMatrix(n, matrix);
            initializeMatrix(matrix);
            if (n + 1 < DEFAULT_ITERATION)
                changeMatrix(n, matrix);
            MakeImage(matrix, n);
        }
        Window window = new Window();
        window.run();
        SaveFile.saveFile(Matrix.DEFAULT_ITERATION - 1, matrix);
    }

}
