package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsRolenodeNodeDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsRolenodeNodeDAO {
	/**
	Perform an initial save of a previously unsaved WebimsRolenodeNode entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsRolenodeNodeDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsRolenodeNode entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsRolenodeNode entity);

	/**
	 Delete a persistent WebimsRolenodeNode entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsRolenodeNodeDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsRolenodeNode entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsRolenodeNode entity);

	/**
	 Persist a previously saved WebimsRolenodeNode entity and return it or a copy of it to the sender. 
	 A copy of the WebimsRolenodeNode entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsRolenodeNodeDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsRolenodeNode entity to update
	 @return WebimsRolenodeNode the persisted WebimsRolenodeNode entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsRolenodeNode update(WebimsRolenodeNode entity);

	public WebimsRolenodeNode findById(WebimsRolenodeNodeId id);

	/**
	* Find all WebimsRolenodeNode entities with a specific property value.  
	
	 @param propertyName the name of the WebimsRolenodeNode property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsRolenodeNode> found by query
	*/
	public List<WebimsRolenodeNode> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsRolenodeNode entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsRolenodeNode> all WebimsRolenodeNode entities
	 */
	public List<WebimsRolenodeNode> findAll(int... rowStartIdxAndCount);
}