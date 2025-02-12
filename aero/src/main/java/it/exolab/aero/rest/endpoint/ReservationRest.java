package it.exolab.aero.rest.endpoint;


import it.exolab.aero.airport_01Model.models.entities.Customer;
import it.exolab.aero.airport_01Model.models.entities.FlightRoute;
import it.exolab.aero.airport_01Model.models.entities.Reservation;
import it.exolab.aero.service.controllers.CustomerService;
import it.exolab.aero.service.controllers.FlightRouteService;
import it.exolab.aero.service.controllers.ReservationService;
import it.exolab.aero.utils.customUtils.constants.strings.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestConstants.Airport_01Path.RESERVATION)
@CrossOrigin
public class ReservationRest {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/findAll")
    public ResponseEntity<List> findAll() {
        try {
            List<Reservation> reservations = reservationService.findAll();
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findById")
    public ResponseEntity<Reservation> findById(@RequestBody Reservation reservationInput) {
        try {
            Reservation reservation = reservationService.findById(reservationInput.getId());
            return new ResponseEntity<>(reservation, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Reservation(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//	@SuppressWarnings("finally")
//	@Override
//	public Response findAllReservation() {
//		System.out.println("ReservationRest findAll, start");
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				responseDto = new EJBFactory<ReservationEjbInterface>(ReservationEjbInterface.class).getEJB().findAllReservation();
//				responseStatus = Status.OK;
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				if (e.getMessage().endsWith(GeneralConstants.VOID)) {
//					responseDto.setMessage(GeneralConstants.NO_RESULTS);
//					responseStatus = Status.OK;
//				} else {
//					responseDto.setMessage(e.getMessage());
//				}
//			} catch (Exception e) {
//				responseDto.setMessage(e.getMessage());
//			} finally {
//				System.out.println("RETURN ReservationRest findAll, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}

//	@SuppressWarnings("finally")
//	public ResponseEntity updateReservation(ReservationDto reservationDto) {
//		System.out.println("ReservationRest update, reservationDto: " + reservationDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().updateReservation(reservationDto));
//				responseStatus = Status.OK;
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				if (e.getMessage().endsWith(GeneralConstants.VOID)) {
//					responseDto.setMessage(GeneralConstants.NO_RESULTS);
//					responseStatus = Status.OK;
//				} else {
//					responseDto.setMessage(e.getMessage());
//				}
//			} catch (UnforeseenException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (Exception e) {
//				e.printStackTrace();
//				responseDto.setMessage(GeneralConstants.GENERIC_ERROR);
//			} finally {
//				System.out.println("RETURN ReservationRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	public Response deleteReservation(ReservationDto reservationDto) {
//		System.out.println("ReservationRest delete, reservation: " + reservationDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().deleteReservation(reservationDto));
//				responseStatus = Status.OK;
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				if (e.getMessage().endsWith(GeneralConstants.VOID)) {
//					responseDto.setMessage(GeneralConstants.NO_RESULTS);
//					responseStatus = Status.OK;
//				} else {
//					responseDto.setMessage(e.getMessage());
//				}
//			} catch (Exception e) {
//				responseDto.setMessage(e.getMessage());
//			} finally {
//				System.out.println("RETURN ReservationRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	public Response insertReservation(ReservationDto reservationDto) {
//		System.out.println("ReservationRest insert, reservation: " + reservationDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().insertReservation(reservationDto));
//				responseStatus = Status.OK;
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				if (e.getMessage().endsWith(GeneralConstants.VOID)) {
//					responseDto.setMessage(GeneralConstants.NO_RESULTS);
//					responseStatus = Status.OK;
//				} else {
//					responseDto.setMessage(e.getMessage());
//				}
//			} catch (UnforeseenException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (Exception e) {
//				e.printStackTrace();
//				responseDto.setMessage(GeneralConstants.GENERIC_ERROR);
//			} finally {
//				System.out.println("RETURN ReservationRest insert, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	public Response findReservationByIdCustomer(CustomerDto customerDto) {
//		System.out.println("ReservationRest findReservationByIdCustomer, customer: " + customerDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//		try {
//			new RestUtils().generateOkDto(responseDto, new EJBFactory<ReservationEjbInterface>(ReservationEjbInterface.class).getEJB().findReservationByIdCustomer(customerDto));
//			responseStatus = Status.OK;
//		} catch (ValidatorException e) {
//			responseDto.setMessage(e.getMessage());
//		} catch (DBQueryException e) {
//			if (e.getMessage().endsWith(GeneralConstants.VOID)) {
//				responseDto.setMessage(GeneralConstants.NO_RESULTS);
//				responseStatus = Status.OK;
//			} else {
//				responseDto.setMessage(e.getMessage());
//			}
//		} catch (UnforeseenException e) {
//			responseDto.setMessage(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			responseDto.setMessage(GeneralConstants.GENERIC_ERROR);
//		} finally {
//			System.out.println("RETURN ReservationRest findReservationByIdCustomer, DTO:" + responseDto);
//			return Response.status(responseStatus).entity(responseDto).build();
//		}
//	}

//	@Override
//	public Response findReservationById(Long idReservation) {
//		System.out.println("ReservationRest findByID, start");
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				responseDto = new EJBFactory<ReservationEjbInterface>(ReservationEjbInterface.class).getEJB().findReservationById(idReservation);
//				responseStatus = Status.OK;
//			} catch (ValidatorException e) {
//				responseDto.setMessage(e.getMessage());
//			} catch (DBQueryException e) {
//				if (e.getMessage().endsWith(GeneralConstants.VOID)) {
//					responseDto.setMessage(GeneralConstants.NO_RESULTS);
//					responseStatus = Status.OK;
//				} else {
//					responseDto.setMessage(e.getMessage());
//				}
//			} catch (Exception e) {
//				responseDto.setMessage(e.getMessage());
//			} finally {
//				System.out.println("RETURN ReservationRest findById, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
}
