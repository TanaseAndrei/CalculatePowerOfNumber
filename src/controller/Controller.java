package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import frames.MainFrame;
import frames.SolutionFrame;
import model.Result;

public class Controller {

	private MainFrame mainFrame;
	private Result result;
	private SolutionFrame solutionFrame;
	
	public Controller(MainFrame mainFrame, Result result) {
		this.mainFrame = mainFrame;
		this.result = result;
		solutionFrame = new SolutionFrame();
		this.mainFrame.addCloseButtonListener(new CloseButton());
		this.mainFrame.addExecuteButtonListener(new ExecuteButton());
		this.mainFrame.addCheckBoxListener(new CheckBox());
	}
	
	class CloseButton implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			mainFrame.dispose();
		}
		
	}
	
	class CheckBox implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent event) {
			
			JCheckBox checkBox = (JCheckBox) event.getSource();
			if(checkBox.isSelected()) {
				mainFrame.setUneditableField2();
				mainFrame.updateFrame();
			} else {
				mainFrame.setEditableField2();
				mainFrame.updateFrame();
			}
			
		}
	}
	
	class ExecuteButton implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			double value1 = 0;
			double value2 = 0; 
			try {
				value1 = Double.parseDouble(mainFrame.getField1Content());
				value2 = Double.parseDouble(mainFrame.getField2Content());
				result.setBase(value1);
				result.setExponent(value2);
				solutionFrame.setResult(result.compute());
			} catch(NumberFormatException exception) {
				JOptionPane.showMessageDialog(mainFrame,"Invalid input! Consider just numbers!");
			}
				
		}
		
	}
	
}
