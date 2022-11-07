package io.codelex.flightplanner;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FlightService {


    private FlightRepository flightRepository;
    private AirportService airportService;

    public FlightService(FlightRepository flightRepository, AirportService airportService) {
        this.flightRepository = flightRepository;
        this.airportService = airportService;
    }

    public Flight saveFlight(AddFlightRequest flightRequest) {
        try {
            Flight flight = new Flight(flightRequest.getFrom(), flightRequest.getTo(), flightRequest.getCarrier(), flightRequest.getDepartureTime(), flightRequest.getArrivalTime());
            if (flightRepository.getFlightList().size() > 0) {
                for (Flight anyFlight : flightRepository.getFlightList()) {
                    if (anyFlight.getFrom().equals(flight.getFrom()) && anyFlight.getTo().equals(flight.getTo()) && anyFlight.getCarrier().equals(flight.getCarrier())
                            && anyFlight.getDepartureTime().equals(flight.getDepartureTime()) && anyFlight.getArrivalTime().equals(flight.getArrivalTime())) {
                        throw new ResponseStatusException(HttpStatus.CONFLICT, "That flight already exists!");
                    }
                }
            }
            if (flight.getFrom().equals(flight.getTo())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't fly to the same airport!");
            }
            if (!flight.validDates()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid departure/arrival times!");
            }
            flightRepository.saveFlight(flight);
            airportService.saveAirport(flightRequest.getFrom());
            airportService.saveAirport(flightRequest.getTo());
            return flight;
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request");
        }
    }

    public void clearFlights() {
        flightRepository.clearFlights();
    }

    public void deleteFlight(Long flightId) {
        flightRepository.deleteFlight(flightId);
    }

    public Flight fetchFlight(Long flightId) {
        try {
            return flightRepository.fetchFlight(flightId);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found!");
        }
    }


    public List<Flight> getFlightList() {
        return flightRepository.getFlightList();
    }

}