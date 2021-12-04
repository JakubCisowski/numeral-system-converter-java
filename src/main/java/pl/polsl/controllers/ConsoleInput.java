package pl.polsl.controllers;

import java.util.Scanner;

/**
 * Class responsible for gathering user input from console.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
public class ConsoleInput {
	/**
	 * Method gathering user input from console.
	 *
	 * @return User input string.
	 */
	public String getString() {
		Scanner inputScanner = new Scanner(System.in);
		return inputScanner.next();
	}
}
