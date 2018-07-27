package edu.westga.cs6241.babble.view;

import java.io.FileNotFoundException;

import edu.westga.cs6241.babble.model.RandomLetter;
import edu.westga.cs6241.babble.model.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class BabbleGUI extends GridPane {
	private String word;
	private ObservableList<String> selectedWord;
	private ObservableList<String> listOfLetters;
	
	private ListView<String> userSelectedWord;
	private ListView<String> randomLetters;
	private Button btnSubmitWord;
	private Button btnReset;
	private int score;

	public BabbleGUI() {
		this.listOfLetters = FXCollections.observableArrayList();
		this.selectedWord = FXCollections.observableArrayList();
		this.userSelectedWord = new ListView<String>();
		this.randomLetters = new ListView<String>();
		this.word = "";
		this.score = 0;
		this.buildGridPane();
	}

	public void buildGridPane() {
		this.buildLabels();
		this.buildGaps();
		this.buildRandomLetters();
		this.buildScoreBox();
		this.buildButtons();
	}

	private void buildLabels() {
		Label tiles = new Label("Tiles");
		Label score = new Label("Score " + this.score);
		this.add(tiles, 1, 1);
		this.add(score, 2, 5);
	}

	private void buildGaps() {
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(5, 5, 5, 5));
	}

	public void buildRandomLetters() {
		for (int count = this.listOfLetters.size(); count < 7; count++) {
			this.listOfLetters.add(this.randomLetterHelper());
		}
		this.randomLetters.setItems(this.listOfLetters);
		this.randomLetters.setOrientation(Orientation.HORIZONTAL);
		this.randomLetters.setMaxHeight(30);
		this.randomLetters.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				if (BabbleGUI.this.randomLetters.getSelectionModel().getSelectedItem() != null) {
					BabbleGUI.this.selectedWord.add(BabbleGUI.this.randomLetters.getSelectionModel().getSelectedItem());
					BabbleGUI.this.word += BabbleGUI.this.randomLetters.getSelectionModel().getSelectedItem();
				}
				BabbleGUI.this.listOfLetters.remove(BabbleGUI.this.randomLetters.getSelectionModel().getSelectedItem());
				BabbleGUI.this.userSelectedWord.setItems(BabbleGUI.this.selectedWord);
			}
		});
		this.userSelectedWord.setOrientation(Orientation.HORIZONTAL);
		this.userSelectedWord.setMaxHeight(30);

		this.add(this.randomLetters, 1, 2);
		this.add(this.userSelectedWord, 1, 4);
	}

	private String randomLetterHelper() {
		RandomLetter a2z = new RandomLetter();
		return a2z.getRandomLetter();
	}

	public void resetGridPane() {
		this.getChildren().clear();
		this.word = "";
		this.selectedWord = FXCollections.observableArrayList();
	}

	public void resetWord() {
		
	}
	
	public void resetListOfLetters(String addedLetters) {
		String[] reset = addedLetters.split("");
		for (int count = 0; count < reset.length; count++) {
			this.listOfLetters.add(reset[count]);
		}
	}

	private void buildButtons() {
		this.btnSubmitWord = new Button("Submit");
		this.btnSubmitWord.setOnAction(new SubmitWordListener());
		this.btnReset = new Button("Reset");
		HBox buttonBox = new HBox();
		buttonBox.getStyleClass().add("box-padding");
		buttonBox.getChildren().addAll(this.btnReset, this.btnSubmitWord);
		this.add(buttonBox, 1, 5);

	}

	private class SubmitWordListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			Word testWord = new Word(BabbleGUI.this.word);
			try {
				if (testWord.isAWord()) {
					BabbleGUI.this.score += testWord.getWordValue();
					System.out.println("true" + testWord.getWordValue());
					BabbleGUI.this.selectedWord = FXCollections.observableArrayList();
					BabbleGUI.this.userSelectedWord.setItems(BabbleGUI.this.selectedWord);
				//	BabbleGUI.this.listOfLetters = BabbleGUI.this.tempListOfLetters;
					BabbleGUI.this.resetWord();
					BabbleGUI.this.resetGridPane();
					BabbleGUI.this.buildGridPane();
				} else {
					Alert notAWord = new Alert(AlertType.INFORMATION);
					notAWord.setTitle("Miss Spelled");
					notAWord.setHeaderText("This is not an acceptable word");
					notAWord.setContentText("Please create an acceptable word");
					notAWord.showAndWait();
					ButtonType exit = new ButtonType("exit", ButtonData.CANCEL_CLOSE);
					notAWord.getButtonTypes().setAll(exit);
					BabbleGUI.this.resetListOfLetters(BabbleGUI.this.word);
					BabbleGUI.this.resetGridPane();
					BabbleGUI.this.buildGridPane();
					;
				}
			} catch (FileNotFoundException fnfe) {
				System.out.println("<--File not found-->");
			}

		}

	}

	private void buildScoreBox() {

	}
}
