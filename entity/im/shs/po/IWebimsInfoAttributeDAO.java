package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsInfoAttributeDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsInfoAttributeDAO {
	/**
	Perform an initial save of a previously unsaved WebimsInfoAttribute entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsInfoAttributeDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsInfoAttribute entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsInfoAttribute entity);

	/**
	 Delete a persistent WebimsInfoAttribute entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsInfoAttributeDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsInfoAttribute entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsInfoAttribute entity);

	/**
	 Persist a previously saved WebimsInfoAttribute entity and return it or a copy of it to the sender. 
	 A copy of the WebimsInfoAttribute entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsInfoAttributeDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsInfoAttribute entity to update
	 @return WebimsInfoAttribute the persisted WebimsInfoAttribute entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsInfoAttribute update(WebimsInfoAttribute entity);

	public WebimsInfoAttribute findById(Integer id);

	/**
	* Find all WebimsInfoAttribute entities with a specific property value.  
	
	 @param propertyName the name of the WebimsInfoAttribute property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsInfoAttribute> found by query
	*/
	public List<WebimsInfoAttribute> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsInfoAttribute> findByInfoId(Object infoId,
			int... rowStartIdxAndCount);

	public List<WebimsInfoAttribute> findByAttributeId(Object attributeId,
			int... rowStartIdxAndCount);

	public List<WebimsInfoAttribute> findByImage(Object image,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsInfoAttribute entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsInfoAttribute> all WebimsInfoAttribute entities
	 */
	public List<WebimsInfoAttribute> findAll(int... rowStartIdxAndCount);
}