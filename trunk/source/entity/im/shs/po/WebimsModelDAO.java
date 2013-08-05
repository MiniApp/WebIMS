package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsModel entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsModel
  * @author MyEclipse Persistence Tools 
 */

public class WebimsModelDAO implements IWebimsModelDAO {
	// property constants
	public static final String SITE_ID = "siteId";
	public static final String TYPE = "type";
	public static final String NAME = "name";
	public static final String SEQ = "seq";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsModel entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsModelDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsModel entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsModel entity) {
		EntityManagerHelper
				.log("saving WebimsModel instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsModel entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsModelDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsModel entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsModel entity) {
		EntityManagerHelper.log("deleting WebimsModel instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsModel.class,
					entity.getModelId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsModel entity and return it or a copy of it to the sender. 
	 A copy of the WebimsModel entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsModelDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsModel entity to update
	 @return WebimsModel the persisted WebimsModel entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsModel update(WebimsModel entity) {
		EntityManagerHelper.log("updating WebimsModel instance", Level.INFO,
				null);
		try {
			WebimsModel result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsModel findById(Integer id) {
		EntityManagerHelper.log("finding WebimsModel instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsModel instance = getEntityManager().find(WebimsModel.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsModel entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsModel property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsModel> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsModel> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding WebimsModel instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsModel model where model."
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

	public List<WebimsModel> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsModel> findByType(Object type, int... rowStartIdxAndCount) {
		return findByProperty(TYPE, type, rowStartIdxAndCount);
	}

	public List<WebimsModel> findByName(Object name, int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsModel> findBySeq(Object seq, int... rowStartIdxAndCount) {
		return findByProperty(SEQ, seq, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsModel entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsModel> all WebimsModel entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsModel> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsModel instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsModel model";
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