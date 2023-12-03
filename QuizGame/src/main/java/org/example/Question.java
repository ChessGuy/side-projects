package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {

    private String type;
    private String difficulty;
    private String category;
    private String question;
    @JsonProperty("correct_answer")
    private String correctAnswer;
    @JsonProperty("incorrect_answers")
    private String [] incorrectAnswers;

}
