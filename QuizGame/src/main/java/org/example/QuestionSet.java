package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
public class QuestionSet {

    @JsonProperty ("response_code")
    private int responseCode;
    @JsonProperty("results")
    private Question [] questions;

    public QuestionSet() {
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }
}
