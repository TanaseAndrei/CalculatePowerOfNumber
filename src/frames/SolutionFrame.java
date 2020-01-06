package frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SolutionFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* The result is stored here */
	private double result;
	
	private JTextField resultField;
	private JScrollPane scroll = null;
	private JButton closeButton;
	
	public SolutionFrame() {
		
		super("Result");
		
		this.result = 0;
	
		/*
		 * Init the frame
		 */
		initFrame();
		
		/*
		 * Init the result field
		 */
		initResultField();
		
		/*
		 * Init the close button
		 */
		initButton();
		
		/*
		 * Pack everything together
		 */
		packing();
		
		setVisible(true);
		
	}
	
	private void initFrame() {
		
		setSize(250,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new GridBagLayout());
		
	}
	
	private void initResultField() {
		
		resultField = new JTextField(20);
		scroll = new JScrollPane(resultField);
		resultField.setEditable(false);
		resultField.setText("Result is: " + Double.toString(result));
		
	}
	
	private void initButton() {
		
		closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});
		
	}
	
	public void setResult(double result) {
		resultField.setText("The result is: " + result);
		repaint();
		revalidate();
	}
	
	private void packing() {
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(scroll,gbc);
		gbc.gridy = 1;
		add(closeButton,gbc);
		
	}
	
}
