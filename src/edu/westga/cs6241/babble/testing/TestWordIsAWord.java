package edu.westga.cs6241.babble.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.westga.cs6241.babble.model.Word;

class TestWordIsAWord {

	/**
	 * This test should return false as QWERTYU is not in the dictionary.txt file
	 */
	@Test
	void testIsAWordShouldReturnFalseTestingQWERTYU() {
		Word word = new Word("QWERTYU");
		try {
			assertEquals(false, word.isAWord());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test should return false as 1234 is not in the dictionary.txt file or an
	 * acceptable word
	 */
	@Test
	void testIsAWordShouldReturnFalseTesting1234() {
		Word word = new Word("1234");
		try {
			assertEquals(false, word.isAWord());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test should return True as true is in the dictionary.txt file
	 */
	@Test
	void testIsAWordShouldReturnFalseTestingTRUE() {
		Word word = new Word("true");
		try {
			assertEquals(true, word.isAWord());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test should return True as abandonments is in the dictionary.txt file
	 */
	@Test
	void testIsAWordShouldReturnFalseTestingABANDONMENTS() {
		Word word = new Word("abandonments");
		try {
			assertEquals(true, word.isAWord());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test should return True as lotos is in the dictionary.txt file Extra
	 * test to insure it handles LoToS
	 */
	@Test
	void testIsAWordShouldReturnFalseTestingLoToS() {
		Word word = new Word("LoToS");
		try {
			assertEquals(true, word.isAWord());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test should return trigger the IAE exception as Sun Rises In The West is in the
	 * dictionary.txt file But has spaces which are not allowed
	 */
	@Test
	void testIsAWordShouldReturnFalseTestingSunRisesInTheWestWithSpaces() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Word word = new Word("Sun Rises In The West");
			word.isAWord();
		});
	}
}
