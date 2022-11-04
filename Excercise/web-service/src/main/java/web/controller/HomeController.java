package web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import web.model.Location;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HomeController {
    @GetMapping("/weather/{username}/{password}")
    public ResponseEntity<Location> getWeather(@PathVariable String username, @PathVariable String password) {
        return new ResponseEntity<Location>(new Location(1, "Vietnam", 27.4f, "sun"), HttpStatus.OK);
    }
}
