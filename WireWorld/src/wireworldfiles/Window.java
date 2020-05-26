package wireworldfiles;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    //Color mainBackgroundColor = new Color(253, 204, 125, 221);        Potem to dodam.
    //Color mainMenuBarColor = new Color(196, 157, 77);
    JMenuItem newFile;

    public void run(){
        setBasics();
        setMenu();
        add(new GIFCanvas());
        setVisible(true);
    }

    private void setBasics() {
        setTitle("WireWorld");
        setSize(1000,800);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setMenu(){
        JMenuBar menuBar = new JMenuBar();
        newFile = new JMenuItem("New");
        menuBar.add(newFile);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args){
        Window window = new Window();
        window.run();
    }
}