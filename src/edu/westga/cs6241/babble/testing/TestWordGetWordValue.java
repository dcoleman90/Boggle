package edu.westga.cs6241.babble.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.westga.cs6241.babble.model.Word;

class TestWordGetWordValue {

	/**
	 * This test will insure that the word aa returns the expected value of 2
	 */
	@Test
	void testGetWordValueAAShouldReturnAValueOf2() {
		Word word = new Word("aa");
		assertEquals(2, word.getWordValue());
	}

	/**
	 * This test will insure that the word sylva returns the expected value of 2
	 */
	@Test
	void testGetWordValueSYLVAShouldReturnAValueOf11() {
		Word word = new Word("SylVa");
		assertEquals(11, word.getWordValue());
	}

	/**
	 * This test will insure that the word syllogistically returns the expected
	 * value of 2
	 */
	@Test
	void testGetWordValueSYLLOGISTICALLYShouldReturnAValueOf24() {
		Word word = new Word("syllogistically");
		assertEquals(24, word.getWordValue());
	}

	/**
	 * This test will insure that the word WIZ returns the expected value of 2
	 */
	@Test
	void testGetWordValueWIZShouldReturnAValueOf15() {
		Word word = new Word("wiz");
		assertEquals(15, word.getWordValue());
	}

	/**
	 * This test will insure that the word aa returns the expected value of 0 due to
	 * the space at the end of aa
	 */
	@Test
	void testGetWordValueMISTAKEAAShouldReturnAValueOf0() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Word word = new Word("aa ");
			assertEquals(0, word.getWordValue());
		});
	}

	/**
	 * This test will insure that the word sylva returns the expected value of 0 due
	 * to the space in the middle
	 */
	@Test
	void testGetWordValueMISTAKESYLVAShouldReturnAValueOf0() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Word word = new Word("Sy lVa");
			assertEquals(0, word.getWordValue());
		});
	}

	/**
	 * This test will insure that the word syllogistically returns the expected
	 * value of 0 because of the space at the beginning
	 */
	@Test
	void testGetWordValueMISTAKESYLLOGISTICALLYShouldReturnAValueOf0() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Word word = new Word(" syllogistically");
			assertEquals(0, word.getWordValue());
		});
	}

	/**
	 * This test will insure that the word WIZ returns the expected value of 0
	 * because the i is a 1 (one)
	 */
	@Test
	void testGetWordValueMISTAKEWIZShouldReturnAValueOf0() {
		Word word = new Word("w1z");
		assertEquals(0, word.getWordValue());
	}
}
