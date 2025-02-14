package it.exolab.aero.rest;

import it.exolab.aero.airport_01Model.dto.FlightSearchDto;
import it.exolab.aero.airport_01Model.dto.ResponseDto;
import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.airport_01Model.models.entities.Flight;
import it.exolab.aero.airport_01Model.models.entities.FlightRoute;
import it.exolab.aero.service.controllers.AirplaneService;
import it.exolab.aero.service.controllers.CommonControllerService;
import it.exolab.aero.utils.customUtils.exceptions.AeroportoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestTest {

    @Autowired
    AirplaneService airplaneService;

    @Autowired
    CommonControllerService commonControllerService;

    @GetMapping("/")
    public String test() {
        return "Yeeee";
    }

    @PostMapping("/flightSearch")
    public ResponseEntity<ResponseDto> flightSearch(@RequestBody FlightSearchDto flightSearchDto) throws AeroportoException {
        ResponseDto responseDto = new ResponseDto();
        try {
            List<Flight> availableFlightList = commonControllerService.findFlight(flightSearchDto);
            responseDto.setData(availableFlightList);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (AeroportoException e) {
            e.printStackTrace();
            responseDto.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseDto.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
