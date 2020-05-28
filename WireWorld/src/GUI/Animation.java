package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation extends JPanel implements ActionListener {

    private final ImageIcon[] imageArray;
    private int currentImage = 0;

    public Animation(){
        int totalFrames = 10;                                       //
        imageArray = new ImageIcon[totalFrames];
        for (int i = 0; i <imageArray.length; i++)
            imageArray[i] = new ImageIcon(i + ".png");
        int delay = 50;                                             //
        Timer timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paint(g);
        if (currentImage >= imageArray.length)
            currentImage = 0;
        currentImage++;
        imageArray[currentImage].paintIcon(this, g,50,50);
    }

    public void actionPerformed(ActionEvent e){
        repaint();
    }
}