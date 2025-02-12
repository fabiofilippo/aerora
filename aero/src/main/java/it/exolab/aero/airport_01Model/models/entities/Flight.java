package it.exolab.aero.airport_01Model.models.entities;

import it.exolab.aero.utils.customUtils.constants.db.DbConstants;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


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
	private List<Reservation> reservationList;




	public Flight() {
		super();
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public FlightRoute getFlightRoute() {
		return flightRoute;
	}

	public void setFlightRoute(FlightRoute flightRoute) {
		this.flightRoute = flightRoute;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id
				+ ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", airplane=" + airplane
				+ ", price=" + price + ", flightRoute=" + flightRoute + ", reservationListSize=" + (reservationList == null ? 0 : reservationList.size()) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return
			null != obj
			&& obj instanceof Flight
			&& ((Flight) obj).getId() == this.id;
	}
}
