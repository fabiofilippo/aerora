package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneService {

	@Autowired
	AirplaneRepository airplaneRepository;

	private static final String CLASSNAME = "AirplaneEjb";

	public List<Airplane> findAll() {
		return airplaneRepository.findAll();
	}

	public Airplane findById(Long id) {
		Optional<Airplane> airplane = airplaneRepository.findById(id);

		return airplane.get();
	}

//
//	@SuppressWarnings("serial")
//	@Override
//	public List<AirplaneDto> findAllAirplane() throws DBQueryException, UnforeseenException {
//		System.out.println("AirplaneEjb findAll, start");
//		try {
//			beginEntityTransaction();
//			List<Airplane> returnedAirplaneList = new AirplaneCrud().findAllAirplane(getEntityManager());
//
//			if (returnedAirplaneList.size() == 0) {
//				throw new DBQueryException(GeneralConstants.NO_RESULTS);
//			}
//			ModelToDtoConverter modelToDtoConverter = new ModelToDtoConverter();
//
//			System.out.println("RETURN AirplaneEjb findAll");
//			return new ArrayList<>() {
//				{
//					returnedAirplaneList.forEach(airplaneEntity -> add(modelToDtoConverter.airplaneDtoFactory(airplaneEntity)));
//				}
//			};
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
//	public AirplaneDto insertAirplane(AirplaneDto airplaneDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("AirplaneEjb insert, airplaneDto: " + airplaneDto);
//		try {
//			List<String> errors = new Validator().airplaneInsert(airplaneDto);
//			new ErrorsLogManager().dtoValidationErrorMessagesHandler(errors, CLASSNAME, "insertAirplane", GeneralConstants.VALIDATOR_ERROR);
//			Airplane airplaneEntity = new DtoToModelConverter().airplaneFactory(airplaneDto);
//
//			beginEntityTransaction();
//
//			Airplane insertedAirplaneEntity = new AirplaneCrud().insertAirplane(getEntityManager(), airplaneEntity);
//
//			commitEntityTransaction();
//
//			System.out.println("RETURN AirplaneEjb insert, insertedAirplane: " + insertedAirplaneEntity);
//			return new ModelToDtoConverter().airplaneDtoFactory(insertedAirplaneEntity);
//		} catch (ValidatorException e) {
//			if (e.getMessage().contains(GeneralConstants.LOGIC_VALIDATOR_ERROR)) {
//				rollbackEntityTransaction();
//			}
//			throw new ValidatorException(e.getMessage());
//		} catch (DBQueryException e) {
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
//	public AirplaneDto updateAirplane(AirplaneDto airplaneDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("AirplaneEjb update, airplaneDto: " + airplaneDto);
//		try {
//			List<String> errors = new Validator().airplaneUpdate(airplaneDto);
//			new ErrorsLogManager().dtoValidationErrorMessagesHandler(errors, CLASSNAME, "updateAirplane", GeneralConstants.VALIDATOR_ERROR);
//
//			beginEntityTransaction();
//			AirplaneCrud airplaneCrud = new AirplaneCrud();
//			Airplane foundAirplaneEntity = airplaneCrud.findAirplaneById(getEntityManager(), airplaneDto.getId());
//			Airplane airplaneEntity = new DtoToModelConverter().airplaneFactory(airplaneDto,
//																				foundAirplaneEntity.getFlightList());
//			Airplane updatedAirplaneEntity = airplaneCrud.updateAirplane(getEntityManager(), airplaneEntity);
//
//			commitEntityTransaction();
//			getEntityManager().clear();
//
//			System.out.println("RETURN AirplaneEjb update, updatedAirplane: " + updatedAirplaneEntity);
//			return new ModelToDtoConverter().airplaneDtoFactory(updatedAirplaneEntity);
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
