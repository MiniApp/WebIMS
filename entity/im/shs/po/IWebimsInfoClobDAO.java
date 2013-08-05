package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsInfoClobDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsInfoClobDAO {
	/**
	Perform an initial save of a previously unsaved WebimsInfoClob entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsInfoClobDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoClob entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoClob entity);

	/**
	 Delete a persistent WebimsInfoClob entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsInfoClobDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoClob entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoClob entity);

	/**
	 Persist a previously saved WebimsInfoClob entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoClob entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsInfoClobDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoClob entity to update
	 @return WebimsInfoClob the persisted WebimsInfoClob entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoClob update(WebimsInfoClob entity);

	public WebimsInfoClob findById(WebimsInfoClobId id);

	/**
	* Find all WebimsInfoClob entities with a specific property value.  
	
	 @param propertyName the name of the WebimsInfoClob property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsInfoClob> found by query
	*/
	public List<WebimsInfoClob> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsInfoClob entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoClob> all WebimsInfoClob entities
	 */
	public List<WebimsInfoClob> findAll(int... rowStartIdxAndCount);
}