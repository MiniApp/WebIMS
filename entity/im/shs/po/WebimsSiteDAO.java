package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsSite entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsSite
  * @author MyEclipse Persistence Tools 
 */

public class WebimsSiteDAO implements IWebimsSiteDAO {
	// property constants
	public static final String GLOBAL_ID = "globalId";
	public static final String ORG_ID = "orgId";
	public static final String PARENT_ID = "parentId";
	public static final String NAME = "name";
	public static final String FULL_NAME = "fullName";
	public static final String HTML_PATH = "htmlPath";
	public static final String DOMAIN = "domain";
	public static final String IS_WITH_DOMAIN = "isWithDomain";
	public static final String TEMPLATE_THEME = "templateTheme";
	public static final String TREE_NUMBER = "treeNumber";
	public static final String TREE_LEVEL = "treeLevel";
	public static final String TREE_MAX = "treeMax";
	public static final String NO_PICTURE = "noPicture";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsSite entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsSiteDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsSite entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsSite entity) {
		EntityManagerHelper.log("saving WebimsSite instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Delete a persistent WebimsSite entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsSiteDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsSite entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsSite entity) {
		EntityManagerHelper.log("deleting WebimsSite instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(WebimsSite.class,
					entity.getSiteId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsSite entity and return it or a copy of it to the sender. 
	 A copy of the WebimsSite entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsSiteDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsSite entity to update
	 @return WebimsSite the persisted WebimsSite entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsSite update(WebimsSite entity) {
		EntityManagerHelper.log("updating WebimsSite instance", Level.INFO,
				null);
		try {
			WebimsSite result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsSite findById(Integer id) {
		EntityManagerHelper.log("finding WebimsSite instance with id: " + id,
				Level.INFO, null);
		try {
			WebimsSite instance = getEntityManager().find(WebimsSite.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsSite entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsSite property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsSite> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsSite> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding WebimsSite instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsSite model where model."
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

	public List<WebimsSite> findByGlobalId(Object globalId,
			int... rowStartIdxAndCount) {
		return findByProperty(GLOBAL_ID, globalId, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByOrgId(Object orgId,
			int... rowStartIdxAndCount) {
		return findByProperty(ORG_ID, orgId, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByParentId(Object parentId,
			int... rowStartIdxAndCount) {
		return findByProperty(PARENT_ID, parentId, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByName(Object name, int... rowStartIdxAndCount) {
		return findByProperty(NAME, name, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByFullName(Object fullName,
			int... rowStartIdxAndCount) {
		return findByProperty(FULL_NAME, fullName, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByHtmlPath(Object htmlPath,
			int... rowStartIdxAndCount) {
		return findByProperty(HTML_PATH, htmlPath, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByDomain(Object domain,
			int... rowStartIdxAndCount) {
		return findByProperty(DOMAIN, domain, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByIsWithDomain(Object isWithDomain,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_WITH_DOMAIN, isWithDomain, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByTemplateTheme(Object templateTheme,
			int... rowStartIdxAndCount) {
		return findByProperty(TEMPLATE_THEME, templateTheme,
				rowStartIdxAndCount);
	}

	public List<WebimsSite> findByTreeNumber(Object treeNumber,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_NUMBER, treeNumber, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByTreeLevel(Object treeLevel,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_LEVEL, treeLevel, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByTreeMax(Object treeMax,
			int... rowStartIdxAndCount) {
		return findByProperty(TREE_MAX, treeMax, rowStartIdxAndCount);
	}

	public List<WebimsSite> findByNoPicture(Object noPicture,
			int... rowStartIdxAndCount) {
		return findByProperty(NO_PICTURE, noPicture, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsSite entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsSite> all WebimsSite entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsSite> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsSite instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from WebimsSite model";
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