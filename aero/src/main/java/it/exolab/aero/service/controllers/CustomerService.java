package it.exolab.aero.service.controllers;


import it.exolab.aero.airport_01Model.models.entities.Customer;
import it.exolab.aero.airport_01Model.models.entities.Flight;
import it.exolab.aero.repository.CustomerRepository;
import it.exolab.aero.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	private static final String CLASSNAME = "CustomerEjb";

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer findById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		return customer.get();
	}

//	@Override
//	public CustomerDto findCustomerByEmailAndPassword(CustomerDto customerDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("CustomerEjb findCustomerByEmailAndPassword, customer:" + customerDto);
//		try {
//			List<String> errors = new Validator().customerEmailAndPassword(customerDto);
//
//			new ErrorsLogManager().dtoValidationErrorMessagesHandler(errors, CLASSNAME, "findCustomerByEmailAndPassword", GeneralConstants.VALIDATOR_ERROR);
//			Customer customerEntity = new DtoToModelConverter().customerFactoryForLoginVerify(customerDto);
//
//			beginEntityTransaction();
//			Customer returnedCustomerEntity = new CustomerCrud().findCustomerByEmailAndPassword(getEntityManager(), customerEntity);
//
//			CustomerDto responseCustomerDto = new ModelToDtoConverter().customerDtoFactoryBasic(returnedCustomerEntity);
//
//			System.out.println("RETURN CustomerEjb findCustomerByEmailAndPassword, customerDto:" + responseCustomerDto);
//			return responseCustomerDto;
//		} catch (ValidatorException e) {
//			throw new ValidatorException(e.getMessage());
//		} catch (DBQueryException e) {
//			throw new DBQueryException(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException(e.getMessage());
//		} finally {
//			getEntityManager().close();
//		}
//	}
//
//	@Override
//	public CustomerDto findCustomerById(CustomerDto customerDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("CustomerEjb findCustomerById, customer:" + customerDto);
//		try {
//			if (null == customerDto || null == customerDto.getId()) {
//				System.out.println("RETURN CustomerEjb findCustomerById, VALIDATOR ERROR");
//				throw new ValidatorException(GeneralConstants.MISSING_DATA);
//			}
//			beginEntityTransaction();
//			Customer foundCustomerEntity = new CustomerCrud().findCustomerById(getEntityManager(), customerDto.getId());
//
//			CustomerDto responseCustomerDto = new ModelToDtoConverter().customerDtoFactoryDetailed(foundCustomerEntity);
//
//			System.out.println("RETURN CustomerEjb findCustomerById, customerDto:" + responseCustomerDto);
//			return responseCustomerDto;
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
//	public CustomerDto insertCustomer(CustomerDto customerDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("CustomerEjb insert, customerDto:" + customerDto);
//		try {
//			List<String> errors = new Validator().customerInsert(customerDto);
//			new ErrorsLogManager().dtoValidationErrorMessagesHandler(errors, CLASSNAME, "insertCustomer", GeneralConstants.VALIDATOR_ERROR);
//
//			beginEntityTransaction();
//
//			Customer customerEntity = new DtoToModelConverter().customerFactoryForInsert(customerDto);
//			CustomerCrud crud = new CustomerCrud();
//			Customer returnedCustomerEntity = crud.insertCustomer(getEntityManager(), customerEntity);
//
//			commitEntityTransaction();
//
//			System.out.println("RETURN CustomerEjb insert, customerDto:" + returnedCustomerEntity);
//			return new ModelToDtoConverter().customerDtoFactoryBasic(returnedCustomerEntity);
//		} catch (ValidatorException e) {
//			System.out.println(e.getMessage());
//			if (e.getMessage().contains(GeneralConstants.LOGIC_VALIDATOR_ERROR)) {
//				rollbackEntityTransaction();
//			}
//			throw new ValidatorException(e.getMessage());
//		} catch (DBQueryException e) {
//			e.printStackTrace();
//			rollbackEntityTransaction();
//			throw new DBQueryException(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			rollbackEntityTransaction();
//			throw new UnforeseenException();
//		} finally {
//			getEntityManager().close();
//		}
//	}
//
//	@Override
//	public CustomerDto updateCustomer(CustomerDto customerDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("CustomerEjb update, customerDto:" + customerDto);
//		try {
//			List<String> errors = new Validator().customerUpdate(customerDto);
//			new ErrorsLogManager().dtoValidationErrorMessagesHandler(errors, CLASSNAME, "updateCustomer", GeneralConstants.VALIDATOR_ERROR);
//
//			beginEntityTransaction();
//			CustomerCrud customerCrud = new CustomerCrud();
//			Customer foundCustomerEntity = customerCrud.findCustomerById(getEntityManager(), customerDto.getId());
//			Customer customerEntity = new DtoToModelConverter().customerFactoryForUpdate(customerDto);
//
//			//Non permetto al cliente di aggiornare email e password per il momento, quindi le setto qui sulla base dei dati sul db.
//			//Anche data e citt� di nascita non sono modificabili, quindi setto tutto nel merger
//			new ModelMerger().mergeCustomerUneditableFields(customerEntity, foundCustomerEntity);
//			Customer updatedCustomerEntity = customerCrud.updateCustomer(getEntityManager(), customerEntity);
//
//			commitEntityTransaction();
//
//			System.out.println("RETURN CustomerEjb update, dto:" + updatedCustomerEntity);
//			return new ModelToDtoConverter().customerDtoFactoryBasic(updatedCustomerEntity);
//		} catch (ValidatorException e) {
//			System.out.println(e.getMessage());
//			if (e.getMessage().contains(GeneralConstants.LOGIC_VALIDATOR_ERROR)) {
//				rollbackEntityTransaction();
//			}
//			throw new ValidatorException(e.getMessage());
//		} catch (DBQueryException e) {
//			System.out.println(e.getMessage());
//			rollbackEntityTransaction();
//			throw new DBQueryException(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			rollbackEntityTransaction();
//			throw new UnforeseenException();
//		} finally {
//			getEntityManager().close();
//		}
//	}
//
//	@Override
//	public CustomerDto deleteCustomer(CustomerDto customerDto) throws ValidatorException, DBQueryException, UnforeseenException {
//		System.out.println("CustomerEjb delete, customer: " + customerDto);
//		try {
//			if (null == customerDto || null == customerDto.getId()) {
//				throw new ValidatorException(GeneralConstants.MISSING_DATA);
//			}
//
//			beginEntityTransaction();
//
//			CustomerCrud customerCrud = new CustomerCrud();
//			Customer foundCustomerEntity = customerCrud.findCustomerById(getEntityManager(), customerDto.getId());
//			Customer deletedCustomerEntity = customerCrud.deleteCustomer(getEntityManager(), foundCustomerEntity);
//
//			commitEntityTransaction();
//
//			System.out.println("RETURN CustomerEjb delete, deletedCustomer: " + deletedCustomerEntity);
//			return new ModelToDtoConverter().customerDtoFactoryBasic(deletedCustomerEntity);
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

}
