package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsTagDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsTagDAO {
	/**
	Perform an initial save of a previously unsaved WebimsTag entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsTagDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsTag entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsTag entity);

	/**
	 Delete a persistent WebimsTag entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsTagDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsTag entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsTag entity);

	/**
	 Persist a previously saved WebimsTag entity and return it or a copy of it to the sender. 
	 A copy of the WebimsTag entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsTagDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsTag entity to update
	 @return WebimsTag the persisted WebimsTag entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsTag update(WebimsTag entity);

	public WebimsTag findById(Integer id);

	/**
	* Find all WebimsTag entities with a specific property value.  
	
	 @param propertyName the name of the WebimsTag property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsTag> found by query
	*/
	public List<WebimsTag> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsTag> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsTag> findByName(Object name, int... rowStartIdxAndCount);

	public List<WebimsTag> findByRefers(Object refers,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsTag entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsTag> all WebimsTag entities
	 */
	public List<WebimsTag> findAll(int... rowStartIdxAndCount);
}