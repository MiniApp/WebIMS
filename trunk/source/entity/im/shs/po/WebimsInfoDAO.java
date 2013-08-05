package im.shs.po;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsInfo entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsInfo
  * @author MyEclipse Persistence Tools 
 */

public class WebimsInfoDAO implements IWebimsInfoDAO {
	// property constants
	public static final String CREATOR_ID = "creatorId";
	public static final String SITE_ID = "siteId";
	public static final String NODE_ID = "nodeId";
	public static final String PRIORITY = "priority";
	public static final String IS_WITH_IMAGE = "isWithImage";
	public static final String VIEWS = "views";
	public static final String DOWNLOADS = "downloads";
	public static final String COMMENTS = "comments";
	public static final String STATUS = "status";
	public static final String P1 = "p1";
	public static final String P2 = "p2";
	public static final String P3 = "p3";
	public static final String P4 = "p4";
	public static final String P5 = "p5";
	public static final String P6 = "p6";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsInfo entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsInfoDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfo entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfo entity) {
		EntityManagerHelper.log("saving WebimsInfo instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsInfo entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsInfoDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfo entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfo entity) {
		EntityManagerHelper.log("deleting WebimsInfo instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsInfo.class,
					entity.getInfoId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsInfo entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfo entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsInfoDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfo entity to update
	 @return WebimsInfo the persisted WebimsInfo entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfo update(WebimsInfo entity) {
		EntityManagerHelper.log("updating WebimsInfo instance", Level.INFO,
				null);
		try {
			WebimsInfo result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsInfo findById(Integer id) {
		EntityManagerHelper.log("finding WebimsInfo instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsInfo instance = getEntityManager().find(WebimsInfo.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsInfo entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsInfo property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsInfo> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsInfo> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding WebimsInfo instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsInfo model where model."
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

	public List<WebimsInfo> findByCreatorId(Object creatorId,
			int... rowStartIdxAndCount) {
		return findByProperty(CREATOR_ID, creatorId, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByNodeId(Object nodeId,
			int... rowStartIdxAndCount) {
		return findByProperty(NODE_ID, nodeId, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByPriority(Object priority,
			int... rowStartIdxAndCount) {
		return findByProperty(PRIORITY, priority, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByIsWithImage(Object isWithImage,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_WITH_IMAGE, isWithImage, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByViews(Object views,
			int... rowStartIdxAndCount) {
		return findByProperty(VIEWS, views, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByDownloads(Object downloads,
			int... rowStartIdxAndCount) {
		return findByProperty(DOWNLOADS, downloads, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByComments(Object comments,
			int... rowStartIdxAndCount) {
		return findByProperty(COMMENTS, comments, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByStatus(Object status,
			int... rowStartIdxAndCount) {
		return findByProperty(STATUS, status, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByP1(Object p1, int... rowStartIdxAndCount) {
		return findByProperty(P1, p1, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByP2(Object p2, int... rowStartIdxAndCount) {
		return findByProperty(P2, p2, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByP3(Object p3, int... rowStartIdxAndCount) {
		return findByProperty(P3, p3, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByP4(Object p4, int... rowStartIdxAndCount) {
		return findByProperty(P4, p4, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByP5(Object p5, int... rowStartIdxAndCount) {
		return findByProperty(P5, p5, rowStartIdxAndCount);
	}

	public List<WebimsInfo> findByP6(Object p6, int... rowStartIdxAndCount) {
		return findByProperty(P6, p6, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsInfo entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfo> all WebimsInfo entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsInfo> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsInfo instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from WebimsInfo model";
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