package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsUserDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsUserDAO {
	/**
	Perform an initial save of a previously unsaved WebimsUser entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsUserDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsUser entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsUser entity);

	/**
	 Delete a persistent WebimsUser entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsUserDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsUser entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsUser entity);

	/**
	 Persist a previously saved WebimsUser entity and return it or a copy of it to the sender. 
	 A copy of the WebimsUser entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsUserDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsUser entity to update
	 @return WebimsUser the persisted WebimsUser entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsUser update(WebimsUser entity);

	public WebimsUser findById(Integer id);

	/**
	* Find all WebimsUser entities with a specific property value.  
	
	 @param propertyName the name of the WebimsUser property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsUser> found by query
	*/
	public List<WebimsUser> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByOrgId(Object orgId,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByUsername(Object username,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByPassword(Object password,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findBySalt(Object salt, int... rowStartIdxAndCount);

	public List<WebimsUser> findByEmail(Object email,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByRealName(Object realName,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByMobile(Object mobile,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByPrevLoginIp(Object prevLoginIp,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByLastLoginIp(Object lastLoginIp,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByCreationIp(Object creationIp,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByLogins(Object logins,
			int... rowStartIdxAndCount);

	public List<WebimsUser> findByStatus(Object status,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsUser entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsUser> all WebimsUser entities
	 */
	public List<WebimsUser> findAll(int... rowStartIdxAndCount);
}