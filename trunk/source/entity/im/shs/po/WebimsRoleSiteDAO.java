package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsRoleSite entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsRoleSite
  * @author MyEclipse Persistence Tools 
 */

public class WebimsRoleSiteDAO implements IWebimsRoleSiteDAO {
	// property constants
	public static final String SITE_ID = "siteId";
	public static final String ROLE_ID = "roleId";
	public static final String IS_ALL_NODE = "isAllNode";
	public static final String IS_ALL_INFO = "isAllInfo";
	public static final String INFO_RIGHT_TYPE = "infoRightType";
	public static final String IS_ALL_PERM = "isAllPerm";
	public static final String PERMS = "perms";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsRoleSite entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsRoleSiteDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsRoleSite entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsRoleSite entity) {
		EntityManagerHelper.log("saving WebimsRoleSite instance", Level.INFO,
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
	 Delete a persistent WebimsRoleSite entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsRoleSiteDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsRoleSite entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsRoleSite entity) {
		EntityManagerHelper.log("deleting WebimsRoleSite instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsRoleSite.class,
					entity.getRolesiteId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsRoleSite entity and return it or a copy of it to the sender. 
	 A copy of the WebimsRoleSite entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsRoleSiteDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsRoleSite entity to update
	 @return WebimsRoleSite the persisted WebimsRoleSite entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsRoleSite update(WebimsRoleSite entity) {
		EntityManagerHelper.log("updating WebimsRoleSite instance", Level.INFO,
				null);
		try {
			WebimsRoleSite result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsRoleSite findById(Integer id) {
		EntityManagerHelper.log("finding WebimsRoleSite instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsRoleSite instance = getEntityManager().find(
					WebimsRoleSite.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsRoleSite entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsRoleSite property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsRoleSite> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsRoleSite> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsRoleSite instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsRoleSite model where model."
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

	public List<WebimsRoleSite> findBySiteId(Object siteId,
			int... rowStartIdxAndCount) {
		return findByProperty(SITE_ID, siteId, rowStartIdxAndCount);
	}

	public List<WebimsRoleSite> findByRoleId(Object roleId,
			int... rowStartIdxAndCount) {
		return findByProperty(ROLE_ID, roleId, rowStartIdxAndCount);
	}

	public List<WebimsRoleSite> findByIsAllNode(Object isAllNode,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_ALL_NODE, isAllNode, rowStartIdxAndCount);
	}

	public List<WebimsRoleSite> findByIsAllInfo(Object isAllInfo,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_ALL_INFO, isAllInfo, rowStartIdxAndCount);
	}

	public List<WebimsRoleSite> findByInfoRightType(Object infoRightType,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_RIGHT_TYPE, infoRightType,
				rowStartIdxAndCount);
	}

	public List<WebimsRoleSite> findByIsAllPerm(Object isAllPerm,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_ALL_PERM, isAllPerm, rowStartIdxAndCount);
	}

	public List<WebimsRoleSite> findByPerms(Object perms,
			int... rowStartIdxAndCount) {
		return findByProperty(PERMS, perms, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsRoleSite entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsRoleSite> all WebimsRoleSite entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsRoleSite> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsRoleSite instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsRoleSite model";
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