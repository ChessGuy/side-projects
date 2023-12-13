package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        SimpleQuestion simpleQuestion1 = new SimpleQuestion("test", "easy", "test", "Here is the question", "correct answer",
                new String []{"incorrect 1", "incorrect 2", "incorrect 3"});
        SimpleQuestion simpleQuestion2 = new SimpleQuestion("test", "easy", "test", "Here is another question", "correct answer",
                new String []{"incorrect 1", "incorrect 2", "incorrect 3"});
        QuestionServices questionServices = new QuestionServices();
//        SimpleQuestion [] questions = new SimpleQuestion[] {simpleQuestion1, simpleQuestion2};
        QuestionSet questionSet = questionServices.getAll(9, "medium");
        Question [] questions = questionSet.getQuestions();

        Scanner sc = new Scanner(System.in);
        //Game Loop

        System.out.println("*************************************");
        System.out.println("***      Welcome to the Quiz!     ***");
        System.out.println("*************************************");

        int score = 0;
        int indexOfCorrectAnswer = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println();
            System.out.println("Here is question " + (i + 1) + ":");
            System.out.println();
            System.out.println(questions[i]);
            String correctAnswer = questions[i].getCorrectAnswer();

            String [] answersToQuestion = questions[i].getAnswersToDisplay();

            for (int n = 0; n < answersToQuestion.length;n++) {
                if (answersToQuestion[n].equals(correctAnswer)) {
                    indexOfCorrectAnswer = n;
                }
            }

            int userAnswer = Integer.parseInt(promptForUserAnswer("What is your answer? (1, 2, 3, 4) ", sc));

            if (userAnswer == (indexOfCorrectAnswer + 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer was " + (indexOfCorrectAnswer + 1) + ": " + correctAnswer + ".");
            }
            System.out.println("Your current score is " + score + "/" + (i + 1) + ".");
        }
        //Game Over text
        System.out.println();
        System.out.println("Quiz completed!  Your final score is " + score + "/" + questions.length + ".");
    }

    public static String promptForUserAnswer (String message, Scanner sc) {
        String userInput = "";
        do {
            System.out.println(message);
            userInput = sc.nextLine();
            if (!userInput.equals("1") &&
                    !userInput.equals("2") &&
                    !userInput.equals("3") &&
                    !userInput.equals("4")) {
                System.out.println("Invalid entry.  Please try again.");
            }
        } while (!userInput.equals("1") &&
                !userInput.equals("2") &&
                !userInput.equals("3") &&
                !userInput.equals("4"));
        return userInput;
    }
}