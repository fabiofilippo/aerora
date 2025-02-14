package it.exolab.aero.utils.customUtils.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FlightException extends AeroportoException {

    public FlightException(String message) {
        super(message);
    }
}
