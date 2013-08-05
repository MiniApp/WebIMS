package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for TIdTable entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.TIdTable
  * @author MyEclipse Persistence Tools 
 */

public class TIdTableDAO implements ITIdTableDAO {
	// property constants
	public static final String ID_VALUE = "idValue";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved TIdTable entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   TIdTableDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity TIdTable entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(TIdTable entity) {
		EntityManagerHelper.log("saving TIdTable instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent TIdTable entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   TIdTableDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity TIdTable entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(TIdTable entity) {
		EntityManagerHelper.log("deleting TIdTable instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(TIdTable.class,
					entity.getTable());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved TIdTable entity and return it or a copy of it to the sender. 
	 A copy of the TIdTable entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = TIdTableDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity TIdTable entity to update
	 @return TIdTable the persisted TIdTable entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public TIdTable update(TIdTable entity) {
		EntityManagerHelper.log("updating TIdTable instance", Level.INFO, null);
		try {
			TIdTable result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public TIdTable findById(String id) {
		EntityManagerHelper.log("finding TIdTable instance with id: " + id,
				Level.INFO, null);
		try {
			TIdTable instance = getEntityManager().find(TIdTable.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all TIdTable entities with a specific property value.  
		 
		  @param propertyName the name of the TIdTable property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<TIdTable> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<TIdTable> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding TIdTable instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from TIdTable model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<TIdTable> findByIdValue(Object idValue,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_VALUE, idValue, rowStartIdxAndCount);
	}

	/**
	 * Find all TIdTable entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<TIdTable> all TIdTable entities
	 */
	@SuppressWarnings("unchecked")
	public List<TIdTable> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all TIdTable instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from TIdTable model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}