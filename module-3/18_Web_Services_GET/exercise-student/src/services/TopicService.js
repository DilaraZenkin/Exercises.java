import axios from 'axios';

const http = axios.create({
    baseURL: "https://te-pgh-api.azurewebsites.net/api",
    headers: {
        common: {
            APIKEY: '03050'
        }
    }
});

export default {
    getTopics() {
        return http.get('/topics');
    },

    getTopicsById(id) {
return http.get(`/topics/${id}`)
    }
}