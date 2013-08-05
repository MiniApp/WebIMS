package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsWorkflowstepRole entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsWorkflowstepRole
  * @author MyEclipse Persistence Tools 
 */

public class WebimsWorkflowstepRoleDAO implements IWebimsWorkflowstepRoleDAO {
	// property constants

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsWorkflowstepRole entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsWorkflowstepRoleDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowstepRole entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowstepRole entity) {
		EntityManagerHelper.log("saving WebimsWorkflowstepRole instance",
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
	 Delete a persistent WebimsWorkflowstepRole entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsWorkflowstepRoleDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowstepRole entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowstepRole entity) {
		EntityManagerHelper.log("deleting WebimsWorkflowstepRole instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					WebimsWorkflowstepRole.class, entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsWorkflowstepRole entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowstepRole entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsWorkflowstepRoleDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowstepRole entity to update
	 @return WebimsWorkflowstepRole the persisted WebimsWorkflowstepRole entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowstepRole update(WebimsWorkflowstepRole entity) {
		EntityManagerHelper.log("updating WebimsWorkflowstepRole instance",
				Level.INFO, null);
		try {
			WebimsWorkflowstepRole result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsWorkflowstepRole findById(WebimsWorkflowstepRoleId id) {
		EntityManagerHelper.log(
				"finding WebimsWorkflowstepRole instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsWorkflowstepRole instance = getEntityManager().find(
					WebimsWorkflowstepRole.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsWorkflowstepRole entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsWorkflowstepRole property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsWorkflowstepRole> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowstepRole> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsWorkflowstepRole instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowstepRole model where model."
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
	 * Find all WebimsWorkflowstepRole entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowstepRole> all WebimsWorkflowstepRole entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowstepRole> findAll(
			final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsWorkflowstepRole instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowstepRole model";
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