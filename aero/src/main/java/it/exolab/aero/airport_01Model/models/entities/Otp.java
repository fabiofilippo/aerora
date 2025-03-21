package it.exolab.aero.airport_01Model.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.exolab.aero.utils.customUtils.constants.db.DbConstants;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = DbConstants.OtpTable.TABLE_NAME)
public class Otp implements Serializable {

	private static final long serialVersionUID = 8100214710204079942L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = DbConstants.COLUMN_PK)
	private Long id;

	@Column(name = DbConstants.OtpTable.COLUMN_CODE)
	private String code;

	@Column(name = DbConstants.OtpTable.COLUMN_EXP_DATE)
	private LocalDateTime expirationDate;

	@ManyToOne()
	@JoinColumn(name = DbConstants.CustomerTable.COLUMN_FK,  insertable = true, updatable = true)
	private Customer customer;

	public Otp() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Otp otp)) return false;
        return Objects.equals(id, otp.id) && Objects.equals(customer, otp.customer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, customer);
	}

	@Override
	public String toString() {
		return "Otp{" +
				"id=" + id +
				", code='" + code + '\'' +
				", expirationDate=" + expirationDate +
				", customer=" + customer +
				'}';
	}
}
