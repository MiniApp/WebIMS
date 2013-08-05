package im.shs.po;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for WebimsSpecialDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IWebimsSpecialDAO {
	/**
	Perform an initial save of a previously unsaved WebimsSpecial entity. 
	All subsequent persist actions of this entity should use the #update() method.
	This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 
	* <pre> 
	*   EntityManagerHelper.beginTransaction();
	*   IWebimsSpecialDAO.save(entity);
	*   EntityManagerHelper.commit();
	* </pre>
	@param entity WebimsSpecial entity to persist
	@throws RuntimeException when the operation fails
	*/
	public void save(WebimsSpecial entity);

	/**
	 Delete a persistent WebimsSpecial entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IWebimsSpecialDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity WebimsSpecial entity to delete
	 @throws RuntimeException when the operation fails
	 */
	public void delete(WebimsSpecial entity);

	/**
	 Persist a previously saved WebimsSpecial entity and return it or a copy of it to the sender. 
	 A copy of the WebimsSpecial entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IWebimsSpecialDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity WebimsSpecial entity to update
	 @return WebimsSpecial the persisted WebimsSpecial entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public WebimsSpecial update(WebimsSpecial entity);

	public WebimsSpecial findById(Integer id);

	/**
	* Find all WebimsSpecial entities with a specific property value.  
	
	 @param propertyName the name of the WebimsSpecial property to query
	 @param value the property value to match
	 	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	 	  @return List<WebimsSpecial> found by query
	*/
	public List<WebimsSpecial> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<WebimsSpecial> findBySiteId(Object siteId,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findBySpeccateId(Object speccateId,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByTitle(Object title,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByMetaKeywords(Object metaKeywords,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByMetaDescription(Object metaDescription,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findBySmallImage(Object smallImage,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByLargeImage(Object largeImage,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByVideo(Object video,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByViews(Object views,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByIsRecommend(Object isRecommend,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByRefers(Object refers,
			int... rowStartIdxAndCount);

	public List<WebimsSpecial> findByIsWithImage(Object isWithImage,
			int... rowStartIdxAndCount);

	/**
	 * Find all WebimsSpecial entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<WebimsSpecial> all WebimsSpecial entities
	 */
	public List<WebimsSpecial> findAll(int... rowStartIdxAndCount);
}