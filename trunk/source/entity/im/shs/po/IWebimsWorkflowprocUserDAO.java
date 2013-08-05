package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsWorkflowprocUserDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsWorkflowprocUserDAO {
	/**
	Perform an initial save of a previously unsaved WebimsWorkflowprocUser entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsWorkflowprocUserDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowprocUser entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowprocUser entity);

	/**
	 Delete a persistent WebimsWorkflowprocUser entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsWorkflowprocUserDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowprocUser entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowprocUser entity);

	/**
	 Persist a previously saved WebimsWorkflowprocUser entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowprocUser entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsWorkflowprocUserDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowprocUser entity to update
	 @return WebimsWorkflowprocUser the persisted WebimsWorkflowprocUser entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowprocUser update(WebimsWorkflowprocUser entity);

	public WebimsWorkflowprocUser findById(WebimsWorkflowprocUserId id);

	/**
	* Find all WebimsWorkflowprocUser entities with a specific property value.  
	
	 @param propertyName the name of the WebimsWorkflowprocUser property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsWorkflowprocUser> found by query
	*/
	public List<WebimsWorkflowprocUser> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsWorkflowprocUser entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowprocUser> all WebimsWorkflowprocUser entities
	 */
	public List<WebimsWorkflowprocUser> findAll(int... rowStartIdxAndCount);
}