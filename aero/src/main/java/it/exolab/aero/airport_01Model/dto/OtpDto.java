package it.exolab.aero.airport_01Model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpDto implements Serializable {

	private static final long serialVersionUID = -4830749753056702220L;
	private String code;
	private boolean otpOk;
	private Long customerId;
}
