package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsInfoCustomDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsInfoCustomDAO {
	/**
	Perform an initial save of a previously unsaved WebimsInfoCustom entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsInfoCustomDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoCustom entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoCustom entity);

	/**
	 Delete a persistent WebimsInfoCustom entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsInfoCustomDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoCustom entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoCustom entity);

	/**
	 Persist a previously saved WebimsInfoCustom entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoCustom entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsInfoCustomDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoCustom entity to update
	 @return WebimsInfoCustom the persisted WebimsInfoCustom entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoCustom update(WebimsInfoCustom entity);

	public WebimsInfoCustom findById(WebimsInfoCustomId id);

	/**
	* Find all WebimsInfoCustom entities with a specific property value.  
	
	 @param propertyName the name of the WebimsInfoCustom property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsInfoCustom> found by query
	*/
	public List<WebimsInfoCustom> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsInfoCustom entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoCustom> all WebimsInfoCustom entities
	 */
	public List<WebimsInfoCustom> findAll(int... rowStartIdxAndCount);
}