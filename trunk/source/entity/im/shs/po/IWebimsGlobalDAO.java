package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsGlobalDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsGlobalDAO {
	/**
	Perform an initial save of a previously unsaved WebimsGlobal entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsGlobalDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsGlobal entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsGlobal entity);

	/**
	 Delete a persistent WebimsGlobal entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsGlobalDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsGlobal entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsGlobal entity);

	/**
	 Persist a previously saved WebimsGlobal entity and return it or a copy of it to the sender. 
	 A copy of the WebimsGlobal entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsGlobalDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsGlobal entity to update
	 @return WebimsGlobal the persisted WebimsGlobal entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsGlobal update(WebimsGlobal entity);

	public WebimsGlobal findById(Integer id);

	/**
	* Find all WebimsGlobal entities with a specific property value.  
	
	 @param propertyName the name of the WebimsGlobal property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsGlobal> found by query
	*/
	public List<WebimsGlobal> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsGlobal> findByVersion(Object version,
			int... rowStartIdxAndCount);

	public List<WebimsGlobal> findByPort(Object port,
			int... rowStartIdxAndCount);

	public List<WebimsGlobal> findByContextPath(Object contextPath,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsGlobal entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsGlobal> all WebimsGlobal entities
	 */
	public List<WebimsGlobal> findAll(int... rowStartIdxAndCount);
}