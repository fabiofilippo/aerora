package it.exolab.aero.utils.customUtils.exceptions;


import it.exolab.aero.utils.customUtils.constants.strings.GeneralConstants;

public class UnforeseenException extends Exception {

	private static final long serialVersionUID = 1091732466574906437L;

	public UnforeseenException(String message) {
		super(message);
	}

	public UnforeseenException() {
		super(GeneralConstants.GENERIC_ERROR);
	}
}
