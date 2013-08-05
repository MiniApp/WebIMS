package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsNodeDetailDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsNodeDetailDAO {
	/**
	Perform an initial save of a previously unsaved WebimsNodeDetail entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsNodeDetailDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsNodeDetail entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsNodeDetail entity);

	/**
	 Delete a persistent WebimsNodeDetail entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsNodeDetailDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsNodeDetail entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsNodeDetail entity);

	/**
	 Persist a previously saved WebimsNodeDetail entity and return it or a copy of it to the sender. 
	 A copy of the WebimsNodeDetail entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsNodeDetailDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsNodeDetail entity to update
	 @return WebimsNodeDetail the persisted WebimsNodeDetail entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsNodeDetail update(WebimsNodeDetail entity);

	public WebimsNodeDetail findById(Integer id);

	/**
	* Find all WebimsNodeDetail entities with a specific property value.  
	
	 @param propertyName the name of the WebimsNodeDetail property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsNodeDetail> found by query
	*/
	public List<WebimsNodeDetail> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByLinkUrl(Object linkUrl,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByMetaKeywords(Object metaKeywords,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByMetaDescription(Object metaDescription,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByIsNewWindow(Object isNewWindow,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByNodeTemplate(Object nodeTemplate,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByInfoTemplate(Object infoTemplate,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByIsGenerateNode(Object isGenerateNode,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByIsGenerateInfo(Object isGenerateInfo,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByNodeExtension(Object nodeExtension,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByInfoExtension(Object infoExtension,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByNodePath(Object nodePath,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByInfoPath(Object infoPath,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByIsDepage(Object isDepage,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByStaticMethod(Object staticMethod,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByStaticPage(Object staticPage,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findBySmallImage(Object smallImage,
			int... rowStartIdxAndCount);

	public List<WebimsNodeDetail> findByLargeImage(Object largeImage,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsNodeDetail entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsNodeDetail> all WebimsNodeDetail entities
	 */
	public List<WebimsNodeDetail> findAll(int... rowStartIdxAndCount);
}