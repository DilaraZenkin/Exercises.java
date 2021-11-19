const nerdyURL = 'http://api.icndb.com/jokes/random?exclude=explicit&limitTo=nerdy';
const randomURL = 'http://api.icndb.com/jokes/random?exclude=explicit';
const kanyeURL = 'https://api.kanye.rest/';

document.addEventListener('DOMContentLoaded', () => {
    const nerdyBtn = document.getElementById('nerdButton');
    const randoBtn = document.getElementById('randomButton');
    const message  = document.getElementById('message');

    nerdyBtn.addEventListener('click', (event) => {

        console.log('1');

        fetch(kanyeURL)             // returns Promise object
        .then((response) => {
            console.log('2');
            return response.json(); // returns Promise object, too
        })
        .then((data) => {
            // DOM Manipulation
            console.log('3');
            message.innerText = data.quote;
        })
        .catch((err) => {
            alert('There was a problem retrieving the Chuck quote!');
            console.error(err);
        }); 

        console.log('4');
    });

    randoBtn.addEventListener('click', () => {
        // Promises need .then() functions, so you know what to do when data is ready
        fetch(randomURL)              // fetch() returns Promise
        .then((response) => {         // Entire HTTP Response
            return response.json();   // .json() returns Promise
        }).then((data) => {                        // FINALLY have some JSON data
            message.innerText = data.value.joke;   // DOM manipulation
        })
        .catch((err) => {
            alert('There was a problem retrieving the Chuck quote!');
            console.error(err);
        }); 

    });

});