package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsRoleDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsRoleDAO {
	/**
	Perform an initial save of a previously unsaved WebimsRole entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsRoleDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsRole entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsRole entity);

	/**
	 Delete a persistent WebimsRole entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsRoleDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsRole entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsRole entity);

	/**
	 Persist a previously saved WebimsRole entity and return it or a copy of it to the sender. 
	 A copy of the WebimsRole entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsRoleDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsRole entity to update
	 @return WebimsRole the persisted WebimsRole entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsRole update(WebimsRole entity);

	public WebimsRole findById(Integer id);

	/**
	* Find all WebimsRole entities with a specific property value.  
	
	 @param propertyName the name of the WebimsRole property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsRole> found by query
	*/
	public List<WebimsRole> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsRole> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsRole> findByName(Object name, int... rowStartIdxAndCount);

	public List<WebimsRole> findByDescription(Object description,
			int... rowStartIdxAndCount);

	public List<WebimsRole> findBySeq(Object seq, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsRole entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsRole> all WebimsRole entities
	 */
	public List<WebimsRole> findAll(int... rowStartIdxAndCount);
}