package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsModelFieldCustomDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsModelFieldCustomDAO {
	/**
	Perform an initial save of a previously unsaved WebimsModelFieldCustom entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsModelFieldCustomDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsModelFieldCustom entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsModelFieldCustom entity);

	/**
	 Delete a persistent WebimsModelFieldCustom entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsModelFieldCustomDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsModelFieldCustom entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsModelFieldCustom entity);

	/**
	 Persist a previously saved WebimsModelFieldCustom entity and return it or a copy of it to the sender. 
	 A copy of the WebimsModelFieldCustom entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsModelFieldCustomDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsModelFieldCustom entity to update
	 @return WebimsModelFieldCustom the persisted WebimsModelFieldCustom entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsModelFieldCustom update(WebimsModelFieldCustom entity);

	public WebimsModelFieldCustom findById(WebimsModelFieldCustomId id);

	/**
	* Find all WebimsModelFieldCustom entities with a specific property value.  
	
	 @param propertyName the name of the WebimsModelFieldCustom property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsModelFieldCustom> found by query
	*/
	public List<WebimsModelFieldCustom> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsModelFieldCustom entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsModelFieldCustom> all WebimsModelFieldCustom entities
	 */
	public List<WebimsModelFieldCustom> findAll(int... rowStartIdxAndCount);
}