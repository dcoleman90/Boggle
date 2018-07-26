package edu.westga.cs6241.babble.model;

import java.util.Random;

/**
 * This class will create a random letter from a-z
 * @author Drew Coleman
 * @version 07/26/2018
 */
public class RandomLetter {
	private Random random;

	public RandomLetter() {
		this.random = new Random();
	}
	
	public String getRandomLetter() {
		int selection = this.random.nextInt(26);
		String[] alphabet = { "e", "a", "i", "o", "n", "r", "t", "l", "s", "u", "d", "g", "b", "c", "m", "p", "f", "h",
				"v", "w", "y", "k", "j", "x", "q", "z" };
		String letter = alphabet[selection];
		return letter;
	}
}
