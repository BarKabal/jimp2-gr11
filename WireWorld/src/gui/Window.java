package gui;

import javax.swing.*;

import loadsavefile.CreateImage;
import loadsavefile.SaveFile;
import wireworldfiles.Matrix;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener {
    Color mainBackgroundColor = new Color(255, 243, 174, 255);
    Color setButtonColor = new Color(45, 167, 2);
    JCheckBox animationCheckbox;
    JLabel numOfIterLabel, showIterNumLabel, title, anim;
    JButton save, load, next, previous, saveCurrent, numOfIterSet, showIterNumSet, whatDoIDO;
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
		animationCheckbox.setBounds(650, 90, 20, 20);
		animationCheckbox.setBackground(mainBackgroundColor);
		add(animationCheckbox);
		animationCheckbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				animation.changeTimer();
			}
		});
	}

	private void addLabels() { // numOfIter, showIterNum, title, anim;
		numOfIterLabel = new JLabel("NUMBER OF ITERATIONS");
		numOfIterLabel.setBounds(650, 120, 200, 20);
		add(numOfIterLabel);

		showIterNumLabel = new JLabel("SHOW ITERATION NUMBER");
		showIterNumLabel.setBounds(650, 170, 200, 20);
		add(showIterNumLabel);

		title = new JLabel("WIREWORLD");
		title.setBounds(650, 10, 200, 60);
		title.setFont(new Font("Times New Roman",Font.BOLD, 30));
		add(title);

		anim = new JLabel("ANIMATION");
		anim.setBounds(680, 90, 100, 20);
		add(anim);
	}

	private void addButtons() { // save, load, next, previous, saveCurrent, numOfIterSet, showIterNumSet;
		save = new JButton("SAVE");
		save.setBounds(650, 230, 200, 40);
		save.addActionListener(this);
		save.setActionCommand("SAVE");
		add(save);

		load = new JButton("LOAD");
		load.setBounds(650, 350, 200, 40);
		load.addActionListener(this);
		load.setActionCommand("LOAD");
		add(load);

		next = new JButton("NEXT");
		next.setBounds(755, 410, 95, 40);
		next.addActionListener(this);
		next.setActionCommand("NEXT");
		add(next);

		previous = new JButton("PREVIOUS");
		previous.setBounds(650, 410, 95, 40);
		previous.addActionListener(this);
		previous.setActionCommand("PREVIOUS");
		add(previous);

		saveCurrent = new JButton("SAVE CURRENT");
		saveCurrent.setBounds(650, 290, 200, 40);
		saveCurrent.addActionListener(this);
		saveCurrent.setActionCommand("SAVE CURRENT");
		add(saveCurrent);

		numOfIterSet = new JButton();
		numOfIterSet.setBounds(820, 140, 20, 20);
		numOfIterSet.addActionListener(this);
		numOfIterSet.setActionCommand("SETNUMOFITER");
		numOfIterSet.setBackground(setButtonColor);
		add(numOfIterSet);

		showIterNumSet = new JButton();
		showIterNumSet.setBounds(820, 190, 20, 20);
		showIterNumSet.addActionListener(this);
		showIterNumSet.setActionCommand("SETSHOWITERNUM");
		showIterNumSet.setBackground(setButtonColor);
		add(showIterNumSet);

		whatDoIDO = new JButton("WHAT DO I DO?");
		whatDoIDO.setBounds(650, 500, 200, 40);
		whatDoIDO.addActionListener(this);
		whatDoIDO.setActionCommand("WHAT DO I DO?");
		add(whatDoIDO);

	}

	private void addFields() { // numOfIterField, showIterNumField;
		numOfIterField = new JTextField();
		numOfIterField.setBounds(650, 140, 150, 20);
		numOfIterField.setText(String.valueOf(Matrix.iteration));
		add(numOfIterField);

		showIterNumField = new JTextField();
		showIterNumField.setBounds(650, 190, 150, 20);
		add(showIterNumField);
	}

	private void setAnimation() {
		animation = new Animation();
		animation.setBounds(50, 90, 600, 600);
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
			animation.changeHowManyIterations(WireWorld.selectedFile, Matrix.iteration);
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

	private void setHelpWindow() throws IOException {
    	JFrame help = new JFrame();
		help.setTitle("WireWorld - Help");
		help.setSize(630,800);
		help.setLayout(null);
		help.setDefaultCloseOperation(HIDE_ON_CLOSE);
		help.setResizable(false);
		help.getContentPane().setBackground(mainBackgroundColor);
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(mainBackgroundColor);
		BufferedReader br = new BufferedReader(new FileReader("Help.txt"));
		String line = br.readLine();
		ArrayList<String> listOfStrings = new ArrayList<>();
		listOfStrings.add(line);
		while (line != null) {
			line = br.readLine();
			listOfStrings.add(line);
		}
		for (int i = 0; i < listOfStrings.size(); i++) {
			textArea.append(listOfStrings.get(i));
			textArea.append("\n");
		}
		br.close();
		help.add(textArea);
		help.setVisible(true);
		textArea.setBounds(30,30,540,700);
		Font helpFont = new Font("Arial",Font.PLAIN,16);
		textArea.setFont(helpFont);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println("Got an action");
		switch (command) {
		case "SAVE":
			saveFileWindow(Matrix.iteration - 1);
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
		case "WHAT DO I DO?":
			try {
				setHelpWindow();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
			break;
		}
	}
}