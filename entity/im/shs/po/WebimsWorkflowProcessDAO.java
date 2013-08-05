package im.shs.po;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsWorkflowProcess entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsWorkflowProcess
  * @author MyEclipse Persistence Tools 
 */

public class WebimsWorkflowProcessDAO implements IWebimsWorkflowProcessDAO {
	// property constants
	public static final String WORKFLOW_ID = "workflowId";
	public static final String USER_ID = "userId";
	public static final String DATA_ID = "dataId";
	public static final String STEP = "step";
	public static final String IS_END = "isEnd";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsWorkflowProcess entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsWorkflowProcessDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowProcess entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowProcess entity) {
		EntityManagerHelper.log("saving WebimsWorkflowProcess instance",
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
	 Delete a persistent WebimsWorkflowProcess entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsWorkflowProcessDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowProcess entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowProcess entity) {
		EntityManagerHelper.log("deleting WebimsWorkflowProcess instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					WebimsWorkflowProcess.class, entity.getWorkflowprocessId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsWorkflowProcess entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowProcess entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsWorkflowProcessDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowProcess entity to update
	 @return WebimsWorkflowProcess the persisted WebimsWorkflowProcess entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowProcess update(WebimsWorkflowProcess entity) {
		EntityManagerHelper.log("updating WebimsWorkflowProcess instance",
				Level.INFO, null);
		try {
			WebimsWorkflowProcess result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsWorkflowProcess findById(Integer id) {
		EntityManagerHelper.log(
				"finding WebimsWorkflowProcess instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsWorkflowProcess instance = getEntityManager().find(
					WebimsWorkflowProcess.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsWorkflowProcess entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsWorkflowProcess property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsWorkflowProcess> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowProcess> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsWorkflowProcess instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowProcess model where model."
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

	public List<WebimsWorkflowProcess> findByWorkflowId(Object workflowId,
			int... rowStartIdxAndCount) {
		return findByProperty(WORKFLOW_ID, workflowId, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowProcess> findByUserId(Object userId,
			int... rowStartIdxAndCount) {
		return findByProperty(USER_ID, userId, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowProcess> findByDataId(Object dataId,
			int... rowStartIdxAndCount) {
		return findByProperty(DATA_ID, dataId, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowProcess> findByStep(Object step,
			int... rowStartIdxAndCount) {
		return findByProperty(STEP, step, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowProcess> findByIsEnd(Object isEnd,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_END, isEnd, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsWorkflowProcess entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowProcess> all WebimsWorkflowProcess entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowProcess> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsWorkflowProcess instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowProcess model";
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