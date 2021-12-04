package pl.polsl.controllers;
import pl.polsl.views.SwingView;

/**
 * Main class of the Swing GUI application, as well as its entry point, containing only 'main' method.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class SwingApp {
	/** metoda glowna
	 *	@param args pomijany
	 */
	public static void main(String[] args) {
		SwingView swingView = new SwingView();

		// Create APP GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				swingView.createAndShowGUI();
			}
		});
	}
}