// import database from "./database";

//Test code for database
// console.log(database.list());

//Game Parameters

let roundNumber = 1; 
let tempRound = 0; //Tracks the round for moving the card early
let bid = 0;
const MAX_ROUND = 7;
let changes = 1; //Number of changes a player has
let playerBank = 200;
const ADDED_MONEY = 400; //Money added to playerBank after round 4
let isGameOver = false; //Tracks if the game is still going

let deck = []; //Placeholder for game card deck
let starterCard, change1, change2, change3, card1, card2, card3, card4, card5, card6, card7;

let cardBoard = [starterCard, card1, card2, card3, card4, card5, card6, card7];
let changeCards = [change1, change2, change3];

let resultsMessage = "Welcome to Card Sharks! Good Luck!";
let gameMessage = "Let's start ROUND " + roundNumber + "! \n Is the next card higher or lower?";
let betMessage = "";
let didBustEarly = false; //Track if a player busted before the 4th round

let playerChoice = "";

let gameCard1, gameCard2; //Used for the playRound function

//Game Loop

document.addEventListener('DOMContentLoaded', () => {

    displayMessages ();
    startGame ();
    initDatabase();
    
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

    if (bid > playerBank) {
        betMessage = "** Bet cannot exceed your bank. **";
        displayMessages ();
        return false; 
    } else if (bid < 1) {
        betMessage = "** Bet must be greater than 0. **";
        displayMessages ();
        return false; 
    } else if (bid % 50 != 0) {
        betMessage = "** Bet must be an increment of 50. **";
        displayMessages ();
        return false; 
    } 

    if (roundNumber === MAX_ROUND && (bid < finalBid)) {
        betMessage = "** Must bet at least $" + finalBid + ". **"
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
    if (isGameOver) {
        return;
    } 
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
    if (isGameOver) {
        return;
    } 

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
    if (isGameOver) {
        return;
    } 

    let newCard = changeCards.pop()

    if (changes == 0) {
        betMessage = "** You have no changes remaining. **"
        displayMessages();
    } else {
        cardBoard[roundNumber - 1] = newCard;
        changes -= 1;

    // Select the correct change card based on the round if the player changes the first card in the row
    if (roundNumber == 1) {
        document.getElementById("starter-card-img").src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
    } else if (roundNumber == 4) {
        document.getElementById("row-2-start-img").src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
    } else if (roundNumber == MAX_ROUND) {
        document.getElementById("row-3-start-img").src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
    } else {
        document.getElementById("card-" + (roundNumber - 1) + "-img").src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
    }

    // Selects the correct change card based on the round to replace with the current card
    if (roundNumber < 4) {
        let changeDiv1 = document.getElementById('change-card-1');
        while (changeDiv1.firstChild) {
            changeDiv1.removeChild(changeDiv1.firstChild);
        }
    } else if (roundNumber == MAX_ROUND) {
        let changeDiv3 = document.getElementById('change-card-3');
        while (changeDiv3.firstChild) {
            changeDiv3.removeChild(changeDiv3.firstChild);
        }
    } else {
        let changeDiv2 = document.getElementById('change-card-2');
        while (changeDiv2.firstChild) {
            changeDiv2.removeChild(changeDiv2.firstChild);
        }
    }
}
}

function playRound () {
    let didPlayerWin = false;

    gameCard1 = getValue(cardBoard[roundNumber - 1]);
    gameCard2 = getValue(cardBoard[roundNumber]);

    if (gameCard2 > gameCard1 && playerChoice == "H") {
        didPlayerWin = true;
    } else if (gameCard2 < gameCard1 && playerChoice == "L") {
        didPlayerWin = true;
    }

    if (gameCard1 === gameCard2) {
        resultsMessage = "Push! You keep your bet.";
    } else if (didPlayerWin) {
        resultsMessage = "YES! You guessed correctly!  Your bid of $" + bid + " has been added to your bank.";
        playerBank += parseInt(bid);
    } else {
        resultsMessage = "NO!  Your guess was wrong!  You lose your bid of $" + bid + " from your bank."
        playerBank -= parseInt(bid);
    } 

    document.getElementById("card-" + roundNumber + "-img").src = "./cards/" + cardBoard[roundNumber] + ".png"

    if (roundNumber == MAX_ROUND) {
        gameMessage = "Game Over!"
        isGameOver = true;
        displayMessages ();

        //Add logic to print initials and score to database
        setTimeout(postHighScore, 1000);
        return;
    }

    roundNumber++;

    if (playerBank <= 0) {
        if (roundNumber < 4) {
            
            didBustEarly = true;

            // Move the last card the player revealed on the first row and move it to the second
            tempRound = roundNumber;
            setTimeout(moveCardEarly, 500);

            // let secondRowStartDiv = document.getElementById('row-2-start');
            // let secondRowCard = document.createElement('img');
            // secondRowCard.setAttribute('id', 'row-2-start-img');
            // secondRowCard.src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
            
            // while (secondRowStartDiv.firstChild) {
            //     secondRowStartDiv.removeChild(secondRowStartDiv.firstChild);
            // }
            
            // secondRowStartDiv.appendChild(secondRowCard);

            // let endCardDiv = document.getElementById('card-' + (roundNumber - 1));

            // while (endCardDiv.firstChild) {
            //     endCardDiv.removeChild(endCardDiv.firstChild);
            // }  

            roundNumber = 4;
            // gameMessage += "\nYou have busted before ROUND 4!";
            displayMessages();

            } else if (roundNumber < MAX_ROUND) {
                gameMessage = "You busted! Game Over!"
                isGameOver = true;
                displayMessages();
                return;
                }
            }

    if (roundNumber == MAX_ROUND) {
        changes = 1;
        gameMessage = "Let's start the FINAL ROUND!  You must bet at least half of your bank."

        //Moves the last card from the second row to the top

        setTimeout(moveCardToTopRow, 500);

        // let bigBetStartDiv = document.getElementById('row-3-start');
        // let bigBetCard = document.createElement('img');
        // bigBetCard.setAttribute('id', 'row-3-start-img');
        // bigBetCard.src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
        // while (bigBetStartDiv.firstChild) {
        //     bigBetStartDiv.removeChild(bigBetStartDiv.firstChild);
        // }
        
        // bigBetStartDiv.appendChild(bigBetCard);

        // let endSecondRowDiv = document.getElementById('card-6');

        // while (endSecondRowDiv.firstChild) {
        //     endSecondRowDiv.removeChild(endSecondRowDiv.firstChild);
        // }  

    } else {
        gameMessage = "Let's start ROUND " + roundNumber + "!";
    }

    if (roundNumber == 4) {
        playerBank += ADDED_MONEY;
        changes = 1;
        gameMessage += "  You have an extra $400 in your bank."

        //Check if last card in first row has a card.  If it does, bring it to the next row.

        if (!didBustEarly) {
            
            setTimeout(moveCardToSecondRow, 500);
            
            //Move the last card from the first row to the second 

            // let secondRowStartDiv = document.getElementById('row-2-start');
            // let secondRowCard = document.createElement('img');
            // secondRowCard.setAttribute('id','row-2-start-img');
            // secondRowCard.src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
            // while (secondRowStartDiv.firstChild) {
            //     secondRowStartDiv.removeChild(secondRowStartDiv.firstChild);
            // }
            
            // secondRowStartDiv.appendChild(secondRowCard);

            // let endFirstRowDiv = document.getElementById('card-3');

            // while (endFirstRowDiv.firstChild) {
            //     endFirstRowDiv.removeChild(endFirstRowDiv.firstChild);
            // }  
        }
        
    } 

    gameMessage += "\n Is the next card higher or lower?";

    displayMessages ();

}

async function postHighScore () {

        // event.preventDefault();

        const lowestScoreObject = await getLowestScore ();    
    
        const lowestScore = lowestScoreObject.score
        // console.log(lowestScoreObject);
        // console.log(lowestScore);
        let playerInitials = "";
        if (playerBank > lowestScore) {
            while (playerInitials.length != 3) {
                playerInitials = prompt("You beat a High Score!  \nEnter your initials (ABC format): ").toUpperCase();
        }
        // console.log(playerInitials);
        
        const newScoreObject = {
            initials: playerInitials,
            score: playerBank
        };

        const newScoreToPost = await addNewScore(newScoreObject);
        updateTable(newScoreToPost);
    }

        

        // await deleteLowestScore();
        
        // await getScores();
    }

function moveCardToSecondRow () {
    let secondRowStartDiv = document.getElementById('row-2-start');
    let secondRowCard = document.createElement('img');
    secondRowCard.setAttribute('id','row-2-start-img');
    secondRowCard.src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
    while (secondRowStartDiv.firstChild) {
        secondRowStartDiv.removeChild(secondRowStartDiv.firstChild);
    }
            
    secondRowStartDiv.appendChild(secondRowCard);

    let endFirstRowDiv = document.getElementById('card-3');

    while (endFirstRowDiv.firstChild) {
        endFirstRowDiv.removeChild(endFirstRowDiv.firstChild);
    }  
}

function moveCardToTopRow () {
    let bigBetStartDiv = document.getElementById('row-3-start');
    let bigBetCard = document.createElement('img');
    bigBetCard.setAttribute('id', 'row-3-start-img');
    bigBetCard.src = "./cards/" + cardBoard[roundNumber - 1] + ".png"
    while (bigBetStartDiv.firstChild) {
        bigBetStartDiv.removeChild(bigBetStartDiv.firstChild);
    }
        
    bigBetStartDiv.appendChild(bigBetCard);

    let endSecondRowDiv = document.getElementById('card-6');

    while (endSecondRowDiv.firstChild) {
        endSecondRowDiv.removeChild(endSecondRowDiv.firstChild);
    }     
}

function moveCardEarly () {
    let secondRowStartDiv = document.getElementById('row-2-start');
    let secondRowCard = document.createElement('img');
    secondRowCard.setAttribute('id', 'row-2-start-img');
    secondRowCard.src = "./cards/" + cardBoard[tempRound - 1] + ".png"
            
    while (secondRowStartDiv.firstChild) {
        secondRowStartDiv.removeChild(secondRowStartDiv.firstChild);
    }
            
    secondRowStartDiv.appendChild(secondRowCard);

    let endCardDiv = document.getElementById('card-' + (tempRound - 1));

    while (endCardDiv.firstChild) {
        endCardDiv.removeChild(endCardDiv.firstChild);
    }  

}

//Database Control

const BASE_URL = 'http://localhost:8080';

const getScores = async () => {
    try {
      const response = await axios.get(`${BASE_URL}/scores`);
  
      const scores = response.data;
  
    //   console.log(`GET: Here's the list of scores`, scores);
  
      return scores;
    } catch (errors) {
      console.error(errors);
    }
  };

const getLowestScore = async () => {
    try {
        const response = await axios.get(`${BASE_URL}/scores/lowest`);
    
        const lowestScore = response.data;
    
        console.log(`GET: Here's the lowest score`, lowestScore);
    
        return lowestScore;
      } catch (errors) {
        console.error(errors);
      }
    };

//Create score method (export)
const addNewScore = async score => {
    try {
      const response = await axios.post(`${BASE_URL}/scores`, score);
      const newScore = response.data;
      
      console.log(`Added a new Score!`, newScore);
      
      return newScore;
    } catch (errors) {
      console.error(errors);
    }
  };

// //(export)
// const deleteLowestScore = async () => {
//     try {
//       const response = await axios.delete(`${BASE_URL}/scores/`);
//       console.log(`Deleted lowest score: `);
  
//       return response.data;
//     } catch (errors) {
//       console.error(errors);
//     }
//   };

const initDatabase = async () => {
    updateTable(await getScores ());
  };

const createDatabaseRow = entry => {
    const tableElementRow = document.createElement('tr');
    const tableElementInitials = document.createElement('td');
    const tableElementScore = document.createElement('td');

    tableElementInitials.appendChild(document.createTextNode(entry.initials));
    tableElementScore.appendChild(document.createTextNode(entry.score));

    // console.log(tableElementInitials)
    tableElementRow.appendChild(tableElementInitials);
    tableElementRow.appendChild(tableElementScore);

    // console.log(tableElementRow)
    return tableElementRow;
    
  };

const updateTable = tableRows => {
    const scoreTable = document.getElementById('score-table');

    if (Array.isArray(tableRows) && tableRows.length > 0) {
        tableRows.map(tableRow => {
            scoreTable.appendChild(createDatabaseRow(tableRow));
        });
    } else if (tableRows) {
        scoreTable.appendChild(createDatabaseRow(tableRows));
    }
  }


  
  



