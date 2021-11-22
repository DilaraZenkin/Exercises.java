const nerdyURL = 'http://api.icndb.com/jokes/random?exclude=explicit&limitTo=nerdy';
const randomURL = 'http://api.icndb.com/jokes/random?exclude=explicit';


document.addEventListener('DOMContentLoaded', () => {
    nerdy.addEventListener('click', () => {
        
    })

    const nerdy= document.getElementById('nerdButton');
    nerdy.addEventListener('click', () => {

        fetch(nerdyURL)    //HTTP GET
        .then((response) => {
            return response.json();
        }).then((data) => {
            // Do your DOM manipulation here
            const h4 = document.querySelector('h4');
            h4.innerText = data.value.joke;

        });
    });

    const rando = document.getElementById('randomButton');
    rando.addEventListener('click', () => {

        fetch(randomURL)
        .then()
        .then()
        .catch((errorObject) => {
            console.error(errorObject);
        }))
    })

});
