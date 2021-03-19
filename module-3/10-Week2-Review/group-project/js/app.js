





let score = 0;
let setOfProblems = [];
let currentProblem = 1;

function generateProblemSet() {
    for(let i=0; i <10; i++) {
     let problem = {
            left: getRandomNumber(10),
            right:getRandomNumber(10),
            correctAnswer: null,
        
     }   
    }
}










setOfProblems.push({problem, setOfAnswers})


function displayProblem{
  const theProblem = document.getElementById('problem')  
  const problemExpression = '${setOfProblems[currentProblem-1].problem.left * ${setOfProblems[currentProblem-1]}'
  theProblem.querySelector('div.expression').innerText = problemExpression;
}

/*show the answer choices to the user */
function displayAnswers() {
    const theAnswers = document.getElementById('answers')
    const listOfAnswers = theAnswers.querySelector('ul')
    const allAnswers = listOfAnswers.querySelector('li')
   //we have all the <li> to hold the answers in the array called allAnswers
   //go through the array of <li> and assign each one the answer choices 
    const answerChoices = setOfProblems[currentProblem-1].setOfAnswers;

for(let i=0; i < allAnswers.length; i++) {
    allAnswers[i].innerText = answerChoices[i] //assign answerChoice to the corresponding element in the list items

}

}







function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
}

document.addEventListener('DOMContentLoaded', () => {
let answerListItems = document.querySelector.SelectorAll('#answers ul li')

    answerListItems.forEach((anListItem), () => {
      
    answerListItems.forEach((anListItem), () => {
        anListItem.addEventListener('click', (eventObject) => ({
        const answerPicker = parseInt(eventObject.innerText) 
        const correctAnswer = parseInt(setOfProblems[currentProblem-1].problem.correctAnswer)   
        if(answerPicked === correctAnswer) {
            score++;
        }
    })
    })

    generateProblemSet(); 
    displayProblem();
    displayAnswers();

})

}