package it.exolab.aero.rest.endpoint;

import it.exolab.aero.airport_01Model.dto.FlightSearchDto;
import it.exolab.aero.airport_01Model.dto.ResponseDto;
import it.exolab.aero.airport_01Model.models.entities.Flight;
import it.exolab.aero.airport_01Model.models.entities.FlightRoute;
import it.exolab.aero.service.controllers.CommonControllerService;
import it.exolab.aero.service.controllers.FlightRouteService;
import it.exolab.aero.service.controllers.FlightService;
import it.exolab.aero.utils.customUtils.constants.strings.RestConstants;
import it.exolab.aero.utils.customUtils.exceptions.AeroportoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestConstants.Airport_01Path.FLIGHT)
@CrossOrigin
public class FlightRest {

    @Autowired
    FlightService flightService;

    @Autowired
    CommonControllerService commonControllerService;


    @GetMapping("/findAll")
    public ResponseEntity<List> findAll() {
        try {
            List<Flight> flights = flightService.findAll();
            return new ResponseEntity<>(flights, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findById")
    public ResponseEntity<Flight> findById(@RequestBody Flight flightInput) {
        try {
            Flight flight = flightService.findById(flightInput.getId());
            return new ResponseEntity<>(flight, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Flight(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/flightSearch")
    public ResponseEntity<ResponseDto> flightSearch(@RequestBody FlightSearchDto flightSearchDto) throws AeroportoException {
        ResponseDto responseDto = new ResponseDto();
        try {
            List<Flight> availableFlightList = commonControllerService.findFlight(flightSearchDto);
            responseDto.setData(availableFlightList);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (AeroportoException e) {
            e.printStackTrace();
            responseDto.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseDto.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//	@SuppressWarnings("finally")
//	@Override
//	public Response findAllFlight(RoleDto roleDto) {
//		System.out.println("FlightRest findAll, start");
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<FlightEjbInterface>(FlightEjbInterface.class).getEJB().findAllFlight(roleDto));
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
//				System.out.println("RETURN FlightRest findAll, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response updateFlight(FlightDto flightDto) {
//		System.out.println("FlightRest update, flightDto: " + flightDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().updateFlight(flightDto));
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
//				System.out.println("RETURN FlightRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response insertFlight(FlightDto flightDto) {
//		System.out.println("FlightRest insert, flight: " + flightDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().insertFlight(flightDto));
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
//				System.out.println("RETURN FlightRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response deleteFlight(FlightDto flightDto) {
//		System.out.println("FlightRest delete, flight:" + flightDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().deleteFlight(flightDto));
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
//				System.out.println("RETURN FlightRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//

}
