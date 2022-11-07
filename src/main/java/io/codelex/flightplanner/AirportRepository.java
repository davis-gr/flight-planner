package io.codelex.flightplanner;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AirportRepository {

    public List<Airport> airportList = new ArrayList<>();

    public AirportRepository() {
    }

    public List<Airport> getAirport(String search) {
        return airportList.stream().filter(a -> a.getCity().toLowerCase().startsWith(search) || a.getCountry().toLowerCase().startsWith(search) || a.getAirport().toLowerCase().startsWith(search)).findFirst().stream().toList();
    }

    public List<Airport> getAirportList() {
        return airportList;
    }

    public void saveAirport(Airport airport) {
        airportList.add(airport);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AirportRepository that)) return false;
        return getAirportList().equals(that.getAirportList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAirportList());
    }
}
