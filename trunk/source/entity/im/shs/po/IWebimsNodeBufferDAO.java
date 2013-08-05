package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsNodeBufferDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsNodeBufferDAO {
	/**
	Perform an initial save of a previously unsaved WebimsNodeBuffer entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsNodeBufferDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsNodeBuffer entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsNodeBuffer entity);

	/**
	 Delete a persistent WebimsNodeBuffer entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsNodeBufferDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsNodeBuffer entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsNodeBuffer entity);

	/**
	 Persist a previously saved WebimsNodeBuffer entity and return it or a copy of it to the sender. 
	 A copy of the WebimsNodeBuffer entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsNodeBufferDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsNodeBuffer entity to update
	 @return WebimsNodeBuffer the persisted WebimsNodeBuffer entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsNodeBuffer update(WebimsNodeBuffer entity);

	public WebimsNodeBuffer findById(Integer id);

	/**
	* Find all WebimsNodeBuffer entities with a specific property value.  
	
	 @param propertyName the name of the WebimsNodeBuffer property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsNodeBuffer> found by query
	*/
	public List<WebimsNodeBuffer> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsNodeBuffer> findByViews(Object views,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsNodeBuffer entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsNodeBuffer> all WebimsNodeBuffer entities
	 */
	public List<WebimsNodeBuffer> findAll(int... rowStartIdxAndCount);
}