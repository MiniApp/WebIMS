package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsInfoFileDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsInfoFileDAO {
	/**
	Perform an initial save of a previously unsaved WebimsInfoFile entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsInfoFileDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoFile entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoFile entity);

	/**
	 Delete a persistent WebimsInfoFile entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsInfoFileDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoFile entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoFile entity);

	/**
	 Persist a previously saved WebimsInfoFile entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoFile entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsInfoFileDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoFile entity to update
	 @return WebimsInfoFile the persisted WebimsInfoFile entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoFile update(WebimsInfoFile entity);

	public WebimsInfoFile findById(WebimsInfoFileId id);

	/**
	* Find all WebimsInfoFile entities with a specific property value.  
	
	 @param propertyName the name of the WebimsInfoFile property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsInfoFile> found by query
	*/
	public List<WebimsInfoFile> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsInfoFile entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoFile> all WebimsInfoFile entities
	 */
	public List<WebimsInfoFile> findAll(int... rowStartIdxAndCount);
}