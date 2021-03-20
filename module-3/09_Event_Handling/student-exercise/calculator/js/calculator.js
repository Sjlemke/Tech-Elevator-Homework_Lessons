let display;
let previous = null;
let operator = null;
let operatorClicked = false;

/**
 * Calculates the operation and updates the display.
 */
function performOperation() {
  let result;
  const current = parseNumber(display.value);
  previous = parseNumber(previous);

  switch(operator) {
    case '+' :
      result = previous + current;
    break;
    case '-' :
        result = previous - current;
    break;
    case '*' :
        result = previous * current;
    break;
    case '/' :
        result = previous / current;
    break;
  }

  display.value = result;
  operator = null;
}

/**
 * Parses the display value into a number (float or int).
 * @param {String} num 
 */
function parseNumber(num) {
  return num.includes('.') ? parseFloat(num) : parseInt(num);
}

/**
 * Capture the previous value and the clicked operator
 * so that an operation can be performed.
 */
function clickOperator(event) {
  operator = event.target.value;
  previous = display.value;
  operatorClicked = true;
}

/**
 * Captures a number click and updates the display value.
 * @param {Event} event 
 */
function clickNumber(event) {
  const val = event.target.value;

  if( operatorClicked ) {
    display.value = val;
    operatorClicked = false;
  } else {
    display.value == 0 ? display.value = val : display.value += val;
  }

}

/**
 * Resets the display value.
 */
function clear() {
  display.value = 0;
}


document.addEventListener('DOMContentLoaded', () => {
  display = document.getElementById('display');

  const allNumbers = document.querySelectorAll('.number');

  allNumbers.forEach((loopy) => {
    loopy.addEventListener('click', clickNumber)})

    const theDecimal = document.querySelector('.decimal');
    theDecimal.addEventListener('click', clickNumber);

    const allClear = document.querySelector('.all-clear');

    allClear.addEventListener('click', clear);
    const helloOperator = document.getElementsByClassName('operator');

    Array.from(helloOperator).forEach((loopy) => {
    loopy.addEventListener('click', clickOperator);

    const theAnswer = document.querySelector('.equal-sign');
    theAnswer.addEventListener('click', performOperation);
    })
  });


