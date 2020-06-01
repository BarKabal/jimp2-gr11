package gui;

import javax.swing.*;

import loadsavefile.CreateImage;
import loadsavefile.LoadFile;
import loadsavefile.SaveFile;
import wireworldfiles.Matrix;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Window extends JFrame implements ActionListener {
    Color mainBackgroundColor = new Color(255, 243, 174, 255);
    JCheckBox animationCheckbox;
    JLabel numOfIterLabel, showIterNumLabel, title, anim;
    JButton save, load, next, previous, saveCurrent, numOfIterSet, showIterNumSet;
    JTextField numOfIterField, showIterNumField;
    static Animation animation;

    public void run(){
        setBasics();
        addOptions();
        setAnimation();
        setVisible(true);
    }

    private void setBasics() {
        setTitle("WireWorld");
        setSize(900,640);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                CreateImage.deleteImages();
            }
        });
        getContentPane().setBackground(mainBackgroundColor);
    }

	private void addOptions() {
		addCheckboxes();
		addLabels();
		addButtons();
		addFields();
	}

	private void addCheckboxes() {
		animationCheckbox = new JCheckBox("ANIMATION", true);
		animationCheckbox.setBounds(650, 50, 20, 20);
		add(animationCheckbox);
		animationCheckbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				animation.changeTimer();
			}
		});
	}

	private void addLabels() { // numOfIter, showIterNum, title, anim;
		numOfIterLabel = new JLabel("NUMBER OF ITERATIONS");
		numOfIterLabel.setBounds(650, 80, 200, 20);
		add(numOfIterLabel);
		showIterNumLabel = new JLabel("SHOW ITERATION NUMBER");
		showIterNumLabel.setBounds(650, 130, 200, 20);
		add(showIterNumLabel);
		title = new JLabel("WIREWORLD");
		title.setBounds(700, 10, 100, 20);
		add(title);
		anim = new JLabel("ANIMATION");
		anim.setBounds(680, 50, 100, 20);
		add(anim);
	}

	private void addButtons() { // save, load, next, previous, saveCurrent, numOfIterSet, showIterNumSet;
		save = new JButton("SAVE");
		save.setBounds(650, 180, 200, 40);
		save.addActionListener(this);
		save.setActionCommand("SAVE");
		add(save);

		load = new JButton("LOAD");
		load.setBounds(650, 300, 200, 40);
		load.addActionListener(this);
		load.setActionCommand("LOAD");
		add(load);

		next = new JButton("NEXT");
		next.setBounds(755, 360, 95, 40);
		next.addActionListener(this);
		next.setActionCommand("NEXT");
		add(next);

		previous = new JButton("PREVIOUS");
		previous.setBounds(650, 360, 95, 40);
		previous.addActionListener(this);
		previous.setActionCommand("PREVIOUS");
		add(previous);

		saveCurrent = new JButton("SAVE CURRENT");
		saveCurrent.setBounds(650, 240, 200, 40);
		saveCurrent.addActionListener(this);
		saveCurrent.setActionCommand("SAVE CURRENT");
		add(saveCurrent);

		numOfIterSet = new JButton();
		numOfIterSet.setBounds(820, 100, 20, 20);
		numOfIterSet.addActionListener(this);
		numOfIterSet.setActionCommand("SETNUMOFITER");
		add(numOfIterSet);

		showIterNumSet = new JButton();
		showIterNumSet.setBounds(820, 150, 20, 20);
		showIterNumSet.addActionListener(this);
		showIterNumSet.setActionCommand("SETSHOWITERNUM");
		add(showIterNumSet);

	}

	private void addFields() { // numOfIterField, showIterNumField;
		numOfIterField = new JTextField();
		numOfIterField.setBounds(650, 100, 150, 20);
		numOfIterField.setText(String.valueOf(Matrix.iteration));
		add(numOfIterField);
		showIterNumField = new JTextField();
		showIterNumField.setBounds(650, 150, 150, 20);
		add(showIterNumField);
	}

	private void setAnimation() {
		animation = new Animation();
		animation.setBounds(50, 50, 600, 600);
		animation.StartAnimation(Matrix.iteration, 0, 500, this);
	}

	public static void loadFileWindow() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("JComboBox Test");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			WireWorld.selectedFile = fileChooser.getSelectedFile();
			animation.changeHowManyIterations(WireWorld.selectedFile, WireWorld.matrix.iteration);
		}
	}
	
	public static void saveFileWindow(int n) {
		JFrame parentFrame = new JFrame();
		 
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    SaveFile.saveFile(fileToSave, n , WireWorld.matrix);
		    System.out.println("Save " + fileToSave.getAbsolutePath());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println("Got an action");
		switch (command) {
		case "SAVE":
			/*Do that*/
			break;
		case "LOAD":
			loadFileWindow();
			break;
		case "NEXT":
			animation.NextImage();
			break;
		case "PREVIOUS":
			animation.PreviousImage();
			break;
		case "SAVE CURRENT":
			saveFileWindow(animation.currentImage);
			break;
		case "SETNUMOFITER":
			animation.changeHowManyIterations(WireWorld.selectedFile ,Integer.parseInt(numOfIterField.getText()));
			break;
		case "SETSHOWITERNUM":
			animation.goToImage(Integer.parseInt(showIterNumField.getText()));
			break;

		}
	}
}