package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsMembergroupSiteDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsMembergroupSiteDAO {
	/**
	Perform an initial save of a previously unsaved WebimsMembergroupSite entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsMembergroupSiteDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsMembergroupSite entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsMembergroupSite entity);

	/**
	 Delete a persistent WebimsMembergroupSite entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsMembergroupSiteDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsMembergroupSite entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsMembergroupSite entity);

	/**
	 Persist a previously saved WebimsMembergroupSite entity and return it or a copy of it to the sender. 
	 A copy of the WebimsMembergroupSite entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsMembergroupSiteDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsMembergroupSite entity to update
	 @return WebimsMembergroupSite the persisted WebimsMembergroupSite entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsMembergroupSite update(WebimsMembergroupSite entity);

	public WebimsMembergroupSite findById(Integer id);

	/**
	* Find all WebimsMembergroupSite entities with a specific property value.  
	
	 @param propertyName the name of the WebimsMembergroupSite property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsMembergroupSite> found by query
	*/
	public List<WebimsMembergroupSite> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsMembergroupSite> findByMembergroupId(
			Object membergroupId, int... rowStartIdxAndCount);

	public List<WebimsMembergroupSite> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsMembergroupSite> findByIsAllView(Object isAllView,
			int... rowStartIdxAndCount);

	public List<WebimsMembergroupSite> findByIsAllContri(Object isAllContri,
			int... rowStartIdxAndCount);

	public List<WebimsMembergroupSite> findByIsAllExemption(
			Object isAllExemption, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsMembergroupSite entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsMembergroupSite> all WebimsMembergroupSite entities
	 */
	public List<WebimsMembergroupSite> findAll(int... rowStartIdxAndCount);
}