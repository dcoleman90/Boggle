package edu.westga.cs6241.babble.controller;

import edu.westga.cs6241.babble.view.BabbleGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * This is the BabbleDriver class it contains the main method
 * @author Drew Coleman
 * @version 07/26/2018
 *
 */
public class BabbleDriver extends Application {
	@Override
	public void start(Stage primaryStage) {
		BabbleGUI babble = new BabbleGUI();
		BorderPane pane = new BorderPane();
		pane.setCenter(babble);
		Scene display = new Scene(pane, 300, 250);
		primaryStage.setTitle("Babble");
		primaryStage.setScene(display);
		primaryStage.show();
		
	}	
	
	/**
	 * This is the main method which launches the graphic
	 * @param args is the arguement
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
