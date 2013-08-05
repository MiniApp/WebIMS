package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsInfoDetailDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsInfoDetailDAO {
	/**
	Perform an initial save of a previously unsaved WebimsInfoDetail entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsInfoDetailDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoDetail entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoDetail entity);

	/**
	 Delete a persistent WebimsInfoDetail entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsInfoDetailDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoDetail entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoDetail entity);

	/**
	 Persist a previously saved WebimsInfoDetail entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoDetail entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsInfoDetailDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoDetail entity to update
	 @return WebimsInfoDetail the persisted WebimsInfoDetail entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoDetail update(WebimsInfoDetail entity);

	public WebimsInfoDetail findById(Integer id);

	/**
	* Find all WebimsInfoDetail entities with a specific property value.  
	
	 @param propertyName the name of the WebimsInfoDetail property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsInfoDetail> found by query
	*/
	public List<WebimsInfoDetail> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByTitle(Object title,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findBySubtitle(Object subtitle,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByFullTitle(Object fullTitle,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByLinkUrl(Object linkUrl,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByColor(Object color,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByIsStrong(Object isStrong,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByIsEm(Object isEm,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByMetaDescription(Object metaDescription,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findBySource(Object source,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findBySourceUrl(Object sourceUrl,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByAuthor(Object author,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findBySmallImage(Object smallImage,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByLargeImage(Object largeImage,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByVideo(Object video,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByFile(Object file,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByFileName(Object fileName,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByInfoTemplate(Object infoTemplate,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByInfoPath(Object infoPath,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByVideoName(Object videoName,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByIsNewWindow(Object isNewWindow,
			int... rowStartIdxAndCount);

	public List<WebimsInfoDetail> findByFileLength(Object fileLength,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsInfoDetail entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoDetail> all WebimsInfoDetail entities
	 */
	public List<WebimsInfoDetail> findAll(int... rowStartIdxAndCount);
}