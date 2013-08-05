package im.shs.po;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsComment entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsComment
  * @author MyEclipse Persistence Tools 
 */

public class WebimsCommentDAO implements IWebimsCommentDAO {
	// property constants
	public static final String SITE_ID = "siteId";
	public static final String CREATOR_ID = "creatorId";
	public static final String AUDITOR_ID = "auditorId";
	public static final String FTYPE = "ftype";
	public static final String FID = "fid";
	public static final String SCORE = "score";
	public static final String STATUS = "status";
	public static final String TEXT = "text";
	public static final String IP = "ip";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsComment entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsCommentDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsComment entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsComment entity) {
		EntityManagerHelper.log("saving WebimsComment instance", Level.INFO,
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
	 Delete a persistent WebimsComment entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsCommentDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsComment entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsComment entity) {
		EntityManagerHelper.log("deleting WebimsComment instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsComment.class,
					entity.getCommentId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsComment entity and return it or a copy of it to the sender. 
	 A copy of the WebimsComment entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsCommentDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsComment entity to update
	 @return WebimsComment the persisted WebimsComment entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsComment update(WebimsComment entity) {
		EntityManagerHelper.log("updating WebimsComment instance", Level.INFO,
				null);
		try {
			WebimsComment result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsComment findById(Integer id) {
		EntityManagerHelper.log(
				"finding WebimsComment instance with id: " + id, Level.INFO,
				null);
		try {
			WebimsComment instance = getEntityManager().find(
					WebimsComment.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsComment entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsComment property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsComment> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsComment> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsComment instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsComment model where model."
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

	public List<WebimsComment> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsComment> findByCreatorId(Object creatorId,
			int... rowStartIdxAndCount) {
		return findByProperty(CREATOR_ID, creatorId, rowStartIdxAndCount);
	}

	public List<WebimsComment> findByAuditorId(Object auditorId,
			int... rowStartIdxAndCount) {
		return findByProperty(AUDITOR_ID, auditorId, rowStartIdxAndCount);
	}

	public List<WebimsComment> findByFtype(Object ftype,
			int... rowStartIdxAndCount) {
		return findByProperty(FTYPE, ftype, rowStartIdxAndCount);
	}

	public List<WebimsComment> findByFid(Object fid, int... rowStartIdxAndCount) {
		return findByProperty(FID, fid, rowStartIdxAndCount);
	}

	public List<WebimsComment> findByScore(Object score,
			int... rowStartIdxAndCount) {
		return findByProperty(SCORE, score, rowStartIdxAndCount);
	}

	public List<WebimsComment> findByStatus(Object status,
			int... rowStartIdxAndCount) {
		return findByProperty(STATUS, status, rowStartIdxAndCount);
	}

	public List<WebimsComment> findByText(Object text,
			int... rowStartIdxAndCount) {
		return findByProperty(TEXT, text, rowStartIdxAndCount);
	}

	public List<WebimsComment> findByIp(Object ip, int... rowStartIdxAndCount) {
		return findByProperty(IP, ip, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsComment entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsComment> all WebimsComment entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsComment> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsComment instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsComment model";
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