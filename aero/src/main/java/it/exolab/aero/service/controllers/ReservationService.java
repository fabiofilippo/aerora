package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.dto.ReservationDto;
import it.exolab.aero.airport_01Model.dto.TicketDto;
import it.exolab.aero.airport_01Model.models.entities.*;
import it.exolab.aero.repository.CustomerRepository;
import it.exolab.aero.repository.FlightRepository;
import it.exolab.aero.repository.ReservationRepository;
import it.exolab.aero.repository.TicketRepository;
import it.exolab.aero.utils.businessUtils.TicketUtils;
import it.exolab.aero.utils.customUtils.exceptions.AeroportoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	CustomerRepository customerRepository;

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public Reservation findById(Long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);

		return reservation.get();
	}

	public Reservation insert(Reservation reservation) {
		Flight trovato = flightRepository.findById(reservation.getFlight().getId()).get();
		Customer customerTrovato = customerRepository.findById(reservation.getCustomer().getId()).get();

		reservation.setDate(LocalDate.now());
		reservation.setValidity(true);
		reservation.setFlight(trovato);
		reservation.setCustomer(customerTrovato);
		List<Ticket> ticketList = reservation.getTicketList();
		reservation.setTicketList(null);
		Reservation inserita = reservationRepository.save(reservation);
		inserita.setTicketList(ticketList);

		reservation.getTicketList().forEach(ticket -> {
			ticket.setValidity(true);
			ticket.setPrice(trovato.getPrice());
			ticket.setReservation(inserita);
			ticket.setCode(TicketUtils.generateCode());
			ticketRepository.save(ticket);
		});
		return inserita;
	}

	public Reservation findByTicket(String ticketCode, String surname) {
		Optional<Ticket> optionalTicket = ticketRepository.findByCodeAndHolderSurname(ticketCode, surname);
		if (optionalTicket.isEmpty()) {
			throw new AeroportoException("Non sono stati trovati biglietti con il codice ed il cognome inseriti");
		}
		return getReservationByTicket(optionalTicket.get());
	}

	public Reservation findByTicket(String ticketCode) {
		List<Ticket> tickets = ticketRepository.findByCode(ticketCode);
		if (tickets.isEmpty()) {
			throw new AeroportoException("Non sono stati trovati biglietti con il codice inserito");
		}
		if (tickets.size() > 1) {
			throw new AeroportoException("Sono stati trovati più biglietti con questo codice. Inserire anche il cognome del passeggero");
		}
		return getReservationByTicket(tickets.get(0));
	}

	private Reservation getReservationByTicket(Ticket ticket) {
		Reservation reservation = ticket.getReservation();
		reservation.setCustomer(null);

		return reservation;
	}
//
//	@Override
//	public List<ReservationDto> findReservationByIdCustomer(CustomerDto customerDto)
//			throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("ReservationEjb findReservationByIdCustomer, customer:" + customerDto);
//		try {
//			if (null == customerDto || null == customerDto.getId()) {
//				throw new ValidatorException(GeneralConstants.MISSING_DATA);
//			}
//
//			beginEntityTransaction();
//			List<Reservation> reservationEntityList = new ReservationCrud().findReservationByIdCustomer(getEntityManager(), customerDto.getId());
//			List<ReservationDto> reservationDtoList = new ArrayList<>();
//			ModelToDtoConverter modelToDtoConverter = new ModelToDtoConverter();
//
//			reservationEntityList.forEach(reservation -> reservationDtoList.add(modelToDtoConverter.reservationDtoFactory(reservation)));
//
//			System.out.println("RETURN ReservationEjb findReservationByIdCustomer, customer:" + reservationDtoList);
//			return reservationDtoList;
//		} catch (ValidatorException e) {
//			throw new ValidatorException(e.getMessage());
//		} catch (DBQueryException e) {
//			throw new DBQueryException(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException();
//		} finally {
//			getEntityManager().close();
//		}
//	}

}
