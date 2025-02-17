package it.exolab.aero.airport_01Model.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.exolab.aero.utils.customUtils.constants.db.DbConstants;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = DbConstants.FlightTable.TABLE_NAME)
public class Flight implements Serializable {

	private static final long serialVersionUID = -3460751453612533352L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DbConstants.COLUMN_PK)
	private Long id;

	@Column(name = DbConstants.FlightTable.COLUMN_DEPARTURE)
	private LocalDateTime departureDate;

	@Column(name = DbConstants.FlightTable.COLUMN_ARRIVAL)
	private LocalDateTime arrivalDate;

	@Column(name = DbConstants.FlightTable.COLUMN_PRICE)
	private Float price;

	@ManyToOne()
	@JoinColumn(name = DbConstants.AirplaneTable.COLUMN_FK,  insertable = true, updatable = true)
	private Airplane airplane;

	@ManyToOne()
	@JoinColumn(name = DbConstants.FlightRouteTable.COLUMN_FK,  insertable = true, updatable = true)
	private FlightRoute flightRoute;

	@OneToMany(mappedBy = DbConstants.FlightTable.TABLE_NAME, fetch = FetchType.LAZY)
	@JsonbTransient
	@JsonIgnore
	private List<Reservation> reservationList;

}
