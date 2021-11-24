<template>
    <div class="main">
        <!-- HTML goes here -->
        <h2>Product reviews for {{ productName }}</h2> <!-- One-way data binding-->
        <p class="description" {{ description }}></p> <!--from the data to the view-->

        <div class="well-display">
    <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
    </div>

    <div class="well">
        <span class="amount">{{ numberOfOneStars }}</span>
        1 Star Review{{ numberOfOneStars === 1 ? '' : 's'}}
    </div>

    <div class="well">
        <span class="amount">{{ numberOfTwoStars }}</span>
        2 Star Review{{ numberOfTwoStars === 1 ? '' : 's'}}
    </div>

    <div class="well">
        <span class="amount">{{ numberOfThreeStars }}</span>
        3 Star Review{{ numberOfThreeStars === 1 ? '' : 's'}}
    </div>

    <div class="well">
        <span class="amount">{{ numberOfFourStars }}</span>
        4 Star Review{{ numberOfFourStars === 1 ? '' : 's'}}
    </div>

    <div class="well">
        <span class="amount">{{ numberOfFiveStars }}</span>
        5 Star Review{{ numberOfFiveStars === 1 ? '' : 's'}}
    </div>
</div>

    <div class="review" v-for="r in reviews" v-bind:key="r.id">
        <h4>{{ r.reviewer }}</h4>
        <div class="rating"> 
            <img class="ratingStar" v-for="n in r.rating" v-bind:key="n" src="../assets/star.png"/>
         </div>
        <h3> {{ r.title }} </h3>
        <p> {{ r.review }} </p>
</div>
        </div>
</template>

<script>
// JavaScript

export default {
    data() {
        return {
            productName: 'Cigar Parties for Dummies',
            description: 'Host and plan bla bla bla',
            reviews: [ 
                {
                    reviewer: 'Malcolm Gladwell',
                    title: 'What a book!',
                    review:"It's a book!",
                    rating:3
                },
                {
                    reviewer: 'Tom',
                    title: 'What a book!',
                    review:"It's  still a book!",
                    rating:3

                }
            ]
        };
    },
    computed : {
        averageRating() {
            const sum = this.reviews.reduce( (currentSum, review) => {
                return review.rating + currentSum;
            }, 0);

            return sum / this.reviews.length;
        },

        numberOfOneStars() {
            let oneStars = 0;
            for(let i = 0; i <this.reviews.length; i++) {
                if(this.reviews[i].rating ===1) {
                    oneStars++;
                }
            }
            return oneStars;
        },
        numberOfTwoStars() {
            let twoStarts = 0;
            for(let i in this.reviews) {
                if(this.reviews[i].rating ===2) {
                    twoStarts++;
                }
            }
            return twoStarts;
        },
        numberOfThreeStars() {
            let threeStars = 0;
            this.reviews.forEach((review) => {
                if(review.rating ===3) {
                    threeStars++;
                }
            });
            return threeStars;
        },
        numberOfFourStars() {const filteredArray = this.reviews.filter((review) => {
            return review.rating === 4;
        });
        return filteredArray.length;
    },

    numberOfFiveStars() {
        return this.reviews.reduce((counter, element) => {
            return counter + (element.rating === 5 );
        })
    },
}

</script>

<style scoped>
/*CSS goes here*/
div.main {
    margin: 1rem 0;
}
div.main div.well-display {
    display: flex;
    justify-content: space-around;
}

div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

div.main div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}

div.main div.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}

div.main div.review div.rating img {
    height: 100%;
}

div.main div.review p {
    margin: 20px;
}

div.main div.review h3 {
    display: inline-block;
}

div.main div.review h4 {
    font-size: 1rem;
}
</style>