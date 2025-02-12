package it.exolab.aero.service.controllers;

public class SearcherEjb {
//
//	@Override
//	public List<QueryResultDto> invokeSearcher(final String input)
//			throws ValidatorException, SearcherException, UnforeseenException {
//
//		try {
//			if (CustomStringUtils.isStringNullOrEmpty(input)) {
//				throw new ValidatorException(GeneralConstants.MISSING_DATA);
//			}
//
//			List<QueryFromSearcher> queries = new Searcher(input
//															, SearcherConstants.PRIMARY_KEYWORDS
//															, SearcherConstants.TABLE_STRUCTURE_LIST)
//													.withTheseSecondaryKeywords(SearcherConstants.SECONDARY_KEYWORDS)
//													.buildQuery();
//			List<List<?>> resultEntitiesList = new ArrayList<>();
//			List<QueryResultDto> resultDtoList = new ArrayList<>();
//			SearcherCrud searcherCrud = new SearcherCrud();
//			beginEntityTransaction();
//
//			executeQueriesAndGetResults(queries, resultEntitiesList, resultDtoList, searcherCrud);
//			convertResults(resultEntitiesList, resultDtoList);
//
//			return resultDtoList;
//		} catch (ValidatorException e) {
//			throw new ValidatorException(e.getMessage());
//		} catch (DBQueryException e) {
//			throw new SearcherException(GeneralConstants.NO_RESULTS);
//		} catch (SearcherException e) {
//			throw new SearcherException(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException();
//		} finally {
//			getEntityManager().close();
//		}
//	}
//
//	private void executeQueriesAndGetResults(List<QueryFromSearcher> queries
//											, List<List<?>> resultEntitiesList
//											, List<QueryResultDto> resultDtoList
//											, SearcherCrud searcherCrud) throws Exception {
//
//		for (QueryFromSearcher queryFromSearcher : queries) {
//			resultDtoList.add(new QueryResultDto(queryFromSearcher.getDtoType()));
//			System.out.println("Query che sto lanciando: " + queryFromSearcher.getQuery());
//			if (!stringValueOnColumnNumber(queryFromSearcher.getQuery())) {
//				try {
//					resultEntitiesList.add(searcherCrud.executeQuery(getEntityManager()
//																	, queryFromSearcher.getQuery()
//																	, queryFromSearcher.getEntityType()));
//				} catch (DBQueryException e) {
//					rollbackEntityTransaction();
//					beginEntityTransaction();
//				}
//			}
//		}
//	}
//
//	private void convertResults(List<List<?>> resultEntitiesList, List<QueryResultDto> resultDtoList) throws SearcherException {
//		ModelToDtoConverter converter = new ModelToDtoConverter();
//		for (int index = 0; index < resultEntitiesList.size(); index++) {
//			convertToRightDtoList(resultEntitiesList.get(index), resultDtoList.get(index), converter);
//		}
//	}
//
//
//	private void convertToRightDtoList(List<?> resultEntityList, QueryResultDto resultDto, ModelToDtoConverter converter) throws SearcherException {
//		if (AirplaneDto.class.equals(resultDto.getDtoType())) {
//			fillDtoListWithAirplaneDto(resultEntityList, resultDto, converter);
//		} else if (AirportDto.class.equals(resultDto.getDtoType())) {
//			fillDtoListWithAirportDto(resultEntityList, resultDto, converter);
//		} else if (CustomerDto.class.equals(resultDto.getDtoType())) {
//			fillDtoListWithCustomerDto(resultEntityList, resultDto, converter);
//		} else if (FlightDto.class.equals(resultDto.getDtoType())) {
//			fillDtoListWithFlightDto(resultEntityList, resultDto, converter);
//		} else if (FlightRouteDto.class.equals(resultDto.getDtoType())) {
//			resultDto.setDtoList(flightRouteDtoListFactory(resultEntityList, resultDto, converter));
//		} else if (ReservationDto.class.equals(resultDto.getDtoType())) {
//			fillDtoListWithReservationDto(resultEntityList, resultDto, converter);
//		} else {
//			throw new SearcherException(SearcherErrors.TYPE_NOT_RECOGNIZED + " " + resultDto.getDtoType());
//		}
//	}
//
//	private void fillDtoListWithAirplaneDto(List<?> resultEntityList
//											, QueryResultDto resultDto
//											, ModelToDtoConverter converter) {
//
//		for (Object entity : resultEntityList) {
//			resultDto.getDtoList().add(converter.airplaneDtoFactory((Airplane) entity));
//		}
//	}
//
//	private void fillDtoListWithAirportDto(List<?> resultEntityList
//											, QueryResultDto resultDto
//											, ModelToDtoConverter converter) {
//
//		for (Object entity : resultEntityList) {
//			resultDto.getDtoList().add(converter.airportDtoFactoryBasic((Airport) entity));
//		}
//	}
//
//	private void fillDtoListWithCustomerDto(List<?> resultEntityList
//											, QueryResultDto resultDto
//											, ModelToDtoConverter converter) {
//
//		for (Object entity : resultEntityList) {
//			resultDto.getDtoList().add(converter.customerDtoFactoryForReminderFlight((Customer) entity));
//		}
//	}
//
//	private void fillDtoListWithFlightDto(List<?> resultEntityList
//											, QueryResultDto resultDto
//											, ModelToDtoConverter converter) {
//
//		SeatsManager seatsManager = new SeatsManager();
//		for (Object entity : resultEntityList) {
//			resultDto.getDtoList().add(converter.flightDtoFactoryForAdmin((Flight) entity, seatsManager.countAvailableSeats((Flight) entity)));
//		}
//	}
//
//	private void fillDtoListWithReservationDto(List<?> resultEntityList
//												, QueryResultDto resultDto
//												, ModelToDtoConverter converter) {
//
//		for (Object entity : resultEntityList) {
//			resultDto.getDtoList().add(converter.reservationDtoFactory((Reservation) entity));
//		}
//	}
//
//	private List<FlightRouteDto> flightRouteDtoListFactory(List<?> resultEntityList
//															, QueryResultDto resultDto
//															, ModelToDtoConverter converter) {
//
//		return new ModelsManagingUtils()
//					.generateFlightRouteDtoListWithReservableFlights((List<FlightRoute>) resultEntityList
//																	, converter
//																	, new AirportProjectUtil()
//																	, true);
//	}
//
//	private boolean stringValueOnColumnNumber(String query) {
//		String[] splittedQuery = query.split(" ");
//		for (int index = 0; index < splittedQuery.length;) {
//			if ((splittedQuery[index].equals("WHERE")
//				|| splittedQuery[index].equals("AND")
//				|| splittedQuery[index].equals("OR"))
//				&& isNumericClass(getClassOfCurrentColumn(splittedQuery[index + 1]))) {
//
//				if (!CustomStringUtils.isStringParsableToNumber(splittedQuery[index + 3])) {
//					return true;
//				} else {
//					index+= 4;
//				}
//			} else {
//				index++;
//			}
//		}
//		return false;
//	}
//
//	private Class<?> getClassOfCurrentColumn(String columnName) {
//		return SearcherConstants.TABLE_STRUCTURE_LIST.stream()
//	               .flatMap(table -> table.getColumns().entrySet().stream())
//	               .filter(column -> column.getKey().equals(columnName))
//	               .map(Entry::getValue)
//	               .findFirst()
//	               .orElse(null);
//	}
//
//	private boolean isNumericClass(Class<?> classType) {
//		return classType.equals(Integer.class)
//				|| classType.equals(Float.class)
//				|| classType.equals(Byte.class)
//				|| classType.equals(Long.class)
//				|| classType.equals(Double.class);
//	}
//	@SuppressWarnings("serial")
//	private List<Class<?>> getAllEntityClass() {
//		return new ArrayList<>() {
//			{
//				for (DbTableStructure tableStructure : SearcherConstants.TABLE_STRUCTURE_LIST) {
//					add(tableStructure.getEntityClass());
//				}
//			}
//		};
//	}
//
//	private Class<?> findEntityClass(List<Class<?>> allEntityClasses, Class<?> currentClass) {
//		for ()
//	}
}
