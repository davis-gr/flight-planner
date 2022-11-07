package io.codelex.flightplanner;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AirportService {

    private AirportRepository repository;

    public AirportService(AirportRepository repository) {
        this.repository = repository;
    }

    public List<Airport> getAirport(String search) {
        try {
            return repository.getAirport(search.trim().toLowerCase());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Airport not found!");
        }
    };
    public void saveAirport(Airport airport) {
        repository.saveAirport(airport);
    }

}
