package edu.westga.cs6241.babble.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs6241.babble.model.Letter;

/**
 * @author Drew Coleman
 *
 */
class TestLetterSetTileValue {

	/**
	 * This test will set the letter to A and test the returned numerical value 
	 * should return 1
	 */
	@Test
	void testSetTileValueLetterAShouldReturn1() {
		Letter testLetter = new Letter("a");
		assertEquals(1, testLetter.getTileValue());
	}

	/**
	 * This test will set the letter to D and test the returned numerical value 
	 * should return 2
	 */
	@Test
	void testSetTileValueLetterDShouldReturn2() {
		Letter testLetter = new Letter("d");
		assertEquals(2, testLetter.getTileValue());
	}
	
	/**
	 * This test will set the letter to C and test the returned numerical value 
	 * should return 3
	 */
	@Test
	void testSetTileValueLetterCShouldReturn3() {
		Letter testLetter = new Letter("c");
		assertEquals(3, testLetter.getTileValue());
	}
	
	/**
	 * This test will set the letter to h and test the returned numerical value 
	 * should return 4
	 */
	@Test
	void testSetTileValueLetterHShouldReturn1() {
		Letter testLetter = new Letter("h");
		assertEquals(4, testLetter.getTileValue());
	}
	
	/**
	 * This test will set the letter to A and test the returned numerical value 
	 * should return 1
	 */
	@Test
	void testSetTileValueLetterKShouldReturn5() {
		Letter testLetter = new Letter("k");
		assertEquals(5, testLetter.getTileValue());
	}
	
	/**
	 * This test will set the letter to J and test the returned numerical value 
	 * should return 8
	 */
	@Test
	void testSetTileValueLetterJShouldReturn8() {
		Letter testLetter = new Letter("j");
		assertEquals(8, testLetter.getTileValue());
	}
	
	/**
	 * This test will set the letter to Z and test the returned numerical value 
	 * should return 10
	 */
	@Test
	void testSetTileValueLetterZShouldReturn10() {
		Letter testLetter = new Letter("z");
		assertEquals(10, testLetter.getTileValue());
	}
	
	/**
	 * This test will check for a capital letter and return the numerical value
	 * should return 1
	 */
	@Test
	void testSetTileValueCapLetterAShouldReturn1() {
		Letter testLetter = new Letter("A");
		assertEquals(1, testLetter.getTileValue());
	}
	
	/**
	 * This test will check for a capital letter and return the numerical value
	 * should return 1
	 */
	@Test
	void testSetTileValueCapLetterXShouldReturn() {
		Letter testLetter = new Letter("X");
		assertEquals(8, testLetter.getTileValue());
	}
}
