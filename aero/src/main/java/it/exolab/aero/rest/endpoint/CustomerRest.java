package it.exolab.aero.rest.endpoint;

import it.exolab.aero.airport_01Model.dto.CustomerDto;
import it.exolab.aero.airport_01Model.dto.ResponseDto;
import it.exolab.aero.airport_01Model.models.entities.Customer;
import it.exolab.aero.service.controllers.CustomerService;
import it.exolab.aero.utils.customUtils.constants.strings.RestConstants;
import it.exolab.aero.utils.customUtils.exceptions.AeroportoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestConstants.Airport_01Path.CUSTOMER)
@CrossOrigin
public class CustomerRest {

    @Autowired
    CustomerService customerService;

    @GetMapping("/findAll")
    public ResponseEntity<List> findAll() {
        try {
            List<Customer> customers = customerService.findAll();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findById")
    public ResponseEntity<Customer> findById(@RequestBody Customer customerInput) {
        try {
            Customer customer = customerService.findById(customerInput.getId());
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Customer(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findByEmailAndPassword")
    public ResponseEntity<ResponseDto> findByEmailAndPassword(@RequestBody CustomerDto customerInput) {
        ResponseDto response = new ResponseDto();
        try {
            CustomerDto customer = customerService.findByEmailAndPassword(customerInput);
            response.setData(customer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AeroportoException ex) {
            response.setErrorMessage(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseDto> register(@RequestBody CustomerDto customerInput) {
        ResponseDto response = new ResponseDto();
        try {
            CustomerDto customer = customerService.register(customerInput);
            response.setData(customer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AeroportoException ex) {
            response.setErrorMessage(ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//	@Override
//	public Response findAllCustomer() {
//		return null;
//	}

//	@SuppressWarnings("finally")
//	@Override
//	public Response findCustomerByEmailAndPassword(CustomerDto customerDto) {
//		System.out.println("CustomerRest findCustomerByEmailAndPassword, customer:" + customerDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CustomerEjbInterface>(CustomerEjbInterface.class).getEJB().findCustomerByEmailAndPassword(customerDto));
//				responseStatus = Status.OK;
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				if (e.getMessage().endsWith(GeneralConstants.NULL)) {
//					responseDto.setMessage(GeneralConstants.WRONG_CREDENTIALS);
//				} else {
//					responseDto.setMessage(e.getMessage());
//				}
//			} catch (UnforeseenException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (Exception e) {
//				e.printStackTrace();
//				responseDto.setMessage(GeneralConstants.GENERIC_ERROR);
//			} finally {
//				System.out.println("RETURN CustomerRest findCustomerByEmailAndPassword, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response findCustomerById(CustomerDto customerDto) {
//		System.out.println("CustomerRest findCustomerById, customer:" + customerDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CustomerEjbInterface>(CustomerEjbInterface.class).getEJB().findCustomerById(customerDto));
//				responseStatus = Status.OK;
//				System.out.println("RETURN CustomerRest findCustomerById, DTO:" + responseDto);
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (UnforeseenException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (Exception e) {
//				e.printStackTrace();
//				responseDto.setMessage(GeneralConstants.GENERIC_ERROR);
//			} finally {
//				System.out.println("RETURN CustomerRest findCustomerById, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response insertCustomer(CustomerDto customerDto) {
//		System.out.println("CustomerRest insert, customer:" + customerDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CustomerEjbInterface>(CustomerEjbInterface.class).getEJB().insertCustomer(customerDto));
//				responseStatus = Status.OK;
//				System.out.println("RETURN CustomerRest insert, DTO:" + responseDto);
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				if (e.getMessage().endsWith(GeneralConstants.ALREADY_EXISTS)) {
//					responseDto.setMessage("Customer " + GeneralConstants.ALREADY_EXISTS);
//				} else {
//					responseDto.setMessage(e.getMessage());
//				}
//			} catch (UnforeseenException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (Exception e) {
//				e.printStackTrace();
//				responseDto.setMessage(GeneralConstants.GENERIC_ERROR);
//			} finally {
//				System.out.println("RETURN CustomerRest insert, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response updateCustomer(CustomerDto customerDto) {
//		System.out.println("CustomerRest update, customer:" + customerDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CustomerEjbInterface>(CustomerEjbInterface.class).getEJB().updateCustomer(customerDto));
//				responseStatus = Status.OK;
//				System.out.println("RETURN CustomerRest update, DTO:" + responseDto);
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				if (e.getMessage().endsWith(GeneralConstants.ALREADY_EXISTS)) {
//					responseDto.setMessage("Customer " + GeneralConstants.ALREADY_EXISTS);
//				} else {
//					responseDto.setMessage(e.getMessage());
//				}
//			} catch (UnforeseenException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (Exception e) {
//				e.printStackTrace();
//				responseDto.setMessage(GeneralConstants.GENERIC_ERROR);
//			} finally {
//				System.out.println("RETURN CustomerRest update, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response deleteCustomer(CustomerDto customerDto) {
//		System.out.println("CustomerRest delete, airport:" + customerDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CustomerEjbInterface>(CustomerEjbInterface.class).getEJB().deleteCustomer(customerDto));
//				responseStatus = Status.OK;
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (UnforeseenException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (Exception e) {
//				e.printStackTrace();
//				responseDto.setMessage(GeneralConstants.GENERIC_ERROR);
//			} finally {
//				System.out.println("RETURN CustomerRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
}
