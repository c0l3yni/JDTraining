const computerChoiceDisplay = document.getElementById("computer-choice");
const userChoiceDisplay = document.getElementById("user-choice");
const resultDisplay = document.getElementById("result");
const possibleChoice = document.querySelectorAll("button");

possibleChoice.forEach(possibleChoice => possibleChoice.addEventListener('click', (e) => {
userChoice = e.target.id;
userChoiceDisplay.innerHTML = userChoice;
computerChoiceDisplay.innerHTML = computerChoice();
resultDisplay.innerHTML = result();
}))

function computerChoice() {
    let randomizer = Math.floor(Math.random() * 3 )

    if(randomizer === 0) {
        option = "rock"
    } else if(randomizer === 1) {
        option = "paper"
    } else if(randomizer === 2) {
        option = "scissors"
    }
    return option
}

function result() {
    if (userChoice == computerChoiceDisplay.innerHTML) {
        return "tie"
    } else if (userChoiceDisplay.innerHTML == "rock" && computerChoiceDisplay.innerHTML == "scissors") {
        return "Computer LOSES"
    } else if (userChoiceDisplay.innerHTML == "paper" && computerChoiceDisplay.innerHTML == "rock") {
        return "Computer LOSES"
    } else if (userChoiceDisplay.innerHTML == "scissors" && computerChoiceDisplay.innerHTML == "paper") {
        return "Computer LOSES"
    } else if (userChoiceDisplay.innerHTML == "rock" && computerChoiceDisplay.innerHTML == "paper") {
        return "You LOSE"
    } else if (userChoiceDisplay.innerHTML == "paper" && computerChoiceDisplay.innerHTML == "scissors") {
        return "You LOSE"
    } else if (userChoiceDisplay.innerHTML == "scissors" && computerChoiceDisplay.innerHTML == "rock") {
        return "You LOSE"
    }
}
