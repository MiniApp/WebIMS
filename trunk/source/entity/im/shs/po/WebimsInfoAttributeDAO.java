package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsInfoAttribute entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsInfoAttribute
  * @author MyEclipse Persistence Tools 
 */

public class WebimsInfoAttributeDAO implements IWebimsInfoAttributeDAO {
	// property constants
	public static final String INFO_ID = "infoId";
	public static final String ATTRIBUTE_ID = "attributeId";
	public static final String IMAGE = "image";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsInfoAttribute entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsInfoAttributeDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoAttribute entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoAttribute entity) {
		EntityManagerHelper.log("saving WebimsInfoAttribute instance",
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
	 Delete a persistent WebimsInfoAttribute entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsInfoAttributeDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoAttribute entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoAttribute entity) {
		EntityManagerHelper.log("deleting WebimsInfoAttribute instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsInfoAttribute.class,
					entity.getInfoattrId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsInfoAttribute entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoAttribute entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsInfoAttributeDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoAttribute entity to update
	 @return WebimsInfoAttribute the persisted WebimsInfoAttribute entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoAttribute update(WebimsInfoAttribute entity) {
		EntityManagerHelper.log("updating WebimsInfoAttribute instance",
				Level.INFO, null);
		try {
			WebimsInfoAttribute result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsInfoAttribute findById(Integer id) {
		EntityManagerHelper.log(
				"finding WebimsInfoAttribute instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsInfoAttribute instance = getEntityManager().find(
					WebimsInfoAttribute.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsInfoAttribute entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsInfoAttribute property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsInfoAttribute> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsInfoAttribute> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsInfoAttribute instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsInfoAttribute model where model."
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

	public List<WebimsInfoAttribute> findByInfoId(Object infoId,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_ID, infoId, rowStartIdxAndCount);
	}

	public List<WebimsInfoAttribute> findByAttributeId(Object attributeId,
			int... rowStartIdxAndCount) {
		return findByProperty(ATTRIBUTE_ID, attributeId, rowStartIdxAndCount);
	}

	public List<WebimsInfoAttribute> findByImage(Object image,
			int... rowStartIdxAndCount) {
		return findByProperty(IMAGE, image, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsInfoAttribute entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoAttribute> all WebimsInfoAttribute entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsInfoAttribute> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsInfoAttribute instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsInfoAttribute model";
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