package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsMemgroupnodeViewDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsMemgroupnodeViewDAO {
	/**
	Perform an initial save of a previously unsaved WebimsMemgroupnodeView entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsMemgroupnodeViewDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsMemgroupnodeView entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsMemgroupnodeView entity);

	/**
	 Delete a persistent WebimsMemgroupnodeView entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsMemgroupnodeViewDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsMemgroupnodeView entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsMemgroupnodeView entity);

	/**
	 Persist a previously saved WebimsMemgroupnodeView entity and return it or a copy of it to the sender. 
	 A copy of the WebimsMemgroupnodeView entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsMemgroupnodeViewDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsMemgroupnodeView entity to update
	 @return WebimsMemgroupnodeView the persisted WebimsMemgroupnodeView entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsMemgroupnodeView update(WebimsMemgroupnodeView entity);

	public WebimsMemgroupnodeView findById(WebimsMemgroupnodeViewId id);

	/**
	* Find all WebimsMemgroupnodeView entities with a specific property value.  
	
	 @param propertyName the name of the WebimsMemgroupnodeView property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsMemgroupnodeView> found by query
	*/
	public List<WebimsMemgroupnodeView> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsMemgroupnodeView entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsMemgroupnodeView> all WebimsMemgroupnodeView entities
	 */
	public List<WebimsMemgroupnodeView> findAll(int... rowStartIdxAndCount);
}