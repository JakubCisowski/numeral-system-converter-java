package pl.polsl.controllers;

import java.util.Scanner;

/**
 * Class responsible for gathering user input.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class Input {
	/**
	 * Method gathering user input from console.
	 *
	 * @return User input string.
	 */
	public static String getStringConsole() {
		Scanner inputScanner = new Scanner(System.in);
		return inputScanner.next();
	}
}
