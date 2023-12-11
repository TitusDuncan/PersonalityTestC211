package application;

//Question class to represent each question
class Question {
	
	// Declare variables for questions and 
	private String question;
	private int[] scoring;
	
	// Constructor for personality test questions
	public Question(String question, int[] scoring) {
		this.question = question;
		this.scoring = scoring;
	}
	
	// Return a question from the personality test
	public String getQuestion() {
		return question;
	}
	
	// Return the total score from the personality test
	public int[] getScoring() {
		return scoring;
	}
}