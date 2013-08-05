package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsWorkflowstepRoleDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsWorkflowstepRoleDAO {
	/**
	Perform an initial save of a previously unsaved WebimsWorkflowstepRole entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsWorkflowstepRoleDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowstepRole entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowstepRole entity);

	/**
	 Delete a persistent WebimsWorkflowstepRole entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsWorkflowstepRoleDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowstepRole entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowstepRole entity);

	/**
	 Persist a previously saved WebimsWorkflowstepRole entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowstepRole entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsWorkflowstepRoleDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowstepRole entity to update
	 @return WebimsWorkflowstepRole the persisted WebimsWorkflowstepRole entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowstepRole update(WebimsWorkflowstepRole entity);

	public WebimsWorkflowstepRole findById(WebimsWorkflowstepRoleId id);

	/**
	* Find all WebimsWorkflowstepRole entities with a specific property value.  
	
	 @param propertyName the name of the WebimsWorkflowstepRole property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsWorkflowstepRole> found by query
	*/
	public List<WebimsWorkflowstepRole> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsWorkflowstepRole entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowstepRole> all WebimsWorkflowstepRole entities
	 */
	public List<WebimsWorkflowstepRole> findAll(int... rowStartIdxAndCount);
}