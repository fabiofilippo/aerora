package it.exolab.aero.repository;

import it.exolab.aero.airport_01Model.models.entities.Airport;
import it.exolab.aero.airport_01Model.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r ")
    List<Reservation> findAll();


    Optional<Reservation> findById(Long id);

    Reservation save(Reservation reservation);

//	public Reservation insertReservation(EntityManager entityManager, Reservation reservation) throws UnforeseenException {
//		System.out.println("ReservationCRUD update, reservation: " + reservation);
//		try {
//			return entityManager.merge(reservation);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException();
//		}
//	}
//
//	public Reservation updateReservation(EntityManager entityManager, Reservation reservation) throws UnforeseenException {
//		System.out.println("ReservationCRUD update, reservation: " + reservation);
//		try {
//			return entityManager.merge(reservation);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException();
//		}
//	}
//
//	public Reservation findReservationById(EntityManager entityManager, Long idReservation) throws DBQueryException, UnforeseenException {
//		System.out.println("ReservationCRUD findReservationById, idReservation: " + idReservation);
//		try {
//			String queryString = 	"SELECT r "
//									+ "FROM Reservation r "
//									+ "WHERE r.id 	= :id "
//									;
//			Reservation returnedReservation = (Reservation) entityManager.createQuery(queryString, Reservation.class)
//										.setParameter("id", idReservation)
//											.getSingleResult();
//			System.out.println("RETURN ReservationCRUD findById, Reservation: " + returnedReservation);
//			return returnedReservation;
//		} catch (NoResultException e) {
//			throw new DBQueryException("Class ReservationCRUD -> Method findById -> Reservation is NULL");
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException();
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	public List<Reservation> findReservationByIdCustomer(EntityManager entityManager, Long idCustomer) throws DBQueryException, UnforeseenException {
//		System.out.println("ReservationCRUD findReservationByIdCustomer, idCustomer: " + idCustomer);
//		try {
//			String queryString = 	"SELECT * "
//									+ "FROM reservation r "
//									+ "WHERE r.id_customer 	= " + idCustomer
//									+ " ORDER BY r.date DESC, r.id DESC";
//			List<Reservation> returnedReservationList = (List<Reservation>) entityManager.createNativeQuery(queryString, Reservation.class).getResultList();
//			System.out.println("RETURN ReservationCRUD findReservationByIdCustomer, list: " + returnedReservationList);
//			return returnedReservationList;
//		} catch (NoResultException e) {
//			throw new DBQueryException("Class ReservationCRUD -> Method findReservationByIdCustomer -> Reservation is NULL");
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException(GeneralConstants.GENERIC_ERROR);
//		}
//	}
//
//	public Reservation deleteReservation(EntityManager entityManager, Reservation reservation) throws UnforeseenException {
//		System.out.println("ReservationCRUD delete, idReservation: " + reservation);
//		try {
//			entityManager.remove(reservation);
//			return reservation;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UnforeseenException();
//		}
//	}
}
