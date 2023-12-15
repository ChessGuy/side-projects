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


        Scanner sc = new Scanner(System.in);
        //Game Loop

        System.out.println("*************************************");
        System.out.println("***      Welcome to the Quiz!     ***");
        System.out.println("*************************************");

        int score = 0;
        int indexOfCorrectAnswer = 0;
        String categoryToOutput = "";

        //Prompt User for Category
        String [] category = promptForUserCategory(sc);

        //Prompt Use for Difficulty
        String difficulty = promptForUserDifficulty(sc);

        QuestionSet questionSet = questionServices.getAll(Integer.parseInt(category[0]), difficulty);
        Question [] questions = questionSet.getQuestions();

        System.out.println("\nYou have selected 10 " + difficulty + " questions in the category of " + category[1] + ".");

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

    public static String [] promptForUserCategory (Scanner sc) {
        String userInput = "";
        String [] categoryChoice = new String[2];

        System.out.println("Which category would you like to play?");
        System.out.println("1. General Knowledge");
        System.out.println("2. Books");
        System.out.println("3. Movies");
        System.out.println("4. Music");
        System.out.println("5. Television");
        System.out.println("6. Video Games");
        System.out.println("7. Sports");
        System.out.println("8. Animals");
        System.out.println("9. Science & Nature");

        do {
            userInput = sc.nextLine();
            if (!userInput.equals("1") &&
                    !userInput.equals("2") &&
                    !userInput.equals("3") &&
                    !userInput.equals("4") &&
                    !userInput.equals("5") &&
                    !userInput.equals("6") &&
                    !userInput.equals("7") &&
                    !userInput.equals("8") &&
                    !userInput.equals("9")) {
                System.out.println("Invalid entry.  Please try again.");
            }
        } while (!userInput.equals("1") &&
                !userInput.equals("2") &&
                !userInput.equals("3") &&
                !userInput.equals("4") &&
                !userInput.equals("5") &&
                !userInput.equals("6") &&
                !userInput.equals("7") &&
                !userInput.equals("8") &&
                !userInput.equals("9"));

        int userChoiceInt = Integer.parseInt(userInput);

        if (userChoiceInt == 1) {
            categoryChoice[0] = "9";
            categoryChoice[1] = "General Knowledge";
        } else if (userChoiceInt == 2) {
            categoryChoice[0] = "10";
            categoryChoice[1] = "Books";
        } else if (userChoiceInt == 3) {
            categoryChoice[0] = "11";
            categoryChoice[1] = "Movies";
        } else if (userChoiceInt == 4) {
            categoryChoice[0] = "12";
            categoryChoice[1] = "Music";
        } else if (userChoiceInt == 5) {
            categoryChoice[0] = "14";
            categoryChoice[1] = "Television";
        } else if (userChoiceInt == 6) {
            categoryChoice[0] = "15";
            categoryChoice[1] = "Video Games";
        } else if (userChoiceInt == 7) {
            categoryChoice[0] = "21";
            categoryChoice[1] = "Sports";
        } else if (userChoiceInt == 8) {
            categoryChoice[0] = "27";
            categoryChoice[1] = "Animals";
        } else if (userChoiceInt == 9) {
            categoryChoice[0] = "17";
            categoryChoice[1] = "Science & Nature";
        }
        return categoryChoice;
    }

    public static String promptForUserDifficulty (Scanner sc) {
        String userInput = "";

        System.out.println("Which difficulty would you like to play?");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        do {
            userInput = sc.nextLine();
            if (!userInput.equals("1") &&
                    !userInput.equals("2") &&
                    !userInput.equals("3"))
            {
                System.out.println("Invalid entry.  Please try again.");
            }
        } while (!userInput.equals("1") &&
                !userInput.equals("2") &&
                !userInput.equals("3"));

        if (userInput.equals("1")) {
            return "easy";
        } else if (userInput.equals("2")) {
            return "medium";
        } else {
            return "hard";
        }
    }
}