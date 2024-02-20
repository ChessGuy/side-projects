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

let resultsMessage = "Welcome to Card Sharks!";
let gameMessage = "Good Luck!";
let betMessage = "Increments of $50";


//Game Loop

document.addEventListener('DOMContentLoaded', () => {

    document.getElementById("bank").innerText = '$' + playerBank;

    displayMessages();

});



//Functions

function buildDeck() {
    let values = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    let types = ["C", "D", "H", "S"];
    deck = [];

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
        } else if (value == "J") {
            return 11;
        } else {
            return parseInt(value);
        }
    }
}

function checkPlayerBid () {
    let finalBid = playerBank / 2;

    while (bid > playerBank || bid % 50 != 0) {
        
    }


}

function displayMessages () {
    document.getElementById("bank").innerText = '$' + playerBank;
    document.getElementById("game-message").innerText = gameMessage;
    document.getElementById("results-message").innerText = resultsMessage;
    document.getElementById("bet-message").innerText = betMessage;
}