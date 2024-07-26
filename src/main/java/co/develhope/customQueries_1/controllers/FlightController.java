package co.develhope.customQueries_1.controllers;

import co.develhope.customQueries_1.entities.Flight;
import co.develhope.customQueries_1.enumerated.StatusFlightEnum;
import co.develhope.customQueries_1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    private Random random = new Random();

    @PostMapping("/provision")
    public String provisionFlights() {
        List<Flight> flights = IntStream.range(0, 50)
                .mapToObj(i -> {
                    Flight flight = new Flight();
                    flight.setDescription(generateRandomString());
                    flight.setFromAirport(generateRandomString());
                    flight.setToAirport(generateRandomString());
                    flight.setStatus(StatusFlightEnum.ON_TIME);
                    return flight;
                })
                .collect(Collectors.toList());

        flightRepository.saveAll(flights);
        return "50 flights was created on the db.";
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    private String generateRandomString() {
        return random.ints(97, 123)
                .limit(10)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }
}
