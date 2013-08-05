package im.shs.po;

import java.util.List;

/**
 * Interface for WebimsOrgDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsOrgDAO {
	/**
	Perform an initial save of a previously unsaved WebimsOrg entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsOrgDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsOrg entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsOrg entity);

	/**
	 Delete a persistent WebimsOrg entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsOrgDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsOrg entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsOrg entity);

	/**
	 Persist a previously saved WebimsOrg entity and return it or a copy of it to the sender. 
	 A copy of the WebimsOrg entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsOrgDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsOrg entity to update
	 @return WebimsOrg the persisted WebimsOrg entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsOrg update(WebimsOrg entity);

	public WebimsOrg findById(Integer id);

	/**
	* Find all WebimsOrg entities with a specific property value.  
	
	 @param propertyName the name of the WebimsOrg property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsOrg> found by query
	*/
	public List<WebimsOrg> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<WebimsOrg> findByParentId(Object parentId,
			int... rowStartIdxAndCount);

	public List<WebimsOrg> findByName(Object name, int... rowStartIdxAndCount);

	public List<WebimsOrg> findByFullName(Object fullName,
			int... rowStartIdxAndCount);

	public List<WebimsOrg> findByDescription(Object description,
			int... rowStartIdxAndCount);

	public List<WebimsOrg> findByNumber(Object number,
			int... rowStartIdxAndCount);

	public List<WebimsOrg> findByTreeNumber(Object treeNumber,
			int... rowStartIdxAndCount);

	public List<WebimsOrg> findByTreeLevel(Object treeLevel,
			int... rowStartIdxAndCount);

	public List<WebimsOrg> findByTreeMax(Object treeMax,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsOrg entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsOrg> all WebimsOrg entities
	 */
	public List<WebimsOrg> findAll(int... rowStartIdxAndCount);
}