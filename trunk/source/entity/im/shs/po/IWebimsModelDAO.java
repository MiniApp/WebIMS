package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsModelDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsModelDAO {
	/**
	Perform an initial save of a previously unsaved WebimsModel entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsModelDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsModel entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsModel entity);

	/**
	 Delete a persistent WebimsModel entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsModelDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsModel entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsModel entity);

	/**
	 Persist a previously saved WebimsModel entity and return it or a copy of it to the sender. 
	 A copy of the WebimsModel entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsModelDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsModel entity to update
	 @return WebimsModel the persisted WebimsModel entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsModel update(WebimsModel entity);

	public WebimsModel findById(Integer id);

	/**
	* Find all WebimsModel entities with a specific property value.  
	
	 @param propertyName the name of the WebimsModel property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsModel> found by query
	*/
	public List<WebimsModel> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsModel> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsModel> findByType(Object type, int... rowStartIdxAndCount);

	public List<WebimsModel> findByName(Object name, int... rowStartIdxAndCount);

	public List<WebimsModel> findBySeq(Object seq, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsModel entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsModel> all WebimsModel entities
	 */
	public List<WebimsModel> findAll(int... rowStartIdxAndCount);
}