package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsWorkflowStepDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsWorkflowStepDAO {
	/**
	Perform an initial save of a previously unsaved WebimsWorkflowStep entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsWorkflowStepDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowStep entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowStep entity);

	/**
	 Delete a persistent WebimsWorkflowStep entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsWorkflowStepDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowStep entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowStep entity);

	/**
	 Persist a previously saved WebimsWorkflowStep entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowStep entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsWorkflowStepDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowStep entity to update
	 @return WebimsWorkflowStep the persisted WebimsWorkflowStep entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowStep update(WebimsWorkflowStep entity);

	public WebimsWorkflowStep findById(Integer id);

	/**
	* Find all WebimsWorkflowStep entities with a specific property value.  
	
	 @param propertyName the name of the WebimsWorkflowStep property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsWorkflowStep> found by query
	*/
	public List<WebimsWorkflowStep> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsWorkflowStep> findByWorkflowId(Object workflowId,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowStep> findByName(Object name,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsWorkflowStep entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowStep> all WebimsWorkflowStep entities
	 */
	public List<WebimsWorkflowStep> findAll(int... rowStartIdxAndCount);
}