package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsMembergroupSite entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsMembergroupSite
  * @author MyEclipse Persistence Tools 
 */

public class WebimsMembergroupSiteDAO implements IWebimsMembergroupSiteDAO {
	// property constants
	public static final String MEMBERGROUP_ID = "membergroupId";
	public static final String SITE_ID = "siteId";
	public static final String IS_ALL_VIEW = "isAllView";
	public static final String IS_ALL_CONTRI = "isAllContri";
	public static final String IS_ALL_EXEMPTION = "isAllExemption";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsMembergroupSite entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsMembergroupSiteDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsMembergroupSite entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsMembergroupSite entity) {
		EntityManagerHelper.log("saving WebimsMembergroupSite instance",
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
	 Delete a persistent WebimsMembergroupSite entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsMembergroupSiteDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsMembergroupSite entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsMembergroupSite entity) {
		EntityManagerHelper.log("deleting WebimsMembergroupSite instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					WebimsMembergroupSite.class, entity.getMemgroupsiteId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsMembergroupSite entity and return it or a copy of it to the sender. 
	 A copy of the WebimsMembergroupSite entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsMembergroupSiteDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsMembergroupSite entity to update
	 @return WebimsMembergroupSite the persisted WebimsMembergroupSite entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsMembergroupSite update(WebimsMembergroupSite entity) {
		EntityManagerHelper.log("updating WebimsMembergroupSite instance",
				Level.INFO, null);
		try {
			WebimsMembergroupSite result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsMembergroupSite findById(Integer id) {
		EntityManagerHelper.log(
				"finding WebimsMembergroupSite instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsMembergroupSite instance = getEntityManager().find(
					WebimsMembergroupSite.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsMembergroupSite entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsMembergroupSite property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsMembergroupSite> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsMembergroupSite> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsMembergroupSite instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsMembergroupSite model where model."
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

	public List<WebimsMembergroupSite> findByMembergroupId(
			Object membergroupId, int... rowStartIdxAndCount) {
		return findByProperty(MEMBERGROUP_ID, membergroupId,
				rowStartIdxAndCount);
	}

	public List<WebimsMembergroupSite> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsMembergroupSite> findByIsAllView(Object isAllView,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_ALL_VIEW, isAllView, rowStartIdxAndCount);
	}

	public List<WebimsMembergroupSite> findByIsAllContri(Object isAllContri,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_ALL_CONTRI, isAllContri, rowStartIdxAndCount);
	}

	public List<WebimsMembergroupSite> findByIsAllExemption(
			Object isAllExemption, int... rowStartIdxAndCount) {
		return findByProperty(IS_ALL_EXEMPTION, isAllExemption,
				rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsMembergroupSite entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsMembergroupSite> all WebimsMembergroupSite entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsMembergroupSite> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsMembergroupSite instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsMembergroupSite model";
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