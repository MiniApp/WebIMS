package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsScoreitem entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsScoreitem
  * @author MyEclipse Persistence Tools 
 */

public class WebimsScoreitemDAO implements IWebimsScoreitemDAO {
	// property constants
	public static final String SCOREGROUP_ID = "scoregroupId";
	public static final String SITE_ID = "siteId";
	public static final String NAME = "name";
	public static final String ICON = "icon";
	public static final String SEQ = "seq";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsScoreitem entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsScoreitemDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsScoreitem entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsScoreitem entity) {
		EntityManagerHelper.log("saving WebimsScoreitem instance", Level.INFO,
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
	 Delete a persistent WebimsScoreitem entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsScoreitemDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsScoreitem entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsScoreitem entity) {
		EntityManagerHelper.log("deleting WebimsScoreitem instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsScoreitem.class,
					entity.getScoreitemId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsScoreitem entity and return it or a copy of it to the sender. 
	 A copy of the WebimsScoreitem entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsScoreitemDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsScoreitem entity to update
	 @return WebimsScoreitem the persisted WebimsScoreitem entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsScoreitem update(WebimsScoreitem entity) {
		EntityManagerHelper.log("updating WebimsScoreitem instance",
				Level.INFO, null);
		try {
			WebimsScoreitem result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsScoreitem findById(Integer id) {
		EntityManagerHelper.log("finding WebimsScoreitem instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsScoreitem instance = getEntityManager().find(
					WebimsScoreitem.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsScoreitem entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsScoreitem property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsScoreitem> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsScoreitem> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsScoreitem instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsScoreitem model where model."
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

	public List<WebimsScoreitem> findByScoregroupId(Object scoregroupId,
			int... rowStartIdxAndCount) {
		return findByProperty(SCOREGROUP_ID, scoregroupId, rowStartIdxAndCount);
	}

	public List<WebimsScoreitem> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsScoreitem> findByName(Object name,
			int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsScoreitem> findByIcon(Object icon,
			int... rowStartIdxAndCount) {
		return findByProperty(ICON, icon, rowStartIdxAndCount);
	}

	public List<WebimsScoreitem> findBySeq(Object seq,
			int... rowStartIdxAndCount) {
		return findByProperty(SEQ, seq, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsScoreitem entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsScoreitem> all WebimsScoreitem entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsScoreitem> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsScoreitem instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsScoreitem model";
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