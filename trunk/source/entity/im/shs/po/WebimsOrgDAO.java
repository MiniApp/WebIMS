package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsOrg entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsOrg
  * @author MyEclipse Persistence Tools 
 */

public class WebimsOrgDAO implements IWebimsOrgDAO {
	// property constants
	public static final String PARENT_ID = "parentId";
	public static final String NAME = "name";
	public static final String FULL_NAME = "fullName";
	public static final String DESCRIPTION = "description";
	public static final String NUMBER = "number";
	public static final String TREE_NUMBER = "treeNumber";
	public static final String TREE_LEVEL = "treeLevel";
	public static final String TREE_MAX = "treeMax";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsOrg entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsOrgDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsOrg entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsOrg entity) {
		EntityManagerHelper.log("saving WebimsOrg instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsOrg entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsOrgDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsOrg entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsOrg entity) {
		EntityManagerHelper
				.log("deleting WebimsOrg instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsOrg.class,
					entity.getOrgId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsOrg entity and return it or a copy of it to the sender. 
	 A copy of the WebimsOrg entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsOrgDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsOrg entity to update
	 @return WebimsOrg the persisted WebimsOrg entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsOrg update(WebimsOrg entity) {
		EntityManagerHelper
				.log("updating WebimsOrg instance", Level.INFO, null);
		try {
			WebimsOrg result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsOrg findById(Integer id) {
		EntityManagerHelper.log("finding WebimsOrg instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsOrg instance = getEntityManager().find(WebimsOrg.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsOrg entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsOrg property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsOrg> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsOrg> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding WebimsOrg instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsOrg model where model."
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

	public List<WebimsOrg> findByParentId(Object parentId,
			int... rowStartIdxAndCount) {
		return findByProperty(PARENT_ID, parentId, rowStartIdxAndCount);
	}

	public List<WebimsOrg> findByName(Object name, int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsOrg> findByFullName(Object fullName,
			int... rowStartIdxAndCount) {
		return findByProperty(FULL_NAME, fullName, rowStartIdxAndCount);
	}

	public List<WebimsOrg> findByDescription(Object description,
			int... rowStartIdxAndCount) {
		return findByProperty(DESCRIPTION, description, rowStartIdxAndCount);
	}

	public List<WebimsOrg> findByNumber(Object number,
			int... rowStartIdxAndCount) {
		return findByProperty(NUMBER, number, rowStartIdxAndCount);
	}

	public List<WebimsOrg> findByTreeNumber(Object treeNumber,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_NUMBER, treeNumber, rowStartIdxAndCount);
	}

	public List<WebimsOrg> findByTreeLevel(Object treeLevel,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_LEVEL, treeLevel, rowStartIdxAndCount);
	}

	public List<WebimsOrg> findByTreeMax(Object treeMax,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_MAX, treeMax, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsOrg entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsOrg> all WebimsOrg entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsOrg> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsOrg instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from WebimsOrg model";
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