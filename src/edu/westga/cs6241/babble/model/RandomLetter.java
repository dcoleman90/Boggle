package edu.westga.cs6241.babble.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class will create a random letter from a-z
 * 
 * @author Drew Coleman
 * @version 07/26/2018
 */
public class RandomLetter {
	private Random random;
	ArrayList<String> alphabet;

	public RandomLetter() {
		this.random = new Random();
		this.alphabet = new ArrayList<String>();
		this.setAI9();
		this.setBCMPFHVWY2();
		this.setE12();
		this.setG3();
		this.setKJXQZ1();
		this.setLSUD4();
		this.setNRT6();
		this.setO8();
	}

	public String getRandomLetter() {
		int selection = this.random.nextInt(98);
		String letter = this.alphabet.get(selection);
		return letter.toUpperCase();
	}

	private void setE12() {
		for (int count = 0; count < 12; count++) {
			this.alphabet.add("e");
		}
	}

	private void setAI9() {
		for (int count = 0; count < 9; count++) {
			this.alphabet.add("a");
			this.alphabet.add("i");
		}
	}

	private void setO8() {
		for (int count = 0; count < 8; count++) {
			this.alphabet.add("o");
		}
	}

	private void setNRT6() {
		for (int count = 0; count < 6; count++) {
			this.alphabet.add("n");
			this.alphabet.add("r");
			this.alphabet.add("t");
		}
	}

	private void setLSUD4() {
		for (int count = 0; count < 4; count++) {
			this.alphabet.add("l");
			this.alphabet.add("s");
			this.alphabet.add("u");
			this.alphabet.add("d");
		}
	}
	
	private void setG3() {
		for (int count = 0; count < 3; count++) {
			this.alphabet.add("g");
		}
	}
	
	private void setBCMPFHVWY2() {
		for (int count = 0; count < 2; count++) {
			this.alphabet.add("b");
			this.alphabet.add("c");
			this.alphabet.add("m");
			this.alphabet.add("p");
			this.alphabet.add("f");
			this.alphabet.add("h");
			this.alphabet.add("v");
			this.alphabet.add("w");
			this.alphabet.add("y");
		}
	}
	
	private void setKJXQZ1() {
		for (int count = 0; count < 1; count++) {
			this.alphabet.add("k");
			this.alphabet.add("j");
			this.alphabet.add("x");
			this.alphabet.add("q");
			this.alphabet.add("z");
		}
	}
}
