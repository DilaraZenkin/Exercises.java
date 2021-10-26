package com.techelevator.auction;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.Auction;
import com.techelevator.services.AuctionService;

public class AppTest {
	private static final String TECH_ELEVATOR_API_KEY = "0000";
	private final AuctionService auctionService = new AuctionService(App.API_URL, TECH_ELEVATOR_API_KEY);

	@Before
	public void setUp() {
		resetData();
	}

	@AfterClass
	public static void tearDown() {
		resetData();
	}

	@Test
	public void listAllAuctions() {
		// Arrange
		Auction[] expectedAuctions = {
				new Auction(1, "Bell Computer Monitor", "4K LCD monitor from Bell Computers, HDMI & DisplayPort",
						"Queenie34", 100.39),
				new Auction(2, "Pineapple Smart Watch", "Pears with Pineapple ePhone", "Miller.Fahey", 377.44),
				new Auction(3, "Mad-dog Sneakers", "Soles check. Laces check.", "Cierra_Pagac", 125.23),
				new Auction(4, "Annie Sunglasses", "Keep the sun from blinding you", "Sallie_Kerluke4", 69.67),
				new Auction(5, "Byson Vacuum", "Clean your house with a spherical vacuum", "Lisette_Crist", 287.73),
				new Auction(6, "Fony Headphones", "Listen to music, movies, games and not bother people around you!",
						"Chester67", 267.38),
				new Auction(7, "Molex Gold Watch", "Definitely not fake gold watch", "Stuart27", 188.39) };

		// Act
		Auction[] actualAuctions = auctionService.listAllAuctions();

		// Assert

		MatcherAssert.assertThat(actualAuctions, Matchers.samePropertyValuesAs(expectedAuctions));
	}

	@Test
	public void listDetailsForAuction() {
		// Arrange
		Auction expectedAuctionOne = new Auction(1, "Bell Computer Monitor",
				"4K LCD monitor from Bell Computers, HDMI & DisplayPort", "Queenie34", 100.39);
		Auction expectedAuctionFour = new Auction(4, "Annie Sunglasses", "Keep the sun from blinding you",
				"Sallie_Kerluke4", 69.67);
		Auction expectedAuctionSeven = new Auction(7, "Molex Gold Watch", "Definitely not fake gold watch", "Stuart27",
				188.39);

		// Act
		Auction actualOne = auctionService.listDetailsForAuction(1);
		Auction actualFour = auctionService.listDetailsForAuction(4);
		Auction actualSeven = auctionService.listDetailsForAuction(7);

		// Assert
		MatcherAssert.assertThat(actualOne, Matchers.samePropertyValuesAs(expectedAuctionOne));
		MatcherAssert.assertThat(actualFour, Matchers.samePropertyValuesAs(expectedAuctionFour));
		MatcherAssert.assertThat(actualSeven, Matchers.samePropertyValuesAs(expectedAuctionSeven));
	}

	@Test
	public void findAuctionsSearchTitle() {
		// Arrange
		Auction[] expectedWatchAuctions = {
				new Auction(2, "Pineapple Smart Watch", "Pears with Pineapple ePhone", "Miller.Fahey", 377.44),
				new Auction(7, "Molex Gold Watch", "Definitely not fake gold watch", "Stuart27", 188.39) };

		// Act
		Auction[] actualWatchAuctions = auctionService.findAuctionsSearchTitle("watch");

		// Assert
		MatcherAssert.assertThat(actualWatchAuctions, Matchers.samePropertyValuesAs(expectedWatchAuctions));
	}

	@Test
	public void findAuctionsSearchTitleNotFound() {
		// Arrange

		// Act
		Auction[] actualAuctions = auctionService.findAuctionsSearchTitle("NoSuchTitle");

		// Assert
		MatcherAssert.assertThat(actualAuctions, Matchers.samePropertyValuesAs(new Auction[0]));
	}

	@Test
	public void findAuctionsSearchPrice() {
		// Arrange
		Auction[] expectedAuctions = {
				new Auction(1, "Bell Computer Monitor", "4K LCD monitor from Bell Computers, HDMI & DisplayPort",
						"Queenie34", 100.39),
				new Auction(3, "Mad-dog Sneakers", "Soles check. Laces check.", "Cierra_Pagac", 125.23),
				new Auction(4, "Annie Sunglasses", "Keep the sun from blinding you", "Sallie_Kerluke4", 69.67) };

		// Act
		Auction[] actualAuctions = auctionService.findAuctionsSearchPrice(150);

		// Assert
		MatcherAssert.assertThat(actualAuctions, Matchers.samePropertyValuesAs(expectedAuctions));
	}

	@Test
	public void findAuctionsSearchPriceNotFound() {
		// Arrange

		// Act
		Auction[] actualAuctions = auctionService.findAuctionsSearchPrice(0.0);

		// Assert
		MatcherAssert.assertThat(actualAuctions, Matchers.samePropertyValuesAs(new Auction[0]));
	}

	private static void resetData() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(App.API_URL + "/resetdata?apikey=" + TECH_ELEVATOR_API_KEY, Null.class);
	}

}
