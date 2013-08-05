package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsWorkflowLogDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsWorkflowLogDAO {
	/**
	Perform an initial save of a previously unsaved WebimsWorkflowLog entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsWorkflowLogDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsWorkflowLog entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsWorkflowLog entity);

	/**
	 Delete a persistent WebimsWorkflowLog entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsWorkflowLogDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsWorkflowLog entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsWorkflowLog entity);

	/**
	 Persist a previously saved WebimsWorkflowLog entity and return it or a copy of it to the sender. 
	 A copy of the WebimsWorkflowLog entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsWorkflowLogDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsWorkflowLog entity to update
	 @return WebimsWorkflowLog the persisted WebimsWorkflowLog entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsWorkflowLog update(WebimsWorkflowLog entity);

	public WebimsWorkflowLog findById(Integer id);

	/**
	* Find all WebimsWorkflowLog entities with a specific property value.  
	
	 @param propertyName the name of the WebimsWorkflowLog property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsWorkflowLog> found by query
	*/
	public List<WebimsWorkflowLog> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsWorkflowLog> findByUserId(Object userId,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowLog> findByWorkflowprocessId(
			Object workflowprocessId, int... rowStartIdxAndCount);

	public List<WebimsWorkflowLog> findByFrom(Object from,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowLog> findByTo(Object to,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowLog> findByOpinion(Object opinion,
			int... rowStartIdxAndCount);

	public List<WebimsWorkflowLog> findByType(Object type,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsWorkflowLog entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsWorkflowLog> all WebimsWorkflowLog entities
	 */
	public List<WebimsWorkflowLog> findAll(int... rowStartIdxAndCount);
}