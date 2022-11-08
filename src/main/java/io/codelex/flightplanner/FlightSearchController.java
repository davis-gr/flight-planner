package io.codelex.flightplanner;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/")
public class FlightSearchController {

    private FlightService service;

    public FlightSearchController(FlightService service) {
        this.service = service;
    }

    @PostMapping("/flights/search")
    public SearchFlightsResponse searchFlights(@Valid @RequestBody SearchFlightsRequest searchFlightsRequest) {
        return service.searchFlights(searchFlightsRequest);
    }

    @GetMapping("/flights/{flightId}")
    public Flight searchFlightById(@PathVariable Long flightId) {
        return service.fetchFlight(flightId);
    }

}
