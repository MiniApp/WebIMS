package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsScoreboardScoreuser entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsScoreboardScoreuser
  * @author MyEclipse Persistence Tools 
 */

public class WebimsScoreboardScoreuserDAO implements
		IWebimsScoreboardScoreuserDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsScoreboardScoreuser entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsScoreboardScoreuserDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsScoreboardScoreuser entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsScoreboardScoreuser entity) {
		EntityManagerHelper.log("saving WebimsScoreboardScoreuser instance",
				Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsScoreboardScoreuser entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsScoreboardScoreuserDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsScoreboardScoreuser entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsScoreboardScoreuser entity) {
		EntityManagerHelper.log("deleting WebimsScoreboardScoreuser instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					WebimsScoreboardScoreuser.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsScoreboardScoreuser entity and return it or a copy of it to the sender. 
	 A copy of the WebimsScoreboardScoreuser entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsScoreboardScoreuserDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsScoreboardScoreuser entity to update
	 @return WebimsScoreboardScoreuser the persisted WebimsScoreboardScoreuser entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsScoreboardScoreuser update(WebimsScoreboardScoreuser entity) {
		EntityManagerHelper.log("updating WebimsScoreboardScoreuser instance",
				Level.INFO, null);
		try {
			WebimsScoreboardScoreuser result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsScoreboardScoreuser findById(WebimsScoreboardScoreuserId id) {
		EntityManagerHelper.log(
				"finding WebimsScoreboardScoreuser instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsScoreboardScoreuser instance = getEntityManager().find(
					WebimsScoreboardScoreuser.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsScoreboardScoreuser entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsScoreboardScoreuser property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsScoreboardScoreuser> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsScoreboardScoreuser> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsScoreboardScoreuser instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsScoreboardScoreuser model where model."
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

	/**
	 * Find all WebimsScoreboardScoreuser entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsScoreboardScoreuser> all WebimsScoreboardScoreuser entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsScoreboardScoreuser> findAll(
			final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding all WebimsScoreboardScoreuser instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from WebimsScoreboardScoreuser model";
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