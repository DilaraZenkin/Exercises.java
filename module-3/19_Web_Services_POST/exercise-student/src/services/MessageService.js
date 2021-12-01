import axios from 'axios';

const http = axios.create({
  baseURL: "https://te-pgh-api.azurewebsites.net/api",
  headers: {
    common: {
      APIKEY: 000000 // ADD YOUR API KEY HERE!
    }
  }
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  }

}
