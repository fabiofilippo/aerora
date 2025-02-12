package it.exolab.aero.repository;

import it.exolab.aero.utils.customUtils.exceptions.DBQueryException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;

import java.util.List;


public class SearcherCrud {

	public List<?> executeQuery(EntityManager entityManager, String query, Class<?> entityType) throws DBQueryException {
		try {
			return entityManager.createNativeQuery(query, entityType).getResultList();
		} catch (NoResultException e) {
			throw new DBQueryException(e.getMessage());
		} catch (PersistenceException e) {
			throw new DBQueryException(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBQueryException(e.getMessage());
		}
	}
}
