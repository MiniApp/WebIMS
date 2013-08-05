package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsInfoSpecialDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsInfoSpecialDAO {
	/**
	Perform an initial save of a previously unsaved WebimsInfoSpecial entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsInfoSpecialDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoSpecial entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoSpecial entity);

	/**
	 Delete a persistent WebimsInfoSpecial entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsInfoSpecialDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoSpecial entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoSpecial entity);

	/**
	 Persist a previously saved WebimsInfoSpecial entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoSpecial entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsInfoSpecialDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoSpecial entity to update
	 @return WebimsInfoSpecial the persisted WebimsInfoSpecial entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoSpecial update(WebimsInfoSpecial entity);

	public WebimsInfoSpecial findById(WebimsInfoSpecialId id);

	/**
	* Find all WebimsInfoSpecial entities with a specific property value.  
	
	 @param propertyName the name of the WebimsInfoSpecial property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsInfoSpecial> found by query
	*/
	public List<WebimsInfoSpecial> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsInfoSpecial entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoSpecial> all WebimsInfoSpecial entities
	 */
	public List<WebimsInfoSpecial> findAll(int... rowStartIdxAndCount);
}