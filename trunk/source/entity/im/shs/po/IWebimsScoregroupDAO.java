package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsScoregroupDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsScoregroupDAO {
	/**
	Perform an initial save of a previously unsaved WebimsScoregroup entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsScoregroupDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsScoregroup entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsScoregroup entity);

	/**
	 Delete a persistent WebimsScoregroup entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsScoregroupDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsScoregroup entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsScoregroup entity);

	/**
	 Persist a previously saved WebimsScoregroup entity and return it or a copy of it to the sender. 
	 A copy of the WebimsScoregroup entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsScoregroupDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsScoregroup entity to update
	 @return WebimsScoregroup the persisted WebimsScoregroup entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsScoregroup update(WebimsScoregroup entity);

	public WebimsScoregroup findById(Integer id);

	/**
	* Find all WebimsScoregroup entities with a specific property value.  
	
	 @param propertyName the name of the WebimsScoregroup property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsScoregroup> found by query
	*/
	public List<WebimsScoregroup> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsScoregroup> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsScoregroup> findByName(Object name,
			int... rowStartIdxAndCount);

	public List<WebimsScoregroup> findByDescription(Object description,
			int... rowStartIdxAndCount);

	public List<WebimsScoregroup> findBySeq(Object seq,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsScoregroup entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsScoregroup> all WebimsScoregroup entities
	 */
	public List<WebimsScoregroup> findAll(int... rowStartIdxAndCount);
}