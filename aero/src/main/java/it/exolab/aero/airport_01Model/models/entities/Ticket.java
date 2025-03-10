package it.exolab.aero.airport_01Model.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.exolab.aero.utils.customUtils.constants.db.DbConstants;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = DbConstants.TicketTable.TABLE_NAME)
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DbConstants.COLUMN_PK)
	private Long id;

	@Column(name = DbConstants.FlightTable.COLUMN_PRICE)
	private Float price;

	@Column(name = DbConstants.TicketTable.COLUMN_HOLDER_NAME)
	private String holderName;

	@Column(name = DbConstants.TicketTable.COLUMN_HOLDER_SURNAME)
	private String holderSurname;

	@Column(name = DbConstants.TicketTable.COLUMN_CODE)
	private String code;

	@ManyToOne()
	@JoinColumn(name = DbConstants.ReservationTable.COLUMN_FK,  insertable = true, updatable = true)
	@JsonbTransient
	@JsonIgnore
	private Reservation reservation;

	@Column(name = DbConstants.COLUMN_VALIDITY)
	private boolean validity;

	public Ticket() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getHolderSurname() {
		return holderSurname;
	}

	public void setHolderSurname(String holderSurname) {
		this.holderSurname = holderSurname;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public boolean isValidity() {
		return validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Ticket ticket = (Ticket) o;
		return validity == ticket.validity && Objects.equals(id, ticket.id) && Objects.equals(price, ticket.price) && Objects.equals(holderName,
				ticket.holderName) && Objects.equals(holderSurname, ticket.holderSurname) && Objects.equals(code, ticket.code) && Objects.equals(reservation,
				ticket.reservation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, holderName, holderSurname, code, reservation, validity);
	}

	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", price=" + price +
				", holderName='" + holderName + '\'' +
				", holderSurname='" + holderSurname + '\'' +
				", code='" + code + '\'' +
				", reservation=" + reservation +
				", validity=" + validity +
				'}';
	}
}
