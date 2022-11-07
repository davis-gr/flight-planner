package io.codelex.flightplanner;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class FlightRepository {


    private List<Flight> flightList = new ArrayList<>();

    public FlightRepository() {
    }

    public void saveFlight(Flight flight) {
        flightList.add(flight);
    }

    public void deleteFlight(Long flightId) {
        flightList.removeIf(flight -> flight.getId().equals(flightId));
    }

    public Flight fetchFlight(Long flightId) {
        return flightList.stream().filter(f -> Objects.equals(f.getId(), flightId)).toList().get(0);
    }

    public void clearFlights() {
        flightList.clear();
    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}
