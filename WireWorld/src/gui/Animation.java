package gui;

import loadsavefile.CreateImage;
import wireworldfiles.Matrix;


import loadsavefile.LoadFile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animation extends JPanel implements ActionListener {

	int currentImage; // dla 1 obrazka currentimage = 0 a howManyImages = 1
	private int howManyImages;
	private int delayOfTheAnimation;
	JLabel label = new JLabel();
	Timer tm;
	boolean isAnimationGoing = true;

	public void StartAnimation(int imageNumber, int startingImage, int delay, Window window) {
		howManyImages = imageNumber;
		currentImage = startingImage;
		delayOfTheAnimation = delay;
		label.setBounds(50, 50, 600, 600);
		window.add(label, BorderLayout.CENTER);
		ShowImage();
		StartTimer();
	}

	private void ShowImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(currentImage + ".png"));
		} catch (IOException e) {
		}
		Icon imgIcon = new ImageIcon(img);
		System.out.println("Showing image" + currentImage);
		label.setIcon(imgIcon);
		updateUI();
	}

	public void goToImage(int number) {
		if (number <= howManyImages)
			currentImage = (number - 1);
		ShowImage();
	}

	public void changeHowManyIterations(File selectedFile, int number) {
		CreateImage.deleteImages();
		for (int i = 0; i < WireWorld.matrix.rows; i++) {
			for (int j = 0; j < WireWorld.matrix.columns; j++) {
				WireWorld.matrix.board[i][j].clear();
			}
		}
		File file = selectedFile;
		WireWorld.matrix = LoadFile.loadMatrixSize(file);
		WireWorld.matrix.startMatrix();
		LoadFile.loadMatrixState(file, WireWorld.matrix);
		Matrix.iteration = number;
		howManyImages = number;
		WireWorld.makeIterations();
		remakeAnimation();
	}

	public void remakeAnimation() {
		StopTimer();
		currentImage = 0;
		ShowImage();
		if (isAnimationGoing)
			StartTimer();
	}

	public void NextImage() {
		if (currentImage < howManyImages - 1) {
			currentImage++;
		} else
			currentImage = 0;
		ShowImage();
	}

	public void PreviousImage() {
		if (currentImage == 0)
			currentImage = WireWorld.matrix.iteration - 1;
		else
			currentImage--;
		ShowImage();
	}

	public void changeTimer() {
		if (isAnimationGoing) {
			StopTimer();
			isAnimationGoing = false;
		} else {
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

	public void actionPerformed(ActionEvent e) {
		NextImage();
	}
}