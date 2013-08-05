package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsRoleSiteDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsRoleSiteDAO {
	/**
	Perform an initial save of a previously unsaved WebimsRoleSite entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsRoleSiteDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsRoleSite entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsRoleSite entity);

	/**
	 Delete a persistent WebimsRoleSite entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsRoleSiteDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsRoleSite entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsRoleSite entity);

	/**
	 Persist a previously saved WebimsRoleSite entity and return it or a copy of it to the sender. 
	 A copy of the WebimsRoleSite entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsRoleSiteDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsRoleSite entity to update
	 @return WebimsRoleSite the persisted WebimsRoleSite entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsRoleSite update(WebimsRoleSite entity);

	public WebimsRoleSite findById(Integer id);

	/**
	* Find all WebimsRoleSite entities with a specific property value.  
	
	 @param propertyName the name of the WebimsRoleSite property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsRoleSite> found by query
	*/
	public List<WebimsRoleSite> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsRoleSite> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsRoleSite> findByRoleId(Object roleId,
			int... rowStartIdxAndCount);

	public List<WebimsRoleSite> findByIsAllNode(Object isAllNode,
			int... rowStartIdxAndCount);

	public List<WebimsRoleSite> findByIsAllInfo(Object isAllInfo,
			int... rowStartIdxAndCount);

	public List<WebimsRoleSite> findByInfoRightType(Object infoRightType,
			int... rowStartIdxAndCount);

	public List<WebimsRoleSite> findByIsAllPerm(Object isAllPerm,
			int... rowStartIdxAndCount);

	public List<WebimsRoleSite> findByPerms(Object perms,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsRoleSite entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsRoleSite> all WebimsRoleSite entities
	 */
	public List<WebimsRoleSite> findAll(int... rowStartIdxAndCount);
}