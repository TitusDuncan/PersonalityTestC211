package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.List;

public class DnDPersonalityTest extends Application {
	private int totalScore = 0; // used to determine the personality type
	private int currentQuestionIndex = 0; // used to return the current question
	private List<Question> questions; // linked list that holds the question for the test

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Dungeons & Dragons: Personality Test");

		//Questions are added to the linkedList for the personality test
		questions = new LinkedList<>();
		questions.add(new Question(
				"Q1. You find yourself in a dark dungeon as a shadowy figure approaches. What do you do?\n"
						+ "   - A) Sneak past them without being seen. \n" 
						+ "   - B) Confront the figure head on. \n"
						+ "   - C) Study the figure and consider your options before taking action.\n",
				new int[] { 1, 2, 3 }));
		questions.add(new Question(
				"Q2.You encounter a locked chest possessing unknown contents. What do you do?\n"
						+ "   - A) You pick the lock on the chest.\n" 
						+ "   - B) You smash the chest open.\n"
						+ "   - C) You carefully search for booby traps or magical wards before touching the chest.",
				new int[] { 1, 2, 3 }));
		questions.add(new Question(
				"Q3. You must duel a fierce opponent. How you do approach the battle?\n"
				+ "   - A) You focus on cunning and speed, striking at the enemy before they have time to react.\n"
				+ "   - B) You overpower the enemy with the sheer force of your blows.\n"
				+ "   - C) You tactically defeat your enemy using magic to control the battlefield.",
				new int[] { 1, 2, 3 }));
		questions.add(new Question("Q4. You may a carry one weapon into battle. What do you choose?\n"
				+ "   - A) A set of sharp glaives.\n" 
				+ "   - B) A massive greatsword.\n"
				+ "   - C) A staff possessing magical properties.", new int[] { 1, 2, 3 }));
		questions.add(new Question(
				"Q5. Your adventuring party thinks of you as:\n" + "   - A) The quickest group member.\n"
						+ "   - B) The strongest group member.\n" + "   - C) The most intelligent group member.",
				new int[] { 1, 2, 3 }));
		
		displayQuestion(primaryStage);

		primaryStage.show();
	}


	 // This method displays the question in the primary stage
	private void displayQuestion(Stage primaryStage) {
		if (currentQuestionIndex < questions.size()) {
			VBox vbox = new VBox(10);
			vbox.setPadding(new Insets(10));
			vbox.setSpacing(10);

			Label questionLabel = new Label(questions.get(currentQuestionIndex).getQuestion());
			ComboBox<String> comboBox = new ComboBox<>();
			comboBox.getItems().addAll("A", "B", "C");

			Button nextButton = new Button("Next");
			nextButton.setOnAction(e -> {
				String response = comboBox.getValue();
				if (response != null && !response.isEmpty()) {
					int scoreIndex;
					switch (response) {
					case "A":
						scoreIndex = 0;
						break;
					case "B":
						scoreIndex = 1;
						break;
					case "C":
						scoreIndex = 2;
						break;
					default:
						scoreIndex = 0; // Default to the first option
					}

					totalScore += questions.get(currentQuestionIndex).getScoring()[scoreIndex];
					currentQuestionIndex++;
					displayQuestion(primaryStage);
				} else {
					showAlert("Please answer the question.");
				}
			});

			vbox.getChildren().addAll(questionLabel, comboBox, nextButton);
			vbox.setAlignment(Pos.CENTER_LEFT);

			Scene scene = new Scene(vbox, 700, 400);
			primaryStage.setScene(scene);
		} else {
			displayResult(primaryStage);
		}
	}

	// used to display the result of the personality test
	private void displayResult(Stage primaryStage) {
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(10));

		Personality personalityType = determinePersonality(totalScore);

		Label resultLabel = new Label("Your total score is: " + totalScore);
		Label typeLabel = new Label("Personality Type: " + personalityType.getType());
		Label descriptionLabel = new Label("Description: " + personalityType.getDescription());

		vbox.getChildren().addAll(resultLabel, typeLabel, descriptionLabel);
		vbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vbox, 700, 400);
		primaryStage.setScene(scene);
	}

	// Prompts a message when the user tries to continue the test without answering the question
	private void showAlert(String message) {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Warning");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	// Method used to determine and return the personality type based on the answers provided
	private Personality determinePersonality(int totalScore) {
		if (totalScore <= 5) {
			return new Rogue();
		} else if (totalScore <= 10) {
			return new Fighter();
		} else {
			return new Wizard();
		}
	}
}