package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsMemberDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsMemberDAO {
	/**
	Perform an initial save of a previously unsaved WebimsMember entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsMemberDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsMember entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsMember entity);

	/**
	 Delete a persistent WebimsMember entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsMemberDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsMember entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsMember entity);

	/**
	 Persist a previously saved WebimsMember entity and return it or a copy of it to the sender. 
	 A copy of the WebimsMember entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsMemberDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsMember entity to update
	 @return WebimsMember the persisted WebimsMember entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsMember update(WebimsMember entity);

	public WebimsMember findById(Integer id);

	/**
	* Find all WebimsMember entities with a specific property value.  
	
	 @param propertyName the name of the WebimsMember property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsMember> found by query
	*/
	public List<WebimsMember> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsMember> findByMembergroupId(Object membergroupId,
			int... rowStartIdxAndCount);

	public List<WebimsMember> findByAvatar(Object avatar,
			int... rowStartIdxAndCount);

	public List<WebimsMember> findBySelintro(Object selintro,
			int... rowStartIdxAndCount);

	public List<WebimsMember> findByComeFrom(Object comeFrom,
			int... rowStartIdxAndCount);

	public List<WebimsMember> findByGender(Object gender,
			int... rowStartIdxAndCount);

	public List<WebimsMember> findByStatus(Object status,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsMember entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsMember> all WebimsMember entities
	 */
	public List<WebimsMember> findAll(int... rowStartIdxAndCount);
}