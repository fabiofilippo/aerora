package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.models.entities.Airport;
import it.exolab.aero.airport_01Model.models.entities.Reservation;
import it.exolab.aero.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public Reservation findById(Long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);

		return reservation.get();
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
