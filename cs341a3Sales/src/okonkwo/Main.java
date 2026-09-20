package okonkwo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Main {

	private JFrame frame;
	private JTextField inItem;
	private JTextField inPrice;
	private JTextField inQuantity;
	private JLabel lblTitle;
	private JTextField outTotal;

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
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setBounds(68, 50, 125, 14);
		frame.getContentPane().add(lblItem);
		
		JLabel lblCost = new JLabel("Cost ($):");
		lblCost.setBounds(68, 83, 125, 14);
		frame.getContentPane().add(lblCost);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(68, 118, 125, 14);
		frame.getContentPane().add(lblQuantity);
		
		inItem = new JTextField();
		inItem.setBounds(182, 47, 182, 20);
		frame.getContentPane().add(inItem);
		inItem.setColumns(10);
		
		inPrice = new JTextField();
		inPrice.setColumns(10);
		inPrice.setBounds(182, 80, 182, 20);
		frame.getContentPane().add(inPrice);
		
		inQuantity = new JTextField();
		inQuantity.setColumns(10);
		inQuantity.setBounds(182, 115, 182, 20);
		frame.getContentPane().add(inQuantity);
		
		JButton btnAdd = new JButton("Add Item");
		btnAdd.setBounds(182, 143, 88, 22);
		frame.getContentPane().add(btnAdd);
		
		lblTitle = new JLabel("Sales List");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTitle.setBounds(159, 0, 111, 36);
		frame.getContentPane().add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 166, 298, 60);
		frame.getContentPane().add(scrollPane);
		
		JTextPane outItems = new JTextPane();
		outItems.setEditable(false);
		scrollPane.setViewportView(outItems);
		
		JLabel lblTotal = new JLabel("Total Sales:");
		lblTotal.setBounds(130, 237, 67, 14);
		frame.getContentPane().add(lblTotal);
		
		outTotal = new JTextField();
		outTotal.setEditable(false);
		outTotal.setBounds(206, 234, 96, 20);
		frame.getContentPane().add(outTotal);
		outTotal.setColumns(10);
	}
}
