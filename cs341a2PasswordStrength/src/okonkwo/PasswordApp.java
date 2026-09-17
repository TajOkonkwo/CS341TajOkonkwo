package okonkwo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PasswordApp {

	private JFrame frame;
	private JTextField txtIn;
	private JTextPane txtOut = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordApp window = new PasswordApp();
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
	public PasswordApp() {
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
		
		JLabel lblTitle = new JLabel("Password Strength");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitle.setBounds(103, 11, 224, 32);
		frame.getContentPane().add(lblTitle);
		
		txtIn = new JTextField();
		txtIn.setBounds(231, 68, 160, 20);
		frame.getContentPane().add(txtIn);
		txtIn.setColumns(10);
		
		JLabel lblEnter = new JLabel("Enter Password (8 ≤ length ≤ 12)");
		lblEnter.setBounds(25, 71, 179, 14);
		frame.getContentPane().add(lblEnter);
		
		JButton btnEvaluate = new JButton("Evaluate");
		btnEvaluate.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Determine the strength of the password entered by the user and display the result in the output text pane.
			 */
			public void mousePressed(MouseEvent e) {
				// 1. Get password
				String password = txtIn.getText();
				
				// 2. Evaluate password strength
				txtOut.setText(evaluate(password));
			}
		});
		btnEvaluate.setBounds(170, 99, 88, 22);
		frame.getContentPane().add(btnEvaluate);
		txtOut.setEditable(false);
		
		txtOut.setBounds(35, 141, 356, 111);
		frame.getContentPane().add(txtOut);
	}
	
	/**
	 * Evaluate the strength of a password based on its length and the longest block of characters.
	 * @param password The password to evaluate.
	 * @return A message indicating the strength of the password.
	 */
	public static String evaluate(String password) {
		// 1. Determine character length and return error if outside bounds
		if (password.length() < 8)
			return "Password is too short at only " + password.length() + " characters.";
		else if (password.length() > 12)
			return "Password is too long at " + password.length() + " characters.";
		
		// 2. Determine longest block of characters
		int longest = longestBlock(password);
		
		// 3. If the longest block is <= 2, accept password; otherwise reject
		if (longest <= 2)
			return "The longest block of characters is " + longest + " characters. This is a decent password.";
		else
			return "The longest block of characters is " + longest + " characters. This password is not secure enough. Remove " + (longest - 2) + " of these characters.";
	}
	
	/**
	 * Determine the length of the longest block of characters in a password.
	 * @param password The password to evaluate.
	 * @return The length of the longest block of characters.
	 */
	public static int longestBlock(String password) {
		// Tracking variables
		int currentLongest = 0; // Length of current longest block of characters
		int currentBlock = 0; // Length of current block
		char lastChar = (char) (password.charAt(0) - 1); // Previous character (sets to unequal value to start)
		boolean start = true; // Tracks the start of the iteration
		
		// 1. Iterate through the password characters
		for (char c : password.toCharArray()) {
			// 2. If this character is equal to the last, increment current length; otherwise, reset to 0
			if (c == lastChar || start)
				currentBlock++;
			else
				currentBlock = 1;
			
			// 3. If new length is greater than current record, replace
			if (currentBlock > currentLongest)
				currentLongest = currentBlock;
			
			// 4. Update last character
			lastChar = c;
			
			start = false;
		}
		
		// 5. Return record length
		return currentLongest;
	}

}
