package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsInfoBuffer entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsInfoBuffer
  * @author MyEclipse Persistence Tools 
 */

public class WebimsInfoBufferDAO implements IWebimsInfoBufferDAO {
	// property constants
	public static final String VIEWS = "views";
	public static final String DOWNLOADS = "downloads";
	public static final String COMMENTS = "comments";
	public static final String INVOLVEDS = "involveds";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsInfoBuffer entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsInfoBufferDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoBuffer entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoBuffer entity) {
		EntityManagerHelper.log("saving WebimsInfoBuffer instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsInfoBuffer entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsInfoBufferDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoBuffer entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoBuffer entity) {
		EntityManagerHelper.log("deleting WebimsInfoBuffer instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsInfoBuffer.class,
					entity.getInfoId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsInfoBuffer entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoBuffer entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsInfoBufferDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoBuffer entity to update
	 @return WebimsInfoBuffer the persisted WebimsInfoBuffer entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoBuffer update(WebimsInfoBuffer entity) {
		EntityManagerHelper.log("updating WebimsInfoBuffer instance",
				Level.INFO, null);
		try {
			WebimsInfoBuffer result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsInfoBuffer findById(Integer id) {
		EntityManagerHelper.log("finding WebimsInfoBuffer instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsInfoBuffer instance = getEntityManager().find(
					WebimsInfoBuffer.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsInfoBuffer entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsInfoBuffer property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsInfoBuffer> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsInfoBuffer> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsInfoBuffer instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsInfoBuffer model where model."
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

	public List<WebimsInfoBuffer> findByViews(Object views,
			int... rowStartIdxAndCount) {
		return findByProperty(VIEWS, views, rowStartIdxAndCount);
	}

	public List<WebimsInfoBuffer> findByDownloads(Object downloads,
			int... rowStartIdxAndCount) {
		return findByProperty(DOWNLOADS, downloads, rowStartIdxAndCount);
	}

	public List<WebimsInfoBuffer> findByComments(Object comments,
			int... rowStartIdxAndCount) {
		return findByProperty(COMMENTS, comments, rowStartIdxAndCount);
	}

	public List<WebimsInfoBuffer> findByInvolveds(Object involveds,
			int... rowStartIdxAndCount) {
		return findByProperty(INVOLVEDS, involveds, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsInfoBuffer entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoBuffer> all WebimsInfoBuffer entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsInfoBuffer> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsInfoBuffer instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsInfoBuffer model";
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