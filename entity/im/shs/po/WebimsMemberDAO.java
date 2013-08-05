package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsMember entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsMember
  * @author MyEclipse Persistence Tools 
 */

public class WebimsMemberDAO implements IWebimsMemberDAO {
	// property constants
	public static final String MEMBERGROUP_ID = "membergroupId";
	public static final String AVATAR = "avatar";
	public static final String SELINTRO = "selintro";
	public static final String COME_FROM = "comeFrom";
	public static final String GENDER = "gender";
	public static final String STATUS = "status";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsMember entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsMemberDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsMember entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsMember entity) {
		EntityManagerHelper.log("saving WebimsMember instance", Level.INFO,
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
	 Delete a persistent WebimsMember entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsMemberDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsMember entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsMember entity) {
		EntityManagerHelper.log("deleting WebimsMember instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsMember.class,
					entity.getMemberId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsMember entity and return it or a copy of it to the sender. 
	 A copy of the WebimsMember entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsMemberDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsMember entity to update
	 @return WebimsMember the persisted WebimsMember entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsMember update(WebimsMember entity) {
		EntityManagerHelper.log("updating WebimsMember instance", Level.INFO,
				null);
		try {
			WebimsMember result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsMember findById(Integer id) {
		EntityManagerHelper.log("finding WebimsMember instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsMember instance = getEntityManager().find(WebimsMember.class,
					id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsMember entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsMember property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsMember> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsMember> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding WebimsMember instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsMember model where model."
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

	public List<WebimsMember> findByMembergroupId(Object membergroupId,
			int... rowStartIdxAndCount) {
		return findByProperty(MEMBERGROUP_ID, membergroupId,
				rowStartIdxAndCount);
	}

	public List<WebimsMember> findByAvatar(Object avatar,
			int... rowStartIdxAndCount) {
		return findByProperty(AVATAR, avatar, rowStartIdxAndCount);
	}

	public List<WebimsMember> findBySelintro(Object selintro,
			int... rowStartIdxAndCount) {
		return findByProperty(SELINTRO, selintro, rowStartIdxAndCount);
	}

	public List<WebimsMember> findByComeFrom(Object comeFrom,
			int... rowStartIdxAndCount) {
		return findByProperty(COME_FROM, comeFrom, rowStartIdxAndCount);
	}

	public List<WebimsMember> findByGender(Object gender,
			int... rowStartIdxAndCount) {
		return findByProperty(GENDER, gender, rowStartIdxAndCount);
	}

	public List<WebimsMember> findByStatus(Object status,
			int... rowStartIdxAndCount) {
		return findByProperty(STATUS, status, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsMember entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsMember> all WebimsMember entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsMember> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsMember instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsMember model";
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