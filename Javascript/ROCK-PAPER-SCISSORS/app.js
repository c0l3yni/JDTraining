const computerChoiceDisplay = document.getElementById("computer-choice");
const userChoiceDisplay = document.getElementById("user-choice");
const resultDisplay = document.getElementById("result");
const possibleChoice = document.querySelectorAll("button");

possibleChoice.forEach(possibleChoice => possibleChoice.addEventListener('click', (e) => {
userChoice = e.target.id;
userChoiceDisplay.innerHTML = userChoice;
computerChoiceDisplay.innerHTML = computerChoice()
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
    return computerChoice
}


