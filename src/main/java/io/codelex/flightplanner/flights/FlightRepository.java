package io.codelex.flightplanner.flights;

import io.codelex.flightplanner.flights.objects.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class FlightRepository {


    private List<Flight> flightList = new ArrayList<>();

    public FlightRepository() {
    }

    public synchronized void saveFlight(Flight flight) {
        flightList.add(flight);
    }

    public synchronized void deleteFlight(Long flightId) {
        flightList.removeIf(flight -> flight.getId().equals(flightId));
    }

    public Flight fetchFlight(Long flightId) {
        return flightList.stream().filter(f -> Objects.equals(f.getId(), flightId)).toList().get(0);
    }

    public void clearFlights() {
        flightList.clear();
    }

    public synchronized List<Flight> getFlightList() {
        return flightList;
    }
}
