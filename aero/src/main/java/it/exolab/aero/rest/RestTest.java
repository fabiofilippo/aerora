package it.exolab.aero.rest;

import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.service.controllers.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestTest {

    @Autowired
    AirplaneService airplaneService;

    @GetMapping("/")
    public String test() {
        return "Yeeee";
    }

    @GetMapping("/db")
    public ResponseEntity<HttpStatus> findAll() {
        try {
            List<Airplane> airplanes = airplaneService.findAll();
            System.out.println(airplanes);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
