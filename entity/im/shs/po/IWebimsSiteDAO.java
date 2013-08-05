package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsSiteDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsSiteDAO {
	/**
	Perform an initial save of a previously unsaved WebimsSite entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsSiteDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsSite entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsSite entity);

	/**
	 Delete a persistent WebimsSite entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsSiteDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsSite entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsSite entity);

	/**
	 Persist a previously saved WebimsSite entity and return it or a copy of it to the sender. 
	 A copy of the WebimsSite entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsSiteDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsSite entity to update
	 @return WebimsSite the persisted WebimsSite entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsSite update(WebimsSite entity);

	public WebimsSite findById(Integer id);

	/**
	* Find all WebimsSite entities with a specific property value.  
	
	 @param propertyName the name of the WebimsSite property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsSite> found by query
	*/
	public List<WebimsSite> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByGlobalId(Object globalId,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByOrgId(Object orgId,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByParentId(Object parentId,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByName(Object name, int... rowStartIdxAndCount);

	public List<WebimsSite> findByFullName(Object fullName,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByHtmlPath(Object htmlPath,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByDomain(Object domain,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByIsWithDomain(Object isWithDomain,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByTemplateTheme(Object templateTheme,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByTreeNumber(Object treeNumber,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByTreeLevel(Object treeLevel,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByTreeMax(Object treeMax,
			int... rowStartIdxAndCount);

	public List<WebimsSite> findByNoPicture(Object noPicture,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsSite entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsSite> all WebimsSite entities
	 */
	public List<WebimsSite> findAll(int... rowStartIdxAndCount);
}