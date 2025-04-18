package it.exolab.aero.airport_01Model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDto implements Serializable {

	private static final long serialVersionUID = -25953339119343120L;
	private Object data;
	private String successMessage;
	private String warningMessage;
	private String errorMessage;
	private int status;
	private boolean state;

}
