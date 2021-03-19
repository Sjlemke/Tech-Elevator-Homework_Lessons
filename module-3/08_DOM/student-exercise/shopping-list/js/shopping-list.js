// add pageTitle
const pageTitle = 'My Shopping List';
// add groceries
let groceries = ['Chips', 'Banana', 'Jelly', 'Gravy', 'Soup', 'Pasta', 'Green beans', 'Salsa', 'Water Bottles', 'Grilled Chicken']

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const thePageTitle = document.getElementById('title')
  thePageTitle.innerText = pageTitle;
}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {

  const shopping = document.getElementById('groceries')
  groceries.forEach((theGroceries) => {
    const newGrocery = document.createElement('div')
    newGrocery.setAttribute('class', 'item')
    addGrocery(newGrocery, theGroceries)
    shopping.insertAdjacentElement('beforeend', newGrocery)
  })
  }
  function addGrocery(parent, title) {
    const aTitle = document.createElement('li')
    aTitle.innerText = title;
    parent.appendChild(aTitle)
  }

  


/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const listOfItems = document.querySelectorAll('li');
  listOfItems.forEach(element => {
    element.classList.add('completed');
  });

  }


setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
