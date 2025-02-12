package it.exolab.aero.service.controllers;


import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.airport_01Model.models.entities.Airport;
import it.exolab.aero.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

	@Autowired
	AirportRepository airportRepository;

	private static final String CLASSNAME = "AirportEjb";

	public List<Airport> findAll() {
		return airportRepository.findAll();
	}

	public Airport findById(Long id) {
		Optional<Airport> airport = airportRepository.findById(id);

		return airport.get();
	}
//
//	@Override
//	public List<AirportDto> findAllAirport() throws DBQueryException, UnforeseenException {
//		System.out.println("AirportEjb findAll, start");
//		try {
//
//			beginEntityTransaction();
//
//			List<Airport> returnedAirportEntityList = new AirportCrud().findAllAirport(getEntityManager());
//			List<AirportDto> airportDtoList = new ArrayList<>();
//			ModelToDtoConverter modelToDtoConverter = new ModelToDtoConverter();
//			returnedAirportEntityList.forEach(airport
//					-> airportDtoList.add(modelToDtoConverter.airportDtoFactoryBasic(airport)));
//
//			System.out.println("RETURN AirportEjb findAll");
//			return airportDtoList;
//		} catch (DBQueryException e) {
//			e.printStackTrace();
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
//	public AirportDto insertAirport(AirportDto airportDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("AirportEjb insert, airportDto: " + airportDto);
//		try {
//			List<String> errors = new Validator().airportInsert(airportDto);
//			new ErrorsLogManager().dtoValidationErrorMessagesHandler(errors, CLASSNAME, "insertAirport", GeneralConstants.VALIDATOR_ERROR);
//			Airport airportEntity = new DtoToModelConverter().airportFactory(airportDto);
//
//			beginEntityTransaction();
//
//			Airport insertedAirportEntity = new AirportCrud().insertAirport(getEntityManager(), airportEntity);
//
//			commitEntityTransaction();
//
//			System.out.println("RETURN AirportEjb insert, insertedAirport: " + insertedAirportEntity);
//			return new ModelToDtoConverter().airportDtoFactoryBasic(insertedAirportEntity);
//		} catch (ValidatorException e) {
//			if (e.getMessage().contains(GeneralConstants.LOGIC_VALIDATOR_ERROR)) {
//				rollbackEntityTransaction();
//			}
//			throw new ValidatorException(e.getMessage());
//		} catch (DBQueryException e) {
//			e.printStackTrace();
//			rollbackEntityTransaction();
//			throw new DBQueryException(e.getMessage());
//		} catch (Exception e) {
//			rollbackEntityTransaction();
//			e.printStackTrace();
//			throw new UnforeseenException();
//		} finally {
//			getEntityManager().close();
//		}
//	}
//
//	@Override
//	public AirportDto updateAirport(AirportDto airportDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("AirportEjb update, airportDto: " + airportDto);
//		try {
//			List<String> errors = new Validator().airportUpdate(airportDto);
//			new ErrorsLogManager().dtoValidationErrorMessagesHandler(errors, CLASSNAME, "updateAirport", GeneralConstants.VALIDATOR_ERROR);
//
//			beginEntityTransaction();
//			AirportCrud airportCrud = new AirportCrud();
//			Airport foundAirportEntity = airportCrud.findAirportById(getEntityManager(), airportDto.getId());
//			Airport airportEntity = new DtoToModelConverter()
//									.airportFactory(airportDto
//													, foundAirportEntity.getArrivalAirport()
//													, foundAirportEntity.getDepartureAirport());
//			Airport updatedAirportEntity = airportCrud.updateAirport(getEntityManager(), airportEntity);
//
//			commitEntityTransaction();
//
//			System.out.println("RETURN AirportEjb update, updatedAirport: " + updatedAirportEntity);
//			return new ModelToDtoConverter().airportDtoFactoryBasic(updatedAirportEntity);
//		} catch (ValidatorException e) {
//			if (e.getMessage().contains(GeneralConstants.LOGIC_VALIDATOR_ERROR)) {
//				rollbackEntityTransaction();
//			}
//			throw new ValidatorException(e.getMessage());
//		} catch (DBQueryException e) {
//			rollbackEntityTransaction();
//			e.printStackTrace();
//			throw new DBQueryException(e.getMessage());
//		} catch (Exception e) {
//			rollbackEntityTransaction();
//			e.printStackTrace();
//			throw new UnforeseenException();
//		} finally {
//			getEntityManager().close();
//		}
//	}
}
