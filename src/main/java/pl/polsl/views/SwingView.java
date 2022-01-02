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

	/**
	 * Main frame of the GUI application.
	 */
	private JFrame mainFrame;

	/**
	 * Original system text field.
	 */
	private JTextField originalSystemTextField;

	/**
	 * Target system text field.
	 */
	private JTextField targetSystemTextField;

	/**
	 * Number value text field.
	 */
	private JTextField numberValueTextField;

	/**
	 * Conversion registry.
	 */
	private Registry registry;


	/**
	 * Class constructor responsible for setting controls placement and properties.
	 */
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

	/**
	 * Method responsible for creating and showing graphical user interface.
	 */
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

		mainFrame = frame;
	}

	/**
	 * Method responsible for handling button click events.
	 *
	 * @param e Event triggered by action such as button click.
	 */
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
			SwingRegistryTableDialog d = new SwingRegistryTableDialog(mainFrame, registry);
		}
	}
}
