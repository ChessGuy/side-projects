package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Question question1 = new Question("test", "easy", "test", "Here is the question", "correct answer",
                new String []{"incorrect 1", "incorrect 2", "incorrect 3"});
        Question question2 = new Question("test", "easy", "test", "Here is another question", "correct answer",
                new String []{"incorrect 1", "incorrect 2", "incorrect 3"});
        QuestionServices questionServices = new QuestionServices();
        Question [] questions = new Question []{question1, question2};
//        Question [] questions = questionServices.getAll(9, "medium");

        //Game Loop

        System.out.println("*************************************");
        System.out.println("**       Welcome to the Quiz!      **");
        System.out.println("*************************************");

        int score = 0;
        int indexOfCorrectAnswer = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println();
            System.out.println("Here is question: " + (i + 1));
            System.out.println();
            System.out.println(questions[i]);
            String correctAnswer = questions[i].getCorrectAnswer();

            String [] answersToQuestion = questions[i].getAnswersToDisplay();

            for (int n = 0; n < answersToQuestion.length;n++) {
                if (answersToQuestion[n].equals(correctAnswer)) {
                    indexOfCorrectAnswer = n;
                }
            }

            int userAnswer = Integer.parseInt(promptForUserInput("What is your answer? (1, 2, 3, 4) "));

            if (userAnswer == (indexOfCorrectAnswer + 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was: " + (indexOfCorrectAnswer + 1));
            }
            System.out.println("Your current score is " + score + "/" + (i + 1));
        }
        //Game Over text
        System.out.println();
        System.out.println("Quiz completed!  Your final score is " + score + "/" + questions.length);
    }

    public static String promptForUserInput (String message) {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(message);
            userInput = sc.nextLine();
            if (!userInput.equals("1") &&
                    !userInput.equals("2") &&
                    !userInput.equals("3") &&
                    !userInput.equals("4")) {
                System.out.println("Invalid entry.  Please try again");
            }
        } while (!userInput.equals("1") &&
                !userInput.equals("2") &&
                !userInput.equals("3") &&
                !userInput.equals("4"));
        return userInput;
    }
}