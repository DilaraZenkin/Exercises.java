// add pageTitle
let pageTitle = 'My Shopping List';
let groceries = [
  'Egg', 'Milk', 'Bread', 'Fruit', 'Soap', 'Cleaner', 'Chicken', 'Meat', 'Yogurt', 'Water'
]
// add groceries



/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
const titlePage = document.getElementById('title');
titlePage.innerText = pageTitle;

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
 function displayGroceries() {
   const groceryUl = document.getElementById('groceries');
   groceries.forEach((grocery) => {
 const groceryLi = document.createElement('li');
 groceryLi.setAttribute('key', 'groceryLi');
 groceryLi.innerText = grocery;
 groceryUl.appendChild(groceryLi);
  });
 }

// function displayGroceries() {
//   const list = document.querySelector('.shopping-list ul');

//   for (let i = 0; i < groceries.length; i++) {
//     const listItem = document.createElement('li');
//     listItem.innerText = groceries[i];
//     list.insertAdjacentElement('beforeend', listItem);
//   }

// }

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
const groceryLi = document.querySelectorAll('li');
groceryLi.forEach((grocery)=> {
  grocery.setAttribute('class', 'completed')
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
