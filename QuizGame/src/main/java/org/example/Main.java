package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
//        Question question = new Question("test", "easy", "test", "Here is the question", "correct answer",
//                new String []{"incorrect 1", "incorrect 2", "incorrect 3"});
        QuestionServices questionServices = new QuestionServices();
        Question [] questions = questionServices.getAll(9, "easy");

        System.out.println(questions[0]);
    }
}