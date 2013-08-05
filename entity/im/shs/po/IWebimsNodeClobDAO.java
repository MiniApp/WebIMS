package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsNodeClobDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsNodeClobDAO {
	/**
	Perform an initial save of a previously unsaved WebimsNodeClob entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsNodeClobDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsNodeClob entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsNodeClob entity);

	/**
	 Delete a persistent WebimsNodeClob entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsNodeClobDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsNodeClob entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsNodeClob entity);

	/**
	 Persist a previously saved WebimsNodeClob entity and return it or a copy of it to the sender. 
	 A copy of the WebimsNodeClob entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsNodeClobDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsNodeClob entity to update
	 @return WebimsNodeClob the persisted WebimsNodeClob entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsNodeClob update(WebimsNodeClob entity);

	public WebimsNodeClob findById(WebimsNodeClobId id);

	/**
	* Find all WebimsNodeClob entities with a specific property value.  
	
	 @param propertyName the name of the WebimsNodeClob property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsNodeClob> found by query
	*/
	public List<WebimsNodeClob> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsNodeClob entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsNodeClob> all WebimsNodeClob entities
	 */
	public List<WebimsNodeClob> findAll(int... rowStartIdxAndCount);
}