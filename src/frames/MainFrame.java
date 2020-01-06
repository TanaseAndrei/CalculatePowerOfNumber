package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Main components of the frame
	 */
	private JTextField field1, field2;
	private JButton executeButton, closeButton;
	private JCheckBox checkBox;
	
	/*
	 * Containers for the components
	 */
	private JPanel firstPanel;
	private JPanel secondPanel;
	private JPanel thirdPanel;
	
	public MainFrame(String name) {
		
		super(name);
		
		/*
		 * Init the frame with its attributes
		 */
		initFrame();
		
		/*
		 * Init the panels. Panels are containers that hold components
		 */
		initPanel();
		
		/*
		 * Init the text fields
		 */
		initTextField();
		
		/*
		 * Init the buttons
		 */
		initButtons();
		
		/*
		 * Init the checkbox
		 */
		initCheckBox();
		
		/*
		 * Pack everything together
		 */
		packing();
		
		setVisible(true);
		
		
	}
	
	private void initFrame() {
		
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		
	}
	
	private void initPanel() {
		
		/* By default the layout is FlowLayout */
		firstPanel = new JPanel();
		secondPanel = new JPanel();
		thirdPanel = new JPanel();
		
	}
	
	private void initTextField() {
		
		field1 = new JTextField(20);
		field2 = new JTextField(20);
		
	}
	
	private void initButtons() {
		
		executeButton = new JButton("Execute");
		closeButton = new JButton("Close");
		
	}
	
	private void initCheckBox() {
		
		checkBox = new JCheckBox();
		checkBox.setSelected(false);
		
	}
	
	public void addExecuteButtonListener(ActionListener actionListener) {
		executeButton.addActionListener(actionListener);
	}
	
	public void addCloseButtonListener(ActionListener actionListener) {
		closeButton.addActionListener(actionListener);
	}
	
	public void addCheckBoxListener(ItemListener itemListener) {
		checkBox.addItemListener(itemListener);
	}
	
	public void setEditableField2() {
		field2.setEditable(true);
	}
	
	public void setUneditableField2() {
		field2.setEditable(false);
	}
	
	public String getField1Content() {
		return field1.getText();
	}
	
	public String getField2Content() {
		return field2.getText();
	}
	
	public void updateFrame() {
		repaint();
		revalidate();
	}
	
	private void packing() {
		
		firstPanel.add(field1);
		firstPanel.add(executeButton);
		add(firstPanel,BorderLayout.NORTH);
		
		secondPanel.add(field2);
		secondPanel.add(checkBox);
		add(secondPanel,BorderLayout.CENTER);
		
		thirdPanel.add(closeButton);
		add(thirdPanel,BorderLayout.SOUTH);
		
	}
	
}
