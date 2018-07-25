package edu.westga.cs6241.babble.model;

import java.util.Arrays;

public class Alphabet {
	int value;
	String letter;
	
	public Alphabet(String letter) {
		if (letter == null) { 
			//illegal throw
		}
		if (letter.length() > 1) {
			//illegal throw exception
		}
		this.letter = letter;
		this.setLetterValue();
	}
	
	public void setLetterValue() {
		String[] onePoint = {"e", "a", "i", "o", "n", "r", "t", "l", "s", "u"};
		String[] twoPoints = {"d", "g"};
		String[] threePoints = {"b", "c", "m", "p"};
		String[] fourPoints = {"f", "h", "v", "w", "y"};
		String[] fivePoints = {"k"};
		String[] eightPoints = {"j", "x"};
		String[] tenPoints = {"q", "z"};
		
		if (Arrays.asList(onePoint).contains(this.letter)) {
			this.value = 1;
		} else if (Arrays.asList(twoPoints).contains(this.letter)) {
			this.value = 1;
		} else if (Arrays.asList(threePoints).contains(this.letter)) {
			this.value = 1;
		} else if (Arrays.asList(fourPoints).contains(this.letter)) {
			this.value = 1;
		} else if (Arrays.asList(fivePoints).contains(this.letter)) {
			this.value = 1;
		} else if (Arrays.asList(eightPoints).contains(this.letter)) {
			this.value = 1;
		} else if (Arrays.asList(tenPoints).contains(this.letter)) {
			this.value = 1;
		} else {
			this.value = 0;
			//Needs to throw exception
		}
		
		
	}
}
