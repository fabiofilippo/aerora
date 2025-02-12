package it.exolab.aero.rest.endpoint;


import it.exolab.aero.airport_01Model.models.entities.Airport;
import it.exolab.aero.service.controllers.AirportService;
import it.exolab.aero.utils.customUtils.constants.strings.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestConstants.Airport_01Path.AIRPORT)
@CrossOrigin
public class AirportRest {

    @Autowired
    AirportService airportService;

    @GetMapping("/findAll")
    public ResponseEntity<List> findAll() {
        try {
            List<Airport> airports = airportService.findAll();
            return new ResponseEntity<>(airports, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/findById")
    public ResponseEntity<Airport> findById(@RequestBody Airport airportInput) {
        try {
            Airport airport = airportService.findById(airportInput.getId());
            return new ResponseEntity<>(airport, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new Airport(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}








//	@SuppressWarnings("finally")
//	@Override
//	public Response findAllAirport() {
//		System.out.println("AirportRest findAll, start");
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<AirportEjbInterface>(AirportEjbInterface.class).getEJB().findAllAirport());
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
//				System.out.println("RETURN AirportRest findAll, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response insertAirport(AirportDto airportDto) {
//		System.out.println("AirportRest insert, airport:" + airportDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<AirportEjbInterface>(AirportEjbInterface.class).getEJB().insertAirport(airportDto));
//				responseStatus = Status.OK;
//				System.out.println("RETURN AirportRest insert, DTO:" + responseDto);
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
//				System.out.println("RETURN AirportRest insert, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response deleteAirport(AirportDto airportDto) {
//		System.out.println("AirportRest delete, airport:" + airportDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().deleteAirport(airportDto));
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
//				System.out.println("RETURN AirportRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response updateAirport(AirportDto airportDto) {
//		System.out.println("AirportRest update, airport:" + airportDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<AirportEjbInterface>(AirportEjbInterface.class).getEJB().updateAirport(airportDto));
//				responseStatus = Status.OK;
//				System.out.println("RETURN AirportRest update, DTO:" + responseDto);
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
//				System.out.println("RETURN AirportRest update, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
