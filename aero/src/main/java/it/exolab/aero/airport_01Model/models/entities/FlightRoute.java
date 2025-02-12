package it.exolab.aero.airport_01Model.models.entities;

import it.exolab.aero.utils.customUtils.constants.db.DbConstants;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = DbConstants.FlightRouteTable.TABLE_NAME)
public class FlightRoute implements Serializable {

	private static final long serialVersionUID = 1178727250807640255L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DbConstants.COLUMN_PK)
	private Long id;

	@Column(name = DbConstants.FlightRouteTable.COLUMN_DISTANCE)
	private Float distanceKm;

	@ManyToOne()
	@JoinColumn(name = "id_departure_airport",  nullable = false)
	private Airport departureAirport;

	@ManyToOne()
	@JoinColumn(name = "id_arrival_airport",  nullable = false)
	private Airport arrivalAirport;

	@OneToMany(mappedBy = "flightRoute", fetch = FetchType.LAZY)
	@JsonbTransient
	private List<Flight> flightList;




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(Float distanceKm) {
		this.distanceKm = distanceKm;
	}

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public List<Flight> getFlightList() {
		return flightList;
	}

	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}

	@Override
	public String toString() {
		return "FlightRoute [id=" + id + ", distanceKm=" + distanceKm + ", departureAirport=" + departureAirport
				+ ", arrivalAirport=" + arrivalAirport + ", flightList=" + (flightList == null ? 0 : flightList.size()) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return
			null != obj
			&& obj instanceof FlightRoute
			&& ((FlightRoute) obj).getId() == this.id;
	}
}
