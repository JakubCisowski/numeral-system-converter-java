package pl.polsl.views;

import pl.polsl.models.ConversionSet;
import pl.polsl.models.Converter;
import pl.polsl.models.InvalidParameterException;
import pl.polsl.models.Registry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main view class of the Swing GUI application, responsible for creating and displaying GUI.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class SwingView extends JPanel
		implements ActionListener {

	private JTextField originalSystemTextField, targetSystemTextField, numberValueTextField;
	private Registry registry;

	public SwingView() {
		JButton buttonConvert, buttonShowRegistry;
		JLabel originalSystemLabel, targetSystemLabel, numberValueLabel;

		registry = new Registry();

		originalSystemTextField = new JTextField();
		targetSystemTextField = new JTextField();
		numberValueTextField = new JTextField();

		originalSystemLabel = new JLabel("Original system:");
		targetSystemLabel = new JLabel("Target system:");
		numberValueLabel = new JLabel("Number to convert:");

		buttonConvert = new JButton("<html><center><b>Convert</b><br>");
		buttonConvert.setVerticalTextPosition(AbstractButton.CENTER);
		buttonConvert.setHorizontalTextPosition(AbstractButton.LEADING);
		buttonConvert.setActionCommand("convert");

		buttonShowRegistry = new JButton("<html><center><b>Show Registry</b><br>");
		buttonShowRegistry.setVerticalTextPosition(AbstractButton.CENTER);
		buttonShowRegistry.setHorizontalTextPosition(AbstractButton.CENTER);
		buttonShowRegistry.setActionCommand("showRegistry");

		buttonConvert.addActionListener(this);
		buttonShowRegistry.addActionListener(this);

		add(numberValueLabel,0);
		add(numberValueTextField,1);
		add(originalSystemLabel,2);
		add(originalSystemTextField,3);
		add(targetSystemLabel,4);
		add(targetSystemTextField,5);
		add(buttonConvert,6);
		add(buttonShowRegistry,7);
	}

	public void createAndShowGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Converter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SwingView newContentPane = new SwingView();
		newContentPane.setLayout(new GridLayout(4,2));
		newContentPane.setOpaque(true);

		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if ("convert".equals(e.getActionCommand())) {

			try{
				Converter converter = new Converter();
				String conversionResult = converter.convertNumeralSystem(numberValueTextField.getText(), originalSystemTextField.getText(), targetSystemTextField.getText());
				JOptionPane.showMessageDialog(this, conversionResult, "Conversion result", JOptionPane.INFORMATION_MESSAGE);
				registry.addConversionSet(numberValueTextField.getText(),originalSystemTextField.getText(),targetSystemTextField.getText(),conversionResult);
			} catch (InvalidParameterException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Conversion error", JOptionPane.ERROR_MESSAGE);
			}

		} else if("showRegistry".equals(e.getActionCommand())) {
			String registryString = "REGISTRY RECORDS:\n";

			for (ConversionSet set : registry.getRegistry()) {
				registryString += set.getNumberValue() + "(" + set.getOriginalSystem() + ") = " + set.getConversionResult() + "(" + set.getTargetSystem() + ")\n";
			}

			JOptionPane.showMessageDialog(this, registryString, "Registry", JOptionPane.PLAIN_MESSAGE);
		}
	}

//	public String getNumberValueText(){
//		return numberValueTextField.getText();
//	}
//
//	public String getOriginalSystemText(){
//		return originalSystemTextField.getText();
//	}
//
//	public String getTargetSystemText(){
//		return targetSystemTextField.getText();
//	}
//
//	public void showDialog(String message, String title, int iconType){
//		JOptionPane.showMessageDialog(this, message, title, iconType);
//	}
}
