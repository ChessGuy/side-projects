//Game Parameters

let roundNumber = 1; 
let bid = 0;
const MAX_ROUND = 8;
let changes = 1; //Number of changes a player has
let playerBank = 200;
const ADDED_MONEY = 400; //Money added to playerBank after round 4
let isGameOver = false; //Tracks if the game is still going

let deck = []; //Placeholder for game card deck
let starterCard, change1, change2, change3, card1, card2, card3, card4, card5, card6, card7;

let cardBoard = [starterCard, card1, card2, card3, card4, card5, card6, card7];
let changeCards = [change1, change2, change3];

let resultsMessage = "Welcome to Card Sharks! Good Luck!";
let gameMessage = "Let's start round " + roundNumber + "! \n Is the next card higher or lower?";
let betMessage = "";

let playerChoice = "";

let gameCard1, gameCard2; //Used for the playRound function

//Game Loop

document.addEventListener('DOMContentLoaded', () => {

    displayMessages ();
    startGame ();
  
    //Button Event Listeners 
    document.getElementById("higher").addEventListener('click', higher);
    document.getElementById("lower").addEventListener('click', lower);
    document.getElementById("change").addEventListener('click', changeCard);

    //Display starter Card
    document.getElementById('starter-card-img').src = "./cards/" + starterCard + ".png";

});



//Functions

function buildDeck() {
    let values = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    let types = ["C", "D", "H", "S"];

    for (let i=0; i < types.length; i++) {
        for (let j=0; j < values.length; j++) {
            deck.push(values[j] + "-" + types[i]);
        }
    }
}

function shuffleDeck() {
    for (let i=0; i < deck.length; i++) {
        let j = Math.floor(Math.random() * deck.length);
        let temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }
}

function dealStartingCards () {
    starterCard = deck.pop();
    change1 = deck.pop();
    change2 = deck.pop();
    change3 = deck.pop();
    card1 = deck.pop();
    card2 = deck.pop();
    card3 = deck.pop();
    card4 = deck.pop();
    card5 = deck.pop();
    card6 = deck.pop();
    card7 = deck.pop();
    cardBoard = [starterCard, card1, card2, card3, card4, card5, card6, card7];
    changeCards = [change1, change2, change3];
}

function getValue(card) {
    let data = card.split("-"); 
    let value = data[0];

    if (isNaN(value)) {  //If the card is A K Q J
        if (value == "A") {
            return 14;
        } else if (value == "K") {
            return 13;
        } else if (value == "Q") {
            return 12;
        } else  {
            return 11;
        }
    } else {
        return parseInt(value);
        }
    }

function isValidBid () {
    let finalBid = playerBank / 2;

    if (bid > playerBank || bid % 50 != 0 || bid < 1) {
        betMessage = "Invalid bid. Please try again.";
        displayMessages ();
        return false; 
    }

    if (roundNumber === MAX_ROUND && (bid < finalBid)) {
        betMessage = "You must bid at least half of your bank ( " + finalBid + ")."
        displayMessages ();
        return false;
    }
    return true;

}

function displayMessages () {
    document.getElementById("bank").innerText = '$' + playerBank;
    document.getElementById("game-message").innerText = gameMessage;
    document.getElementById("results-message").innerText = resultsMessage;
    document.getElementById("bet-message").innerText = betMessage;
}

function startGame () {
    buildDeck ();
    shuffleDeck ();
    dealStartingCards ();
}

function higher () {
    bid = document.getElementById("bet").value;

    if (isValidBid()) {
        betMessage = "";
        displayMessages ();
    } else {
        return;
    }

    playerChoice = "H";
    playRound ();

}

function lower () {
    bid = document.getElementById("bet").value;

    if (isValidBid()) {
        betMessage = "";
        displayMessages ();
    } else {
        return;
    }

    playerChoice = "L";
    playRound ();
}

function changeCard() {
    let newCard = changeCards.pop()
    if (changes == 0) {
        betMessage = "You have no changes remaining."
        displayMessages();
    } else {
        cardBoard[roundNumber - 1] = newCard;
        changes -= 1;
    } 
    if (roundNumber == 1) {
        document.getElementById("starter-card-img").src = "./cards/" + cardBoard[roundNumber - 1] + ".png"

    } else {
        document.getElementById("card-" + (roundNumber - 1) + "-img").src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
    }
}

function playRound () {
    let didPlayerWin = false;
    console.log(playerChoice);

    gameCard1 = getValue(cardBoard[roundNumber - 1]);
    gameCard2 = getValue(cardBoard[roundNumber]);

    console.log(gameCard1);
    console.log(gameCard2);

    if (gameCard2 > gameCard1 && playerChoice == "H") {
        didPlayerWin = true;
    } else if (gameCard2 < gameCard1 && playerChoice == "L") {
        didPlayerWin = true;
    }

    if (gameCard1 === gameCard2) {
        resultsMessage = "Push! You keep your bet for the next round.";
    } else if (didPlayerWin) {
        resultsMessage = "YES! You guessed correctly!  Your bid of $" + bid + " has been added to your bank.";
        playerBank += parseInt(bid);
    } else {
        resultsMessage = "NO!  Your guess was wrong!  You lose your bid of $" + bid + " from your bank."
        playerBank -= parseInt(bid);
    } 
    console.log(didPlayerWin);

    document.getElementById("card-" + roundNumber + "-img").src = "./cards/" + cardBoard[roundNumber] + ".png"

    roundNumber++;
    gameMessage = "Let's start round " + roundNumber + "! \n Is the next card higher or lower?";
    
    displayMessages ();
}


