package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsUserOrgDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsUserOrgDAO {
	/**
	Perform an initial save of a previously unsaved WebimsUserOrg entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsUserOrgDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsUserOrg entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsUserOrg entity);

	/**
	 Delete a persistent WebimsUserOrg entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsUserOrgDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsUserOrg entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsUserOrg entity);

	/**
	 Persist a previously saved WebimsUserOrg entity and return it or a copy of it to the sender. 
	 A copy of the WebimsUserOrg entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsUserOrgDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsUserOrg entity to update
	 @return WebimsUserOrg the persisted WebimsUserOrg entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsUserOrg update(WebimsUserOrg entity);

	public WebimsUserOrg findById(WebimsUserOrgId id);

	/**
	* Find all WebimsUserOrg entities with a specific property value.  
	
	 @param propertyName the name of the WebimsUserOrg property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsUserOrg> found by query
	*/
	public List<WebimsUserOrg> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsUserOrg entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsUserOrg> all WebimsUserOrg entities
	 */
	public List<WebimsUserOrg> findAll(int... rowStartIdxAndCount);
}