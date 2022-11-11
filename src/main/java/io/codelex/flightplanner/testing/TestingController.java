package io.codelex.flightplanner.testing;

import io.codelex.flightplanner.flights.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing-api/")
public class TestingController {

    private FlightService service;

    public TestingController(FlightService service) {
        this.service = service;
    }

    @PostMapping("/clear")
    @ResponseStatus(HttpStatus.OK)
    public void clear() {
        service.clearFlights();
    }

}

