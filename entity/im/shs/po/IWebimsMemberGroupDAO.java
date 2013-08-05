package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsMemberGroupDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsMemberGroupDAO {
	/**
	Perform an initial save of a previously unsaved WebimsMemberGroup entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsMemberGroupDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsMemberGroup entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsMemberGroup entity);

	/**
	 Delete a persistent WebimsMemberGroup entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsMemberGroupDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsMemberGroup entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsMemberGroup entity);

	/**
	 Persist a previously saved WebimsMemberGroup entity and return it or a copy of it to the sender. 
	 A copy of the WebimsMemberGroup entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsMemberGroupDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsMemberGroup entity to update
	 @return WebimsMemberGroup the persisted WebimsMemberGroup entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsMemberGroup update(WebimsMemberGroup entity);

	public WebimsMemberGroup findById(Integer id);

	/**
	* Find all WebimsMemberGroup entities with a specific property value.  
	
	 @param propertyName the name of the WebimsMemberGroup property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsMemberGroup> found by query
	*/
	public List<WebimsMemberGroup> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsMemberGroup> findByName(Object name,
			int... rowStartIdxAndCount);

	public List<WebimsMemberGroup> findByDescription(Object description,
			int... rowStartIdxAndCount);

	public List<WebimsMemberGroup> findBySeq(Object seq,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsMemberGroup entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsMemberGroup> all WebimsMemberGroup entities
	 */
	public List<WebimsMemberGroup> findAll(int... rowStartIdxAndCount);
}