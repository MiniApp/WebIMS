package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsGlobalCustomDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsGlobalCustomDAO {
	/**
	Perform an initial save of a previously unsaved WebimsGlobalCustom entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsGlobalCustomDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsGlobalCustom entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsGlobalCustom entity);

	/**
	 Delete a persistent WebimsGlobalCustom entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsGlobalCustomDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsGlobalCustom entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsGlobalCustom entity);

	/**
	 Persist a previously saved WebimsGlobalCustom entity and return it or a copy of it to the sender. 
	 A copy of the WebimsGlobalCustom entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsGlobalCustomDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsGlobalCustom entity to update
	 @return WebimsGlobalCustom the persisted WebimsGlobalCustom entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsGlobalCustom update(WebimsGlobalCustom entity);

	public WebimsGlobalCustom findById(WebimsGlobalCustomId id);

	/**
	* Find all WebimsGlobalCustom entities with a specific property value.  
	
	 @param propertyName the name of the WebimsGlobalCustom property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsGlobalCustom> found by query
	*/
	public List<WebimsGlobalCustom> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsGlobalCustom entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsGlobalCustom> all WebimsGlobalCustom entities
	 */
	public List<WebimsGlobalCustom> findAll(int... rowStartIdxAndCount);
}