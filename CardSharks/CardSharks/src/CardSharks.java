import java.util.*;

public class CardSharks {
    public static void main(String[] args) throws Exception {
    //Create a clone of the Card Sharks money cards game

    int roundNumber = 1;
    int bid = 0;
    String playerChoice = "";
    final int MAX_ROUND = 8;
    int changes = 3;
    int playerBank = 200;
    int addMoney = 400;
    boolean gameOver = false;
    final int SUITS = 4;
    final int MIN_VALUE = 2;
    final int MAX_VALUE = 14;
    ArrayList<Integer> cardsInPlay = new ArrayList<Integer>();
    ArrayList<Integer> deck = createDeck(SUITS, MIN_VALUE, MAX_VALUE);

    //Start of first hand

    System.out.println("WELCOME TO CARD SHARKS!!");
    cardsInPlay = drawCard(cardsInPlay, deck);

    //Start of game loop
    
    while(!gameOver){
        //Print player bank and cards in play
        Scanner input = new Scanner(System.in);
        String changeText = "changes";
        if (changes == 1) {
            changeText = "change";
        }
        System.out.printf("You have %d in your bank and %d %s left.\n", playerBank, changes, changeText);
        if(roundNumber == MAX_ROUND){
            System.out.println("\nFINAL ROUND!  You must bid half of your bank on this flip.  Good Luck!");
        }
        else{
            System.out.printf("\nLet's start Round %d!\n",roundNumber);
        }
        System.out.println("Here is the board of cards:");
    
        //Display board 
        System.out.println(cardsInPlay);

        //Ask player if they want to change the current card
        if(changes > 0){
            System.out.println("Would you like to keep or change the current card? (Enter keep or change)");
            playerChoice = input.nextLine().toUpperCase();
    
            while(!playerChoice.equals("KEEP") && !playerChoice.equals("CHANGE")){
                System.out.println("Invalid choice.  Please try again");
                System.out.println("Would you like to keep or change the current card? (Enter keep or change)");
                playerChoice = input.nextLine().toUpperCase();
            }
        }
        if(playerChoice.equals("CHANGE")){
            System.out.println("You have chosen to change your card.  Here is your new board:");
            replaceCard(cardsInPlay, deck, roundNumber - 1);
            System.out.println(cardsInPlay);
            changes--;
        }
    
        //Ask the player for the higher or lower choice
        System.out.println("Do you think the next card is higher or lower?");
        playerChoice = input.nextLine().toUpperCase();

        while(!playerChoice.equals("HIGHER") && !playerChoice.equals("LOWER")){
            System.out.println("Invalid choice.  Please try again");
            System.out.println("Do you think the next card is higher or lower?");
            playerChoice = input.nextLine().toUpperCase();
        }

        //Ask the player for a bid
        bid = takeBid(input, playerBank, roundNumber, MAX_ROUND);

        //Draw and new card Compare results and adjust their bank
        drawCard(cardsInPlay, deck);
        playerBank = playRound(cardsInPlay.get(roundNumber - 1), cardsInPlay.get(roundNumber), bid, playerBank, playerChoice);
        //Increment round and resolve new money and game over conditions 
        if(roundNumber == MAX_ROUND){
            gameOver = gameOver(gameOver, playerBank);
        }

        roundNumber++;

        if(playerBank == 0) {
            if (roundNumber < 4) {
                System.out.println("You have busted before the 3rd round.");
                roundNumber = 4;
            } else if (roundNumber < MAX_ROUND) {
                gameOver = gameOver(gameOver, playerBank);
            }
        }

        if(roundNumber == 4){
            playerBank += addMoney;
            System.out.println("You have 400 extra in your bank for making it to Round 4.");
        }   
        


    }

}

    public static ArrayList<Integer> createDeck(int suits, int minValue, int maxValue){
        //Creates the deck and shuffles it before starting the game
        ArrayList<Integer> deck = new ArrayList<Integer>();

        for(int i=0;i<suits; i++){
            for(int n=minValue; n<=maxValue;n++){
                deck.add(n);
            }
        }
        Collections.shuffle(deck);
        return deck;
    }
    public static ArrayList<Integer> drawCard(ArrayList<Integer> cardsInPlay, ArrayList<Integer> deck){
        Random rand = new Random();
        int randIndex = rand.nextInt(0,(deck.size() - 1));
        cardsInPlay.add(deck.remove(randIndex));
        return cardsInPlay;
    }
    public static ArrayList<Integer> replaceCard(ArrayList<Integer>  cardsInPlay, ArrayList<Integer> deck, int index){
        Random rand = new Random();
        int randIndex = rand.nextInt(0,(deck.size() - 1));
        cardsInPlay.set(index, deck.remove(randIndex));
        return cardsInPlay;
    }

    public static int playRound(int card1, int card2, int bid, int playerBank, String playerChoice){
        boolean didPlayerWin = false;
        
        if((card2 > card1 && playerChoice.equals("HIGHER"))){
            didPlayerWin = true;
        }
        else if((card2 < card1 && playerChoice.equals("LOWER"))){
            didPlayerWin = true;
        }
        if(card1 == card2){
            //Push.  Player does not lose money.
            System.out.println("Push! You keep your bet for the next round.");
        }
        else if(didPlayerWin){
            playerBank += bid;
            System.out.println("YES! You guessed correctly!  Your bid has been added to your bank.");
        }
        else {
            playerBank -= bid;
            System.out.println("NO!  Your guess was wrong!  You lose your bid from your bank.");
        }

        return playerBank;
        }
        public static int takeBid(Scanner input, int playerBank, int round, int MAX_ROUND){
            int bid = 0;
            System.out.println("What would you like to bid (Increments of 50)?");
            bid = input.nextInt();

            while(bid > playerBank || bid % 50 != 0 ){
                System.out.println("Invalid bid. Please try again.");
                System.out.println("What would you like to bid (Increments of 50)?");
                bid = input.nextInt();
            }
            while(round == MAX_ROUND && (bid < (playerBank/2))){
                System.out.println("You must bid at least half of your bank.");
                System.out.println("What would you like to bid (Increments of 50)?");
                bid = input.nextInt();
            }
        return bid;
        
        }
        public static boolean gameOver(boolean gameOver, int playerBank){
            gameOver = true;
            System.out.printf("\nGame Over. Your final bank is %d.", playerBank);
            return gameOver;
        }

            
        
        
    }

