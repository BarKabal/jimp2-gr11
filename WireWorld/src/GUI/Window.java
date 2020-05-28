package GUI;

import loadsavefile.CreateImage;
import loadsavefile.LoadFile;
import loadsavefile.SaveFile;
import wireworldfiles.Matrix;

import javax.swing.*;

import static loadsavefile.CreateImage.MakeImage;
import static wireworldfiles.Matrix.*;

public class Window extends JFrame {
    //Color mainBackgroundColor = new Color(253, 204, 125, 221);        Potem to dodam.
    //Color mainMenuBarColor = new Color(196, 157, 77);
    JMenuItem newFile;

    public void run(){
        setBasics();
        setMenu();
        setAnimation();
        setVisible(true);
    }

    private void setBasics() {
        setTitle("WireWorld");
        setSize(1000,800);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setMenu(){
        JMenuBar menuBar = new JMenuBar();
        newFile = new JMenuItem("New");
        menuBar.add(newFile);
        setJMenuBar(menuBar);
    }

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
        SaveFile.saveFile(DEFAULT_ITERATION  - 1, matrix);
    }

    public void setAnimation() {
        Animation animation = new Animation();
        getContentPane().add(animation);
    }
}