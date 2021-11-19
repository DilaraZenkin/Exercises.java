const omdbURL = 'http://www.omdbapi.com/?apikey=GET_AN_API_KEY&s=';

document.addEventListener('DOMContentLoaded', () => {
    const inputBox = document.getElementById('movie');
    const searchBtn = document.getElementById('btnSearch');
    const movieData = document.getElementById('movieData');
    const container = document.querySelectorAll('.container')[1];
    //container.innerHTML = '';

    searchBtn.addEventListener('click', () => {
        const searchTerm = inputBox.value;

        fetch(omdbURL)
        .then((httpResponse) => {
            return httpResponse.json();
        })
        .then((jsonData) => {
            jsonData.Search.forEach((movie) => {
                // const posterImg = document.createElement('img'); // <img />
                // posterImg.src = movie.Poster; // <img src=... />
                // container.appendChild(posterImg);
                const newRow = buildRow(movie);
                movieData.appendChild(newRow);
            });
        });


    });

});


function buildRow(data) {
    const tr = document.createElement('tr');

    const posterCell = document.createElement('td');
    const imdbCell = document.createElement('td');
    const nameCell = document.createElement('td');
    const yearCell = document.createElement('td');
    const img = document.createElement('img');

    imdbCell.innerText = data.imdbID;
    nameCell.innerText = data.Title;
    yearCell.innerText = data.Year;

    img.src = data.Poster;
    img.setAttribute('class','img-responsive');
    img.setAttribute('class','img-thumbnail');

    posterCell.setAttribute('class','col-sm-2');
    posterCell.append(img);

    tr.append(posterCell);
    tr.append(imdbCell);
    tr.append(nameCell);
    tr.append(yearCell);

    return tr; 
};
