package com.techelevator.services;

import com.techelevator.model.Hotel;
import com.techelevator.model.Reservation;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Random;

public class HotelService {

	private final String API_BASE_URL;
	private final String API_KEY;
	private final ConsoleService console;
	private RestTemplate restTemplate = new RestTemplate();

	public HotelService(String apiURL, String apiKey, ConsoleService cs) {
		API_BASE_URL = apiURL;
		API_KEY = apiKey;
		console = cs;
	}

	/**
	 * Create a new reservation in the hotel reservation system
	 *
	 * @param newReservation
	 * @return Reservation
	 */
	public Reservation addReservation(String newReservation) {
		// TODO: Implement method
		// https://te-pgh-api.azurewebsites.net/api/reservations?apikey=3007
		String url = API_BASE_URL + "reservations?apikey=" + API_KEY;

		// Set up Headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Set up Body
		Reservation javaObject = makeReservationObjectFromCSV(newReservation);
		HttpEntity<Reservation> request = new HttpEntity<Reservation>(javaObject, headers);

		Reservation completedReservation = null;

		try {
			completedReservation = restTemplate.postForObject(url, request, Reservation.class);
		} catch (RestClientResponseException e) {
			// Got a response, but it was 4xx or 5xx
			console.printError("Something went wrong!" + e.getRawStatusCode());
			console.printError(e.getStatusText());
		} catch (ResourceAccessException e) {
			// Never got a response :( Forever alone
			console.printError("Server is down!");
		}

		return completedReservation;
	}

	/**
	 * Updates an existing reservation by replacing the old one with a new
	 * reservation
	 *
	 * @param CSV
	 * @return
	 */
	public Reservation updateReservation(String CSV) {
		// TODO: Implement method
		Reservation updatedReservation = makeReservationObjectFromCSV(CSV);

		//https://te-pgh-api.azurewebsites.net/api/reservations/706?apikey=3007
		String url = API_BASE_URL + "reservations/" + updatedReservation.getId() + "?apikey=" + API_KEY;

		// Headers
		HttpHeaders h = new HttpHeaders();
		h.setContentType(MediaType.APPLICATION_JSON);

		// Request Entity (Header + Body)
		HttpEntity<Reservation> request = new HttpEntity<>(updatedReservation, h);

		try {
			restTemplate.put(url, request);
		} catch (RestClientResponseException e) {
			// Response was 4xx or 5xx
			updatedReservation = null;
		} catch (ResourceAccessException e) {
			// No response at all
			console.printError("Server is dahn!");
			updatedReservation = null;
		}
		return updatedReservation;
	}

	/**
	 * Delete an existing reservation
	 *
	 * @param id
	 */
	public void deleteReservation(int id) {
		// TODO: Implement method
		// https://te-pgh-api.azurewebsites.net/api/reservations/706?apikey=3007
		String url = API_BASE_URL + "reservations/" + id + "?apikey=" + API_KEY;

		try {
			restTemplate.delete(url);
		} catch (RestClientResponseException e) {
			console.printError("Didn't work! -- " + e.getRawStatusCode());
			console.printError(e.getStatusText());
		}
	}

	/* DON'T MODIFY ANY METHODS BELOW */

	/**
	 * List all hotels in the system
	 *
	 * @return
	 */
	public Hotel[] listHotels() {
		Hotel[] hotels = null;
		try {
			hotels = restTemplate.getForObject(API_BASE_URL + "hotels?apikey=" + API_KEY, Hotel[].class);
		} catch (RestClientResponseException ex) {
			// handles exceptions thrown by rest template and contains status codes
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			// i/o error, ex: the server isn't running
			console.printError(ex.getMessage());
		}
		return hotels;
	}

	/**
	 * Get the details for a single hotel by id
	 *
	 * @param id
	 * @return Hotel
	 */
	public Hotel getHotel(int id) {
		Hotel hotel = null;
		try {
			hotel = restTemplate.getForObject(API_BASE_URL + "hotels/" + id + "?apikey=" + API_KEY, Hotel.class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return hotel;
	}

	/**
	 * List all reservations in the hotel reservation system
	 *
	 * @return Reservation[]
	 */
	public Reservation[] listReservations() {
		Reservation[] reservations = null;
		try {
			reservations = restTemplate.getForObject(API_BASE_URL + "reservations?apikey=" + API_KEY, Reservation[].class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservations;
	}

	/**
	 * List all reservations by hotel id.
	 *
	 * @param hotelId
	 * @return Reservation[]
	 */
	public Reservation[] listReservationsByHotel(int hotelId) {
		Reservation[] reservations = null;
		try {
			reservations = restTemplate.getForObject(API_BASE_URL + "/hotels/" + hotelId + "/reservations?apikey=" + API_KEY,
					Reservation[].class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservations;
	}

	/**
	 * Find a single reservation by the reservationId
	 *
	 * @param reservationId
	 * @return Reservation
	 */
	public Reservation getReservation(int reservationId) {
		Reservation reservation = null;
		try {
			reservation = restTemplate.getForObject(API_BASE_URL + "reservations/" + reservationId + "?apikey=" + API_KEY, Reservation.class);
		} catch (RestClientResponseException ex) {
			console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
		} catch (ResourceAccessException ex) {
			console.printError(ex.getMessage());
		}
		return reservation;
	}

	private Reservation makeReservationObjectFromCSV(String CSV) {
		String[] parsed = CSV.split(",");

		// invalid input (
		if (parsed.length < 5 || parsed.length > 6) {
			return null;
		}

		// Add method does not include an id and only has 5 strings
		if (parsed.length == 5) {
			// Create a string version of the id and place into an array to be concatenated
			String[] withId = new String[6];
			String[] idArray = new String[] { new Random().nextInt(1000) + "" };
			// place the id into the first position of the data array
			System.arraycopy(idArray, 0, withId, 0, 1);
			System.arraycopy(parsed, 0, withId, 1, 5);
			parsed = withId;
		}

		return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
				parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
	}

}
