package it.exolab.aero.utils.customUtils.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FlightRouteException extends AeroportoException {

    public FlightRouteException(String message) {
        super(message);
    }
}
