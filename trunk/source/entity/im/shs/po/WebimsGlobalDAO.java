package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsGlobal entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsGlobal
  * @author MyEclipse Persistence Tools 
 */

public class WebimsGlobalDAO implements IWebimsGlobalDAO {
	// property constants
	public static final String VERSION = "version";
	public static final String PORT = "port";
	public static final String CONTEXT_PATH = "contextPath";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsGlobal entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsGlobalDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsGlobal entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsGlobal entity) {
		EntityManagerHelper.log("saving WebimsGlobal instance", Level.INFO,
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
	 Delete a persistent WebimsGlobal entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsGlobalDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsGlobal entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsGlobal entity) {
		EntityManagerHelper.log("deleting WebimsGlobal instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsGlobal.class,
					entity.getGlobalId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsGlobal entity and return it or a copy of it to the sender. 
	 A copy of the WebimsGlobal entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsGlobalDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsGlobal entity to update
	 @return WebimsGlobal the persisted WebimsGlobal entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsGlobal update(WebimsGlobal entity) {
		EntityManagerHelper.log("updating WebimsGlobal instance", Level.INFO,
				null);
		try {
			WebimsGlobal result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsGlobal findById(Integer id) {
		EntityManagerHelper.log("finding WebimsGlobal instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsGlobal instance = getEntityManager().find(WebimsGlobal.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsGlobal entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsGlobal property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsGlobal> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsGlobal> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding WebimsGlobal instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsGlobal model where model."
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

	public List<WebimsGlobal> findByVersion(Object version,
			int... rowStartIdxAndCount) {
		return findByProperty(VERSION, version, rowStartIdxAndCount);
	}

	public List<WebimsGlobal> findByPort(Object port,
			int... rowStartIdxAndCount) {
		return findByProperty(PORT, port, rowStartIdxAndCount);
	}

	public List<WebimsGlobal> findByContextPath(Object contextPath,
			int... rowStartIdxAndCount) {
		return findByProperty(CONTEXT_PATH, contextPath, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsGlobal entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsGlobal> all WebimsGlobal entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsGlobal> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsGlobal instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsGlobal model";
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