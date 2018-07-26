package edu.westga.cs6241.babble.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Word {
	Letter letter;
	String word;

	/**
	 * This is the constructor It acceptes a string object and insuring that it
	 * contains no spaces or has a value of null sets the instance varible this.word
	 * to it
	 * 
	 * @param word
	 *            is what this.word equals
	 */
	public Word(String word) {
		if (word == null) {
			throw new NullPointerException("Letter cannot be null");
		}
		String[] words = word.split("");
		if (Arrays.asList(words).contains(" ")) {
			throw new IllegalArgumentException("There can be no spaces in the word");
		}
		this.word = word;
	}

	/**
	 * This method checks the accepted word object and insures that it is actually a
	 * word by comparing it to the list of words withing the dictionary.txt file
	 * 
	 * @return true if this.word is found within dictionary.txt
	 * @throws FileNotFoundException
	 */
	public boolean isAWord() throws FileNotFoundException {
		File file = new File("dictionary.txt");
		try {
			Scanner scanFile = new Scanner(file);
			scanFile.useDelimiter("\n");
			while (scanFile.hasNext()) {
				try {
					if (this.word.equalsIgnoreCase(scanFile.nextLine())) {
						return true;
					}
				} catch (IllegalArgumentException nsee) {
					System.out.println("Values must be a-z or A-Z");
				} catch (NoSuchElementException nsee) {
					System.out.println("Read past the end of the file");
				} catch (ArrayIndexOutOfBoundsException aoppbe) {
					System.out.println("Dictionary not formated correctly");
				}
			}
			scanFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("<--File not found-->");
		}
		return false;
	}

	/**
	 * This method returns the value of the word object, as long as isAWord returns true
	 * @return the value of the word - 0 if it is not a word.
	 */
	public int getWordValue() {
		int wordValue = 0;
		try {
			if (isAWord()) {
				String[] letters = this.word.split("");
				for (int count = 0; count < letters.length; count++) {
					wordValue += this.getWordValueHelper(letters[count]);
				}
				return wordValue;
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("<--File not found-->");
		}
		return 0;
	}

	private int getWordValueHelper(String letter) {
		this.letter = new Letter(letter);
		return this.letter.getTileValue();
	}
	
	public String getWord() {
		return this.word;
	}
}
