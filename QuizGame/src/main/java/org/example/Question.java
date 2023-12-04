package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Random;

public class Question {

    private String type;
    private String difficulty;
    private String category;
    private String question;
    @JsonProperty("correct_answer")
    private String correctAnswer;
    @JsonProperty("incorrect_answers")
    private String [] incorrectAnswers;
    private String [] answersToDisplay;

    public Question (String type, String difficulty, String category, String question, String correctAnswer, String[] incorrectAnswers) {
        this.type = type;
        this.difficulty = difficulty;
        this.category = category;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getType() {
        return type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setIncorrectAnswers(String[] incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
    public String [] getAnswersToDisplay () {
        String [] allAnswers = {getCorrectAnswer(), getIncorrectAnswers()[0], getIncorrectAnswers()[1], getIncorrectAnswers()[2]};
        String [] answersToDisplay = new String[4];
        int [] randIndexes = new int []{-1, -1, -1, -1};
        Random random = new Random();
        int randNum = -1;
        boolean alreadyUsed;

        for (int i = 0; i < 4; i++) {
            alreadyUsed = false;

            while (!alreadyUsed) {
                randNum = random.nextInt(0, 4);

                for (int n = 0; n < 4; n++) {
                    if (randIndexes[n] == randNum) {
                        break;
                    } else if (n == 3) {
                        alreadyUsed = true;
                        break;
                    }
                }
            }
            randIndexes[i] = randNum;

        }
        for (int i = 0; i < 4; i++) {
            answersToDisplay[i] = allAnswers[randIndexes[i]];
        }
        return answersToDisplay;

    }

    @Override
    public String toString() {
        answersToDisplay = getAnswersToDisplay();
        return getQuestion() +
                "\n1. " + answersToDisplay[0] +
                "\n2. " + answersToDisplay[1] +
                "\n3. " + answersToDisplay[2] +
                "\n4. " + answersToDisplay[3];

    }
}
