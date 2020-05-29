package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation extends JPanel implements ActionListener {

    private int currentImage, howManyImages;
    JLabel label = new JLabel();

    public void StartAnimation(int imageNumber, int startingImage, int delay, Window window){
        howManyImages = imageNumber;
        currentImage = startingImage;
        Timer tm = new Timer(delay, this);
        label.setBounds(50, 50, 600, 600);
        window.add(label, BorderLayout.CENTER);
        tm.start();
        ShowImage();
    }

    private void ShowImage() {
        Icon imgIcon = new ImageIcon(currentImage+".png");
        label.setIcon(imgIcon);
        updateUI();
    }

    private void NextImage() {
        if (currentImage < howManyImages-1) {
            currentImage++;
        }
        else
            currentImage = 0;
        ShowImage();
    }

    public void actionPerformed(ActionEvent e){
        NextImage();
    }
}