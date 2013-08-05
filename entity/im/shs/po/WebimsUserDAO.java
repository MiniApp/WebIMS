package im.shs.po;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsUser entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsUser
  * @author MyEclipse Persistence Tools 
 */

public class WebimsUserDAO implements IWebimsUserDAO {
	// property constants
	public static final String ORG_ID = "orgId";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String SALT = "salt";
	public static final String EMAIL = "email";
	public static final String REAL_NAME = "realName";
	public static final String MOBILE = "mobile";
	public static final String PREV_LOGIN_IP = "prevLoginIp";
	public static final String LAST_LOGIN_IP = "lastLoginIp";
	public static final String CREATION_IP = "creationIp";
	public static final String LOGINS = "logins";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsUser entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsUserDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsUser entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsUser entity) {
		EntityManagerHelper.log("saving WebimsUser instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsUser entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsUserDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsUser entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsUser entity) {
		EntityManagerHelper.log("deleting WebimsUser instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsUser.class,
					entity.getUserId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsUser entity and return it or a copy of it to the sender. 
	 A copy of the WebimsUser entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsUserDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsUser entity to update
	 @return WebimsUser the persisted WebimsUser entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsUser update(WebimsUser entity) {
		EntityManagerHelper.log("updating WebimsUser instance", Level.INFO,
				null);
		try {
			WebimsUser result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsUser findById(Integer id) {
		EntityManagerHelper.log("finding WebimsUser instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsUser instance = getEntityManager().find(WebimsUser.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsUser entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsUser property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsUser> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsUser> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding WebimsUser instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsUser model where model."
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

	public List<WebimsUser> findByOrgId(Object orgId,
			int... rowStartIdxAndCount) {
		return findByProperty(ORG_ID, orgId, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByUsername(Object username,
			int... rowStartIdxAndCount) {
		return findByProperty(USERNAME, username, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByPassword(Object password,
			int... rowStartIdxAndCount) {
		return findByProperty(PASSWORD, password, rowStartIdxAndCount);
	}

	public List<WebimsUser> findBySalt(Object salt, int... rowStartIdxAndCount) {
		return findByProperty(SALT, salt, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByEmail(Object email,
			int... rowStartIdxAndCount) {
		return findByProperty(EMAIL, email, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByRealName(Object realName,
			int... rowStartIdxAndCount) {
		return findByProperty(REAL_NAME, realName, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByMobile(Object mobile,
			int... rowStartIdxAndCount) {
		return findByProperty(MOBILE, mobile, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByPrevLoginIp(Object prevLoginIp,
			int... rowStartIdxAndCount) {
		return findByProperty(PREV_LOGIN_IP, prevLoginIp, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByLastLoginIp(Object lastLoginIp,
			int... rowStartIdxAndCount) {
		return findByProperty(LAST_LOGIN_IP, lastLoginIp, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByCreationIp(Object creationIp,
			int... rowStartIdxAndCount) {
		return findByProperty(CREATION_IP, creationIp, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByLogins(Object logins,
			int... rowStartIdxAndCount) {
		return findByProperty(LOGINS, logins, rowStartIdxAndCount);
	}

	public List<WebimsUser> findByStatus(Object status,
			int... rowStartIdxAndCount) {
		return findByProperty(STATUS, status, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsUser entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsUser> all WebimsUser entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsUser> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsUser instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from WebimsUser model";
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