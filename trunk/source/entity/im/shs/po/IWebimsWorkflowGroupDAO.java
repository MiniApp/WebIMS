package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsWorkflowGroupDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsWorkflowGroupDAO {
	/**
	Perform an initial save of a previously unsaved WebimsWorkflowGroup entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsWorkflowGroupDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowGroup entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowGroup entity);

	/**
	 Delete a persistent WebimsWorkflowGroup entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsWorkflowGroupDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowGroup entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowGroup entity);

	/**
	 Persist a previously saved WebimsWorkflowGroup entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowGroup entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsWorkflowGroupDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowGroup entity to update
	 @return WebimsWorkflowGroup the persisted WebimsWorkflowGroup entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowGroup update(WebimsWorkflowGroup entity);

	public WebimsWorkflowGroup findById(Integer id);

	/**
	* Find all WebimsWorkflowGroup entities with a specific property value.  
	
	 @param propertyName the name of the WebimsWorkflowGroup property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsWorkflowGroup> found by query
	*/
	public List<WebimsWorkflowGroup> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsWorkflowGroup> findByName(Object name,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowGroup> findByDescription(Object description,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowGroup> findBySeq(Object seq,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowGroup> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsWorkflowGroup entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowGroup> all WebimsWorkflowGroup entities
	 */
	public List<WebimsWorkflowGroup> findAll(int... rowStartIdxAndCount);
}