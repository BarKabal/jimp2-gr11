package GUI;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    //Color mainBackgroundColor = new Color(253, 204, 125, 221);        Potem to dodam.
    //Color mainMenuBarColor = new Color(196, 157, 77);
    JMenuItem newFile;

    public void run(){
        setBasics();
        //setMenu();
        setAnimation();
        setVisible(true);
    }

    private void setBasics() {
        setTitle("WireWorld");
        setSize(900,640);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void setMenu(){
        JMenuBar menuBar = new JMenuBar();
        newFile = new JMenuItem("New");
        menuBar.add(newFile);
        setJMenuBar(menuBar);
    }

    public void setAnimation() {
        Animation animation = new Animation();
        animation.setBounds(50,50,600,600);
        animation.StartAnimation(10, 0, 500, this);
    }
}