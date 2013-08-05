package im.shs.po;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsSpecialCategory entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsSpecialCategory
  * @author MyEclipse Persistence Tools 
 */

public class WebimsSpecialCategoryDAO implements IWebimsSpecialCategoryDAO {
	// property constants
	public static final String SITE_ID = "siteId";
	public static final String NAME = "name";
	public static final String SEQ = "seq";
	public static final String VIEWS = "views";
	public static final String META_KEYWORDS = "metaKeywords";
	public static final String META_DESCRIPTION = "metaDescription";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsSpecialCategory entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsSpecialCategoryDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsSpecialCategory entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsSpecialCategory entity) {
		EntityManagerHelper.log("saving WebimsSpecialCategory instance",
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
	 Delete a persistent WebimsSpecialCategory entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsSpecialCategoryDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsSpecialCategory entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsSpecialCategory entity) {
		EntityManagerHelper.log("deleting WebimsSpecialCategory instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(
					WebimsSpecialCategory.class, entity.getSpeccateId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsSpecialCategory entity and return it or a copy of it to the sender. 
	 A copy of the WebimsSpecialCategory entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsSpecialCategoryDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsSpecialCategory entity to update
	 @return WebimsSpecialCategory the persisted WebimsSpecialCategory entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsSpecialCategory update(WebimsSpecialCategory entity) {
		EntityManagerHelper.log("updating WebimsSpecialCategory instance",
				Level.INFO, null);
		try {
			WebimsSpecialCategory result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsSpecialCategory findById(Integer id) {
		EntityManagerHelper.log(
				"finding WebimsSpecialCategory instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsSpecialCategory instance = getEntityManager().find(
					WebimsSpecialCategory.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsSpecialCategory entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsSpecialCategory property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsSpecialCategory> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsSpecialCategory> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsSpecialCategory instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsSpecialCategory model where model."
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

	public List<WebimsSpecialCategory> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsSpecialCategory> findByName(Object name,
			int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsSpecialCategory> findBySeq(Object seq,
			int... rowStartIdxAndCount) {
		return findByProperty(SEQ, seq, rowStartIdxAndCount);
	}

	public List<WebimsSpecialCategory> findByViews(Object views,
			int... rowStartIdxAndCount) {
		return findByProperty(VIEWS, views, rowStartIdxAndCount);
	}

	public List<WebimsSpecialCategory> findByMetaKeywords(Object metaKeywords,
			int... rowStartIdxAndCount) {
		return findByProperty(META_KEYWORDS, metaKeywords, rowStartIdxAndCount);
	}

	public List<WebimsSpecialCategory> findByMetaDescription(
			Object metaDescription, int... rowStartIdxAndCount) {
		return findByProperty(META_DESCRIPTION, metaDescription,
				rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsSpecialCategory entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsSpecialCategory> all WebimsSpecialCategory entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsSpecialCategory> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsSpecialCategory instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsSpecialCategory model";
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