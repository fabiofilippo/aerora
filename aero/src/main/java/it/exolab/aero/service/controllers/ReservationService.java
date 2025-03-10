package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.models.entities.*;
import it.exolab.aero.repository.CustomerRepository;
import it.exolab.aero.repository.FlightRepository;
import it.exolab.aero.repository.ReservationRepository;
import it.exolab.aero.repository.TicketRepository;
import it.exolab.aero.utils.businessUtils.TicketUtils;
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
