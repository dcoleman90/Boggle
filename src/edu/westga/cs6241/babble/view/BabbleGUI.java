package edu.westga.cs6241.babble.view;

import java.util.ArrayList;

import edu.westga.cs6241.babble.model.RandomLetter;
import edu.westga.cs6241.babble.model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class BabbleGUI extends GridPane {
	private Word word;
	private ObservableList<String> selectedWord;
	private ObservableList<String> listOfLetters;
	private ListView<String> userSelectedWord;

	public BabbleGUI() {
		this.listOfLetters = FXCollections.observableArrayList();
		this.selectedWord = FXCollections.observableArrayList();
		this.userSelectedWord = new ListView<String>();
		this.buildGaps();
		this.buildRandomLetters();
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
		Label testRemove = new Label("Look What Was Selected please Remove");
		Label testAdd = new Label("");
		ListView<String> randomLetters = new ListView<String>();
		for (int count = this.listOfLetters.size(); count < 7; count++) {
			this.listOfLetters.add(this.randomLetterHelper());
		}
		randomLetters.setItems(this.listOfLetters);
		randomLetters.setOrientation(Orientation.HORIZONTAL);
		randomLetters.setMaxHeight(30);
		randomLetters.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				testRemove.setText("Looked what you clicked " + randomLetters.getSelectionModel().getSelectedItem());
				if (randomLetters.getSelectionModel().getSelectedItem() != null) {
					BabbleGUI.this.selectedWord.add(randomLetters.getSelectionModel().getSelectedItem());
				}
				BabbleGUI.this.listOfLetters.remove(randomLetters.getSelectionModel().getSelectedItem());
				BabbleGUI.this.userSelectedWord.setItems(BabbleGUI.this.selectedWord);
			}
		});
		this.userSelectedWord.setOrientation(Orientation.HORIZONTAL);
		this.userSelectedWord.setMaxHeight(30);
		this.add(tiles, 1, 1);
		this.add(randomLetters, 1, 2);
		this.add(testRemove, 1, 3);
		this.add(this.userSelectedWord, 1, 4);
	}

	private String randomLetterHelper() {
		RandomLetter a2z = new RandomLetter();
		return a2z.getRandomLetter();
	}

	public ListView<String> buildWordBox(ObservableList<String> pickedLetters) {
		ListView<String> wordSelected = new ListView<String>();
		wordSelected.setItems(pickedLetters);
		wordSelected.setOrientation(Orientation.HORIZONTAL);
		wordSelected.setMaxHeight(30);
		return wordSelected;
	}

	private void buildButtons() {

	}

	private void buildScoreBox() {

	}
}
