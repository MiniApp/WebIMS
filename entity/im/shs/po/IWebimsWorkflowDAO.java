package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsWorkflowDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsWorkflowDAO {
	/**
	Perform an initial save of a previously unsaved WebimsWorkflow entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsWorkflowDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflow entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflow entity);

	/**
	 Delete a persistent WebimsWorkflow entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsWorkflowDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflow entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflow entity);

	/**
	 Persist a previously saved WebimsWorkflow entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflow entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsWorkflowDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflow entity to update
	 @return WebimsWorkflow the persisted WebimsWorkflow entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflow update(WebimsWorkflow entity);

	public WebimsWorkflow findById(Integer id);

	/**
	* Find all WebimsWorkflow entities with a specific property value.  
	
	 @param propertyName the name of the WebimsWorkflow property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsWorkflow> found by query
	*/
	public List<WebimsWorkflow> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsWorkflow> findByWorkflowgroupId(Object workflowgroupId,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflow> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflow> findByName(Object name,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflow> findByDescription(Object description,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflow> findBySeq(Object seq,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflow> findByStatus(Object status,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsWorkflow entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflow> all WebimsWorkflow entities
	 */
	public List<WebimsWorkflow> findAll(int... rowStartIdxAndCount);
}