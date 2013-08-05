package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsMemgroupnodeContriDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsMemgroupnodeContriDAO {
	/**
	Perform an initial save of a previously unsaved WebimsMemgroupnodeContri entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsMemgroupnodeContriDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsMemgroupnodeContri entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsMemgroupnodeContri entity);

	/**
	 Delete a persistent WebimsMemgroupnodeContri entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsMemgroupnodeContriDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsMemgroupnodeContri entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsMemgroupnodeContri entity);

	/**
	 Persist a previously saved WebimsMemgroupnodeContri entity and return it or a copy of it to the sender. 
	 A copy of the WebimsMemgroupnodeContri entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsMemgroupnodeContriDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsMemgroupnodeContri entity to update
	 @return WebimsMemgroupnodeContri the persisted WebimsMemgroupnodeContri entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsMemgroupnodeContri update(WebimsMemgroupnodeContri entity);

	public WebimsMemgroupnodeContri findById(WebimsMemgroupnodeContriId id);

	/**
	* Find all WebimsMemgroupnodeContri entities with a specific property value.  
	
	 @param propertyName the name of the WebimsMemgroupnodeContri property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsMemgroupnodeContri> found by query
	*/
	public List<WebimsMemgroupnodeContri> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsMemgroupnodeContri entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsMemgroupnodeContri> all WebimsMemgroupnodeContri entities
	 */
	public List<WebimsMemgroupnodeContri> findAll(int... rowStartIdxAndCount);
}