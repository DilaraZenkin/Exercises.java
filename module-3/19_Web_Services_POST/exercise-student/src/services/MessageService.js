import axios from 'axios';

const http = axios.create({
  baseURL: "https://te-pgh-api.azurewebsites.net/api",
  headers: {
    common: {
      APIKEY: <Your API KEY>
    }
  }
});

export default {

  get(id) {
    return http.get(`/messages/${id}`);
  }

}
