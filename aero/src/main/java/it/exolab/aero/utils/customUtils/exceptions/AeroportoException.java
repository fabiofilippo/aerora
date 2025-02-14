package it.exolab.aero.utils.customUtils.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AeroportoException extends RuntimeException {

    public AeroportoException(String message) {
        super(message);
    }
}
