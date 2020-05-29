package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation extends JPanel implements ActionListener {

    private int currentImage, howManyImages, delayOfTheAnimation;
    JLabel label = new JLabel();
    Timer tm;
    boolean isAnimationGoing = true;

    public void StartAnimation(int imageNumber, int startingImage, int delay, Window window){
        howManyImages = imageNumber;
        currentImage = startingImage;
        delayOfTheAnimation = delay;
        label.setBounds(50, 50, 600, 600);
        window.add(label, BorderLayout.CENTER);
        ShowImage();
        StartTimer();
    }

    private void ShowImage() {
        Icon imgIcon = new ImageIcon(currentImage+".png");
        label.setIcon(imgIcon);
        updateUI();
    }

    public void NextImage() {
        if (currentImage < howManyImages-1) {
            currentImage++;
        }
        else
            currentImage = 0;
        ShowImage();
    }

    public void PreviousImage(){
        if (currentImage == 1)
            currentImage = 15;
        else
            currentImage--;
        ShowImage();
    }

    public void changeTimer() {
        if (isAnimationGoing) {
            StopTimer();
            isAnimationGoing = false;
        }
        else {
            StartTimer();
            isAnimationGoing = true;
        }
    }

    private void StopTimer() {
        tm.stop();
    }

    private void StartTimer() {
        tm = new Timer(delayOfTheAnimation, this);
        tm.start();
    }

    public void actionPerformed(ActionEvent e){
        NextImage();
    }
}