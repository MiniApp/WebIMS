package im.shs.po;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsSpecial entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsSpecial
  * @author MyEclipse Persistence Tools 
 */

public class WebimsSpecialDAO implements IWebimsSpecialDAO {
	// property constants
	public static final String SITE_ID = "siteId";
	public static final String SPECCATE_ID = "speccateId";
	public static final String TITLE = "title";
	public static final String META_KEYWORDS = "metaKeywords";
	public static final String META_DESCRIPTION = "metaDescription";
	public static final String SMALL_IMAGE = "smallImage";
	public static final String LARGE_IMAGE = "largeImage";
	public static final String VIDEO = "video";
	public static final String VIEWS = "views";
	public static final String IS_RECOMMEND = "isRecommend";
	public static final String REFERS = "refers";
	public static final String IS_WITH_IMAGE = "isWithImage";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsSpecial entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsSpecialDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsSpecial entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsSpecial entity) {
		EntityManagerHelper.log("saving WebimsSpecial instance", Level.INFO,
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
	 Delete a persistent WebimsSpecial entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsSpecialDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsSpecial entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsSpecial entity) {
		EntityManagerHelper.log("deleting WebimsSpecial instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsSpecial.class,
					entity.getSpecialId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsSpecial entity and return it or a copy of it to the sender. 
	 A copy of the WebimsSpecial entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsSpecialDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsSpecial entity to update
	 @return WebimsSpecial the persisted WebimsSpecial entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsSpecial update(WebimsSpecial entity) {
		EntityManagerHelper.log("updating WebimsSpecial instance", Level.INFO,
				null);
		try {
			WebimsSpecial result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsSpecial findById(Integer id) {
		EntityManagerHelper.log(
				"finding WebimsSpecial instance with id: " + id, Level.INFO,
				null);
		try {
			WebimsSpecial instance = getEntityManager().find(
					WebimsSpecial.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsSpecial entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsSpecial property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsSpecial> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsSpecial> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsSpecial instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsSpecial model where model."
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

	public List<WebimsSpecial> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findBySpeccateId(Object speccateId,
			int... rowStartIdxAndCount) {
		return findByProperty(SPECCATE_ID, speccateId, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByTitle(Object title,
			int... rowStartIdxAndCount) {
		return findByProperty(TITLE, title, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByMetaKeywords(Object metaKeywords,
			int... rowStartIdxAndCount) {
		return findByProperty(META_KEYWORDS, metaKeywords, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByMetaDescription(Object metaDescription,
			int... rowStartIdxAndCount) {
		return findByProperty(META_DESCRIPTION, metaDescription,
				rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findBySmallImage(Object smallImage,
			int... rowStartIdxAndCount) {
		return findByProperty(SMALL_IMAGE, smallImage, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByLargeImage(Object largeImage,
			int... rowStartIdxAndCount) {
		return findByProperty(LARGE_IMAGE, largeImage, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByVideo(Object video,
			int... rowStartIdxAndCount) {
		return findByProperty(VIDEO, video, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByViews(Object views,
			int... rowStartIdxAndCount) {
		return findByProperty(VIEWS, views, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByIsRecommend(Object isRecommend,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_RECOMMEND, isRecommend, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByRefers(Object refers,
			int... rowStartIdxAndCount) {
		return findByProperty(REFERS, refers, rowStartIdxAndCount);
	}

	public List<WebimsSpecial> findByIsWithImage(Object isWithImage,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_WITH_IMAGE, isWithImage, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsSpecial entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsSpecial> all WebimsSpecial entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsSpecial> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsSpecial instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsSpecial model";
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