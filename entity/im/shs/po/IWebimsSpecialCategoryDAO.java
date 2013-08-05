package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsSpecialCategoryDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsSpecialCategoryDAO {
	/**
	Perform an initial save of a previously unsaved WebimsSpecialCategory entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsSpecialCategoryDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsSpecialCategory entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsSpecialCategory entity);

	/**
	 Delete a persistent WebimsSpecialCategory entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsSpecialCategoryDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsSpecialCategory entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsSpecialCategory entity);

	/**
	 Persist a previously saved WebimsSpecialCategory entity and return it or a copy of it to the sender. 
	 A copy of the WebimsSpecialCategory entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsSpecialCategoryDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsSpecialCategory entity to update
	 @return WebimsSpecialCategory the persisted WebimsSpecialCategory entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsSpecialCategory update(WebimsSpecialCategory entity);

	public WebimsSpecialCategory findById(Integer id);

	/**
	* Find all WebimsSpecialCategory entities with a specific property value.  
	
	 @param propertyName the name of the WebimsSpecialCategory property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsSpecialCategory> found by query
	*/
	public List<WebimsSpecialCategory> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsSpecialCategory> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsSpecialCategory> findByName(Object name,
			int... rowStartIdxAndCount);

	public List<WebimsSpecialCategory> findBySeq(Object seq,
			int... rowStartIdxAndCount);

	public List<WebimsSpecialCategory> findByViews(Object views,
			int... rowStartIdxAndCount);

	public List<WebimsSpecialCategory> findByMetaKeywords(Object metaKeywords,
			int... rowStartIdxAndCount);

	public List<WebimsSpecialCategory> findByMetaDescription(
			Object metaDescription, int... rowStartIdxAndCount);

	/**
	 * Find all WebimsSpecialCategory entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsSpecialCategory> all WebimsSpecialCategory entities
	 */
	public List<WebimsSpecialCategory> findAll(int... rowStartIdxAndCount);
}