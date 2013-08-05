package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsScoreitemDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsScoreitemDAO {
	/**
	Perform an initial save of a previously unsaved WebimsScoreitem entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsScoreitemDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsScoreitem entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsScoreitem entity);

	/**
	 Delete a persistent WebimsScoreitem entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsScoreitemDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsScoreitem entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsScoreitem entity);

	/**
	 Persist a previously saved WebimsScoreitem entity and return it or a copy of it to the sender. 
	 A copy of the WebimsScoreitem entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsScoreitemDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsScoreitem entity to update
	 @return WebimsScoreitem the persisted WebimsScoreitem entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsScoreitem update(WebimsScoreitem entity);

	public WebimsScoreitem findById(Integer id);

	/**
	* Find all WebimsScoreitem entities with a specific property value.  
	
	 @param propertyName the name of the WebimsScoreitem property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsScoreitem> found by query
	*/
	public List<WebimsScoreitem> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsScoreitem> findByScoregroupId(Object scoregroupId,
			int... rowStartIdxAndCount);

	public List<WebimsScoreitem> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsScoreitem> findByName(Object name,
			int... rowStartIdxAndCount);

	public List<WebimsScoreitem> findByIcon(Object icon,
			int... rowStartIdxAndCount);

	public List<WebimsScoreitem> findBySeq(Object seq,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsScoreitem entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsScoreitem> all WebimsScoreitem entities
	 */
	public List<WebimsScoreitem> findAll(int... rowStartIdxAndCount);
}