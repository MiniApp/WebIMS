package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsNodeCustomDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsNodeCustomDAO {
	/**
	Perform an initial save of a previously unsaved WebimsNodeCustom entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsNodeCustomDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsNodeCustom entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsNodeCustom entity);

	/**
	 Delete a persistent WebimsNodeCustom entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsNodeCustomDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsNodeCustom entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsNodeCustom entity);

	/**
	 Persist a previously saved WebimsNodeCustom entity and return it or a copy of it to the sender. 
	 A copy of the WebimsNodeCustom entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsNodeCustomDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsNodeCustom entity to update
	 @return WebimsNodeCustom the persisted WebimsNodeCustom entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsNodeCustom update(WebimsNodeCustom entity);

	public WebimsNodeCustom findById(WebimsNodeCustomId id);

	/**
	* Find all WebimsNodeCustom entities with a specific property value.  
	
	 @param propertyName the name of the WebimsNodeCustom property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsNodeCustom> found by query
	*/
	public List<WebimsNodeCustom> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsNodeCustom entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsNodeCustom> all WebimsNodeCustom entities
	 */
	public List<WebimsNodeCustom> findAll(int... rowStartIdxAndCount);
}