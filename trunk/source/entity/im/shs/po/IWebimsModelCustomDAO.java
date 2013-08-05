package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsModelCustomDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsModelCustomDAO {
	/**
	Perform an initial save of a previously unsaved WebimsModelCustom entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsModelCustomDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsModelCustom entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsModelCustom entity);

	/**
	 Delete a persistent WebimsModelCustom entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsModelCustomDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsModelCustom entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsModelCustom entity);

	/**
	 Persist a previously saved WebimsModelCustom entity and return it or a copy of it to the sender. 
	 A copy of the WebimsModelCustom entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsModelCustomDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsModelCustom entity to update
	 @return WebimsModelCustom the persisted WebimsModelCustom entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsModelCustom update(WebimsModelCustom entity);

	public WebimsModelCustom findById(WebimsModelCustomId id);

	/**
	* Find all WebimsModelCustom entities with a specific property value.  
	
	 @param propertyName the name of the WebimsModelCustom property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsModelCustom> found by query
	*/
	public List<WebimsModelCustom> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsModelCustom entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsModelCustom> all WebimsModelCustom entities
	 */
	public List<WebimsModelCustom> findAll(int... rowStartIdxAndCount);
}