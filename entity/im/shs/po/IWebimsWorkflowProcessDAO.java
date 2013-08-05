package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsWorkflowProcessDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsWorkflowProcessDAO {
	/**
	Perform an initial save of a previously unsaved WebimsWorkflowProcess entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsWorkflowProcessDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowProcess entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowProcess entity);

	/**
	 Delete a persistent WebimsWorkflowProcess entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsWorkflowProcessDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowProcess entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowProcess entity);

	/**
	 Persist a previously saved WebimsWorkflowProcess entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowProcess entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsWorkflowProcessDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowProcess entity to update
	 @return WebimsWorkflowProcess the persisted WebimsWorkflowProcess entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowProcess update(WebimsWorkflowProcess entity);

	public WebimsWorkflowProcess findById(Integer id);

	/**
	* Find all WebimsWorkflowProcess entities with a specific property value.  
	
	 @param propertyName the name of the WebimsWorkflowProcess property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsWorkflowProcess> found by query
	*/
	public List<WebimsWorkflowProcess> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsWorkflowProcess> findByWorkflowId(Object workflowId,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowProcess> findByUserId(Object userId,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowProcess> findByDataId(Object dataId,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowProcess> findByStep(Object step,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowProcess> findByIsEnd(Object isEnd,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsWorkflowProcess entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowProcess> all WebimsWorkflowProcess entities
	 */
	public List<WebimsWorkflowProcess> findAll(int... rowStartIdxAndCount);
}