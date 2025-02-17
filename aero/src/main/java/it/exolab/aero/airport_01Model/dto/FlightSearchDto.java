package it.exolab.aero.airport_01Model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FlightSearchDto implements Serializable {

    private static final long serialVersionUID = 1791293047960835926L;
    private String cityDepartureAirport;
    private String cityArrivalAirport;
    private Integer passengersNumber;
    private String departureDate;
}
