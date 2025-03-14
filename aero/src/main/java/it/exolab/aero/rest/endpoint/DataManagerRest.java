package it.exolab.aero.rest.endpoint;

import it.exolab.aero.airport_01Model.dto.EntryDataDto;
import it.exolab.aero.airport_01Model.dto.ResponseDto;
import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.service.controllers.AirplaneService;
import it.exolab.aero.service.controllers.DataManagerService;
import it.exolab.aero.service.controllers.FileService;
import it.exolab.aero.utils.customUtils.constants.strings.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(RestConstants.Airport_01Path.DATA_MANAGER)
@CrossOrigin
public class DataManagerRest {

    @Autowired
    DataManagerService dataManagerService;

    @PostMapping(RestConstants.Airport_01Path.ENTRY_DATA)
    public ResponseDto findAll(@RequestBody EntryDataDto entryData) {
        ResponseDto response = new ResponseDto();
        response.setStatus(500);
        try {
            boolean esito = dataManagerService.entryFlightsByMonthAndYear(entryData.getMese(), entryData.getAnno());
            response.setStatus(200);
            response.setData(esito);
            response.setState(true);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            response.setErrorMessage(e.getMessage());
            return response;
        }
    }















//	@SuppressWarnings("finally")
//	@Override
//	public Response findAllAirplane() {
//		System.out.println("AirplaneRest findAll, start");
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<AirplaneEjbInterface>(AirplaneEjbInterface.class).getEJB().findAllAirplane());
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
//				System.out.println("RETURN AirplaneRest findAll, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response insertAirplane(AirplaneDto airplaneDto) {
//		System.out.println("AirplaneRest insert, airplane:" + airplaneDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<AirplaneEjbInterface>(AirplaneEjbInterface.class).getEJB().insertAirplane(airplaneDto));
//				responseStatus = Status.OK;
//				System.out.println("RETURN AirplaneRest insert, DTO:" + responseDto);
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
//				System.out.println("RETURN AirplaneRest insert, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response deleteAirplane(AirplaneDto airplaneDto) {
//		System.out.println("AirplaneRest delete, airplane:" + airplaneDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto, new EJBFactory<CommonControllerEjbInterface>(CommonControllerEjbInterface.class).getEJB().deleteAirplane(airplaneDto));
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
//				System.out.println("RETURN AirplaneRest delete, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
//
//	@SuppressWarnings("finally")
//	@Override
//	public Response updateAirplane(AirplaneDto airplaneDto) {
//		System.out.println("AirplaneRest update, airplane:" + airplaneDto);
//
//		ResponseDto responseDto = new ResponseDto();
//		Status responseStatus = Status.INTERNAL_SERVER_ERROR;
//			try {
//				new RestUtils().generateOkDto(responseDto,  new EJBFactory<AirplaneEjbInterface>(AirplaneEjbInterface.class).getEJB().updateAirplane(airplaneDto));
//				responseStatus = Status.OK;
//				System.out.println("RETURN AirplaneRest update, DTO:" + responseDto);
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
//				System.out.println("RETURN AirplaneRest update, DTO:" + responseDto);
//				return Response.status(responseStatus).entity(responseDto).build();
//			}
//	}
}
