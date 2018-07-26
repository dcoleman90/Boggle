package edu.westga.cs6241.babble.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import edu.westga.cs6241.babble.model.RandomLetter;

class TestRandomLetterGetRandomLetter {

	/**
	 * This test will insure that a RandomLetter does not return anything other than a value from a-z when called 10000 times
	 */
	@Test
	void testGetRandomLetterAShouldReturnTrue() {
		String[] alphabet = { "e", "a", "i", "o", "n", "r", "t", "l", "s", "u", "d", "g", "b", "c", "m", "p", "f", "h",
				"v", "w", "y", "k", "j", "x", "q", "z" };
		for (int count = 0; count < 10000; count++) {
			RandomLetter a2z = new RandomLetter();
			if (!Arrays.asList(alphabet).contains(a2z.getRandomLetter())) {
				fail("returned a value that was not in the alphabet ---" + a2z.getRandomLetter());
			}
		}
	}

}
