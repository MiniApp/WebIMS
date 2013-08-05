package im.shs.po;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 	* A data access object (DAO) providing persistence and search support for WebimsInfoDetail entities.
 	 		* Transaction control of the save(), update() and delete() operations must be handled externally by senders of these methods 
 		  or must be manually added to each of these methods for data to be persisted to the JPA datastore.	
 	 * @see im.shs.po.WebimsInfoDetail
  * @author MyEclipse Persistence Tools 
 */

public class WebimsInfoDetailDAO implements IWebimsInfoDetailDAO {
	// property constants
	public static final String TITLE = "title";
	public static final String SUBTITLE = "subtitle";
	public static final String FULL_TITLE = "fullTitle";
	public static final String LINK_URL = "linkUrl";
	public static final String COLOR = "color";
	public static final String IS_STRONG = "isStrong";
	public static final String IS_EM = "isEm";
	public static final String META_DESCRIPTION = "metaDescription";
	public static final String SOURCE = "source";
	public static final String SOURCE_URL = "sourceUrl";
	public static final String AUTHOR = "author";
	public static final String SMALL_IMAGE = "smallImage";
	public static final String LARGE_IMAGE = "largeImage";
	public static final String VIDEO = "video";
	public static final String FILE = "file";
	public static final String FILE_NAME = "fileName";
	public static final String INFO_TEMPLATE = "infoTemplate";
	public static final String INFO_PATH = "infoPath";
	public static final String VIDEO_NAME = "videoName";
	public static final String IS_NEW_WINDOW = "isNewWindow";
	public static final String FILE_LENGTH = "fileLength";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	Perform an initial save of a previously unsaved WebimsInfoDetail entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   WebimsInfoDetailDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoDetail entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoDetail entity) {
		EntityManagerHelper.log("saving WebimsInfoDetail instance", Level.INFO,
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
	 Delete a persistent WebimsInfoDetail entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   WebimsInfoDetailDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoDetail entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoDetail entity) {
		EntityManagerHelper.log("deleting WebimsInfoDetail instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(WebimsInfoDetail.class,
					entity.getInfoId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 Persist a previously saved WebimsInfoDetail entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoDetail entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = WebimsInfoDetailDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoDetail entity to update
	 @return WebimsInfoDetail the persisted WebimsInfoDetail entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoDetail update(WebimsInfoDetail entity) {
		EntityManagerHelper.log("updating WebimsInfoDetail instance",
				Level.INFO, null);
		try {
			WebimsInfoDetail result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public WebimsInfoDetail findById(Integer id) {
		EntityManagerHelper.log("finding WebimsInfoDetail instance with id: "
				+ id, Level.INFO, null);
		try {
			WebimsInfoDetail instance = getEntityManager().find(
					WebimsInfoDetail.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
		 * Find all WebimsInfoDetail entities with a specific property value.  
		 
		  @param propertyName the name of the WebimsInfoDetail property to query
		  @param value the property value to match
		  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.  
		  	  @return List<WebimsInfoDetail> found by query
		 */
	@SuppressWarnings("unchecked")
	public List<WebimsInfoDetail> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding WebimsInfoDetail instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from WebimsInfoDetail model where model."
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

	public List<WebimsInfoDetail> findByTitle(Object title,
			int... rowStartIdxAndCount) {
		return findByProperty(TITLE, title, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findBySubtitle(Object subtitle,
			int... rowStartIdxAndCount) {
		return findByProperty(SUBTITLE, subtitle, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByFullTitle(Object fullTitle,
			int... rowStartIdxAndCount) {
		return findByProperty(FULL_TITLE, fullTitle, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByLinkUrl(Object linkUrl,
			int... rowStartIdxAndCount) {
		return findByProperty(LINK_URL, linkUrl, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByColor(Object color,
			int... rowStartIdxAndCount) {
		return findByProperty(COLOR, color, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByIsStrong(Object isStrong,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_STRONG, isStrong, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByIsEm(Object isEm,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_EM, isEm, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByMetaDescription(Object metaDescription,
			int... rowStartIdxAndCount) {
		return findByProperty(META_DESCRIPTION, metaDescription,
				rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findBySource(Object source,
			int... rowStartIdxAndCount) {
		return findByProperty(SOURCE, source, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findBySourceUrl(Object sourceUrl,
			int... rowStartIdxAndCount) {
		return findByProperty(SOURCE_URL, sourceUrl, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByAuthor(Object author,
			int... rowStartIdxAndCount) {
		return findByProperty(AUTHOR, author, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findBySmallImage(Object smallImage,
			int... rowStartIdxAndCount) {
		return findByProperty(SMALL_IMAGE, smallImage, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByLargeImage(Object largeImage,
			int... rowStartIdxAndCount) {
		return findByProperty(LARGE_IMAGE, largeImage, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByVideo(Object video,
			int... rowStartIdxAndCount) {
		return findByProperty(VIDEO, video, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByFile(Object file,
			int... rowStartIdxAndCount) {
		return findByProperty(FILE, file, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByFileName(Object fileName,
			int... rowStartIdxAndCount) {
		return findByProperty(FILE_NAME, fileName, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByInfoTemplate(Object infoTemplate,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_TEMPLATE, infoTemplate, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByInfoPath(Object infoPath,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_PATH, infoPath, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByVideoName(Object videoName,
			int... rowStartIdxAndCount) {
		return findByProperty(VIDEO_NAME, videoName, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByIsNewWindow(Object isNewWindow,
			int... rowStartIdxAndCount) {
		return findByProperty(IS_NEW_WINDOW, isNewWindow, rowStartIdxAndCount);
	}

	public List<WebimsInfoDetail> findByFileLength(Object fileLength,
			int... rowStartIdxAndCount) {
		return findByProperty(FILE_LENGTH, fileLength, rowStartIdxAndCount);
	}

	/**
	 * Find all WebimsInfoDetail entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoDetail> all WebimsInfoDetail entities
	 */
	@SuppressWarnings("unchecked")
	public List<WebimsInfoDetail> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all WebimsInfoDetail instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from WebimsInfoDetail model";
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