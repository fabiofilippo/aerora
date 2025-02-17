package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.dto.FlightRouteDto;
import it.exolab.aero.airport_01Model.models.entities.Airport;
import it.exolab.aero.airport_01Model.models.entities.FlightRoute;
import it.exolab.aero.repository.FlightRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightRouteService {
	@Autowired
	FlightRouteRepository flightRouteRepository;

	public List<FlightRoute> findAll() {
		return flightRouteRepository.findAll();
	}

	public FlightRoute findById(Long id) {
		Optional<FlightRoute> flightRoute = flightRouteRepository.findById(id);

		return flightRoute.get();
	}

	public List<FlightRoute> findByDepartureCity(FlightRouteDto flightRouteDto) {
		try {
			List<FlightRoute> flightRouteList = flightRouteRepository.findByDepartureCity(flightRouteDto.getDepartureAirportCity());
			return flightRouteList;
		} catch (Exception e) {
			throw e;
		}
	}

//	@Override
//	public List<FlightRouteDto> findAllFlightRoute(RoleDto roleDto) throws DBQueryException, UnforeseenException {
//		System.out.println("FlightRouteEjb findAll, start");
//		try {
//			beginEntityTransaction();
//			List<FlightRoute> returnedFlightRouteEntityList = new FlightRouteCrud().findAllFlightRoute(getEntityManager());
//
//			if (0 == returnedFlightRouteEntityList.size()) {
//				throw new DBQueryException(GeneralConstants.NO_RESULTS);
//			}
//
//			List<FlightRouteDto> flightRouteDtoList = new ModelsManagingUtils()
//														.generateFlightRouteDtoListWithReservableFlights(returnedFlightRouteEntityList
//																										, new ModelToDtoConverter()
//																										, new AirportProjectUtil()
//																										, null != roleDto
//																											&& DbConstants.RoleTable.ID_ADMIN == roleDto.getId());
//
//			System.out.println("RETURN FlightRouteEjb findAll " + flightRouteDtoList);
//			return flightRouteDtoList;
//		} catch (DBQueryException e) {
//			throw new DBQueryException(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException();
//		} finally {
//			getEntityManager().close();
//		}
//	}


}
