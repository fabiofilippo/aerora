package it.exolab.aero.service.utils;

import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.airport_01Model.models.entities.Flight;
import it.exolab.aero.airport_01Model.models.entities.FlightRoute;
import it.exolab.aero.utils.customUtils.constants.strings.GeneralConstants;

import java.util.List;


public class LogicValidator {

	public void validateNumberOfTicketBasedOnAvailableSeats (int availableSeats, int ticketNumber, List<String> errors) {
		if(availableSeats < ticketNumber) {
			errors.add("Posti disponibili: " + availableSeats
				+ ", biglietti della prenotazione: " + ticketNumber
				+ ". " + GeneralConstants.INSERT_FAILURE);
		}
	}

	public void checkIfFlightIsUpdatable (Flight flight
											, Airplane currentAirplane
											, FlightRoute currentFlightRoute
											, Airplane incomingAirplane
											, FlightRoute incomingFlightRoute
											, List<String> errors) {
		checkAirplane(flight, currentAirplane, incomingAirplane, errors);
		checkFlightRoute(flight, currentFlightRoute, incomingFlightRoute, errors);
	}

	private void checkAirplane (Flight flight, Airplane currentAirplane, Airplane incomingAirplane, List<String> errors) {
		if (currentAirplane.getId() != incomingAirplane.getId()
			&& incomingAirplane.getSeats() < currentAirplane.getSeats()) {

			}
	}

	private void checkFlightRoute (Flight flight, FlightRoute currentFlightRoute, FlightRoute incomingFlightRoute, List<String> errors) {
	}

}
