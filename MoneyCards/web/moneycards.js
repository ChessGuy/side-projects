//Game Parameters

let roundNumber = 1; 
let bid = 0;
const MAX_ROUND = 8;
let changes = 1; //Number of changes a player has
let playerBank = 200;
const ADDED_MONEY = 400; //Money added to playerBank after round 4
let isGameOver = false; //Tracks if the game is still going
let deck = []; //Placeholder for game card deck

//Game Loop





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