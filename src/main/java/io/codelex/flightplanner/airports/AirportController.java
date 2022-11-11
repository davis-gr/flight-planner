package io.codelex.flightplanner.airports;

import io.codelex.flightplanner.airports.objects.Airport;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class AirportController {

    private AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping("/airports")
    public List<Airport> getAirport(@RequestParam String search) {
        return service.getAirport(search);
    }

}
