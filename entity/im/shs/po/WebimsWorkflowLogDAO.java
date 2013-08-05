package im.shs.po;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsWorkflowLog entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsWorkflowLog
  * @author MyEclipse Persistence Tools 
 */

public class WebimsWorkflowLogDAO implements IWebimsWorkflowLogDAO {
	// property constants
	public static final String USER_ID = "userId";
	public static final String WORKFLOWPROCESS_ID = "workflowprocessId";
	public static final String FROM = "from";
	public static final String TO = "to";
	public static final String OPINION = "opinion";
	public static final String TYPE = "type";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsWorkflowLog entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsWorkflowLogDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowLog entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowLog entity) {
		EntityManagerHelper.log("saving WebimsWorkflowLog instance",
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
	 Delete a persistent WebimsWorkflowLog entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsWorkflowLogDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowLog entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowLog entity) {
		EntityManagerHelper.log("deleting WebimsWorkflowLog instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsWorkflowLog.class,
					entity.getWorkflowlogId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsWorkflowLog entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowLog entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsWorkflowLogDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowLog entity to update
	 @return WebimsWorkflowLog the persisted WebimsWorkflowLog entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowLog update(WebimsWorkflowLog entity) {
		EntityManagerHelper.log("updating WebimsWorkflowLog instance",
				Level.INFO, null);
		try {
			WebimsWorkflowLog result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsWorkflowLog findById(Integer id) {
		EntityManagerHelper.log("finding WebimsWorkflowLog instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsWorkflowLog instance = getEntityManager().find(
					WebimsWorkflowLog.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsWorkflowLog entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsWorkflowLog property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsWorkflowLog> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowLog> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsWorkflowLog instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowLog model where model."
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

	public List<WebimsWorkflowLog> findByUserId(Object userId,
			int... rowStartIdxAndCount) {
		return findByProperty(USER_ID, userId, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowLog> findByWorkflowprocessId(
			Object workflowprocessId, int... rowStartIdxAndCount) {
		return findByProperty(WORKFLOWPROCESS_ID, workflowprocessId,
				rowStartIdxAndCount);
	}

	public List<WebimsWorkflowLog> findByFrom(Object from,
			int... rowStartIdxAndCount) {
		return findByProperty(FROM, from, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowLog> findByTo(Object to,
			int... rowStartIdxAndCount) {
		return findByProperty(TO, to, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowLog> findByOpinion(Object opinion,
			int... rowStartIdxAndCount) {
		return findByProperty(OPINION, opinion, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowLog> findByType(Object type,
			int... rowStartIdxAndCount) {
		return findByProperty(TYPE, type, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsWorkflowLog entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowLog> all WebimsWorkflowLog entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowLog> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsWorkflowLog instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowLog model";
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