package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsMemberGroup entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsMemberGroup
  * @author MyEclipse Persistence Tools 
 */

public class WebimsMemberGroupDAO implements IWebimsMemberGroupDAO {
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String SEQ = "seq";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsMemberGroup entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsMemberGroupDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsMemberGroup entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsMemberGroup entity) {
		EntityManagerHelper.log("saving WebimsMemberGroup instance",
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
	 Delete a persistent WebimsMemberGroup entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsMemberGroupDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsMemberGroup entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsMemberGroup entity) {
		EntityManagerHelper.log("deleting WebimsMemberGroup instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsMemberGroup.class,
					entity.getMembergroupId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsMemberGroup entity and return it or a copy of it to the sender. 
	 A copy of the WebimsMemberGroup entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsMemberGroupDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsMemberGroup entity to update
	 @return WebimsMemberGroup the persisted WebimsMemberGroup entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsMemberGroup update(WebimsMemberGroup entity) {
		EntityManagerHelper.log("updating WebimsMemberGroup instance",
				Level.INFO, null);
		try {
			WebimsMemberGroup result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsMemberGroup findById(Integer id) {
		EntityManagerHelper.log("finding WebimsMemberGroup instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsMemberGroup instance = getEntityManager().find(
					WebimsMemberGroup.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsMemberGroup entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsMemberGroup property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsMemberGroup> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsMemberGroup> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsMemberGroup instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsMemberGroup model where model."
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

	public List<WebimsMemberGroup> findByName(Object name,
			int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsMemberGroup> findByDescription(Object description,
			int... rowStartIdxAndCount) {
		return findByProperty(DESCRIPTION, description, rowStartIdxAndCount);
	}

	public List<WebimsMemberGroup> findBySeq(Object seq,
			int... rowStartIdxAndCount) {
		return findByProperty(SEQ, seq, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsMemberGroup entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsMemberGroup> all WebimsMemberGroup entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsMemberGroup> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsMemberGroup instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsMemberGroup model";
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