package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Question question = new Question("test", "easy", "test", "Here is the question", "correct answer",
                new String []{"incorrect 1", "incorrect 2", "incorrect 3"});

        System.out.println(question.getQuestion());
        System.out.println(Arrays.toString(question.getAnswersToDisplay()));
    }
}