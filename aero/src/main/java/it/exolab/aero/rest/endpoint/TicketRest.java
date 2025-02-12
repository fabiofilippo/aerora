package it.exolab.aero.rest.endpoint;

import it.exolab.aero.airport_01Model.models.entities.Airport;
import it.exolab.aero.airport_01Model.models.entities.Ticket;
import it.exolab.aero.service.controllers.AirportService;
import it.exolab.aero.service.controllers.TicketService;
import it.exolab.aero.utils.customUtils.constants.strings.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestConstants.Airport_01Path.TICKET)
@CrossOrigin
public class TicketRest {

    @Autowired
    TicketService ticketService;

    @GetMapping("/findAll")
    public ResponseEntity<List> findAll() {
        try {
            List<Ticket> tickets = ticketService.findAll();
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findById")
    public ResponseEntity<Ticket> findById(@RequestBody Ticket ticketInput) {
        try {
            Ticket ticket = ticketService.findById(ticketInput.getId());
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Ticket(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//	@SuppressWarnings("finally")
//	@Override
//	public Response deleteTicket(TicketDto ticketDto) {
//		System.out.println("TicketRest delete, ticket: " + ticketDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().deleteTicket(ticketDto));
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
//				System.out.println("RETURN TicketRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//
////	@SuppressWarnings("finally")
////	@Override
////	public Response deleteReservation(Reservation reservation) {
////		System.out.println("ReservationRest delete, reservation: " + reservation);
////
////		ResponseDto responseDto = new ResponseDto();
////		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
////			try {
////				responseDto = new EJBFactory<ReservationEjbInterface>(ReservationEjbInterface.class).getEJB().deleteReservation(reservation);
////				responseStatus = Status.OK;
////			} catch (ValidatorException e) {
////				responseDto.setMessage(e.getMessage());
////			} catch (DBQueryException e) {
////				if (e.getMessage().endsWith(GeneralConstants.VOID)) {
////					responseDto.setMessage(GeneralConstants.NO_RESULTS);
////					responseStatus = Status.OK;
////				} else {
////					responseDto.setMessage(e.getMessage());
////				}
////			} catch (Exception e) {
////				responseDto.setMessage(e.getMessage());
////			} finally {
////				System.out.println("RETURN ReservationRest delete, DTO:" + responseDto);
////				return Response.status(responseStatus).entity(responseDto).build();
////			}
////	}
//

}
