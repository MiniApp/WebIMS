package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsScoreboardDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsScoreboardDAO {
	/**
	Perform an initial save of a previously unsaved WebimsScoreboard entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsScoreboardDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsScoreboard entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsScoreboard entity);

	/**
	 Delete a persistent WebimsScoreboard entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsScoreboardDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsScoreboard entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsScoreboard entity);

	/**
	 Persist a previously saved WebimsScoreboard entity and return it or a copy of it to the sender. 
	 A copy of the WebimsScoreboard entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsScoreboardDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsScoreboard entity to update
	 @return WebimsScoreboard the persisted WebimsScoreboard entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsScoreboard update(WebimsScoreboard entity);

	public WebimsScoreboard findById(Integer id);

	/**
	* Find all WebimsScoreboard entities with a specific property value.  
	
	 @param propertyName the name of the WebimsScoreboard property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsScoreboard> found by query
	*/
	public List<WebimsScoreboard> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsScoreboard> findByScoreitemId(Object scoreitemId,
			int... rowStartIdxAndCount);

	public List<WebimsScoreboard> findByFtype(Object ftype,
			int... rowStartIdxAndCount);

	public List<WebimsScoreboard> findByFid(Object fid,
			int... rowStartIdxAndCount);

	public List<WebimsScoreboard> findByScore(Object score,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsScoreboard entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsScoreboard> all WebimsScoreboard entities
	 */
	public List<WebimsScoreboard> findAll(int... rowStartIdxAndCount);
}