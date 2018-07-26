package edu.westga.cs6241.babble.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Word {
	Letter letter;
	String word;

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
			} scanFile.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("<--File not found-->");
		}
		return false;	
	}
}
