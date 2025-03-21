package it.exolab.aero.airport_01Model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TicketDto implements Serializable {

	private static final long serialVersionUID = -6464452060741936009L;

	private Long id;
	private Float price;
	private String holderName;
	private String holderSurname;
	private Long idReservation;
	private boolean validity;
	private String code;
}
