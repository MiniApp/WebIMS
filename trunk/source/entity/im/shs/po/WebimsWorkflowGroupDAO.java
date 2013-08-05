package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsWorkflowGroup entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsWorkflowGroup
  * @author MyEclipse Persistence Tools 
 */

public class WebimsWorkflowGroupDAO implements IWebimsWorkflowGroupDAO {
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String SEQ = "seq";
	public static final String SITE_ID = "siteId";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsWorkflowGroup entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsWorkflowGroupDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowGroup entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowGroup entity) {
		EntityManagerHelper.log("saving WebimsWorkflowGroup instance",
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
	 Delete a persistent WebimsWorkflowGroup entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsWorkflowGroupDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowGroup entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowGroup entity) {
		EntityManagerHelper.log("deleting WebimsWorkflowGroup instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsWorkflowGroup.class,
					entity.getWorkflowgroupId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsWorkflowGroup entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowGroup entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsWorkflowGroupDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowGroup entity to update
	 @return WebimsWorkflowGroup the persisted WebimsWorkflowGroup entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowGroup update(WebimsWorkflowGroup entity) {
		EntityManagerHelper.log("updating WebimsWorkflowGroup instance",
				Level.INFO, null);
		try {
			WebimsWorkflowGroup result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsWorkflowGroup findById(Integer id) {
		EntityManagerHelper.log(
				"finding WebimsWorkflowGroup instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsWorkflowGroup instance = getEntityManager().find(
					WebimsWorkflowGroup.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsWorkflowGroup entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsWorkflowGroup property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsWorkflowGroup> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowGroup> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsWorkflowGroup instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowGroup model where model."
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

	public List<WebimsWorkflowGroup> findByName(Object name,
			int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowGroup> findByDescription(Object description,
			int... rowStartIdxAndCount) {
		return findByProperty(DESCRIPTION, description, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowGroup> findBySeq(Object seq,
			int... rowStartIdxAndCount) {
		return findByProperty(SEQ, seq, rowStartIdxAndCount);
	}

	public List<WebimsWorkflowGroup> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsWorkflowGroup entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowGroup> all WebimsWorkflowGroup entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsWorkflowGroup> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsWorkflowGroup instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsWorkflowGroup model";
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