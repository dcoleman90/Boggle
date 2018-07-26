package edu.westga.cs6241.babble.view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.westga.cs6241.babble.model.Word;

/**
 * This is the Text based user interface it will be extremely streamlined and
 * mostly to insure proper functions between the other classes before tackling
 * the GUI
 * 
 * @author Drew Coleman
 * @version 07/26/2018
 *
 */
public class BabbleTUI {
	private Scanner scan;
	private Word word;

	public BabbleTUI() {
		this.scan = new Scanner(System.in);
	}

	public void run() {
		int selection;
		do {
			this.displayMenu();
			String userChoice = "";
			selection = (this.getUserInt(userChoice));
			System.out.println();
			switch (selection) {
			case 1:
				this.addWord();
				break;
			case 2:
				this.wordIsValid();
				break;
			case 3:
				this.checkPoints();
				break;
			case 4:
				System.out.println(this.goodbye());
				break;

			default:
				System.out.println("This is not a valid selection. Please try again");
			}
		} while (selection != 4);
	}

	private void displayMenu() {
		System.out.print(" 1 - Add word\n" + " 2 - See if Word is valid\n" + " 3 - Check points for word\n"
				+ " 4 - Quit\n" + " Please make your selection: ");
	}

	private int getUserInt(String message) {
		int userSelection = 0;
		boolean isValid = false;
		do {
			try {
				message = this.scan.nextLine();
				userSelection = Integer.parseInt(message);
				isValid = true;
			} catch (IllegalArgumentException iae) {
				System.out.println("Please enter in an integer (example 1, 2 etc)");
			}
		} while (!isValid);
		return userSelection;
	}

	private void addWord() {
		System.out.println("Please type in your word ");
		this.word = new Word(this.scan.nextLine());
		System.out.println(" You entered " + this.word.getWord());
	}

	private void wordIsValid() {
		if (this.word == null) {
			System.out.println("You must enter in a word please press 1");
		} else
			try {
				if (this.word.isAWord()) {
					System.out.println(this.word.getWord() + " is a valid word");
				} else {
					System.out.println(this.word.getWord() + " is a not valid word");
				}
			} catch (FileNotFoundException fnfe) {
				System.out.println("<--File not found-->");
			}
	}

	private void checkPoints() {
		if (this.word.getWordValue() == 0) {
			System.out.println(" You might want to check the validity of that word");
		} else {
			System.out
					.println(" Your word " + this.word.getWord() + " is worth " + this.word.getWordValue() + " points");
		}
	}

	private String goodbye() {
		return "Thank you for using the Babble TextBased User Interface\n Good-bye";
	}
}
