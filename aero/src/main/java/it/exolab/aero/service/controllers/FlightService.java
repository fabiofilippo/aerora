package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.models.entities.Flight;
import it.exolab.aero.airport_01Model.models.entities.FlightRoute;
import it.exolab.aero.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService{

	@Autowired
	FlightRepository flightRepository;

	public List<Flight> findAll() {
		return flightRepository.findAll();
	}

	public Flight findById(Long id) {
		Optional<Flight> flight = flightRepository.findById(id);

		return flight.get();
	}

//	@SuppressWarnings("serial")
//	@Override
//	public List<FlightDto> findAllFlight(RoleDto roleDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("FlightEjb findAll, start");
//		try {
//			if (null == roleDto || null == roleDto.getId()) {
//				throw new ValidatorException(GeneralConstants.MISSING_DATA);
//			}
//			beginEntityTransaction();
//
//			List<Flight> returnedFlightEntityList = new FlightCrud().findAllFlight(getEntityManager());
//
//			if (0 == returnedFlightEntityList.size()) {
//				throw new DBQueryException(GeneralConstants.NO_RESULTS);
//			}
//
//			SeatsManager seatsManager = new SeatsManager();
//			ModelToDtoConverter modelToDtoConverter = new ModelToDtoConverter();
//
//			List<FlightDto> flightDtoList = new ArrayList<>() {
//				{
//					for (Flight flight : returnedFlightEntityList) {
//						if (null != flight.getDepartureDate() && flight.getDepartureDate().isAfter(LocalDateTime.now())) {
//							FlightDto flightDto = (roleDto.getId() != DbConstants.RoleTable.ID_ADMIN
//														? modelToDtoConverter
//															.flightDtoFactoryForCustomerFlightChoice(flight, seatsManager.countAvailableSeats(flight))
//														: modelToDtoConverter.flightDtoFactoryForAdmin(flight, seatsManager.countAvailableSeats(flight)));
//							add(flightDto);
//						}
//					}
//				}
//			};
//			System.out.println("RETURN FlightEjb findAll: " + flightDtoList);
//			return flightDtoList;
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
//
//	@Override
//	public FlightDto findFlightById(FlightDto flightDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("FlightEjb findFlightById, flight:" + flightDto);
//		try {
//			if (null == flightDto || null == flightDto.getId()) {
//				System.out.println("RETURN FlightEjb findFlightById, VALIDATOR ERROR");
//				throw new ValidatorException(GeneralConstants.MISSING_DATA);
//			}
//			beginEntityTransaction();
//			Flight foundFlightEntity = new FlightCrud().findFlightById(getEntityManager(), flightDto.getId());
//
//			FlightDto responseFlightDto = new ModelToDtoConverter().flightDtoFactoryForCustomerFlightChoice(foundFlightEntity, new SeatsManager().countAvailableSeats(foundFlightEntity));
//
//			System.out.println("RETURN FlightEjb findFlightById, flightDto:" + responseFlightDto);
//			return responseFlightDto;
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
