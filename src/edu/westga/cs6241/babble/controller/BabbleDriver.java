package edu.westga.cs6241.babble.controller;

import edu.westga.cs6241.babble.view.BabbleTUI;

/**
 * This is the BabbleDriver class it contains the main method
 * @author Drew Coleman
 * @version 07/26/2018
 *
 */
public class BabbleDriver {

	/**
	 * This is the main method it will call the BabbleTUI run method
	 * @param args is the arguement
	 */
	public static void main(String[] args) {
		BabbleTUI wordCheck = new BabbleTUI();
		wordCheck.run();
	}

}
