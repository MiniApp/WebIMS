package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsScoreboardScoreuserDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsScoreboardScoreuserDAO {
	/**
	Perform an initial save of a previously unsaved WebimsScoreboardScoreuser entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsScoreboardScoreuserDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsScoreboardScoreuser entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsScoreboardScoreuser entity);

	/**
	 Delete a persistent WebimsScoreboardScoreuser entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsScoreboardScoreuserDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsScoreboardScoreuser entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsScoreboardScoreuser entity);

	/**
	 Persist a previously saved WebimsScoreboardScoreuser entity and return it or a copy of it to the sender. 
	 A copy of the WebimsScoreboardScoreuser entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsScoreboardScoreuserDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsScoreboardScoreuser entity to update
	 @return WebimsScoreboardScoreuser the persisted WebimsScoreboardScoreuser entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsScoreboardScoreuser update(WebimsScoreboardScoreuser entity);

	public WebimsScoreboardScoreuser findById(WebimsScoreboardScoreuserId id);

	/**
	* Find all WebimsScoreboardScoreuser entities with a specific property value.  
	
	 @param propertyName the name of the WebimsScoreboardScoreuser property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsScoreboardScoreuser> found by query
	*/
	public List<WebimsScoreboardScoreuser> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsScoreboardScoreuser entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsScoreboardScoreuser> all WebimsScoreboardScoreuser entities
	 */
	public List<WebimsScoreboardScoreuser> findAll(int... rowStartIdxAndCount);
}