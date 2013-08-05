package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsNodeDetail entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsNodeDetail
  * @author MyEclipse Persistence Tools 
 */

public class WebimsNodeDetailDAO implements IWebimsNodeDetailDAO {
	// property constants
	public static final String LINK_URL = "linkUrl";
	public static final String META_KEYWORDS = "metaKeywords";
	public static final String META_DESCRIPTION = "metaDescription";
	public static final String IS_NEW_WINDOW = "isNewWindow";
	public static final String NODE_TEMPLATE = "nodeTemplate";
	public static final String INFO_TEMPLATE = "infoTemplate";
	public static final String IS_GENERATE_NODE = "isGenerateNode";
	public static final String IS_GENERATE_INFO = "isGenerateInfo";
	public static final String NODE_EXTENSION = "nodeExtension";
	public static final String INFO_EXTENSION = "infoExtension";
	public static final String NODE_PATH = "nodePath";
	public static final String INFO_PATH = "infoPath";
	public static final String IS_DEPAGE = "isDepage";
	public static final String STATIC_METHOD = "staticMethod";
	public static final String STATIC_PAGE = "staticPage";
	public static final String SMALL_IMAGE = "smallImage";
	public static final String LARGE_IMAGE = "largeImage";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsNodeDetail entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsNodeDetailDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsNodeDetail entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsNodeDetail entity) {
		EntityManagerHelper.log("saving WebimsNodeDetail instance", Level.INFO,
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
	 Delete a persistent WebimsNodeDetail entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsNodeDetailDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsNodeDetail entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsNodeDetail entity) {
		EntityManagerHelper.log("deleting WebimsNodeDetail instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsNodeDetail.class,
					entity.getNodeId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsNodeDetail entity and return it or a copy of it to the sender. 
	 A copy of the WebimsNodeDetail entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsNodeDetailDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsNodeDetail entity to update
	 @return WebimsNodeDetail the persisted WebimsNodeDetail entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsNodeDetail update(WebimsNodeDetail entity) {
		EntityManagerHelper.log("updating WebimsNodeDetail instance",
				Level.INFO, null);
		try {
			WebimsNodeDetail result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsNodeDetail findById(Integer id) {
		EntityManagerHelper.log("finding WebimsNodeDetail instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsNodeDetail instance = getEntityManager().find(
					WebimsNodeDetail.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsNodeDetail entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsNodeDetail property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsNodeDetail> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsNodeDetail> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsNodeDetail instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsNodeDetail model where model."
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

	public List<WebimsNodeDetail> findByLinkUrl(Object linkUrl,
			int... rowStartIdxAndCount) {
		return findByProperty(LINK_URL, linkUrl, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByMetaKeywords(Object metaKeywords,
			int... rowStartIdxAndCount) {
		return findByProperty(META_KEYWORDS, metaKeywords, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByMetaDescription(Object metaDescription,
			int... rowStartIdxAndCount) {
		return findByProperty(META_DESCRIPTION, metaDescription,
				rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByIsNewWindow(Object isNewWindow,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_NEW_WINDOW, isNewWindow, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByNodeTemplate(Object nodeTemplate,
			int... rowStartIdxAndCount) {
		return findByProperty(NODE_TEMPLATE, nodeTemplate, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByInfoTemplate(Object infoTemplate,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_TEMPLATE, infoTemplate, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByIsGenerateNode(Object isGenerateNode,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_GENERATE_NODE, isGenerateNode,
				rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByIsGenerateInfo(Object isGenerateInfo,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_GENERATE_INFO, isGenerateInfo,
				rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByNodeExtension(Object nodeExtension,
			int... rowStartIdxAndCount) {
		return findByProperty(NODE_EXTENSION, nodeExtension,
				rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByInfoExtension(Object infoExtension,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_EXTENSION, infoExtension,
				rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByNodePath(Object nodePath,
			int... rowStartIdxAndCount) {
		return findByProperty(NODE_PATH, nodePath, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByInfoPath(Object infoPath,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_PATH, infoPath, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByIsDepage(Object isDepage,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_DEPAGE, isDepage, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByStaticMethod(Object staticMethod,
			int... rowStartIdxAndCount) {
		return findByProperty(STATIC_METHOD, staticMethod, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByStaticPage(Object staticPage,
			int... rowStartIdxAndCount) {
		return findByProperty(STATIC_PAGE, staticPage, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findBySmallImage(Object smallImage,
			int... rowStartIdxAndCount) {
		return findByProperty(SMALL_IMAGE, smallImage, rowStartIdxAndCount);
	}

	public List<WebimsNodeDetail> findByLargeImage(Object largeImage,
			int... rowStartIdxAndCount) {
		return findByProperty(LARGE_IMAGE, largeImage, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsNodeDetail entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsNodeDetail> all WebimsNodeDetail entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsNodeDetail> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsNodeDetail instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsNodeDetail model";
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