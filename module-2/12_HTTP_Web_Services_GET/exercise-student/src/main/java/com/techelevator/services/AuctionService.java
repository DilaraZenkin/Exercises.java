package com.techelevator.services;

import org.springframework.web.client.RestTemplate;

import com.techelevator.model.Auction;

public class AuctionService {

    public final String API_URL;
    public final String API_KEY;
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();

    public AuctionService(String apiUrl, String apiKey) {
        API_URL = apiUrl;
        API_KEY = apiKey;
    }

    public Auction[] listAllAuctions() {
        // api code here
        return restTemplate.getForObject(API_URL + "?apikey=" + API_KEY, Auction[].class);
    }

    public Auction listDetailsForAuction(int id) {
        // api code here

        return restTemplate.getForObject(API_URL + "/" + id + "?apikey=" + API_KEY, Auction.class);
    }

    public Auction[] findAuctionsSearchTitle(String title) {
        // api code here
        Auction[] auctions = restTemplate.getForObject(API_URL + "?apikey=" + API_KEY +"&title_like=" + title, Auction[].class);
        return auctions;
// https://te-pgh-api.azurewebsites.net/api/auctions?apikey=3050&title_like=Bell
    }

    public Auction[] findAuctionsSearchPrice(double price) {
        // api code here
        Auction[] auctions = restTemplate.getForObject(API_URL + "?apikey=" + API_KEY +"&currentBid_Ite=" + price, Auction[].class);
        return auctions;
    }

}
