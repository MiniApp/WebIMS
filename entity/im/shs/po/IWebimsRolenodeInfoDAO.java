package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsRolenodeInfoDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsRolenodeInfoDAO {
	/**
	Perform an initial save of a previously unsaved WebimsRolenodeInfo entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsRolenodeInfoDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsRolenodeInfo entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsRolenodeInfo entity);

	/**
	 Delete a persistent WebimsRolenodeInfo entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsRolenodeInfoDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsRolenodeInfo entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsRolenodeInfo entity);

	/**
	 Persist a previously saved WebimsRolenodeInfo entity and return it or a copy of it to the sender. 
	 A copy of the WebimsRolenodeInfo entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsRolenodeInfoDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsRolenodeInfo entity to update
	 @return WebimsRolenodeInfo the persisted WebimsRolenodeInfo entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsRolenodeInfo update(WebimsRolenodeInfo entity);

	public WebimsRolenodeInfo findById(WebimsRolenodeInfoId id);

	/**
	* Find all WebimsRolenodeInfo entities with a specific property value.  
	
	 @param propertyName the name of the WebimsRolenodeInfo property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsRolenodeInfo> found by query
	*/
	public List<WebimsRolenodeInfo> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsRolenodeInfo entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsRolenodeInfo> all WebimsRolenodeInfo entities
	 */
	public List<WebimsRolenodeInfo> findAll(int... rowStartIdxAndCount);
}