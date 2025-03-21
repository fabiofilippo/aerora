package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.dto.CustomerDto;
import it.exolab.aero.airport_01Model.dto.OtpDto;
import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.airport_01Model.models.entities.Customer;
import it.exolab.aero.airport_01Model.models.entities.Otp;
import it.exolab.aero.repository.CustomerRepository;
import it.exolab.aero.repository.OtpRepository;
import it.exolab.aero.utils.customUtils.exceptions.AeroportoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OtpRepository otpRepository;

	private static final String CLASSNAME = "OtpEjb";
	private final static int CODE_LENGTH = 6;

	public OtpDto recuperoPass(CustomerDto customerDto) {
		Customer customerTrovato = customerRepository.findById(customerDto.getId()).get();

		Otp otp = new Otp();
		String code = generaOtp();
		otp.setCode(code);
		otp.setCustomer(customerTrovato);
		otp.setExpirationDate(LocalDateTime.now().plusMinutes(5L));

		otpRepository.save(otp);
		OtpDto dto = new OtpDto();
		dto.setCode(code);

		return dto;
	}

	public OtpDto verificaOtp(OtpDto otpDto) throws AeroportoException {
		LocalDateTime now = LocalDateTime.now();
		Customer customer = customerRepository.findById(otpDto.getCustomerId()).get();
		Optional<Otp> optOtp = otpRepository.findByCustomerIdAndCode(customer.getId(), otpDto.getCode());

		if (optOtp.isEmpty()) {
			throw new AeroportoException("Codice errato. Riprova");
		}
		Otp otp = optOtp.get();
		if (otp.getExpirationDate().isBefore(now)) {
			throw new AeroportoException("Codice scaduto. Richiedine un altro");
		}

		otpDto.setOtpOk(true);
		otpRepository.removeOtpsByCustomerId(otpDto.getCustomerId());

		return otpDto;
	}

	private String generaOtp() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int counter = 0; counter < CODE_LENGTH; counter++) {
			int estratto = random.nextInt(0, 10);
			sb.append(estratto);
		}
		return sb.toString();
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
