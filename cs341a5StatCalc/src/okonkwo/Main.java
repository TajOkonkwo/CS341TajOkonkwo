package okonkwo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InterruptedIOException;

import okonkwo.*;

/**
 * A GUI for the Stats Calculator | Allows the user to select a file of real numbers and calculates the mean and standard deviation of the numbers in the file
 * <p>Comments, documentation, and code generated in part by GitHub Copilot</p>
 * @author Taj Okonkwo
 * @version 1.0.1
 */
public class Main {

	private JFrame frame;
	private JTextField outMean;
	private JTextField outStDev;
	private FileHandler fileHandler = new FileHandler(new JFileChooser());
	
	private JLabel lblCurrentFile = new JLabel("No file");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Stats Calculator");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(90, 11, 253, 35);
		frame.getContentPane().add(lblTitle);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 1. Open a file chooser dialog
				File file = null;
				try {
					fileHandler.chooseFile();
					file = fileHandler.getFile();
				} catch (InterruptedIOException e1) {
					// Interrupted, display message
					lblCurrentFile.setText("No file");
					outMean.setText("");
					outStDev.setText("");
					return;
				}
				
				// 2. Read the file and calculate mean and standard deviation
				try {
					DoubleList list = fileHandler.toDoubleList();
					double mean = StatCalculator.mean(list);
					double stDev = StatCalculator.stDev(list);
					
					// 3. Display the results
					lblCurrentFile.setText(file.getName());
					outMean.setText(String.valueOf(mean));
					outStDev.setText(String.valueOf(stDev));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnOpenFile.setBounds(34, 70, 146, 22);
		frame.getContentPane().add(btnOpenFile);
		
		lblCurrentFile.setBounds(190, 74, 225, 14);
		frame.getContentPane().add(lblCurrentFile);
		
		JLabel lblMean = new JLabel("Mean (μ)");
		lblMean.setBounds(34, 130, 146, 14);
		frame.getContentPane().add(lblMean);
		
		JLabel lblStDev = new JLabel("Standard Deviation (σ)");
		lblStDev.setBounds(34, 170, 146, 14);
		frame.getContentPane().add(lblStDev);
		
		outMean = new JTextField();
		outMean.setEditable(false);
		outMean.setBounds(190, 127, 225, 20);
		frame.getContentPane().add(outMean);
		outMean.setColumns(10);
		
		outStDev = new JTextField();
		outStDev.setEditable(false);
		outStDev.setColumns(10);
		outStDev.setBounds(190, 167, 225, 20);
		frame.getContentPane().add(outStDev);
	}
}
