package edu.westga.cs6241.babble.view;

import edu.westga.cs6241.babble.model.RandomLetter;
import edu.westga.cs6241.babble.model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class BabbleGUI extends GridPane {
	private Word word;
	
	public BabbleGUI() {
		this.buildGaps();
		this.buildRandomLetters();
		this.buildWordBox();
		this.buildScoreBox();
		this.buildButtons();
	}
	
	private void buildGaps() {
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(5, 5, 5, 5));
	}
	
	private void buildRandomLetters() {
		Label tiles = new Label("Tiles");
		ListView<String> randomLetters = new ListView<String>();
		ObservableList<String> listOfLetters = FXCollections.observableArrayList();
				for(int count = 0; count < 7; count++) {
					listOfLetters.add(this.randomLetterHelper());
				};
		randomLetters.setItems(listOfLetters);
		randomLetters.setOrientation(Orientation.HORIZONTAL);
		this.add(tiles, 0, 1);
		this.add(randomLetters, 1, 1);
	}
	
	private String randomLetterHelper() {
		RandomLetter a2z = new RandomLetter();
		return a2z.getRandomLetter();
	}
	
	private Rectangle buildWordBox() {
		Rectangle test = new Rectangle();
		return test;
	}
	
	private void buildButtons() {
		
	}
	
	private void buildScoreBox() {
		
	}
}
