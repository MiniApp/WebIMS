package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsWorkflowStep entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsWorkflowStep
  * @author MyEclipse Persistence Tools 
 */

public class WebimsWorkflowStepDAO implements IWebimsWorkflowStepDAO {
	// property constants
	public static final String WORKFLOW_ID = "workflowId";
	public static final String NAME = "name";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsWorkflowStep entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsWorkflowStepDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowStep entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowStep entity) {
		EntityManagerHelper.log("saving WebimsWorkflowStep instance",
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
	 Delete a persistent WebimsWorkflowStep entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsWorkflowStepDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowStep entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowStep entity) {
		EntityManagerHelper.log("deleting WebimsWorkflowStep instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsWorkflowStep.class,
					entity.getWorkflowstepId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsWorkflowStep entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowStep entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsWorkflowStepDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowStep entity to update
	 @return WebimsWorkflowStep the persisted WebimsWorkflowStep entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowStep update(WebimsWorkflowStep entity) {
		EntityManagerHelper.log("updating WebimsWorkflowStep instance",
				Level.INFO, null);
		try {
			WebimsWorkflowStep result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsWorkflowStep findById(Integer id) {
		EntityManagerHelper.log("finding WebimsWorkflowStep instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsWorkflowStep instance = getEntityManager().find(
					WebimsWorkflowStep.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsWorkflowStep entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsWorkflowStep property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsWorkflowStep> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowStep> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsWorkflowStep instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowStep model where model."
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

	public List<WebimsWorkflowStep> findByWorkflowId(Object workflowId,
			int... rowStartIdxAndCount) {
		return findByProperty(WORKFLOW_ID, workflowId, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowStep> findByName(Object name,
			int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsWorkflowStep entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowStep> all WebimsWorkflowStep entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowStep> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsWorkflowStep instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowStep model";
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