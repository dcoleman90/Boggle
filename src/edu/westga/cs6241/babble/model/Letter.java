package edu.westga.cs6241.babble.model;

import java.util.Arrays;

/**
 * The Letter class returns the value of an accepted String. It will only accept
 * an a-z character
 * 
 * @author Drew Coleman
 *
 */
public class Letter {
	int value;
	String tile;

	/**
	 * This is the constructor it insures the accepted string object is no more than
	 * one tile in length and is not null
	 * 
	 * @param tile
	 *            is the accepted tile that this.tile is set to
	 * 
	 *            the constructor then calls the private settileValue method which
	 *            sets this.value to the point value of the tile
	 */
	public Letter(String tile) {
		String[] alphabet = { "e", "a", "i", "o", "n", "r", "t", "l", "s", "u", "d", "g", "b", "c", "m", "p", "f", "h",
				"v", "w", "y", "k", "j", "x", "q", "z" };
		if (tile == null) {
			throw new NullPointerException("Invalid Strategy");
		}
		if (tile.length() > 1) {
			throw new IllegalArgumentException("Letter is only to be one character long");
		}
		String lowerCaseTile = tile.toLowerCase();
		if (!Arrays.asList(alphabet).contains(lowerCaseTile)) {
			throw new IllegalArgumentException("Only charactors a-z and A-Z are allowed");
		}
		this.tile = lowerCaseTile;
		this.setTileValue();
	}

	private void setTileValue() {
		String[] onePoint = { "e", "a", "i", "o", "n", "r", "t", "l", "s", "u" };
		String[] twoPoints = { "d", "g" };
		String[] threePoints = { "b", "c", "m", "p" };
		String[] fourPoints = { "f", "h", "v", "w", "y" };
		String[] fivePoints = { "k" };
		String[] eightPoints = { "j", "x" };
		String[] tenPoints = { "q", "z" };

		if (Arrays.asList(onePoint).contains(this.tile)) {
			this.value = 1;
		} else if (Arrays.asList(twoPoints).contains(this.tile)) {
			this.value = 2;
		} else if (Arrays.asList(threePoints).contains(this.tile)) {
			this.value = 3;
		} else if (Arrays.asList(fourPoints).contains(this.tile)) {
			this.value = 4;
		} else if (Arrays.asList(fivePoints).contains(this.tile)) {
			this.value = 5;
		} else if (Arrays.asList(eightPoints).contains(this.tile)) {
			this.value = 8;
		} else if (Arrays.asList(tenPoints).contains(this.tile)) {
			this.value = 10;
		} else {
			throw new IllegalArgumentException("Charactor not found within Alphabet");
		}

	}

	/**
	 * This is the getter for this.value
	 * 
	 * @return the value of the tile as set by the settileValue
	 */
	public int getTileValue() {
		return this.value;
	}
}
