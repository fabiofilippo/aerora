package it.exolab.aero.service.utils;

import it.exolab.aero.airport_01Model.dto.*;
import it.exolab.aero.airport_01Model.models.entities.*;

import java.util.List;


public class DtoToModelConverter {

	public Customer customerFactoryForLoginVerify(CustomerDto customerDto) {
		Customer customerEntity = new Customer();
		customerEntity.setEmail(customerDto.getEmail());
		customerEntity.setPassword(customerDto.getPassword());
		return customerEntity;
	}

	public Customer customerFactoryForUpdate(CustomerDto customerDto) {
		Customer customerEntity = new Customer();
		customerEntity.setId(customerDto.getId());
		customerEntity.setName(customerDto.getName());
		customerEntity.setSurname(customerDto.getSurname());
		customerEntity.setPhoneNumber(customerDto.getPhoneNumber());
		customerEntity.setResidentialAddress(customerDto.getResidentialAddress());
		customerEntity.setResidenceCity(customerDto.getResidenceCity());
		customerEntity.setResidenceProvince(customerDto.getResidenceProvince());
		customerEntity.setResidencePostcode(customerDto.getResidencePostcode());
		customerEntity.setTaxCode(customerDto.getTaxCode());
		customerEntity.setIdentityCardNumber(customerDto.getIdentityCardNumber());
		Role roleEntity = new Role();
		roleEntity.setId(customerDto.getIdRole());
		customerEntity.setRole(roleEntity);
		return customerEntity;
	}

	public Customer customerFactoryForInsert(CustomerDto customerDto) {
		Customer customerEntity = customerFactoryForUpdate(customerDto);
		customerEntity.setEmail(customerDto.getEmail());
		customerEntity.setPassword(customerDto.getPassword());
		customerEntity.setBirthDate(customerDto.getBirthDate());
		customerEntity.setBirthCity(customerDto.getBirthCity());
		return customerEntity;
	}

	public Reservation reservationFactoryForInsert(ReservationDto reservationDto) {
		Reservation reservationEntity = new Reservation();
		reservationEntity.setDate(reservationDto.getDate());
		reservationEntity.setPaymentMethod(reservationDto.getPaymentMethod());
		reservationEntity.setValidity(reservationDto.getValidity());
		Flight flightEntity = new Flight();
		flightEntity.setId(reservationDto.getIdFlight());
		Customer customerEntity = new Customer();
		customerEntity.setId(reservationDto.getIdCustomer());
		return reservationEntity;
	}

	public Reservation reservationFactoryForUpdate(ReservationDto reservationDto, Customer customerEntity, Flight flightEntity, List<Ticket> ticketEntityList) {
		Reservation reservationEntity = new Reservation();
		reservationEntity.setDate(reservationDto.getDate());
		reservationEntity.setPaymentMethod(reservationDto.getPaymentMethod());
		reservationEntity.setValidity(reservationDto.getValidity());
		return reservationEntity;
	}

	public Ticket ticketFactory(TicketDto ticketDto, Reservation returnedReservationEntity, Float price) {
		Ticket ticketEntity = new Ticket();
		ticketEntity.setHolderName(ticketDto.getHolderName());
		ticketEntity.setHolderSurname(ticketDto.getHolderSurname());
		ticketEntity.setPrice(price);
		ticketEntity.setValidity(returnedReservationEntity.getValidity());
		Reservation reservationEntity = new Reservation();
		reservationEntity.setId(returnedReservationEntity.getId());
		ticketEntity.setReservation(reservationEntity);
		return ticketEntity;
	}

	public FlightRoute flightRouteFactory(FlightRouteDto flightRouteDto, Airport departureEntity, Airport arrivalEntity) {
		FlightRoute flightRouteEntity = new FlightRoute();
		flightRouteEntity.setDistanceKm(flightRouteDto.getDistanceKm());
		return flightRouteEntity;
	}

	public Airport airportFactory(AirportDto airportDto) {
		Airport airportEntity = new Airport();
		airportEntity.setCity(airportDto.getAirportCity());
		airportEntity.setId(airportDto.getId());
		airportEntity.setName(airportDto.getAirportName());
		return airportEntity;
	}

	public Airport airportFactory(AirportDto airportDto, List<FlightRoute> departure, List<FlightRoute> arrival) {
		Airport airportEntity = airportFactory(airportDto);

		return airportEntity;
	}

	public Airplane airplaneFactory(AirplaneDto airplaneDto) {
		Airplane airplaneEntity = new Airplane();
		airplaneEntity.setHoldCapacity(airplaneDto.getHoldCapacity());
		airplaneEntity.setTankCapacity(airplaneDto.getTankCapacity());
		airplaneEntity.setSeats(airplaneDto.getSeats());
		airplaneEntity.setModel(airplaneDto.getModel());

		return airplaneEntity;
	}

	public Airplane airplaneFactory(AirplaneDto airplaneDto, List<Flight> flightEntityList) {
		Airplane airplaneEntity = airplaneFactory(airplaneDto);
//		airplaneEntity.setFlightList(flightEntityList);

		return airplaneEntity;
	}

	public Flight flightFactory(FlightDto flightDto, FlightRoute flightRouteEntity, Airplane airplaneEntity, Float price) {
		Flight flightEntity = new Flight();
		flightEntity.setArrivalDate(flightDto.getArrivalDate());
		flightEntity.setDepartureDate(flightDto.getDepartureDate());
		flightEntity.setId(flightDto.getId());
		flightEntity.setPrice(price);
		return flightEntity;
	}
}
