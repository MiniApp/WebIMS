package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsInfoBufferDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsInfoBufferDAO {
	/**
	Perform an initial save of a previously unsaved WebimsInfoBuffer entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsInfoBufferDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoBuffer entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoBuffer entity);

	/**
	 Delete a persistent WebimsInfoBuffer entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsInfoBufferDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoBuffer entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoBuffer entity);

	/**
	 Persist a previously saved WebimsInfoBuffer entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoBuffer entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsInfoBufferDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoBuffer entity to update
	 @return WebimsInfoBuffer the persisted WebimsInfoBuffer entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoBuffer update(WebimsInfoBuffer entity);

	public WebimsInfoBuffer findById(Integer id);

	/**
	* Find all WebimsInfoBuffer entities with a specific property value.  
	
	 @param propertyName the name of the WebimsInfoBuffer property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsInfoBuffer> found by query
	*/
	public List<WebimsInfoBuffer> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsInfoBuffer> findByViews(Object views,
			int... rowStartIdxAndCount);

	public List<WebimsInfoBuffer> findByDownloads(Object downloads,
			int... rowStartIdxAndCount);

	public List<WebimsInfoBuffer> findByComments(Object comments,
			int... rowStartIdxAndCount);

	public List<WebimsInfoBuffer> findByInvolveds(Object involveds,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsInfoBuffer entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoBuffer> all WebimsInfoBuffer entities
	 */
	public List<WebimsInfoBuffer> findAll(int... rowStartIdxAndCount);
}