package it.exolab.aero.rest.endpoint;

import it.exolab.aero.airport_01Model.dto.FlightRouteDto;
import it.exolab.aero.airport_01Model.models.entities.FlightRoute;
import it.exolab.aero.service.controllers.FlightRouteService;
import it.exolab.aero.utils.customUtils.constants.strings.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestConstants.Airport_01Path.FLIGHT_ROUTE)
@CrossOrigin
public class FlightRouteRest{

    @Autowired
    FlightRouteService flightRouteService;

    @GetMapping("/findAll")
    public ResponseEntity<List> findAll() {
        try {
            List<FlightRoute> flightRoutes = flightRouteService.findAll();
            return new ResponseEntity<>(flightRoutes, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findById")
    public ResponseEntity<FlightRoute> findById(@RequestBody FlightRoute flightRouteInput) {
        try {
            FlightRoute flightRoute = flightRouteService.findById(flightRouteInput.getId());
            return new ResponseEntity<>(flightRoute, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new FlightRoute(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findByDepartureCity")
    public ResponseEntity<List<FlightRoute>> findByDepartureCity(@RequestBody FlightRouteDto flightRouteInput) {
        try {
            List<FlightRoute> flightRouteList = flightRouteService.findByDepartureCity(flightRouteInput);
            return new ResponseEntity<>(flightRouteList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//	@SuppressWarnings("finally")
//	@Override
//	public Response findAllFlightRoute() {
//		System.out.println("FlightRouteRest findAll, start");
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<FlightRouteEjbInterface>(FlightRouteEjbInterface.class).getEJB().findAllFlightRoute());
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
//				System.out.println("RETURN FlightRouteRest findAll, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	//									Esempio: ?idDeparture=1&idArrival=5
//	public Response findFlightRouteByAirports(
//												@QueryParam("idDeparture") Long idDepartureAirport,
//									            @QueryParam("idArrival") Long idArrivalAirport,
//									            RoleDto roleDto
//									         ) {
//		System.out.println("FlightRouteRest findFlightRouteByAirports, airports: "
//									         + idDepartureAirport + ", " + idArrivalAirport);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB()
//						.findFlightRouteByAirports(idDepartureAirport, idArrivalAirport, roleDto));
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
//				System.out.println("RETURN FlightRouteRest findFlightRouteByEmailAndPassword, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response insertFlightRoute(FlightRouteDto flightRouteDto) {
//		System.out.println("FlightRouteRest insert, flightRoute:" + flightRouteDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().insertFlightRoute(flightRouteDto));
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
//				System.out.println("RETURN FlightRouteRest insert, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response deleteFlightRoute(FlightRouteDto flightRouteDto) {
//		System.out.println("FlightRouteRest delete, flightRoute:" + flightRouteDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().deleteFlightRoute(flightRouteDto));
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
//				System.out.println("RETURN FlightRouteRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}

}
