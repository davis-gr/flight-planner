package io.codelex.flightplanner.flights;

import io.codelex.flightplanner.api.AddFlightRequest;
import io.codelex.flightplanner.flights.objects.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin-api/")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PutMapping("/flights")
    @ResponseStatus(HttpStatus.CREATED)
    public Flight addFlightRequest(@Valid @RequestBody AddFlightRequest flightRequest) {
        return flightService.saveFlight(flightRequest);
    }

    @DeleteMapping("/flights/{flightId}")
    public void deleteFlight(@PathVariable Long flightId) {
        flightService.deleteFlight(flightId);
    }

    @GetMapping("/flights/{flightId}")
    public Flight fetchFlight(@PathVariable Long flightId) {
        return flightService.fetchFlight(flightId);
    }

}
