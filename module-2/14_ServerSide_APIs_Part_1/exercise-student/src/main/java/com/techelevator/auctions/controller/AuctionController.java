package com.techelevator.auctions.controller;

import com.techelevator.auctions.DAO.AuctionDAO;
import com.techelevator.auctions.DAO.MemoryAuctionDAO;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping(path = "/auctions", method = RequestMethod.GET)
public class AuctionController {

    private AuctionDAO dao;

    public AuctionController() {
        this.dao = new MemoryAuctionDAO();
    }

    //Return a list of all auctions //add searching by title //Add searching by price
    @RequestMapping(path = "/auctions", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false, defaultValue = "") String title_like,
                              @RequestParam(required = false, defaultValue = "0") Double currentBid_lte) {
        if ((title_like != null && !title_like.equals("")) && (currentBid_lte != null && currentBid_lte > 0)) {
            return dao.searchByTitleAndPrice(title_like, currentBid_lte);
        } else if (title_like != null && !title_like.equals("")) {
            return dao.searchByTitle(title_like);
        } else if (currentBid_lte != null && currentBid_lte > 0) {
            return dao.searchByPrice(currentBid_lte);
        } else {

            return dao.list();
        }
    }

    // return a specific auction based on the value passed to it.
    @RequestMapping(path = "/auctions/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return dao.get(id);
    }

    //create a new auction for a auction id
    @RequestMapping(path = "/auctions", method = RequestMethod.POST)
    public Auction addAuctions(@RequestBody Auction auction) {
        return dao.create(auction, auction.getId());






    }
}


