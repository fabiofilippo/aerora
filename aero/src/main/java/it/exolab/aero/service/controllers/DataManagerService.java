package it.exolab.aero.service.controllers;

import it.exolab.aero.airport_01Model.models.entities.Airplane;
import it.exolab.aero.airport_01Model.models.entities.Airport;
import it.exolab.aero.airport_01Model.models.entities.Flight;
import it.exolab.aero.airport_01Model.models.entities.FlightRoute;
import it.exolab.aero.repository.AirplaneRepository;
import it.exolab.aero.repository.AirportRepository;
import it.exolab.aero.repository.FlightRepository;
import it.exolab.aero.repository.FlightRouteRepository;
import it.exolab.aero.utils.customUtils.Algorythms;
import it.exolab.aero.utils.customUtils.classes.CustomDateUtils;
import it.exolab.aero.utils.customUtils.constants.airport_01.DataPaths;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FlushModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DataManagerService {
	@Autowired
	AirportRepository airportRep;

	@Autowired
	AirplaneRepository airplaneRep;

	@Autowired
	FlightRouteRepository flightRouteRep;

	@Autowired
	FlightRepository flightRep;

	@PersistenceContext
	EntityManager em;

	private static final String CLASSNAME = "DataManagerService";

	@Transactional
	public void setup() throws Exception {
		try {
			em.setFlushMode(FlushModeType.COMMIT);

			List<Airplane> airplaneList = airplaneRep.findAll();
			if (!airplaneList.isEmpty() && airplaneList.size() == 10) {
				while (airplaneList.size() < 225) {
					Airplane currentEntity = airplaneList.get((airplaneList.size() % 10));
					Airplane copy = Algorythms.dynamicEntityCopy(currentEntity);
					airplaneList.add(copy);
				}

				for (int index = 10; index < airplaneList.size(); index++) {
					airplaneRep.save(airplaneList.get(index));
					em.flush();
					em.clear();
				}
			}

			List<Airport> airportList = airportRep.findAll();
			if (!airportList.isEmpty() && airportList.size() == 10) {
				for (int indexPartenza = 0; indexPartenza < airportList.size(); indexPartenza++) {
					String departureName = airportList.get(indexPartenza).getAirportName();
					for (int indexArrivo = 0; indexArrivo < airportList.size(); indexArrivo++) {
						if (indexPartenza != indexArrivo) {
							String arrivalName = airportList.get(indexArrivo).getAirportName();
							if (!flightRouteRep.existsByAirportsName(departureName, arrivalName)) {
								FlightRoute flightRoute = new FlightRoute();
								flightRoute.setDepartureAirport(airportList.get(indexPartenza));
								flightRoute.setArrivalAirport(airportList.get(indexArrivo));
								flightRoute.setDistanceKm(1000F);
								flightRouteRep.save(flightRoute);
							}
						}
					}
				}
				em.flush();
				em.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Transactional
	public boolean entryFlightsByMonthAndYear(int month, int year) {
		try {
			setup();
			List<LocalDateTime> days = CustomDateUtils.getDaysAtMidnight(year, month);
			List<Airport> airportList = airportRep.findAll();
			List<Airplane> airplaneList = airplaneRep.findAll();
			for (int indexDay = 0; indexDay < days.size(); indexDay++) {
				for (int indexPartenza = 0; indexPartenza < airportList.size(); indexPartenza++) {
					for (int indexArrivo = indexPartenza + 1; indexArrivo < airportList.size(); indexArrivo++) {
						if (indexPartenza != indexArrivo) {
							Airport aeroportoPartenza = airportList.get(indexPartenza);
							Airport aeroportoArrivo = airportList.get(indexArrivo);
							Optional<FlightRoute> flightRouteA = flightRouteRep.findByAirportsName(aeroportoPartenza.getAirportName(), aeroportoArrivo.getAirportName());
							Optional<FlightRoute> flightRouteR = flightRouteRep.findByAirportsName(aeroportoArrivo.getAirportName(), aeroportoPartenza.getAirportName());
							if (flightRouteA.isPresent() && flightRouteR.isPresent()) {
								for (int numeroVoloStessoGiorno = 0; numeroVoloStessoGiorno < 5; numeroVoloStessoGiorno++) {
									LocalDateTime dataPartenza = days.get(indexDay).plusHours(numeroVoloStessoGiorno * 4);
									LocalDateTime dataArrivo = dataPartenza.plusHours(3);

									Airplane aereo = airplaneList.get((numeroVoloStessoGiorno * 2) % airplaneList.size());

									Flight voloAndata = new Flight();
									voloAndata.setAirplane(aereo);
									voloAndata.setPrice(200F);
									voloAndata.setFlightRoute(flightRouteA.get());
									voloAndata.setDepartureDate(dataPartenza);
									voloAndata.setArrivalDate(dataArrivo);
									flightRep.save(voloAndata);

									LocalDateTime dataPartenzaRitorno = dataPartenza.plusHours(2);
									LocalDateTime dataArrivoRitorno = dataPartenzaRitorno.plusHours(3);

									Flight voloRitorno = new Flight();
									voloRitorno.setAirplane(aereo);
									voloRitorno.setPrice(200F);
									voloRitorno.setFlightRoute(flightRouteR.get());
									voloRitorno.setDepartureDate(dataPartenzaRitorno);
									voloRitorno.setArrivalDate(dataArrivoRitorno);
									flightRep.save(voloRitorno);
								}
							}
						}
					}
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
