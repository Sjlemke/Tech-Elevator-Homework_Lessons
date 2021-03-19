const shoppingList = document.getElementById('groceries');


let allItemsIncomplete = true;
const pageTitle = 'My Shopping List';
const groceries = [
  { id: 1, name: 'Oatmeal', completed: false },
  { id: 2, name: 'Milk', completed: false },
  { id: 3, name: 'Banana', completed: false },
  { id: 4, name: 'Strawberries', completed: false },
  { id: 5, name: 'Lunch Meat', completed: false },
  { id: 6, name: 'Bread', completed: false },
  { id: 7, name: 'Grapes', completed: false },
  { id: 8, name: 'Steak', completed: false },
  { id: 9, name: 'Salad', completed: false },
  { id: 10, name: 'Tea', completed: false }];


  function setPageTitle() {
  const title = document.getElementById('title');
  title.innerText = pageTitle;}


  function displayGroceries() {
  const ul = document.querySelector('ul');
  
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);});}

    document.addEventListener("DOMContentLoaded", () => {
  
      setPageTitle();
      displayGroceries();

  const tasks = document.querySelectorAll('li');

tasks.forEach((task) => {
  task.addEventListener('click', (eventObject) => {
      if (!eventObject.target.classList.contains('completed')) {
          eventObject.target.classList.add('completed');
          eventObject.target.querySelector('i').classList.add('completed');}});


  task.addEventListener('dblclick', (eventObject) => {
  if(eventObject.target.classList.contains('completed')) {
    eventObject.target.classList.remove('completed');
    eventObject.target.querySelector('i').classList.remove('completed')}})});
   
   
    const completeAll = document.getElementById('toggleAll');
    completeAll.addEventListener('click', () => {
      tasks.forEach((task) => {
        task.classList.add('completed');
        task.querySelector('i').classList.add('completed');})})})

const allComplete = document.getElementById('toggleAll');

allComplete.addEventListener('click'), () => {
    if (allItemsIncomplete === true) {
    singleRow.forEach((row) => {
      row.classList.add('completed');
      row.querySelector('i').classList.add('completed');
    }
    allItemsIncomplete = false;
    completeToggle()}
    
    singleRow.forEach((row) => {
      row.classList.remove('completed')
      row.querySelector('i').classList.remove('Completed'));
    }
    allItemsIncomplete = true;
    completeToggle();
    )


    }
  
document.addEventListener('DOMContentLoaded', () => {

  display = document.getElementById('display');
  

}